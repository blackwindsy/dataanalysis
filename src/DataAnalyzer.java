import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class DataAnalyzer {
	public static void main(String args[]) {

		// input validation
		// the input parameter should be a string to specify the input filename
		boolean isInputFileValid = true;
		String lsErrorMsg = null;
		String lsInputFilename = null;
		File loInputFile = null;

		
//TODO: remove after testing
lsInputFilename = "/Users/syang/Desktop/prac/java/dataanalysis/test.xml";
args = new String[1];
args[0] = new String(lsInputFilename);



		if (args.length == 0) {
			isInputFileValid = false;
			lsErrorMsg = "Input filename should be specified as the parameter (full path if not in current directory).";
		} else {
			lsInputFilename = args[0];
			if (lsInputFilename == null || lsInputFilename.trim().length() == 0) {
				isInputFileValid = false;
				lsErrorMsg = "Input filename should not be empty.";
			} else {
				loInputFile = new File(lsInputFilename);
				if (!loInputFile.exists()) {
					isInputFileValid = false;
					lsErrorMsg = "Input file specified does not exist.";
				}
			}
		}



		if (!isInputFileValid) {
			System.out.print("ERROR: " + lsErrorMsg);
			System.exit(0);
		}

		boolean isXml = lsInputFilename.toLowerCase().endsWith(".xml");
		boolean isJson = lsInputFilename.toLowerCase().endsWith(".json");

		if (isXml) {
			formatXml(loInputFile);
		} else if (isJson) {
			formatJson(loInputFile);
		}
		
	}
	
	public static void formatXml(File foInputFile) {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			XmlHanlder xh = new XmlHanlder();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(foInputFile, xh);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		}

	}
	
	public static void formatJson(File foInputFile) {

	}
	
}
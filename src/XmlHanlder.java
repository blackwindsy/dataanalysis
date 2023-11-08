import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class XmlHanlder extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//debug
		System.out.println("characters() called: ch.length = " + ch.length + ", start = " + start + ", length = " + length);
		if (ch != null && ch.length > 0) {
			StringBuilder sbFullVal = new StringBuilder();
			//for (char c: ch) {
			//	sbFulsbFullVallVal.append(c);
			for (int i = 0; i < ch.length; i++) {
				sbFullVal.append(ch[i]);
			}
			System.out.println("ch = " + sbFullVal.toString());

			StringBuilder sbCurVal = new StringBuilder();
			for (int i = start; i < ch.length && (i - start) < length; i++) {
				sbCurVal.append(ch[i]);
			}
			System.out.println("sbCurVal = " + sbCurVal.toString() + "END OF STRING<<<<<<<<");
		}
	}

	@Override
	public void startDocument() throws SAXException {
		//debug
		System.out.println("startDocument() called ======================");
	}

	@Override
	public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
		//debug
		System.out.println("startElement() called: lName = " + lName + ", qName = " + qName + "\n>>>>>>>>>>------------------------");

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//debug
		System.out.println("\tendElement() called: localName = " + localName + ", qName = " + qName + "\n\t------------------------------<<<<<<<<<<");
	}
}

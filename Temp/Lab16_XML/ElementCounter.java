import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class ElementCounter extends DefaultHandler {
    private int counter =0;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println("start element ----"+qName);
        if("book".equals(qName)) counter++;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("end element ---- "+qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Found "+counter+" book elements in the document.");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("text data = | "+new String(ch,start,length)+"|");
    }

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        ContentHandler handler = new ElementCounter();
        parser.setContentHandler(handler);
        InputStream stream = ElementCounter.class.getResource("Books.xml").openStream();
        parser.parse(new InputSource(stream));
        System.out.println("done");

    }
}

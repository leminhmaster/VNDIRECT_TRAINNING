import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLFilterStripper extends DefaultHandler {
    BookMapper mapper;

    public XMLFilterStripper(BookMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("booktitle".compareTo(qName)==0){
            //System.out.println("booktitle");
            return;
        }
        mapper.startElement(uri,localName,qName,attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        mapper.characters(ch,start,length);
    }
}

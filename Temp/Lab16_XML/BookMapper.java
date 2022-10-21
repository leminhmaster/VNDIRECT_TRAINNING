import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class BookMapper extends DefaultHandler {
    private List<Book> list;
    private Book book;
    private String lastElemantName;

    public BookMapper(List<Book> list) {
        this.list = list;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("book".equals(qName)){
            book=new Book();
            book.setPage(Integer.parseInt(attributes.getValue("page")));
            list.add(book);
        }else {
            lastElemantName = qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (value.trim().isEmpty()) return;

        switch (lastElemantName){
            case "author":
                book.setAuthor(value);
                break;
            case "booktitle":
                book.setTitle(value);
                break;
            case "price":
                book.setPrice(Float.parseFloat(value));
                break;
            default:
                break;
        }
    }
}

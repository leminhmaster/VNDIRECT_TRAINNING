import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

public class RSSParser {
    public static void extract(Document doc){
        //System.out.println(1);
        NodeList channels = doc.getElementsByTagName("channel");

        for (int i = 0; i < channels.getLength(); i++) {
            Document chapter = channels.item(i).getOwnerDocument();
            NodeList items = chapter.getElementsByTagName("item");
            IntStream.range(0,items.getLength()).forEach(idx->{
                System.out.println(items.item(idx).getTextContent());
            });
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuider = dbFactory.newDocumentBuilder();
        InputStream stream = ElementCounter.class.getResource("tintuc.xml").openStream();
        Document doc = dbBuider.parse(stream);
        Document doc1 = dbBuider.parse("https://vnexpress.net/rss/tin-moi-nhat.rss");
        extract(doc1);
    }
}

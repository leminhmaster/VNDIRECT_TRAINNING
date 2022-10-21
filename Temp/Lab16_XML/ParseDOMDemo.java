import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.stream.IntStream;

public class ParseDOMDemo {
    static void print(Node node){
        short type = node.getNodeType();
        if (type == Node.COMMENT_NODE || type == Node.PROCESSING_INSTRUCTION_NODE)return;
        System.out.println(node.getNodeName()+":"+node.getNodeValue());
        NodeList list = node.getChildNodes();
        NamedNodeMap attributes = node.getAttributes();
        if (attributes!=null){
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("attributes:"+attributes.item(i).getNodeName()+":"+attributes.item(i).getNodeValue());
            }
        }
        for (int i = 0; i < list.getLength(); i++){
            System.out.println(list.item(i));
        }
    }
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuider = dbFactory.newDocumentBuilder();
        InputStream stream = ElementCounter.class.getResource("Books.xml").openStream();

        Document doc = dbBuider.parse(stream);
        NodeList list = doc.getChildNodes().item(0).getChildNodes().item(1).getChildNodes().item(1).getChildNodes();
//        System.out.println(list.getLength());
//        IntStream.range(0,list.getLength()).forEach(node->{
//            System.out.println(list.item(node).getNodeName()+":"+list.item(node).getAttributes());
//        });
        print(list.item(1));
        //System.out.println(doc.getNodeName()+":"+doc.getChildNodes().item(0).getTextContent());

    }
}

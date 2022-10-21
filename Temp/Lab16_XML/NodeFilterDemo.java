import org.w3c.dom.*;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class NodeFilterDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuider = dbFactory.newDocumentBuilder();
        InputStream stream = ElementCounter.class.getResource("Books.xml").openStream();
        Document doc = dbBuider.parse(stream);
        Element element = doc.createElement("book");
        element.setAttribute("page","128");
        Text text = doc.createTextNode("hihi");
        element.appendChild(text);

        NodeList nodes = doc.getChildNodes().item(0).getChildNodes().item(1).getChildNodes();
        Node node = nodes.item(1);
        node.appendChild(element);

        DocumentTraversal dt = (DocumentTraversal) doc;
        NodeIterator iterator = dt.createNodeIterator(doc, NodeFilter.SHOW_ELEMENT, new NodeFilter() {
            @Override
            public short acceptNode(Node n) {
                if (n.getNodeName().equals("book")) return 1;
                return -1;
            }
        },true);
        while (true){
            Node n = iterator.nextNode();
            if (n==null) break;
            System.out.println("Element Name : "+n.getTextContent());
        }
    }
}

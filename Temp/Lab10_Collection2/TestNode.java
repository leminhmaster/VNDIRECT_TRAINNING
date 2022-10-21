public class TestNode {
    private static void test(Node<?> node){
        while (node != null) {
            System.out.println("Value is '"+ node.getter() + "'");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node<String> root = new Node<>("Step 1");
        Node<String> node = new Node<>("Step 2");
        Node<String> node2 = new Node<>("Step 3");
        Node<String> node3 = new Node<>("Step 4");
        root.next = node;
        node.next = node2;
        node2.next = node3;
        test(root);
    }
}

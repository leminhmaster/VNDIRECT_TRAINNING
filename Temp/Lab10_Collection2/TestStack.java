public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        while (stack.hasNext()){
            System.out.println("data = "+stack.pop());
        }
    }
}

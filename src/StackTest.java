public class StackTest {
    public static void main(String[] args) throws Exception {
        MyStack<String> list = new MyStack<>();
        list.push("abc1");
        list.push("abc2");
        list.push("abc3");
        list.push("abc4");
        list.push("abc5");
        System.out.println("list.pop(3) = " + list.pop());
        System.out.println("list.peek(3) after pop() = " + list.peek());
        list.remove(3);
        System.out.println("list.peek() after remove() = " + list.peek());
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println("list.size() after clear() = " + list.size());
    }
}

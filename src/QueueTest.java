public class QueueTest {
    public static void main(String[] args) {
        MyQueue<String> list = new MyQueue<>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        list.add("abc5");
        System.out.println("list.pool(3) = " + list.pool());
        System.out.println("list.peek(3) after pool() = " + list.peek());
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println("list.size() after clear() = " + list.size());
    }
}

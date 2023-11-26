public class LinkedListTest {
    public static void main(String[] args) throws Exception {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        list.add("abc5");
        System.out.println("list.get(3) = " + list.get(3));
        list.remove(3);
        System.out.println("list.get(3) after remove() = " + list.get(3));
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println("list.size() after clear() = " + list.size());
    }
}

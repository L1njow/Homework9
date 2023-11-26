public class HashMapTest {
    public static void main(String[] args) throws Exception {
        MyHashMap<String, Integer> list = new MyHashMap<>();
        list.put("abc1", 1);
        list.put("abc2", 2);
        list.put("abc3", 3);
        list.put("abc4", 4);
        list.put("abc5", 5);
        System.out.println("list.get(3) = " + list.get("abc3"));
        list.remove("abc3");
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println("list.size() after clear() = " + list.size());
    }
}

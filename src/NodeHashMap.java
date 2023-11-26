public class NodeHashMap<K, V> {
    private K key;
    private V value;
    private NodeHashMap<K, V> nextNode;
    private NodeHashMap<K, V> prevNode;

    public NodeHashMap(K key, V value, NodeHashMap<K, V> nextNode, NodeHashMap<K, V> prevNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public NodeHashMap<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeHashMap<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public NodeHashMap<K, V> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(NodeHashMap<K, V> prevNode) {
        this.prevNode = prevNode;
    }
}

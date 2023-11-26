public class MyHashMap<K, V> {
    private NodeHashMap<K, V>[] buckets = new NodeHashMap[10];
    private int size = 0;
    public void put(K key, V value) {
        int hash = key.hashCode();
        int hashNumber = hash % buckets.length;
        if (buckets[hashNumber] == null) {
            buckets[hashNumber] = new NodeHashMap(key, value, null, null);
        } else {
            NodeHashMap<K, V> buff = new NodeHashMap(key, value, buckets[hashNumber], null);
            buckets[hashNumber] = buff;
        }
        size++;
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int hashNumber = hash % buckets.length;
        if (buckets[hashNumber] == null) {
            return;
        } else {
            NodeHashMap<K, V> prevNode = null;
            NodeHashMap<K, V> currentNode = buckets[hashNumber];
            while (currentNode != null) {
                if (currentNode.getPrevNode() == null) {
                    NodeHashMap<K, V> buff = buckets[hashNumber];
                    buckets[hashNumber] = buckets[hashNumber].getNextNode();
                    //buckets[hashNumber].setPrevNode(null);
                    buff.setValue(null);
                    buff.setPrevNode(null);
                    buff.setNextNode(null);
                } else if (currentNode.getNextNode() == null) {
                    NodeHashMap<K, V> buff = currentNode;
                    currentNode = currentNode.getPrevNode();
                    currentNode.setNextNode(null);
                    buff.setValue(null);
                    buff.setPrevNode(null);
                    buff.setNextNode(null);
                } else {
                    prevNode.setNextNode(currentNode.getNextNode());
                    currentNode.getNextNode().setPrevNode(prevNode);
                    currentNode.setNextNode(null);
                    currentNode.setPrevNode(null);
                    currentNode.setValue(null);
                }
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            size--;
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                NodeHashMap<K, V> currentNode = buckets[i];
                while (currentNode != null) {
                    NodeHashMap<K, V> nextNode = currentNode.getNextNode();
                    currentNode.setNextNode(null);
                    currentNode.setPrevNode(null);
                    currentNode.setValue(null);
                    currentNode = nextNode;
                }
                buckets[i] = null;
            }
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int hashNumber = hash % buckets.length;
        boolean inCollection = false;
        V result = null;
        if (buckets[hashNumber] != null) {
            NodeHashMap<K, V> currentNode = buckets[hashNumber];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    result = currentNode.getValue();
                    inCollection = true;
                }
                currentNode = currentNode.getNextNode();
            }
        }
        if (inCollection) {
            return result;
        } else {
            throw new IllegalArgumentException("Wrong key");
        }
    }
}

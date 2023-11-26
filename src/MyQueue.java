public class MyQueue<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(value, null, null);
        } else if (lastNode == null) {
            lastNode = new Node<>(value, null, firstNode);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> buff = new Node<>(value, null, lastNode);
            lastNode.setNextNode(buff);
            lastNode = buff;
        }
        size++;
    }

    public void clear() {
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNextNode();
            currentNode.setNextNode(null);
            currentNode.setPrevNode(null);
            currentNode.setValue(null);
            currentNode = nextNode;
        }
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return firstNode.getValue();
    }

    public T pool() {
        T result = firstNode.getValue();
        Node<T> buff = firstNode;
        firstNode = firstNode.getNextNode();
        firstNode.setPrevNode(null);
        buff.setValue(null);
        buff.setPrevNode(null);
        buff.setNextNode(null);
        size--;
        return result;
    }
}

public class MyLinkedList<T> {
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

    public void remove(int index) {
        if (index >= 0 && index < size) {
            Node<T> prevNode = null;
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            if (index == 0) {
                Node<T> buff = firstNode;
                firstNode = firstNode.getNextNode();
                //firstNode.setPrevNode(null);
                buff.setValue(null);
                buff.setPrevNode(null);
                buff.setNextNode(null);
            } else if (index == size - 1) {
                Node<T> buff = lastNode;
                lastNode = lastNode.getPrevNode();
                lastNode.setNextNode(null);
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
            size--;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds");
        }
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

    public T get(int index) {
        if (index >= 0 && index < size) {
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getValue();
        } else {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }
}

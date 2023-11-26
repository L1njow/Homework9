import java.util.Arrays;

public class MyStack<T> {
    private Object[] values;
    private int size = 0;
    public MyStack() {
        this.values = new Object[10];
    }

    public void push(Object value) {
        refactor();
        values[size] = value;
        size++;
    }

    private void refactor() {
        if (values.length == size) {
            values = Arrays.copyOf(values, size + 10);
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    public void remove(int index) throws Exception {
        if (index >= 0 && index < size) {
            Object[] buff = new Object[values.length - 1];
            for (int i = 0; i < size; i++) {
                if (i < index) {
                    buff[i] = values[i];
                }
                if (i > index) {
                    buff[i - 1] = values[i];
                }
            }
            size--;
            for (int i = 0; i < size; i++) {
                values[i] = null;
            }
            values = buff;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    public int size() {
        return size;
    }

    public T peek() {
        return (T) values[size - 1];
    }

    public T pop() {
        Object result = values[size - 1];
        values = Arrays.copyOf(values, size - 1);
        size--;
        return (T) result;
    }
}

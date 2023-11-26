import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] values;
    private int size = 0;

    public MyArrayList() {
        this.values = new Object[10];
    }

    public void add(Object value) {
        refactor();
        values[size] = value;
        size++;
    }

    private void refactor() {
        if (values.length == size) {
            values = Arrays.copyOf(values, size + 10);
        }
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
            for (int i = 0; i < size - 1; i++) {
                values[i] = null;
            }
            values = buff;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) values[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }
}

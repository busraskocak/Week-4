import java.util.Arrays;

public class MyList<T> {
    private Object[] array;
    private int size;
    private int capacity;

    public MyList() {
        this.capacity = 10;
        this.array = new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        ensureCapacity();
        array[size++] = data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        T removed = (T) array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return removed;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            return;
        }
        array[index] = data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public T[] toArray() {
        return Arrays.copyOf(array, size, (Class<? extends T[]>) array.getClass());
    }

    public void clear() {
        array = new Object[capacity];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = capacity * 2;
            array = Arrays.copyOf(array, newCapacity);
            capacity = newCapacity;
        }
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || start >= size || finish < start || finish >= size) {
            throw new IllegalArgumentException("Invalid start or finish index");
        }

        MyList<T> sublist = new MyList<>();

        for (int i = start; i <= finish; i++) {
            sublist.add(get(i));
        }

        return sublist;
    }


    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}

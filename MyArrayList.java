import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Evaldas on 2015-03-27.
 */
public class MyArrayList implements Iterable {

    public static final int DEFAULT_SIZE = 5;
    public static final int EXPANSION = 5;
    private int capacity;
    private int size;
    private Object[] items;

    public Iterator iterator(){
        return new NewIterator();
    }

    public MyArrayList() {
        size = 0;
        capacity = DEFAULT_SIZE;
        items = new Object[DEFAULT_SIZE];
    }

    public class NewIterator implements Iterator{
        private int index = 0;
        public boolean hasNext(){
            return index < size;
        }
        public Object next(){
            if(index>=size)
                throw new NoSuchElementException();
            index++;
            return items[index-1];
        }
    }

    private void expand() {
        Object[] newItems = new Object[capacity + EXPANSION];
        for (int j = 0; j < size; j++) newItems[j] = items[j];
        items = newItems;
        capacity = capacity + EXPANSION;
    }

    public void add(Object obj) {
        if (size >= capacity) this.expand();
        items[size] = obj;
        size++;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        try{
            if(index < 0 || index >= size())
                throw new IndexOutOfBoundsException("Problem occurred at index "+index);
        } catch(ArrayIndexOutOfBoundsException ex){}
        return items[index];
    }

    public boolean contains(Object obj) {
        for (int j = 0; j < size; j++) {
            if (obj.equals(this.get(j))) return true;
        }
        return false;
    }

    public void add(int index, Object obj) {
        try{
            if(index < 0 || index >= size())
                throw new IndexOutOfBoundsException("Problem occurred at index "+index);
        } catch(ArrayIndexOutOfBoundsException ex){}
        if (size >= capacity) this.expand();
        for (int j = size; j > index; j--) items[j] = items[j - 1];
        items[index] = obj;
        size++;
    }

    public int indexOf(Object obj) {
        for (int j = 0; j < size; j++) {
            if (obj.equals(this.get(j))) return j;
        }
        return -1;
    }

    public boolean remove(Object obj) {
        for (int j = 0; j < size; j++) {
            if (obj.equals(this.get(j))) {
                for (int k = j; k < size-1; k++) items[k] = items[k + 1];
                size--;
                items[size] = null;
                return true;
            }
        }
        return false;
    }

    public Object remove(int index) {
        Object result = this.get(index);
        for (int k = index; k < size-1; k++) items[k] = items[k + 1];
        size--;
        items[size] = null;
        return result;
    }

    public void set(int index, Object obj) {
        try{
            if(index < 0 || index >= size())
                throw new IndexOutOfBoundsException("Problem occurred at index "+index);
        } catch(ArrayIndexOutOfBoundsException ex){}
        items[index] = obj;
    }
}

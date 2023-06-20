public class Array <T> {

    private T items[];

    public Array(int size) {
        items = (T[]) new Object[size];
    }

    public Array(T arr[]) {
        items = arr;
    }

    public boolean add(int index, T item) {
        if (index < 0 || index > items.length)
            return false;
        // add your code
        items[index] = item;
        return true;
    }

    public boolean replace(int index, T item) {
        if (index < 0 || index > items.length)
            return false;
        // add your code
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > items.length)
            return false;
        // add your code
        items[index] = null;
        return true;
    }

    public int numItems() {
        return items.length;
    }

    public boolean changeSize(int nsize) {

        // add your code
        items = (T[]) new Object[nsize];
        return true;
    }
    T x;
    public T grab() {
        // add your code
        return x;
    }

    public T[] toArray() {
        return items;

    }

//	private T[] item;
//	Array(int size) {
//		items = (T[]) new object[5] array(5);
//	}
//	Array(T[] array) {
//		items = array;
//	}
//	public boolean add(int index, T item) {
//	if (index < 0 || index > items.length)
//		return false;
//	return true
//	}
//
//
//	public boolean changeSize()



//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}

interface List<T> {
    void add(T element);
    void put(T element, int index);
    void remove(int index);
    int find(T element);
    T get(int index);
}

class ArrayList<T> implements List<T> {
    private static final int DEFAULT_ARRAYLIST_SIZE = 10;
    public int capacity = DEFAULT_ARRAYLIST_SIZE;
    private T[] elementData;
    int size = 0;
    private int lastElement = 0;
	
    public ArrayList() {
        elementData = (T[])new Object[DEFAULT_ARRAYLIST_SIZE];
    }
	
    public ArrayList(int capacity) {
	elementData =(T[])new Object[capacity];
        this.capacity = capacity;
    }
    
    @Override
    public void add(T element) {
        if (size < capacity) {
            elementData[size++] = element;
        } else {
            T[] tmp = (T[])new Object[capacity];
            for (int i = 0; i < capacity; ++i) {
                tmp[i] = elementData[i];
            }
            elementData = (T[])new Object[capacity * 2];
            for (int i = 0; i < capacity; ++i){
                elementData[i] = tmp[i];
            }
            capacity = capacity * 2;
            elementData[size++] = element;
        }
        lastElement = size;
    }
    
    @Override
    public void put(T element, int index) {
        
        if (index < capacity) {
            if (elementData[index] == null) {
                size++;
            }
            elementData[index] = element;
        } else {
            T[] tmp = (T[])new Object[capacity];
            for (int i = 0; i < capacity; ++i) {
                tmp[i] = elementData[i];
            }
            elementData = (T[])new Object[index * 2];
            for (int i = 0; i < capacity; ++i) {
                elementData[i] = tmp[i];
            }
            capacity = index * 2;
            elementData[index] = element;
            lastElement = index + 1;
            size++;
        }
    }
    
    @Override
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elementData[index] = null;
        int i = index;
        for (; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[i] = null;
        size--;
        lastElement = size;
    }
    
    @Override
    public int find(T element) {
        for (int i = 0; i < size; ++i) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }
    
    public void print() {
        for (int i = 0; i < lastElement; ++i) {
            System.out.print(elementData[i] + " ");
        } 
        System.out.println();
    }
}

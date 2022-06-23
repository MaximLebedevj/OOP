import java.util.Iterator;


interface List<T> {
	void add(T element);
    void put(T element, int index);
    T get(int index);
    int find(T element);
    void remove(int index);
    void print();
}

class Node<T> {
	
	public Node<T> next;
    public Node<T> prev;
    public T data;

    public Node(T value) {
    	next = null;
        prev = null;
    	this.data = value; 
    }
}

class LinkedList<T> implements List<T>, Iterable<T> {
   
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    static class LinkedListIterator<T> implements Iterator<T> {
    	
        private Node<T> cur;
        private final Node<T> tail;
        
        public LinkedListIterator(Node<T> head, Node<T> tail) {
            this.cur = head;
            this.tail = tail;
        }

        @Override
        public boolean hasNext() {
            return cur != tail.next;
        }

        @Override
        public T next() {
            Node<T> newNode = cur;
            cur = cur.next;
            return newNode.data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedList.LinkedListIterator<>(head, tail);
    }
    
    public int getSize() {
    	return this.size;
    } 
    
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        ++size;
    }
    
    @Override
    public void put(T value, int index) {
        Node<T> newNode = new Node<>(value);
        if (size == 1) {
        	newNode.next = head;
            head = newNode;
        } else {
            if (index == size - 1) {
            	newNode.prev = tail.prev;
                tail.prev.next = newNode;
                newNode.next = tail;
            } else if (index == 0) {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            } else {
                Node<T> nodeToPut = head;
                for (int i = 0; i < index; ++i) {
                	nodeToPut = nodeToPut.next;
                }
                Node<T> prevNode = nodeToPut.prev;

                newNode.prev = prevNode;
                prevNode.next = newNode;

                newNode.next = nodeToPut;
                nodeToPut.prev = newNode;
            }
        }
        size++;
    }
    
    @Override
    public T get(int index) {
        Node<T> newNode = head;
        for (int i = 0; i < index; ++i) {
        	newNode = newNode.next;
        }
        return newNode.data;
    }

    @Override
    public int find(T element) {
        Node<T> newNode = head;
        for (int i = 0; i < size; ++i) {
            if (newNode.data == element) {
                return i;
            }
            newNode = newNode.next;
        }
        return -1;
    }

    @Override
    public void print() {
        for (Node<T> temp = head; temp != null; temp = temp.next) {
          System.out.print(temp.data + " ");
        }
        System.out.println();
      }
    
    @Override
    public void remove(int index) {
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            Node<T> previousNode = node.prev;
            Node<T> nextNode = node.next;

            if (previousNode == null) {
                head = nextNode;
                head.prev = null;
            } else if (nextNode == null) {
                tail = previousNode;
                tail.next = null;
            } else {
                previousNode.next = nextNode;
                nextNode.prev = previousNode;
            }
        }
        size--;
    }
}

public class Program {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(10);
		list.add(9);
		list.add(21);
		list.add(100);
		list.add(81);
		list.put(11, 0);
		list.put(12, 0);
		list.put(15, 0);
		list.put(18, 3);
		
		System.out.println(list.find(21));
		
		System.out.println(list.getSize());
		
		list.print();
		
		for (int element : list) {
			System.out.print(element + " ");
		}
		
	}
}



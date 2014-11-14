public class LinkedList<T>{

	private Node<T> head;
	private Node<T> tail;
	private int length = 0;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public LinkedList(T data) {
		Node<T> node = new Node<T>(data);
		this.head = node;
		this.tail = node;
		length++;
	}
	
	public LinkedList(Node<T> head) {
		this.head = head;
		this.tail = head;
		length++;
	}
	
	public boolean isEmpty() {
		if (head == null && tail == null) {
			return true;
		}
		
		return false;
	}
	
	public int getLength() {
		return length;
	}
	
	public void append(T data) {
		Node<T> node = new Node<T>(data);
		
		if (isEmpty()) {
			this.head = node;
			this.tail = node;
			length++;
		}
		
		else {
			tail.next = node;
			this.tail = node;
			length++;
		}
	}
	
	public void prepend(T data) {
		Node<T> node = new Node<T>(data);
		
		if (isEmpty()) {
			this.head = node;
			this.tail = node;
			length++;
		}
		else {
			node.next = head;
			head = node;
			length++;
		}
	}
	
	public boolean insert(T data, int index) {
		Node<T> node = new Node<T>(data);
		Node<T> temp = head.next;
		Node<T> tempPrev = head;
		
		if (index > length - 1) {
			return false;
		}
		else if(index == length - 1) {
			tail.next = node;
			tail = node;
			length++;
			return true;
		}
		else if(index == 0) {
			node.next = head;
			head = node;
			length++;
			return true;
		}
		else {
			while (index != 1) {
				temp = temp.next;
				tempPrev = tempPrev.next;
				index--;
			}
			
			node.next = temp;
			tempPrev.next = node;
			length++;
			return true;
		}
	
	}
	
	public void reverse() {
		int swapsRemaining = length - 4;
		Node<T> temp = head.next;
		Node<T> temp1 = temp.next;
		Node<T> temp2 = temp1.next;
		
		tail = head; 
		tail.next = null;
		temp.next = tail;
		
		while (swapsRemaining > 0) {
			temp1.next = temp;
			temp = temp1;
			temp1 = temp2;
			temp2 = temp2.next;
						
			swapsRemaining--;
		}
		
		temp1.next = temp;
		temp2.next = temp1;
		head = temp2;
	}
	
	public void print() {
		Node<T> temp = head;
		for (int i = 0; i < length; i++) {
			System.out.println(temp.toString());
			temp = temp.next;
		}
		System.out.println("The lenght of the list is: " + length);
	}
	
}
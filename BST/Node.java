public class Node<T> {
	public int data;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void addLeft(int data) {
		Node node = new Node(data);
		this.left = node;
	}
	
	public void addRight(int data) {
		Node node = new Node(data);
		this.right = node;
	}

	public int getSize() {
		int size = 1;
		
		if (left != null) {
			size += left.getSize();
		}
		
		if (right != null) {
			size += right.getSize();
		}
		
		return size;
	}
	
	public void print() {
		System.out.println(this.data);
	}
	
	public void printTreeInOrder() {
		
		if (left != null) {
			left.printTreeInOrder();
		}
		
		print();
		
		if (right != null) {
			right.printTreeInOrder();
		}
		
	}
	
	public void printTreePreOrder() {
		print();
		
		if (left != null) {
			left.printTreePreOrder();
		}
		
		if (right != null) {
			right.printTreePreOrder();
		}
		
	}
	
	public void printTreePostOrder() {
		
		if (left != null) {
			left.printTreePostOrder();
		}
		
		if (right != null) {
			right.printTreePostOrder();
		}
		
		print();
		
	}
	
	public boolean search(int value) {
		if (this.data == value) {
			return true;
		}
		if (value > data) {
			if (this.right != null) {
				return this.right.search(value);
			}
		}
		if (value < data) {
			if (this.left != null) {
				return this.left.search(value);
			}
		}
		
		return false;
		
	}
	
	public void insert(int value) {
		if (value == this.data) {
			return;
		}
		
		if (value < this.data) {
			if (this.left == null) {
				addLeft(value);
			}
			else {
				left.insert(value);
			}
		}
		
		if (value > this.data) {
			if (this.right == null) {
				addRight(value);
			}
			else {
				right.insert(value);
			}
		}
	}
	
	public int maxDepth() {
		int depthLeft = 1;
		int depthRight = 1;
		
		if (left != null) {
			depthLeft += left.maxDepth();
		}
		
		if (right != null) {
			depthRight += right.maxDepth();
		}
		
		return Math.max(depthLeft, depthRight);
	}
	
	public int minValue() {
		int minValueLeft = this.data;
		int minValueRight = this.data;
		
		if (left != null) {
			minValueLeft = Math.min(minValueLeft, left.minValue());
		}
		
		if (right != null) {
			minValueRight = Math.min(minValueRight, right.minValue());
		}
		
		return Math.min(minValueLeft, minValueRight);
	}
	
	public int maxValue() {
		int maxValueLeft = this.data;
		int maxValueRight = this.data;
		
		if (left != null) {
			maxValueLeft = Math.max(maxValueLeft, left.maxValue());
		}
		
		if (right != null) {
			maxValueRight = Math.max(maxValueRight, right.maxValue());
		}
		
		return Math.max(maxValueLeft, maxValueRight);
	}
	
	public int hasPathSum(int value) {
		if (left == null && right == null && this.data == value) {
			return 1;
		}
		
		if (left != null) {
			hasPathSum(
		}
		
		if (right != null) {
			valueRight += right.hasPathSum(valueRight);
		}
		
		return 0;
		
	}
	
	public static void main (String[] args) {
		Node root = new Node(4);
		root.insert(5);
		root.insert(3);
		root.insert(1);
		root.insert(8);
		root.insert(10);
		root.insert(2);
		
		root.printTreeInOrder();
		System.out.println("Tree Size: " + root.getSize());
		System.out.println("Max Depth: " + root.maxDepth());
		System.out.println("Min Value: " + root.minValue());
		System.out.println("Max Value: " + root.maxValue());
		System.out.println("Has Path Sum: 4 " + root.hasPathSum(4));
	}


}
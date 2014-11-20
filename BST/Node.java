import java.util.ArrayList;

public class Node {
	public int data;
	public boolean visited = false;
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
		if (value < this.data) {
			return 0;
		}
	
		value = value - this.data;
		
		int leftPath = 0;
		int rightPath = 0;
	
		if (left == null && right == null && value == 0) {
			return 1;
		}
		
		
		if (left != null) {     
			leftPath = left.hasPathSum(value);
		}
		
		if (right != null) {
			rightPath = right.hasPathSum(value);
		}
		
		return Math.max(leftPath, rightPath);
	}
	
	public int numberOfPaths() {
		int paths = 0;
		
		if (left == null && right == null) {
			paths++;
		}
		
		if (left != null) {
			paths += left.numberOfPaths();
		}
		
		if (right != null) {
			paths += right.numberOfPaths();
		}
		
		return paths;
	}
	
	
	
	public void printPaths(ArrayList<Integer> list) {
		
		list.add((Integer)this.data);
		
		if (left == null & right == null) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}	
			System.out.println();
		}
		
		if (left != null) {
			left.printPaths(list);
		}
		
		if (right != null) {
			right.printPaths(list);
		}
		
		list.remove((Integer)this.data);
	
	}
		
	
	public static void main (String[] args) {
		Node root = new Node(4);
		root.insert(5);
		root.insert(3);
		root.insert(1);
		root.insert(8);
		root.insert(10);
		root.insert(2);
		root.insert(7);
		root.insert(0);
		
		root.printTreeInOrder();
		System.out.println("Tree Size: " + root.getSize());
		System.out.println("Max Depth: " + root.maxDepth());
		System.out.println("Min Value: " + root.minValue());
		System.out.println("Max Value: " + root.maxValue());
		
		int x = 24;
		System.out.println("Has Path Sum: " + x + " " + root.hasPathSum(x));
		System.out.println("Number of paths: " + root.numberOfPaths());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		root.printPaths(list);
	}


}
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
	
	public void mirror() {
		
		Node temp = this.left;
		this.left = this.right;
		this.right = temp;
		
		if (left != null) {
			left.mirror();
		}
		
		if (right != null) {
			right.mirror();
		}
	
	}
	
	public void doubleTree() {
	
		Node newNode = new Node(this.data);
		
		newNode.left = this.left;
		this.left = newNode;
		
		if (left.left != null) {
			left.left.doubleTree();
		}
		
		if (right != null) {
			right.doubleTree();
		}
	
	}
	
	public boolean sameTree(Node node1) {
		boolean leftTree = true, rightTree = true;
		
		if (node1.data != this.data) {
			return false;
		}
		
		if (node1.left != null && left == null || node1.left == null && left != null) {
			return false;
		}
		
		if (node1.right != null && right == null || node1.right == null && right != null) {
			return false;
		}
		
		if (node1.left != null && this.left != null) {
			leftTree = left.sameTree(node1.left);
		}
		
		if (node1.right != null && this.right != null) {
			rightTree = right.sameTree(node1.right);
		}
		
		return (leftTree && rightTree);
	
	}
		
	
	public static void main (String[] args) {
		Node root = new Node(4);
		root.insert(5);
		root.insert(3);
		root.insert(1);
		root.insert(8);
		root.insert(2);
		root.insert(10);
		root.insert(2);
		root.insert(7);
		root.insert(0);
		
		Node root2 = new Node(4);
		root2.insert(5);
		root2.insert(3);
		root2.insert(1);
		root2.insert(8);
		root2.insert(10);
		root2.insert(2);
		root2.insert(7);
		root2.insert(0);
		
		root.printTreeInOrder();
		root2.printTreeInOrder();
		System.out.println("Tree Size: " + root.getSize());
		System.out.println("Max Depth: " + root.maxDepth());
		System.out.println("Min Value: " + root.minValue());
		System.out.println("Max Value: " + root.maxValue());
		
		int x = 24;
		System.out.println("Has Path Sum: " + x + " " + root.hasPathSum(x));
		System.out.println("Number of paths: " + root.numberOfPaths());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		root.printPaths(list);
		
		boolean xxx = root.sameTree(root2);
		System.out.println(xxx);
		
		
	}


}
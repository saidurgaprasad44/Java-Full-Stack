package javaPrograms;

public class Trees {

	public static void main(String[] args) {
		Bst bst = new Bst();
		
		bst.insert(50);
		bst.insert(30);
		bst.insert(70);
		bst.insert(20);
		bst.insert(40);
		bst.insert(60);
		bst.insert(80);
		
		bst.display();

	}

}

class Node{
	int data;	
	Node leftChild;
	Node rightChild;
	
	public Node(int data){
		this.data = data;
	}
}

class Bst{
	private Node root;
	
	public void insert(int data) {
		if(root == null) {
			root = new Node(data);
		}
		else{
			recursiveInsert(root, data);
		}
	}
	
	public void recursiveInsert(Node current, int data) {
		if(data < current.data)
			if(current.leftChild == null)
				current.leftChild = new Node(data);
			else
				recursiveInsert(current.leftChild, data);
		else if(data > current.data)
			if(current.rightChild == null)
				current.rightChild = new Node(data);
			else	
				recursiveInsert(current.rightChild, data);
		else
			return;
	}
	
	public void display() {
		inOrder(root);
		System.out.println();
	}
	
	public void inOrder(Node current) {
		if(current == null)
			return;
		
		inOrder(current.leftChild);
		System.out.println(current.data + " ");
		inOrder(current.rightChild);
	}
}
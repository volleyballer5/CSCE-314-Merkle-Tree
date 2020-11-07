
public abstract class BinaryTree {
	
	private BinaryNode root;
	
	BinaryTree() {}

	public BinaryNode getRoot() {return root;}
	public void setRoot(BinaryNode root) {this.root = root;}
	
	public abstract void build();
	
	public void display() {}
	
}

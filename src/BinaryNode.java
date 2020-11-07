
public class BinaryNode {
	
	private int hashValue;
	private BinaryNode left;
	private BinaryNode right;
	
	BinaryNode()
	{
		
	}
	
	BinaryNode(int hash)
	{
		this.hashValue = hash;
	}
	
	BinaryNode(int hash, BinaryNode left, BinaryNode right)
	{
		this.hashValue = hash;
		this.left = left;
		this.right = right;
	}

	public int getHashValue() {
		return hashValue;
	}

	public void setHashValue(int hashValue) {
		this.hashValue = hashValue;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public boolean equals(BinaryNode node)
	{
		return false;
	}
	
	public String toString()
	{
		return "implement me";
	}
	
	public int depth()
	{
		return -1;
	}
}

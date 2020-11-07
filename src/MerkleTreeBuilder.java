import java.util.*;

public class MerkleTreeBuilder {

	private int hashedRoot;
	private Vector<int> hashedLines;
	
	MerkleTreeBuilder() {}
	MerkleTreeBuilder(String filename) {}
	
	public int getHashedRoot() {return hashedRoot;}
	public void setHashedRoot(int hashedRoot) {this.hashedRoot = hashedRoot;}
	public Vector<int> getHashedLines() {return hashedLines;};
	
	public void addHasedLine(int line) {}
	
	public Vector<String> parseLine(String line) {}
	
	public int hashLine(Vector<String> line) {}
	
	public int hashNodes(BinaryNode leftNode, BinaryNode, rightNode) {}

}

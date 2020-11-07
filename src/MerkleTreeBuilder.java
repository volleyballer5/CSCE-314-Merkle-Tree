import java.util.*;

public class MerkleTreeBuilder {

	private int hashedRoot;
	private Vector<Integer> hashedLines;
	
	MerkleTreeBuilder() {}
	MerkleTreeBuilder(String filename) {}
	
	public int getHashedRoot() {return hashedRoot;}
	public void setHashedRoot(int hashedRoot) {this.hashedRoot = hashedRoot;}
	public Vector<Integer> getHashedLines() {return hashedLines;};
	
	public void addHasedLine(int line) {}
	
	public Vector<String> parseLine(String line) {return null;}
	
	public int hashLine(Vector<String> line) {return -1;}
	
	public int hashNodes(BinaryNode leftNode, BinaryNode rightNode) {return -1;}

}

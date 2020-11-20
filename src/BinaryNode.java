import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*****************************************
** File:    BinaryNode.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the the BinaryNode class which 
**  is a class created to represent the nodes in the
**  Merkle Tree as well as some methods to aid in 
**  searching and verifying nodes.
**
**
***********************************************/

public class BinaryNode {
	
	protected String hashValue;
	protected BinaryNode left;
	protected BinaryNode right;
	
	//-------------------------------------------------------
	// Name: BinaryNode()
	// PreCondition:  none
	// PostCondition: creates default BinaryNode
	//---------------------------------------------------------
	BinaryNode()
	{
		this.hashValue = "";
		this.left = null;
		this.right = null;
	}
	
	//-------------------------------------------------------
	// Name: BinaryNode(BinaryNode child)
	// PreCondition:  none
	// PostCondition: creates BinaryNode for leaf
	//---------------------------------------------------------
	BinaryNode(BinaryNode child)
	{
		this.hashValue = child.getHashValue();
		this.left = child;
		this.right = null;
	}
	
	//-------------------------------------------------------
	// Name: BinaryNode(int hash, BinaryNode left, BinaryNode right)
	// PreCondition:  none
	// PostCondition: creates BinaryNode with hash value and predefined children
	//---------------------------------------------------------
	BinaryNode(BinaryNode left, BinaryNode right)
	{
		this.left = left;
		this.right = right;
		this.hashValue = createHashFromChildren();
	}

	//-------------------------------------------------------
	// Name: getHashValue()
	// PreCondition:  none
	// PostCondition: returns the current hashValue
	//---------------------------------------------------------
	public String getHashValue() {return hashValue;}

	//-------------------------------------------------------
	// Name: setHashValue(int hashValue)
	// PreCondition:  none
	// PostCondition: sets hashValue to the passed argument
	//---------------------------------------------------------
	public void setHashValue(String hashValue) {this.hashValue = hashValue;}

	//-------------------------------------------------------
	// Name: getLeft()
	// PreCondition:  none
	// PostCondition: returns the left child
	//---------------------------------------------------------
	public BinaryNode getLeft() {return left;}

	//-------------------------------------------------------
	// Name: setLeft(BinaryNode left)
	// PreCondition:  none
	// PostCondition: sets the left child to a passed BinaryNode
	//---------------------------------------------------------
	public void setLeft(BinaryNode left)
	{
		this.left = left;
		this.hashValue = createHashFromChildren();
	}

	//-------------------------------------------------------
	// Name: getRight()
	// PreCondition:  none
	// PostCondition: returns the right child
	//---------------------------------------------------------
	public BinaryNode getRight() {return right;}

	//-------------------------------------------------------
	// Name: setRight(BinaryNode right)
	// PreCondition:  none
	// PostCondition: sets the right child to a passed BinaryNode
	//---------------------------------------------------------
	public void setRight(BinaryNode right)
	{
		this.right = right;
		this.hashValue = createHashFromChildren();
	}

	//-------------------------------------------------------
	// Name: equals(BinaryNode node)
	// PreCondition:  none
	// PostCondition: determines if two BinaryNode's are equal
	//---------------------------------------------------------
	public boolean equals(BinaryNode that)
	{
		if(! this.hashValue.equals(that.getHashValue()))
			return false;
		else if(this.left != that.getLeft())
			return false;
		else if(this.right != that.getRight())
			return false;
		else
			return true;
	}
	
	//-------------------------------------------------------
	// Name: toString()
	// PreCondition:  none
	// PostCondition: formats and prints the BinaryNode object
	//---------------------------------------------------------
	public String toString()
	{
		return "Hash: " + hashValue;
		//return "Hash: " + hashValue + "\n" + "Left Child: " + left.toString() + "\n" + "Right Child: " + right.toString();
	}
	
	
	
	private String createHashFromChildren()
	{
		String lHash = left.getHashValue();
		String rHash = right.getHashValue();
		String combinedHash = lHash + rHash;
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(
					combinedHash.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(encodedhash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
	protected String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}

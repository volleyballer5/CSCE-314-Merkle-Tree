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
	
	private int hashValue;
	private BinaryNode left;
	private BinaryNode right;
	
	//-------------------------------------------------------
	// Name: BinaryNode()
	// PreCondition:  none
	// PostCondition: creates default BinaryNode
	//---------------------------------------------------------
	BinaryNode()
	{
		
	}
	
	//-------------------------------------------------------
	// Name: BinaryNode(int hash)
	// PreCondition:  none
	// PostCondition: creates BinaryNode with given hash value
	//---------------------------------------------------------
	BinaryNode(int hash)
	{
		this.hashValue = hash;
	}
	
	//-------------------------------------------------------
	// Name: BinaryNode(int hash, BinaryNode left, BinaryNode right)
	// PreCondition:  none
	// PostCondition: creates BinaryNode with hash value and predefined children
	//---------------------------------------------------------
	BinaryNode(int hash, BinaryNode left, BinaryNode right)
	{
		this.hashValue = hash;
		this.left = left;
		this.right = right;
	}

	//-------------------------------------------------------
	// Name: getHashValue()
	// PreCondition:  none
	// PostCondition: returns the current hashValue
	//---------------------------------------------------------
	public int getHashValue() {
		return hashValue;
	}

	//-------------------------------------------------------
	// Name: setHashValue(int hashValue)
	// PreCondition:  none
	// PostCondition: sets hashValue to the passed argument
	//---------------------------------------------------------
	public void setHashValue(int hashValue) {
		this.hashValue = hashValue;
	}

	//-------------------------------------------------------
	// Name: getLeft()
	// PreCondition:  none
	// PostCondition: returns the left child
	//---------------------------------------------------------
	public BinaryNode getLeft() {
		return left;
	}

	//-------------------------------------------------------
	// Name: setLeft(BinaryNode left)
	// PreCondition:  none
	// PostCondition: sets the left child to a passed BinaryNode
	//---------------------------------------------------------
	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	//-------------------------------------------------------
	// Name: getRight()
	// PreCondition:  none
	// PostCondition: returns the right child
	//---------------------------------------------------------
	public BinaryNode getRight() {
		return right;
	}

	//-------------------------------------------------------
	// Name: setRight(BinaryNode right)
	// PreCondition:  none
	// PostCondition: sets the right child to a passed BinaryNode
	//---------------------------------------------------------
	public void setRight(BinaryNode right) {
		this.right = right;
	}

	//-------------------------------------------------------
	// Name: equals(BinaryNode node)
	// PreCondition:  none
	// PostCondition: determines if two BinaryNode's are equal
	//---------------------------------------------------------
	public boolean equals(BinaryNode node)
	{
		return false;
	}
	
	//-------------------------------------------------------
	// Name: toString()
	// PreCondition:  none
	// PostCondition: formats and prints the BinaryNode object
	//---------------------------------------------------------
	public String toString()
	{
		return "implement me";
	}
	
	//-------------------------------------------------------
	// Name: depth()
	// PreCondition:  none
	// PostCondition: returns the depth of the BinaryNode
	//---------------------------------------------------------
	public int depth()
	{
		return -1;
	}
}

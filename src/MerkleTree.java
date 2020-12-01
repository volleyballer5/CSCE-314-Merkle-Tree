/*****************************************
** File:    MerkleTree.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the the MerkleTree class which is a
** 	subclass of BinaryTree. This class represents a Merkle Tree
** 	which is representing a data file. Contains the method calls
** 	to construct and validate Merkle Trees.
**
**
***********************************************/

public class MerkleTree extends BinaryTree{

	private String file;
	
	//-------------------------------------------------------
	// Name: MerkeTree()
	// PreCondition:  none
	// PostCondition: Creates empty MerkleTree
	//---------------------------------------------------------
	MerkleTree() {
		file = null;
		root = null;
	}
	
	//-------------------------------------------------------
	// Name: MerkeTree(String filename)
	// PreCondition:  filename exists
	// PostCondition: Creates empty MerkleTree associated with filename
	//---------------------------------------------------------
	MerkleTree(String filename) {
		file = filename;
		root = null;
	}
	
	//-------------------------------------------------------
	// Name: getFile()
	// PreCondition:  none
	// PostCondition: returns file associated with Merkle Tree
	//---------------------------------------------------------
	public String getFile() {return file;}
	
	//-------------------------------------------------------
	// Name: setFile()
	// PreCondition:  none
	// PostCondition: updates associated file to passed value
	//---------------------------------------------------------
	public void setFile(String file) {this.file = file;}

	//-------------------------------------------------------
	// Name: build()
	// PreCondition:  none
	// PostCondition: Merkle Tree constructed from file and root updated
	//---------------------------------------------------------
	public void build() {
		MerkleTreeBuilder builder = new MerkleTreeBuilder(file);
		this.root = builder.build();
	}
	
	//-------------------------------------------------------
	// Name: validate(MerkleTree recent)
	// PreCondition:  recent has been constructed
	// PostCondition: returns whether two Merkle Trees match
	//---------------------------------------------------------
	public boolean validate(MerkleTree recent)
	{
		if(this.root != null) {
			return this.root.hashValue.equals(recent.getRoot().hashValue);
		}
		return false;
	}
	
	//-------------------------------------------------------
	// Name: depth()
	// PreCondition:  tree is not empty
	// PostCondition: returns the depth of the tree not counting leaves
	//---------------------------------------------------------
	public int depth() {
		if(root != null) {
			return 1 + depth(root.getRight());
		}
		return 0;
	}
	
	//-------------------------------------------------------
	// Name: depth(BinaryNode node)
	// PreCondition:  node exists
	// PostCondition: returns the depth of the passed node
	//---------------------------------------------------------
	private int depth(BinaryNode node) {
		if(node != null) {
			return 1 + depth(node.getRight());
		}
		return 0;
	}
	
}

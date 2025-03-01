/*****************************************
** File:    BinaryTree.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the the BinaryTree class which is the 
** 	superclass MerkleTree is constructed from. Contains the 
** 	variables and functions common to binary trees.
**
**	Idea for printing tree came from https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
***********************************************/

public abstract class BinaryTree {
	
	protected BinaryNode root;
	
	//-------------------------------------------------------
	// Name: BinaryTree()
	// PreCondition:  none
	// PostCondition: Creates BinaryTree
	//---------------------------------------------------------
	BinaryTree() {}

	//-------------------------------------------------------
	// Name: getRoot()
	// PreCondition:  none
	// PostCondition: return root of the binary tree
	//---------------------------------------------------------
	public BinaryNode getRoot() {return root;}
	
	//-------------------------------------------------------
	// Name: setRoot()
	// PreCondition:  none
	// PostCondition: update root of binary tree to passed value
	//---------------------------------------------------------
	public void setRoot(BinaryNode root) {this.root = root;}
	
	//-------------------------------------------------------
	// Name: build()
	// PreCondition:  implemented by subclass
	// PostCondition: none
	//---------------------------------------------------------
	public abstract void build();
	
	//-------------------------------------------------------
	// Name: display()
	// PreCondition:  tree is not empty
	// PostCondition: neatly displays the binary tree with left most 
	// node being the root and top right node being the last node in the tree
	//---------------------------------------------------------
	public void display() {
		if(root != null) {
			display(root, 0);
		}
	}
	
	//-------------------------------------------------------
	// Name: display(BinaryNode node)
	// PreCondition:  node exists
	// PostCondition: neatly displays the node and children of node
	//---------------------------------------------------------
	public void display(BinaryNode node, int spaces) {
		if(node != null) {
			if(!(node instanceof Leaf)) {
				spaces += 10;
				display(node.getRight(), spaces);
				System.out.println(String.format("%"+spaces+"s", "") + node);
				display(node.getLeft(), spaces);
			}
		}
	}

}

/*****************************************
** File:    Validator.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the the Validator class
**   and various helper methods which can be
**   be used verify and update two Merkle trees.
**
**
***********************************************/

import java.util.Vector;

public class Validator {
	
	MerkleTree machine;
	MerkleTree upToDate;
	
	//-------------------------------------------------------
	// Name: Validator()
	// PreCondition:  none
	// PostCondition: creates a default Validator
	//---------------------------------------------------------
	Validator()
	{
		this.machine = null;
		this.upToDate = null;
	}
	
	//-------------------------------------------------------
	// Name: Validator(MerkleTree update, MerkleTree original)
	// PreCondition:  none
	// PostCondition: creates a Validator with two provided Merkle Trees
	//---------------------------------------------------------
	Validator(MerkleTree machine, MerkleTree upToDate)
	{
		this.machine = machine;
		this.upToDate = upToDate;
	}
	
	//-------------------------------------------------------
	// Name: getMachine()
	// PreCondition:  none
	// PostCondition: returns the Merkle Tree in the machine
	//---------------------------------------------------------
	public MerkleTree getMachine() {return machine;}

	//-------------------------------------------------------
	// Name: setMachine(MerkleTree machine)
	// PreCondition:  none
	// PostCondition: set the machine's Merkle Tree to the passed argument
	//---------------------------------------------------------
	public void setMachine(MerkleTree machine) {this.machine = machine;}

	//-------------------------------------------------------
	// Name: getUpToDate()
	// PreCondition:  none
	// PostCondition: returns the Merkle Tree that is up to date
	//---------------------------------------------------------
	public MerkleTree getUpToDate() {return upToDate;}

	//-------------------------------------------------------
	// Name: setUpToDate(MerkleTree upToDate)
	// PreCondition:  none
	// PostCondition: set the up to date Merkle Tree to the passed argument
	//---------------------------------------------------------
	public void setUpToDate(MerkleTree upToDate) {this.upToDate = upToDate;}
	
	//-------------------------------------------------------
	// Name: checkPath()
	// PreCondition: machine exists and machine root exists
	// PostCondition: checks if given path of hashes exists in machine 
	//	starting from root
	//---------------------------------------------------------
	public boolean checkPath(Vector<String> path)
	{
		// check if machine exists and machine root exists
		if(machine != null && machine.getRoot() != null) {
			return checkPath(path, machine.getRoot());
		}
		
		// machine or root does not exist but trying to check path, invalid
		return false;
	}
	
	//-------------------------------------------------------
	// Name: checkPath(Vector<String> path, BinaryNode node)
	// PreCondition:  none
	// PostCondition: checks if given path of hashes exists from given node
	//---------------------------------------------------------
	private boolean checkPath(Vector<String> path, BinaryNode node)
	{
		// check if no more path
		if(path.size() == 0) {
			// no more path left, valid
			return true;
		}
		// check if node exists and is not a leaf
		else if(node == null && !(node instanceof Leaf)) {
			// end of tree but more path, invalid
			return false;
		}
		// check if last hash in path
		else if (path.size() == 1) {
			// if current node matches current hash in path, valid
			return path.get(0).equals(node.getHashValue());
		}
		// more path and more tree exist
		else {
			// check if current node matches current hash in path
			if(path.get(0).equals(node.getHashValue())) {
				// check if path continues in left or right node
				return checkPath((Vector<String>) path.subList(1, path.size()), node.getLeft()) || checkPath((Vector<String>) path.subList(1, path.size()), node.getRight());
			}
			// current hash in path does not match current node, invalid
			return false;
		}
	}
	
	//-------------------------------------------------------
	// Name: updateMachine() 
	// PreCondition:  machine and upToDate exist
	// PostCondition: updates, if needed, the machine's Merkle Tree based on upToDate
	//---------------------------------------------------------
	public void updateMachine() 
	{
		// check existence of machine and upToDate
		if(machine == null || machine.getRoot() == null) {
			if(machine == null) {
				System.out.println("Machine file does not exist, need to create new tree.");
				fillTree(new BinaryNode(), upToDate.depth() - 1);
				System.out.println("Machine created. Updating machine.");
				updateMachine(machine.getRoot(), upToDate.getRoot());
			}
			else {
				System.out.println("Updated file does not exist.");
			}
		}
		// check if roots match
		else if(machine.getRoot().equals(upToDate.getRoot())) {
			System.out.println("Both files match, no update needed.");
			return;
		}
		// parse tree for mismatch
		else {
			// check both trees are the same size
			if(machine.depth() != upToDate.depth()) {
				//System.out.println("Accommodating depth mismatch.");

				// check which is larger
				if(machine.depth() < upToDate.depth()) {
					//System.out.println("upToDate larger");
					// move original machine root down tree to make depths match
					int diff = upToDate.depth() - machine.depth();
					for(int i = 0; i < diff; i++) {
						machine.setRoot(new BinaryNode(machine.getRoot()));
					}
					fillTree(machine.getRoot(), upToDate.depth() - 1);
				}
				else {
					//System.out.println("machine larger");
					// set root of machine to farther down tree to make depths match
					int diff = machine.depth() - upToDate.depth();
					for(int i = 0; i < diff; i++) {
						machine.setRoot(machine.getRoot().getLeft());
					}
				}
			}
			
			System.out.println("Updating machine.");
			updateMachine(machine.getRoot(), upToDate.getRoot());
		}

	}
	
	//-------------------------------------------------------
	// Name: updateMachine(BinaryNode machineNode, BinaryNode upToDateNode) 
	// PreCondition:  machineNode and upToDateNode exists
	// PostCondition: updated, if needed, the machineNode based on the upTodateNode
	//---------------------------------------------------------
	private void updateMachine(BinaryNode machineNode, BinaryNode upToDateNode) {
		// check if nodes exist
		if(machineNode == null || upToDateNode == null) {
			if(machineNode == null && upToDateNode == null) {
				// if both nodes null, valid
				return;
			}
			// depth check in other updateMachine handles case of only one null node
			// if reaches here something isn't working correctly
			System.out.println("Something wrong...");
		}
		// check if hash values match at current nodes in trees
		else if(machineNode.equals(upToDateNode)) {
			// if hash values match, valid
			return;
		}
		else {
			// check if at leaf of tree
			if(machineNode instanceof Leaf && upToDateNode instanceof Leaf) {
				// update machine leaf to match
				@SuppressWarnings("unchecked")
				Leaf<String> mNode = (Leaf<String>) machineNode;
				@SuppressWarnings("unchecked")
				Leaf<String> uNode = (Leaf<String>) upToDateNode;
				System.out.println("Update " + mNode.getData() + " to " + uNode.getData());
				mNode.setData(uNode.getData());
			}
			else {
				// check both sides of tree for discrepancy
				updateMachine(machineNode.getLeft(), upToDateNode.getLeft());
				updateMachine(machineNode.getRight(), upToDateNode.getRight());
				
				// update current node to reflect changes lower in the tree
				machineNode.rehash();
				
				// machineNode and below has been updated to match upToDateNode, valid
				return;
			}
		}
	}
	
	//-------------------------------------------------------
	// Name: fillTree(BinaryNode toFill, int depth)
	// PreCondition:  none
	// PostCondition: created empty nodes needed to fill subtree
	//---------------------------------------------------------
	private void fillTree(BinaryNode toFill, int depth) {
		// checks if node can, and needs to, be filled
		if(toFill == null) {
			return;
		}
		else if(depth == 0) {
			toFill.setLeft(new Leaf<String>());
		}
		
		// loops through levels of tree until full tree of desired depth
		for(int i = 0; i < depth; i++) {
			if(toFill.left == null) {
				toFill.setLeft(new BinaryNode());
				fillTree(toFill.getLeft(), depth - 1);
			}
			if(toFill.right == null) {
				toFill.setRight(new BinaryNode());
				fillTree(toFill.getRight(), depth - 1);
			}
		}
	}
}

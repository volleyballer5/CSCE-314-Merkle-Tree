/*****************************************
** File:    Validator.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the the Validator class
**   and various helper methods which is will
**   be used verify two different Merkle trees.
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
	// Name: match() 
	// PreCondition:  machine and upToDate exist
	// PostCondition: returns if machine and upToDate roots match
	//---------------------------------------------------------
	public boolean match()
	{
		// check that machine and upToDate exist
		if (machine != null || upToDate != null) {
			return machine.getRoot().equals(upToDate.getRoot());
		}
		// machine and upToDate don't both exist
		return false;
	}
	
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
	public boolean checkPath(Vector<String> path, BinaryNode node)
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
	// PreCondition:  none
	// PostCondition: updates the machine's Merkle Tree based on upToDate
	//---------------------------------------------------------
	public Vector<String> updateMachine() 
	{
		// check existence of machine and upToDate
		if(machine == null || machine.getRoot() == null) {
			if(machine == null) {
				System.out.println("Machine file does not exist, need to create new tree");
				machine = upToDate;
			}
			else {
				System.out.println("Updated file does not exist.");
			}
		}
		// check if roots match
		else if(machine.getRoot().equals(upToDate.getRoot())) {
			System.out.println("Both files match.");
		}
		// parse tree for mismatch
		else {
			// check both trees are the same size
			if(machine.depth() != upToDate.depth()) {
				System.out.println("Not implemented yet.");
				// more complicated stuff to do, have to add onto or delete from machine
				
				// if upToDate is larger, determine how much larger
				// treat root as left side much farther down tree
				// how far down depends on depth mismatch
				// create new nodes in machine then perform update
				
				// if machine is larger
				// delete nodes starting from right side up to root
				// how many times depends on depth mismatch
				
				
			}
			else {
				System.out.println("Updating machine.");
				updateMachine(machine.getRoot(), upToDate.getRoot());
			}
		}
		
		// check left and right child
		// pursue child that does not match until reach mismatch leaf
		// update bad leaf and document change
		// update hashes all the way back up the tree
		return null;
	}
	
	public void updateMachine(BinaryNode machineNode, BinaryNode upToDateNode) {
		System.out.println("Nodes are: " + machineNode + ", and " + upToDateNode);
		// check if nodes exist
		if(machineNode == null || upToDateNode == null) {
			System.out.println("At least one node is null.");
			if(machineNode == null && upToDateNode == null) {
				System.out.println("Both null, valid.");
				// if both nodes null, valid
				return;
			}
			else {
				// should not reach this case b/c handle mismatch depth early
				System.out.println("Something wrong...");
			}
		}
		// check if hash values match at current nodes in trees
		else if(machineNode.equals(upToDateNode)) {
			// if hash values match, valid
			System.out.println("Nodes match.");
			return;
		}
		else {
			// check if at leaf of tree
			if(machineNode instanceof Leaf && upToDateNode instanceof Leaf) {
				// update machine leaf to match
				Leaf<String> mNode = (Leaf<String>) machineNode;
				Leaf<String> uNode = (Leaf<String>) upToDateNode;
				System.out.println("Update " + mNode.getData() + " to " + uNode.getData());
				mNode.setData(uNode.getData());
				System.out.println("Updated check: " + mNode);
			}
			else {
				System.out.println("Check both sides for discrepancies.");
				// check both sides of tree for discrepancy
				System.out.println("Left");
				updateMachine(machineNode.getLeft(), upToDateNode.getLeft());
				System.out.println("Right");
				updateMachine(machineNode.getRight(), upToDateNode.getRight());
				
				System.out.println("Update current node.");
				// update current node to reflect changes lower in the tree
				System.out.println("Old hash: " + machineNode);
				machineNode.rehash();
				System.out.println("New hash: " + machineNode);
				
				// machineNode and below has been updated to match upToDateNode, valid
				return;
			}
		}
	}

}

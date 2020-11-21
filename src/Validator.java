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
	// Name: updateOriginal() 
	// PreCondition:  none
	// PostCondition: updates the machine's Merkle Tree based on upToDate
	//---------------------------------------------------------
	public Vector<String> updateMachine() 
	{
		// first check root node
		// check left and right child
		// pursue child that does not match until reach mismatch leaf
		// update bad leaf and document change
		// update hashes all the way back up the tree
		return null;
	}

}

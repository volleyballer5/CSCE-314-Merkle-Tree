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
	public MerkleTree getMachine() {
		return machine;
	}

	//-------------------------------------------------------
	// Name: setMachine(MerkleTree machine)
	// PreCondition:  none
	// PostCondition: set the machine's Merkle Tree to the passed argument
	//---------------------------------------------------------
	public void setMachine(MerkleTree machine) {
		this.machine = machine;
	}

	//-------------------------------------------------------
	// Name: getUpToDate()
	// PreCondition:  none
	// PostCondition: returns the Merkle Tree that is up to date
	//---------------------------------------------------------
	public MerkleTree getUpToDate() {
		return upToDate;
	}

	//-------------------------------------------------------
	// Name: setUpToDate(MerkleTree upToDate)
	// PreCondition:  none
	// PostCondition: set the up to date Merkle Tree to the passed argument
	//---------------------------------------------------------
	public void setUpToDate(MerkleTree upToDate) {
		this.upToDate = upToDate;
	}

	//-------------------------------------------------------
	// Name: checkPath()
	// PreCondition:  none
	// PostCondition: checks if paths down Merkle Trees are the same
	//---------------------------------------------------------
	public boolean checkPath()
	{
		return false;
	}
	
	//-------------------------------------------------------
	// Name: updateOriginal() 
	// PreCondition:  none
	// PostCondition: updates the machine's Merkle Tree based on upToDate
	//---------------------------------------------------------
	public Vector<String> updateMachine() 
	{
		return null;
	}

}

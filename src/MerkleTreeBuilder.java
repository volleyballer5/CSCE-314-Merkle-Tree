/*****************************************
** File:    MerkleTreeBuilder.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the the MerkleTreeBuilder class which 
**  is a class created to facilitate the creation of a Merkle Tree.
**	This class contains the methods required to construct a Merkle
**  Tree from a data file.
**
**
***********************************************/

import java.util.*;

public class MerkleTreeBuilder {

	private int hashedRoot;
	private Vector<Integer> hashedLines;
	
	//-------------------------------------------------------
	// Name: MerkeTreeBuilder()
	// PreCondition:  none
	// PostCondition: creates default MerkleTreeBuilder
	//---------------------------------------------------------
	MerkleTreeBuilder() {}
	
	//-------------------------------------------------------
	// Name: MerkeTreeBuilder()
	// PreCondition:  none
	// PostCondition: creates MerkleTreeBuilder associated with filename
	//---------------------------------------------------------
	MerkleTreeBuilder(String filename) {}
	
	//-------------------------------------------------------
	// Name: getHashedRoot()
	// PreCondition:  none
	// PostCondition: returns current hashedRoot
	//---------------------------------------------------------
	public int getHashedRoot() {return hashedRoot;}
	
	//-------------------------------------------------------
	// Name: setHashedRoot()
	// PreCondition:  none
	// PostCondition: updates current hashedRoot to passed value
	//---------------------------------------------------------
	public void setHashedRoot(int hashedRoot) {this.hashedRoot = hashedRoot;}
	
	//-------------------------------------------------------
	// Name: getHashedLines()
	// PreCondition:  none
	// PostCondition: returns the vector of hashedLines
	//---------------------------------------------------------
	public Vector<Integer> getHashedLines() {return hashedLines;};
	
	//-------------------------------------------------------
	// Name: addHashedLine()
	// PreCondition:  none
	// PostCondition: adds line to end of hashedLines vector
	//---------------------------------------------------------
	public void addHasedLine(int line) {}
	
	//-------------------------------------------------------
	// Name: parseLine()
	// PreCondition:  none
	// PostCondition: returns vector where each index is a csv
	//---------------------------------------------------------
	public Vector<String> parseLine(String line) {return null;}
	
	//-------------------------------------------------------
	// Name: hashLine()
	// PreCondition:  none
	// PostCondition: returns the hashed value of the line
	//---------------------------------------------------------
	public int hashLine(Vector<String> line) {return -1;}
	
	//-------------------------------------------------------
	// Name: getFile()
	// PreCondition:  none
	// PostCondition: returns current hashedRoot
	//---------------------------------------------------------
	public int hashNodes(BinaryNode leftNode, BinaryNode rightNode) {return -1;}

}

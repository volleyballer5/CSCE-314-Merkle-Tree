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
import java.io.*;
import java.lang.Math;

public class MerkleTreeBuilder {

	private Vector<BinaryNode> hashedLines;
	private String file;
	
	//-------------------------------------------------------
	// Name: MerkeTreeBuilder()
	// PreCondition:  none
	// PostCondition: creates MerkleTreeBuilder associated with filename
	//---------------------------------------------------------
	MerkleTreeBuilder(String filename) {file = filename;}
	
	//-------------------------------------------------------
	// Name: getHashedLines()
	// PreCondition:  none
	// PostCondition: returns the vector of hashedLines
	//---------------------------------------------------------
	public Vector<BinaryNode> getHashedLines() {return hashedLines;};
	
	//-------------------------------------------------------
	// Name: addHashedLine()
	// PreCondition:  none
	// PostCondition: adds passed argument to end of hashedLines vector
	//---------------------------------------------------------
	public void addHasedLine(BinaryNode line) {hashedLines.add(line);}
	
	//-------------------------------------------------------
	// Name: getFile()
	// PreCondition:  none
	// PostCondition: returns the name of the file
	//---------------------------------------------------------
	public String getFile() {return file;};
	
	//-------------------------------------------------------
	// Name: setFile()
	// PreCondition:  none
	// PostCondition: sets file to given argument
	//---------------------------------------------------------
	public void setFile(String file) {this.file = file;}
	
	//-------------------------------------------------------
	// Name: hashLine()
	// PreCondition:  none
	// PostCondition: returns the hashed value of the line
	//---------------------------------------------------------
	public int hashLine(Vector<String> line) {return -1;}
	// update function with hash function
	
	//-------------------------------------------------------
	// Name: hashLeaf()
	// PreCondition:  none
	// PostCondition: returns the hashed node of the leaf
	//---------------------------------------------------------
	public BinaryNode hashLeaf(Leaf<String> leaf) {
		return new BinaryNode(hashLine(leaf.getData()), leaf, null);
	}
	
	//-------------------------------------------------------
	// Name: hashNode()
	// PreCondition:  none
	// PostCondition: returns the hashed node of two nodes
	//---------------------------------------------------------
	public BinaryNode hashNodes(BinaryNode leftNode, BinaryNode rightNode) {
		// update with hash function
		int hashVal = leftNode.getHashValue() + rightNode.getHashValue(); 
		return new BinaryNode(hashVal, null, null);
	}
	
	public BinaryNode build() {
		BufferedReader reader = null;
        String line = "";
        Vector<String> splitLine = null;
        
        try {
        	reader = new BufferedReader(new FileReader(file));
            
            while((line = reader.readLine()) != null) {
            	// splits line by commas and adds to vector
            	splitLine = new Vector<String>();
            	splitLine.addAll(Arrays.asList(line.split(",")));
            	
            	// adds binaryNode containing hash info for leaf and subsequent data to hasedLines vector
            	hashedLines.add(hashLeaf(new Leaf<String>(splitLine)));
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        int neededDuplication = (int) Math.floor(Math.sqrt(hashedLines.size() - 1)) - hashedLines.size();
        BinaryNode duplicate = hashedLines.lastElement();
        
        for(int i = 0; i < neededDuplication; i++) {
        	hashedLines.add(new BinaryNode(duplicate.getHashValue(), new Leaf<String>(splitLine), null))
        }
        
        Vector<BinaryNode> temp = new Vector<BinaryNode>();

		// Recursively hash vector together including those needing duplication
        
		return null;
	}

}

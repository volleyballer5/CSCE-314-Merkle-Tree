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

	private Vector<BinaryNode> hashedLines = new Vector<BinaryNode>();
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
	// Name: build()
	// PreCondition:  file exists
	// PostCondition: creates Merkle tree from file and returns root
	//---------------------------------------------------------
	public BinaryNode build() {
		// setup to read from file
		BufferedReader reader = null;
        String line = "";
        Vector<String> splitLine = null;
        
        // file error handling
        try {
        	reader = new BufferedReader(new FileReader(file));
            
        	// for ignoring header
        	//reader.readLine();
        	
        	// parse file line by line
            while((line = reader.readLine()) != null) {
            	// splits line by commas and adds to vector
            	splitLine = new Vector<String>();
            	splitLine.addAll(Arrays.asList(line.split(",")));
            	
            	// adds binaryNode containing hash info for leaf and subsequent data to hashedLines vector
            	hashedLines.add(new BinaryNode(new Leaf<String>(splitLine)));
            	
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
        
        // check that file was not empty
        if(hashedLines.size() == 0) {
        	return null;
        }

        // determine how many nodes are needed to have full BinaryTree
        int neededDuplication = (int) Math.pow(2, Math.ceil(Math.log(hashedLines.size()) / Math.log(2))) - hashedLines.size();

        // create needed duplicate nodes and add to hashedLines
        BinaryNode duplicate = hashedLines.lastElement();
        for(int i = 0; i < neededDuplication; i++) {
        	hashedLines.add(new BinaryNode(duplicate.getLeft()));
        }
        
        // return the final root hashed node by recursively hashing nodes together
        return new BinaryNode(hashHalf(hashedLines.subList(0, hashedLines.size() / 2)), hashHalf(hashedLines.subList(hashedLines.size() / 2, hashedLines.size())));
	}
	
	//-------------------------------------------------------
	// Name: hashHalf()
	// PreCondition:  half contains 2^n elements
	// PostCondition: returns the binaryNode constructed from the hash 
	// 	of the List half
	//---------------------------------------------------------
	private BinaryNode hashHalf(List<BinaryNode> half) {
		if(half != null) {
			// base case is 2 elements in List - returns a hash of the two nodes
			if(half.size() == 2) {
				return new BinaryNode(half.get(0), half.get(1));
			}
			// recursion - calls hashHalf on each half of the list and hashes result
			else {
				return new BinaryNode(hashHalf(half.subList(0, half.size() / 2)), hashHalf(half.subList(half.size() / 2, half.size())));
			}
		}
		return null;
	}

}

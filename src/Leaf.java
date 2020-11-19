/*****************************************
** File:    Leaf.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the the Leaf class which 
**  is an extension of the BinaryNode class. Its
**  purpose is to function as the leafs of the 
**  tree and hold the unhashed data.
**
**
***********************************************/

import java.util.Vector;

public class Leaf<E> extends BinaryNode {
	
	private Vector<E> data;
	// reminder to set left and right children to node
	
	//-------------------------------------------------------
	// Name: Leaf(Vector<String> data)
	// PreCondition:  none
	// PostCondition: creates a Leaf with given data
	//---------------------------------------------------------
	Leaf(Vector<E> data)
	{
		// TODO: set hash value
		super();
		this.data = data;
	}

	//-------------------------------------------------------
	// Name: getData()
	// PreCondition:  none
	// PostCondition: returns data
	//---------------------------------------------------------
	public Vector<E> getData() {return data;}

	//-------------------------------------------------------
	// Name: setData(Vector<String> data)
	// PreCondition:  none
	// PostCondition: sets data to given argument
	//---------------------------------------------------------
	// TODO: should this update the hashvalue??
	// this should be a thing, but very complication since it has to reflect up (ptr to parent)
	// shouldnt need for our project application
	public void setData(Vector<E> data) {this.data = data;}
	
	//-------------------------------------------------------
	// Name: addData(String datum)
	// PreCondition:  none
	// PostCondition: adds datum to existing data
	//---------------------------------------------------------
	// TODO: should this update the hashvalue??
	public void addData(E datum) {data.add(datum);}
	
	//-------------------------------------------------------
	// Name: duplicate()
	// PreCondition:  none
	// PostCondition: creates and returns of copy of Leaf
	//---------------------------------------------------------
//	public Leaf<E> duplicate()
//	{
//		return this;
//	}

	//-------------------------------------------------------
	// Name: equals(Leaf leaf)
	// PreCondition:  none
	// PostCondition: checks if two Leaf's are equal
	//---------------------------------------------------------
	public boolean equals(Leaf<E> that)
	{
		if(this.hashValue != that.getHashValue())
			return false;
		else if(this.left != that.getLeft())
			return false;
		else if(this.right != that.getRight())
			return false;
		else if(! this.data.equals(that.getData()))
			return false;
		else
			return true;
	}
	
	//-------------------------------------------------------
	// Name: toString()
	// PreCondition:  none
	// PostCondition: formats and prints the Leaf object
	//---------------------------------------------------------
	public String toString()
	{
		return data.toString() + ", " + "Hash: " + hashValue;
	}
	
}

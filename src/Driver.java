import java.util.Vector;

/*****************************************
** File:    Driver.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Kyle Mrosko, Melanie Peavy
** Date:    11/7/2020
** Section: 501
** E-mail:  kylemrosko@tamu.edu, melanie_peavy@tamu.edu 
**
**   This file contains the main driver program for the Project.
** 	This program reads the files specified as the first and second command 
**	line arguments, constructs the Merkle Trees, and performs validation.
**
**
***********************************************/

/*****************************************
** Application and Description
** This project focuses on the use of Merkle Trees for database verification 
** and synchronization specifically in csv files. For this project, we assumed 
** the role of a computer scientist who works for an office supply company whose 
** goal is to verify and synchronize sales data across multiple machines. When 
** comparing old and new files, the program needs to be able to detect any 
** discrepancies and correct them. Given two csv files, where the first is the most 
** recent file and the second is the file on the machine, the program constructs a 
** Merkle Tree for each file then proceeds with its verification process. The program 
** determines if the root hashes match and no update needs to be made or, if not, uses 
** hash codes of various internal nodes to determine where the discrepancies are. If a 
** discrepancy is located an update is made to the machine’s Merkle Tree. By comparing 
** the hash data from the Merkle Trees representing the files, rather than the data inside 
** each file, this implementation simulates the minimal data transferred and compared in 
** a real distributed network setup. 
**
**
***********************************************/

public class Driver {
	
	public static void testNodes()
	{
		Vector<String> v1 = new Vector<>();
		v1.add("Kyle");
		v1.add("Mrosko");
		Vector<String> v2 = new Vector<>();
		v2.add("Melanie");
		v2.add("Peavy");
		Vector<String> v3 = new Vector<>();
		v3.add("Kyle");
		
		Leaf<String> l1 = new Leaf<>(v1);
		Leaf<String> l2 = new Leaf<>(v1);
		
		System.out.println("Leaf1: " + l1.toString());
		System.out.println("Leaf2: " + l2.toString());
		
		l1.setData(v3);
		
		System.out.println("Leaf1: " + l1.toString());
		System.out.println("Leaf2: " + l2.toString());
		
		System.out.println("L1==L2: " + l1.equals(l2));
		
		l1.addData("Mrosko");
		
		System.out.println("Leaf1: " + l1.toString());
		System.out.println("Leaf2: " + l2.toString());
		
		System.out.println("L1==L2: " + l1.equals(l2));
		
		BinaryNode b = new BinaryNode();
		b.setLeft(l1);
		b.setRight(l2);
		
		System.out.println("BinaryNode b: " + b);
	}

	
	
	public static void main(String[] args) {
		
		System.out.println("Test Run");
		
		testNodes();
		
		
	}

}

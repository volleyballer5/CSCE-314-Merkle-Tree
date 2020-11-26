import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		Vector<Integer> v1 = new Vector<>();
		v1.add(20);
		v1.add(23);
		Vector<String> v11 = new Vector<>();
		v11.add("Kyle");
		v11.add("Mrosko");
		Vector<String> v2 = new Vector<>();
		v2.add("Melanie");
		v2.add("Peavy");
		Vector<String> v3 = new Vector<>();
		v3.add("Kyle");
		
		Leaf<String> l1 = new Leaf<>(v11);
		Leaf<String> l2 = new Leaf<>(v2);
		Leaf<Integer> l3 = new Leaf<>(v1);
		
		System.out.println("Integer Leaf: " + l3);
		
		System.out.println();
		
		System.out.println("Leaf1: " + l1.toString());
		System.out.println("Leaf2: " + l2.toString());
		
		System.out.println("\nSet leaf1 to \"Kyle\"");
		l1.setData(v3);
		
		System.out.println("Leaf1: " + l1.toString());
		System.out.println("Leaf2: " + l2.toString());
		
		System.out.println("L1==L2: " + l1.equals(l2));
		
		System.out.println("\nSet leaf1 to \"Melanie, Peavy\"");
		l1.setData(v2);
		
		System.out.println("Leaf1: " + l1.toString());
		System.out.println("Leaf2: " + l2.toString());
		
		System.out.println("L1==L2: " + l1.equals(l2));
		
		BinaryNode b = new BinaryNode(l1, l2);
		
		System.out.println("\nBinaryNode b: " + b);
		System.out.println("Left: " + b.getLeft());
		System.out.println("Right: " + b.getRight());
		
	}
	
	public static void testMerkleTree() {
		MerkleTree testTree = new MerkleTree("testData1.csv");
		System.out.println("Build Merkle Tree with testData1.csv");
		testTree.build();
		System.out.println();
		System.out.println("Root");
		System.out.println(testTree.getRoot().getHashValue());
		System.out.println();
		System.out.println("Tree");
		testTree.display();
	}

	public static void testValidator() {
		MerkleTree testTree1 = new MerkleTree("testData1.csv");
		testTree1.build();
		MerkleTree testTree2 = new MerkleTree("testData2.csv");
		testTree2.build();
		
		System.out.println("Original Trees");
		System.out.println("testTree1" + ", depth: " + testTree1.depth());
		testTree1.display();
		System.out.println();
		System.out.println("testTree2" + ", depth: " + testTree2.depth());
		testTree2.display();
		
		System.out.println();
		System.out.println();
		
		Validator validator = new Validator(testTree1, testTree2);
		System.out.println("validator.match(): " + validator.match());
		
		System.out.println();
		System.out.println();
		
		//System.out.println("Testing new function: " + testTree1.validate(testTree2));
		validator.updateMachine();
		//System.out.println("Testing new function: " + testTree1.validate(testTree2));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Trees After Update");
		System.out.println("testTree1" + ", depth: " + testTree1.depth());
		testTree1.display();
		System.out.println();
		System.out.println("testTree2" + ", depth: " + testTree2.depth());
		testTree2.display();
		
		System.out.println();
		System.out.println();
		
		System.out.println("validator.match(): " + validator.match());
	}
	
	public static void demo(String updated, String machine) throws IOException
	{
		System.out.println("As a system admin for our office supplies company,");
		System.out.println("I need to quickly check that the sales reports on");
		System.out.println("each computer is always up to date. This program");
		System.out.println("is an example of a single computer syncing with the");
		System.out.println("master database using Merkle Trees.\n");
		
		System.out.println("Reading the master database.");
		BufferedReader reader = new BufferedReader(new FileReader(updated));
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
		System.out.println(reader.readLine());
		System.out.println("...\n");
		
		System.out.println("Constructing master database Merkle Tree.\n");
		
		MerkleTree updatedTree = new MerkleTree("officeSuppliesSalesUPDATED.csv");
		updatedTree.build();
		
		System.out.println("Reading the machine's sales report.");
		BufferedReader reader1 = new BufferedReader(new FileReader(machine));
		System.out.println(reader1.readLine());
		System.out.println(reader1.readLine());
		System.out.println(reader1.readLine());
		System.out.println(reader1.readLine());
		System.out.println("...\n");
		
		System.out.println("Constructing the machine's Merkle Tree.\n");
		
		MerkleTree machineTree = new MerkleTree("officeSuppliesSalesMACHINE.csv");
		machineTree.build();
		
		System.out.println("Checking if machine is up to date:");
		System.out.println("Master database root hash: " + updatedTree.getRoot().hashValue);
		System.out.println("Machine root hash: " + machineTree.getRoot().hashValue);
		System.out.println();
		
		boolean same = updatedTree.validate(machineTree);
		
		if(same)
		{
			System.out.println("Machine is already up to date.");
			System.out.println("Exiting...");
			System.exit(0);
		}
		else
		{
			System.out.println("Machine does not match master database.");
			
			Validator validator = new Validator(machineTree, updatedTree);
			validator.updateMachine();
			
			System.out.println("\nMachine up to date?: " + validator.match());
			
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		//System.out.println("Test Run");
		
//		testNodes();
//		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
//		testMerkleTree();
//		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
//		testValidator();
		
		
		if(args.length > 0)
		{
			try
			{
				demo(args[0],args[1]);
			}
			catch(Exception e)
			{
				System.out.println("Error in calling program: ");
				e.printStackTrace();
				System.exit(1);
			}
		}
		else
		{
			demo("officeSuppliesSalesUPDATED.csv", "officeSuppliesSalesMACHINE.csv");
		}
		
	}
}

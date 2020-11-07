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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Run");

	}

}

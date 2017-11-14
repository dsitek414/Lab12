package BinaryTrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchTreeDriver {

	public static void main(String[] args) {
		try {
			BinarySearchTree<StudentGPA> stuTree = new BinarySearchTree();
			File myFile = new File ("students.in");
			Scanner fileScan = new Scanner (myFile);
			String stuInfo = " ", name = " ", adName = " ";
			double GPA = 0;
			int id = 0;
			TreeIterator myTreeIt = new TreeIterator(stuTree);
			
			while (fileScan.hasNextLine()) {
				stuInfo = fileScan.nextLine();
				id = Integer.parseInt(stuInfo.substring(0, 2));
				name = stuInfo.substring(3, 7);
				GPA = Double.parseDouble(stuInfo.substring(7, 10));
				if(stuInfo.length() > 10)
				{
					adName = stuInfo.substring(10, stuInfo.length());
					GraduateStudentGPA newGradStu = new GraduateStudentGPA (id, name, GPA, adName);
					stuTree.insert(newGradStu);
				}
				else
				{
					adName = " ";
					StudentGPA newStu = new StudentGPA (id, name, GPA);
					stuTree.insert(newStu);
				}
			}
			
			myTreeIt.printInorder();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}
	
}
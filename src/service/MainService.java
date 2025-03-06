package service;

import java.util.Arrays;

import datastr.MyLinkedList;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> linkedListForInt = new MyLinkedList<Integer>();
		
		linkedListForInt.add(45);//45
		linkedListForInt.add(100);//45 100
		linkedListForInt.add(-200);//45 100 -200
		linkedListForInt.add(1000);//45 100 -200 1000
		
		try {
			System.out.println("-------------------ADD-------------------");
			linkedListForInt.print();//45 100 -200 1000
			linkedListForInt.add(-222, 1);//-222 45 100 -200 1000
			linkedListForInt.print();//-222 45 100 -200 1000
			linkedListForInt.add(2000, 6);//-222 45 100 -200 1000 2000
			linkedListForInt.print();//-222 45 100 -200 1000 2000
			linkedListForInt.add(55, 4);//-222 45 100 55 -200 1000 2000
			linkedListForInt.print();//-222 45 100 55 -200 1000 2000
			
			System.out.println("-------------------DELETE-------------------");
			linkedListForInt.remove(1);//-222 izdzēsisies
			linkedListForInt.print();//45 100 55 -200 1000 2000
			linkedListForInt.remove(6);//2000 izdzēsisies
			linkedListForInt.print();//45 100 55 -200 1000
			linkedListForInt.remove(3);//55 izdzēsisies
			linkedListForInt.print();//45 100 -200 1000
			
			System.out.println("-------------------GET-------------------");
			System.out.println(linkedListForInt.get(3));//-200
			
			System.out.println("-------------------SEARCH-------------------");
			linkedListForInt.add(100, 1);//100 45 100 -200 1000
			MyLinkedList<Integer> getPositionsForSearchedElement 
			= linkedListForInt.searchElement(100);
			getPositionsForSearchedElement.print();
			
			System.out.println("-------------------MAKE EMPTY-------------------");
			linkedListForInt.makeEmpty();
			linkedListForInt.add(300);
			linkedListForInt.print();//300
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		System.out.println("-----------------------------------");
		MyLinkedList<Student> linkedListForStudent = new MyLinkedList<Student>();
		
		Student st1 = new Student();
		Student st2 = new Student("Janis", "Berzins");
		Student st3 = new Student("Anna Paula", "Jauka-Nejauka");
		linkedListForStudent.add(st1);
		try
		{
			linkedListForStudent.add(st2, 1);
			linkedListForStudent.add(st3, 1);
			linkedListForStudent.print();//Anna Paula, Janis, Test
			
			linkedListForStudent.remove(2);//Janis izdzests
			linkedListForStudent.print();//Anna Paula, Test
			
			
			System.out.println(linkedListForStudent.get(1));//Anna Paula
			MyLinkedList<Integer> getPositionsForSearchedElement 
			= linkedListForStudent.searchElement(st1);
			getPositionsForSearchedElement.print();//2
			
			linkedListForStudent.makeEmpty();
			linkedListForStudent.add(new Student("Roberts", "Gudrais"));
			linkedListForStudent.print();//Roberts
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

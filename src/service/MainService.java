package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> linkedListForInt = new MyLinkedList<Integer>();
		
		linkedListForInt.add(45);//45
		linkedListForInt.add(100);//45 100
		linkedListForInt.add(-200);//45 100 -200
		linkedListForInt.add(1000);//45 100 -200 1000
		
		try {
			linkedListForInt.print();//45 100 -200 1000
			linkedListForInt.add(-222, 1);//-222 45 100 -200 1000
			linkedListForInt.print();//-222 45 100 -200 1000
			linkedListForInt.add(2000, 6);//-222 45 100 -200 1000 2000
			linkedListForInt.print();//-222 45 100 -200 1000 2000
			linkedListForInt.add(55, 4);//-222 45 100 55 -200 1000 2000
			linkedListForInt.print();//-222 45 100 55 -200 1000 2000
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

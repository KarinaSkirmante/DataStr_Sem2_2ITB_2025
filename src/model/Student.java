package model;

public class Student implements Comparable<Student> {

	//1. mainigie
	private long stID;
	private String name;
	private String surname;
	
	private static long counter = 0;
	
	//2. getters
	public long getStID() {
		return stID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}

	//3. setter
	public void setStID() {
		stID = counter++;
	}
	
	public void setName(String inputName) {
		if(inputName != null 
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?"))
		{
			name = inputName;
		}
		else
		{
			name = "unknown";
		}
	}
	
	public void setSurname(String inputSurname) {
		if(inputSurname != null
				&& inputSurname.matches("[A-Z]{1}[a-z]{3,10}([-][A-Z]{1}[a-z]{3,10})?"))
		{
			surname = inputSurname;
		}
		else
		{
			surname = "unknown";
		}
	}
	
	
	
	//4. bez argumenta konstruktors
	public Student() {
		setStID();
		setName("Testa");
		setSurname("Students");
	}
	
	//5. argumena konstruktors
	public Student(String name, String surname) {
		setStID();
		setName(name);
		setSurname(surname);
	}

	
	//6. toString funkcija
	//parrakstam object klases toString funkciju
	//2: Karlis Lielais
	@Override
	public String toString() {
		return stID + ": " + name + " " + surname;
	}
	
	@Override
	public int compareTo(Student arg0) {
		if(this.surname.charAt(0) > arg0.surname.charAt(0))
		{
			return 1;
		}
		else if(this.surname.charAt(0) < arg0.surname.charAt(0))
		{
			return -1;
		}
		else
		{
			return 0;
		}
			
		
	}
	
	
	
	//7. citas funkcijas (ja nepieciesams)
}
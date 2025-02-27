package datastr;

public class MyLinkedList<Ttype> {
	private MyNode firstNode = null;
	private MyNode lastNode = null;
	private int counter = 0;
	
	//var netaisīt bezargumenta konstruktoru, jo tas būs no java Object klases
	//get un set nevajag taisīt priekš firstNode un lastNode, jo lietotajam nevajag ļaut piekļuvi tiem
	//counter būs tikai get funkcija, jo ar set nedrīkst ļaut lietotajam mainīt
	
	//ļoti iespejams nekad neizpildīsies, jo OS bodrišinās RAM pārvaldību
	private boolean isFull() {
		try {
			new MyNode<Integer>(45); //meginām RAM atmiņa ielikt mezglu
			return false;//ja tas izdodas, tad saraksts nav pilns
		}
		catch (OutOfMemoryError e) {
			return true;//bet ja mezglu nevar vairs RAM atmiņa ielikt, tad saraksts ir pilns
		}
	}
	
	
	private boolean isEmpty()
	{
		return (counter == 0);
	}
	
	public int lenght()
	{
		return counter;
	}
	
	public void add(Ttype element) throws NullPointerException{
		if(element == null) {
			throw new NullPointerException("Elementa vērtība nevar būt null");
		}
		
		if(!isFull()) {
			//pevienos elementu
			if(isEmpty()) {//tiks pirmais mezgls pievienots, jo ir saraksts tukšs
				MyNode newNode = new MyNode(element);
				lastNode = newNode;
				firstNode = newNode;
				counter++;
			}
			else
			{
				MyNode newNode = new MyNode(element);
				newNode.setPrevious(lastNode);
				lastNode.setNext(newNode);
				lastNode = newNode;
				counter++;
			}
			
		}
	}
}

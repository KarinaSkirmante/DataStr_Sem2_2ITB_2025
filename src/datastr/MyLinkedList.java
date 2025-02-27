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
			throw new NullPointerException("Element can not be as null");
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
	
	
	public void add(Ttype element, int position) throws Exception {
		if(element == null) {
			throw new NullPointerException("Element can not be as null");
		}
		
		
		if(position == 1) { //grib ielikt 1.elementu
			MyNode newNode = new MyNode(element);
			newNode.setNext(firstNode);
			firstNode.setPrevious(newNode);
			firstNode = newNode;
			counter++;
		}
		else if(position == counter + 1)
		{
			add(element);
		}
		else if(position > 1 && position <= counter)
		{
			MyNode currentNode = firstNode;
			for(int i = 0; i < position-1; i++) {
				currentNode = currentNode.getNext();
			}
			
			MyNode currentNodePrevious = currentNode.getPrevious();
			
			MyNode newNode = new MyNode(element);
			newNode.setNext(currentNode);
			currentNode.setPrevious(newNode);
			
			currentNodePrevious.setNext(newNode);
			newNode.setPrevious(currentNodePrevious);

			counter++;
			
		}
		else
		{
			throw new Exception("The position is not accepted");
		}

		
	}
	public void remove(int position) throws Exception
	{
	//parbaudit, vai saraksts ir tukss un ja ir, metam iznemumu
		if(isEmpty()) {
			throw new Exception("List is empty and it is not possible to remove element");
		}
		
	//parbaudit index. Pie nepareiza indeksa izmest iznemumu
		if(position <= 0 || position > counter)
		{
			throw new Exception("The index is not accepted");
		}
		
		if(position == 1) {//dzēšam pirmo elementu
			firstNode = firstNode.getNext();
			firstNode.setPrevious(null);
			System.gc();
			counter--;
		}
		else if(position == counter) {//dzēšam pēdējo elementu
			lastNode = lastNode.getPrevious();	
			lastNode.setNext(null);
			System.gc();
			counter--;
		}
		else
		{
			MyNode currentNode = firstNode;
			for(int i = 0; i < position-1; i++) {
				currentNode = currentNode.getNext();
			}
			
			MyNode currentNodeNext = currentNode.getNext();
			MyNode currentNodePrevious = currentNode.getPrevious();
			currentNodeNext.setPrevious(currentNodePrevious);
			currentNodePrevious.setNext(currentNodeNext);
			currentNode = null;
			System.gc();
			counter--;
			
			
		}
		
	}
	
	
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("List is empty and it is not possible to print elements");
		}
		
		MyNode currentNode = firstNode;
		
		while(currentNode != null)
		{
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	
	
	
}

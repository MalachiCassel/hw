
public class Numbers {
	
	private Node head;
	private Node tail;
	public int mean;
	
	public Numbers() {
		head=null;
		tail=null;
	}
	
	public void push(Integer n) {
		Node temp=new Node(n);
		if(head==null) {
			head=temp;
			tail=temp;
		}
		else {
			temp.prev=tail;
			tail.next=temp;
			tail=temp;
		}
	}
			
	public double Mean() {
		int total=0;
		int i=0;
		Node current=head;
		while (current!=tail) {
			total+=current.n;
			current=current.next;
			i++;
		}
		mean=total/i;
		return mean;
	}
	
	public double stdev() {
		double stand=0;
		int i=0;
		double insideval;
		Node current=head;
		while (current!=tail) {
			stand+=Math.pow(current.n-mean, 2);
			current=current.next;
			i++;
		}
		insideval=stand/i;
		return Math.sqrt(insideval);
		
	}
}

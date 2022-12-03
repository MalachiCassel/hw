import java.util.LinkedList;

public class Inventory {
	
	LinkedList<Textbook> Inventory=new LinkedList<Textbook>();
	
	public void AddtoInventory(int sku,String title,double price,int quantity) {
		Textbook x=new Textbook(sku,title,price,quantity);
		Inventory.add(x);
	}
	
	public void RemovefromInventory(int sku) {
		for(int i=0; i<Inventory.size(); i++) {
			if(Inventory.get(i).getSku()==sku) {
				Inventory.remove(Inventory.get(i));
			}
			else {
				System.out.println("Error");
			}
		}
	}
	public void showtext(int sku) {
		for(int i=0; i<Inventory.size(); i++) {
			if(Inventory.get(i).getSku()==sku) {
				System.out.println(Inventory.get(i));
			}
			else {
				System.out.println("Error");
			}
		}
	}
	public void showinventory() {
		System.out.println(Inventory);
	}

}

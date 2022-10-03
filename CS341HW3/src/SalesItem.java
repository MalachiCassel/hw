
public class SalesItem {
	private String name;
	private int quantity;
	private double cost;
	
	public SalesItem(String n,int q,double c) {
		name=n;
		quantity=q;
		cost=c;
	}
	public double getTotal() {
		return quantity*cost;
	}
	
	public String toString(String n,int q,double c) {
		String saleitem=n+"\t$"+c+"\t"+q;
		return saleitem;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}

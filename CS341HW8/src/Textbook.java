
public class Textbook {
	
	private int sku;
	private String title;
	private double price;
	private int quantity;
	public Textbook(int sku,String title,double price,int quantity) {
		sku=this.sku;
		title=this.title;
		price=this.price;
		quantity=this.quantity;
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

import java.util.ArrayList;

public class SalesSlip {
	
	private ArrayList<SalesItem> salesList;
	
	public SalesSlip () {
		salesList=new ArrayList<SalesItem>();
	}

	public void additem(SalesItem item) {
		salesList.add(item);
	}

	public String totalcost() {
		double x = 0.0;
		for (int i = 0; i < salesList.size(); i++) {
			x += salesList.get(i).getTotal();
		}
		return "$"+x;
	}
	
	public String ToString() {
		String completelist="";
		for(int i=0; i<salesList.size(); i++) {
			completelist+=salesList.get(i).toString()+"\n";
		}
		return completelist;
	}

}

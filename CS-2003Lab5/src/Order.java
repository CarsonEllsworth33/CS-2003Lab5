
public class Order {
	private int cost;
	private int trackingNum;
	private String customerName;
	private int dateOrdered;
	
	public Order(int track,String custName,int dateOrdered) {
		this.trackingNum = track;
		this.customerName = custName;
		this.dateOrdered = dateOrdered;
	}
	
	public int getDateOrdered() {
		return dateOrdered;
	}
	
	public int getTrackingNum() {
		return trackingNum;
	}
	
	public int determineCost(int price) {
	return (price = cost);	
	}
	public void displayOrderInfo() {
		System.out.println("tracking number is "+trackingNum+"\nThe customers name is "+customerName+"\nand the date it was ordered on was "+dateOrdered);
	}
}

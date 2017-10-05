/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 19 "umple.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int trackingNum;
  private int dateOrdered;
  private String customerName;
  private int cost;

  //Order Associations
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(int aTrackingNum, int aDateOrdered, String aCustomerName, int aCost, Customer aCustomer)
  {
    trackingNum = aTrackingNum;
    dateOrdered = aDateOrdered;
    customerName = aCustomerName;
    cost = aCost;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create order due to customer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTrackingNum(int aTrackingNum)
  {
    boolean wasSet = false;
    trackingNum = aTrackingNum;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOrdered(int aDateOrdered)
  {
    boolean wasSet = false;
    dateOrdered = aDateOrdered;
    wasSet = true;
    return wasSet;
  }

  public boolean setCustomerName(String aCustomerName)
  {
    boolean wasSet = false;
    customerName = aCustomerName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCost(int aCost)
  {
    boolean wasSet = false;
    cost = aCost;
    wasSet = true;
    return wasSet;
  }

  public int getTrackingNum()
  {
    return trackingNum;
  }

  public int getDateOrdered()
  {
    return dateOrdered;
  }

  public String getCustomerName()
  {
    return customerName;
  }

  public int getCost()
  {
    return cost;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeOrder(this);
    }
    customer.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer placeholderCustomer = customer;
    this.customer = null;
    placeholderCustomer.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "trackingNum" + ":" + getTrackingNum()+ "," +
            "dateOrdered" + ":" + getDateOrdered()+ "," +
            "customerName" + ":" + getCustomerName()+ "," +
            "cost" + ":" + getCost()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}
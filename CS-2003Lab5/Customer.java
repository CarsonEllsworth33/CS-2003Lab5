/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/


import java.util.*;

// line 1 "umple.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private boolean isAFrequentShopper;
  private int age;
  private int birthday;
  private String name;

  //Customer Associations
  private List<Order> orders;
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(boolean aIsAFrequentShopper, int aAge, int aBirthday, String aName, Account aAccount)
  {
    isAFrequentShopper = aIsAFrequentShopper;
    age = aAge;
    birthday = aBirthday;
    name = aName;
    orders = new ArrayList<Order>();
    if (aAccount == null || aAccount.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aAccount");
    }
    account = aAccount;
  }

  public Customer(boolean aIsAFrequentShopper, int aAge, int aBirthday, String aName, int aIdForAccount, int aBalanceForAccount, int aSavingsForAccount, String aOwnerForAccount)
  {
    isAFrequentShopper = aIsAFrequentShopper;
    age = aAge;
    birthday = aBirthday;
    name = aName;
    orders = new ArrayList<Order>();
    account = new Account(aIdForAccount, aBalanceForAccount, aSavingsForAccount, aOwnerForAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsAFrequentShopper(boolean aIsAFrequentShopper)
  {
    boolean wasSet = false;
    isAFrequentShopper = aIsAFrequentShopper;
    wasSet = true;
    return wasSet;
  }

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    age = aAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setBirthday(int aBirthday)
  {
    boolean wasSet = false;
    birthday = aBirthday;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsAFrequentShopper()
  {
    return isAFrequentShopper;
  }

  public int getAge()
  {
    return age;
  }

  public int getBirthday()
  {
    return birthday;
  }

  public String getName()
  {
    return name;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Account getAccount()
  {
    return account;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(int aTrackingNum, int aDateOrdered, String aCustomerName, int aCost)
  {
    return new Order(aTrackingNum, aDateOrdered, aCustomerName, aCost, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Customer existingCustomer = aOrder.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);
    if (isNewCustomer)
    {
      aOrder.setCustomer(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a customer
    if (!this.equals(aOrder.getCustomer()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "isAFrequentShopper" + ":" + getIsAFrequentShopper()+ "," +
            "age" + ":" + getAge()+ "," +
            "birthday" + ":" + getBirthday()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 10 "umple.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private int id;
  private int balance;
  private int savings;
  private String owner;

  //Account Associations
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(int aId, int aBalance, int aSavings, String aOwner, Customer aCustomer)
  {
    id = aId;
    balance = aBalance;
    savings = aSavings;
    owner = aOwner;
    if (aCustomer == null || aCustomer.getAccount() != null)
    {
      throw new RuntimeException("Unable to create Account due to aCustomer");
    }
    customer = aCustomer;
  }

  public Account(int aId, int aBalance, int aSavings, String aOwner, boolean aIsAFrequentShopperForCustomer, int aAgeForCustomer, int aBirthdayForCustomer, String aNameForCustomer)
  {
    id = aId;
    balance = aBalance;
    savings = aSavings;
    owner = aOwner;
    customer = new Customer(aIsAFrequentShopperForCustomer, aAgeForCustomer, aBirthdayForCustomer, aNameForCustomer, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setBalance(int aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setSavings(int aSavings)
  {
    boolean wasSet = false;
    savings = aSavings;
    wasSet = true;
    return wasSet;
  }

  public boolean setOwner(String aOwner)
  {
    boolean wasSet = false;
    owner = aOwner;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public int getBalance()
  {
    return balance;
  }

  public int getSavings()
  {
    return savings;
  }

  public String getOwner()
  {
    return owner;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void delete()
  {
    Customer existingCustomer = customer;
    customer = null;
    if (existingCustomer != null)
    {
      existingCustomer.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "balance" + ":" + getBalance()+ "," +
            "savings" + ":" + getSavings()+ "," +
            "owner" + ":" + getOwner()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}
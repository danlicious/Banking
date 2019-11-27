package banking;


public class Transaction implements ITransaction{
  
   private String type;
   private double amount;
   
   @Override
    public String toString(){
       
      String TransText = type + " of " + amount;  
      return TransText;
    }
}

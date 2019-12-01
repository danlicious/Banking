package banking;


public class Transaction implements ITransaction{
  
   private String type;
   private double amount;
   
   public Transaction(){
   
   }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
   
   @Override
    public String toString(){
       
      String TransText = type + " of " + amount;  
      return TransText;
    }
}

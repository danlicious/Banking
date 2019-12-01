package banking;


public class Transaction implements ITransaction{  //Marius
  
   private String type;
   private double amount;

   //@RR
    public Transaction(String type, double amount) {  //Marius
        this.type = type;
        this.amount = amount;
    }      

    public String getType() {  //Marius
        return this.type;
    }

    public void setType(String type) {  //Marius
        this.type = type;
    }

    public double getAmount() {  //Marius
        return this.amount;
    }

    public void setAmount(double amount) {  //Marius
        this.amount = amount;
    }
    @Override
    public String toString(){  //Marius
       
      String TransText = this.type + " of " + Math.round(this.amount*100)/100.0 + "$";  
      return TransText;
    }
}

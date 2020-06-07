package PayPackage;

public class Account {
    String Account_Holder;
    int Account_Number;//Unique key in database
    //Maybe an account type-SAVINGS/Current for extra features
    int Balance;

    public Account(String Name,int Account_Number,int Balance)
    {
        this.Account_Holder=Name;
        this.Account_Number=Account_Number;
        this.Balance=Balance;
    }

    //Getters
    public String getAccount_Holder() {
        return Account_Holder;
    }

    public int getAccount_Number() {
        return Account_Number;
    }

    public int getBalance() {
        return Balance;
    }

    //Setters
    public void setBalance(int balance) {
        Balance = balance;
    }

}

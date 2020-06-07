package PayPackage;

import java.util.ArrayList;

public class TestArrayInit {

    static ArrayList<Account> List=new ArrayList<Account>();
    static ArrayList<Account> InitArray(){

        List.add(new Account("Dhruv",100,1000));
        List.add(new Account("Kartik",200,5000));
        List.add(new Account("Nitin",300,800));
        List.add(new Account("root",500,300));
        return List;
    }

    static void UpdateList(Account User)
    {
        Boolean found=false;
        for(int i=0;i<List.size() && found==false;i++)
        {
            if(List.get(i).getAccount_Number()==User.getAccount_Number())
            {
                found=true;
                List.get(i).setBalance(User.getBalance());
            }
        }
    }

    static ArrayList<Account> getList()
    {
        return List;
    }
}

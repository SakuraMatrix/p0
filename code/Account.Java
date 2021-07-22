import java.lang.String;

public class Account{

    private String _Username;
    private String _Password;


    //For this example of a banking app, I will only focus on basic Checking and Saving accounts
    //I can adjust the structure to allow for other account types in the future
    public enum Check_Save_Account {
        AccountContainer (000.00);

        public double amount = 0;

        private Check_Save_Account(double amountToAdjust){
            this.amount = amountToAdjust;
        }
    };
    Check_Save_Account myAccount[] = new Check_Save_Account[]{};
    double overdraftLim = 200.00;

    void Account(){

    }

    public void SetUserName(String usern) {
        //Check for illegal characters or any existing usernames in the database
        _Username = usern;
    }
    public String GetUserName() {
        return _Username;
    }

    public void SetPassword(String pass){
        //Run simple encryption on the password
        _Password = pass;
    }

    //Create a new account with and initial amount
    //the flag specifies if it is a checking or a savings account
    public void CreateAccount(Check_Save_Account acc, double initAmount,int flag)
    {
        int newLen = myAccount.length + 1;
        //Empty Account
        if (newLen == 1) {
            acc.amount = AdjustAccount(acc, initAmount, flag);
            myAccount = new Check_Save_Account[newLen];
            myAccount[0] = acc;
        }
        //Non-Empty Account
        else {
            acc.amount = AdjustAccount(acc, initAmount, flag);
            Check_Save_Account[] data = myAccount;
            myAccount = new Check_Save_Account[newLen];
            for (int i = 0; i < myAccount.length - 2; i++) {
                myAccount[i] = data[i];
            }
            myAccount[newLen - 1] = acc;
        }
    }

    //Adjust the passed in account based on the passed in amount
    //Negative Values are withdrawls
    //Positive Values are deposits
    //Will not allow a negative balance for savings account
    //Will warn of overdrafting a checking account
    public double AdjustAccount(Check_Save_Account type, double amount, int flag) {
        Check_Save_Account temp = type;
        double adjust = temp.amount + amount;
        //Handle cases where adjustment would result in a negative balance.
        //Reject adjustment for savings accounts
        //Caclulate overdraft for checking accounts
        if(adjust < 0)
        {
            for (int i = 0; i < myAccount.length; i++){
                //Flag for Savings Account
                if(flag == 0){
                    //Log error, reject adjustment of negative balance to savings account

                    return temp.amount;
                }
                //Flag for Checking Account
                if(flag == 1){
                    if(adjust <= overdraftLim){
                        //Overdraft limit reached. Reject adjustment and output repsonse

                        return temp.amount;
                    }
                    //Log activity. Warn of overdraft

                    return temp.amount;
                }
            }
            //Cannot have negative balance. Reject adjustment. Return original amount of account
            //throw exception / log error

            return temp.amount;
        }
        //If a negative value is input, it is a withdrawl
        //If a postive value is input, it is a deposit
        temp.amount += amount;
        return temp.amount;
        //Log activity for an itemized reciept
    }
}
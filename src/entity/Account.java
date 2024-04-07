package entity;

public class Account {
    private int acc_Id;
    private String userName;
    private String password;
    private Boolean permission;
    private Boolean account_Status;
    public Account(){
    }

    public Account(int acc_Id, String userName, String password, Boolean permission, Boolean account_Status) {
        this.acc_Id = acc_Id;
        this.userName = userName;
        this.password = password;
        this.permission = permission;
        this.account_Status = account_Status;
    }

    public int getAcc_Id() {
        return acc_Id;
    }

    public void setAcc_Id(int acc_Id) {
        this.acc_Id = acc_Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    public Boolean getAccount_Status() {
        return account_Status;
    }

    public void setAccount_Status(Boolean account_Status) {
        this.account_Status = account_Status;
    }
}

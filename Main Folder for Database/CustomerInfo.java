
public class CustomerInfo {
	private String userName;
    private String password;
    private String authorization;

    public CustomerInfo (String userName, String password, String authorization) {
		super();
		this.userName = userName;
		this.password = password;
		this.authorization = authorization;
		
	}
    
    
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
   
	public String password() {
        return password;
    }
    public void setauthorization(String authorization) {
        this.authorization = authorization;
    }
   
   
  //toString()
    @Override
    public String toString() {
        return "UserInfo [ userName=" + userName + ", password="
                + password + ",authorization="+ authorization +"]";
    }       


}

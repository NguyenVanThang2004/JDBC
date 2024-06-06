package Test;

import DataAccesObject.UserDAO;
import Model.User;

public class TestUser {
  public static void main(String[] args) {
	 
//	  User u1 = new User("thang","123","Nguyen van thang");
	  
	  User u_find = new User("x\' or 1=1; -- ","","");
	  User check  = UserDAO.getInstance().selectById(u_find);
	  
	  System.out.println(check);
	  
	  
}
}

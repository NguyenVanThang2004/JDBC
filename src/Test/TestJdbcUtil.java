package Test;

import java.sql.Connection;

import Database.JdbcUtil;

public class TestJdbcUtil {
  public static void main(String[] args) {
	Connection connection = JdbcUtil.getConnection();
	
	System.out.println(connection);
}
}

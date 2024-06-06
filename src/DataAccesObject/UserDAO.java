package DataAccesObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import Database.JDBCUtil;
import Model.User;

public class UserDAO implements DAOInterface<User> {

	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(User t) {

		int ketqua = 0;
		try {
			// b1 ket noi csdl
			Connection connect = JDBCUtil.getConnection();

			// b2 tao cau lenh sql
			String sql = "INSERT INTO user(username , password , hoTen)"+
		             "VALUES(?,?,?)";
			
			// b3 tao doi tuong PreparedStatement
			
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1,t.getUserName());
			pst.setString(2,t.getPassWord());
			pst.setString(3, t.getHoTen());
			
			
			

			// b4 thuc hien va kiem tra
			ketqua = pst.executeUpdate();
			System.out.println(sql);
			System.out.println("so dong bi thayt doi :"+ketqua);
			

			// b5 huy ket noi csdl
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;

	}

	@Override
	public int update(User t) {

		int ketqua = 0;
		try {
			// b1 ket noi csdl
			Connection connect = JDBCUtil.getConnection();

			
			 String sql = "UPDATE User "
	                  +"SET "+
					   
	                   "password=?"+
					   "hoTen=?"+
	                   "WHERE username=?";
			 
			 PreparedStatement pst = connect.prepareStatement(sql);
			 pst.setString(1,t.getPassWord());
			 pst.setString(2,t.getHoTen());
			 pst.setString(3,t.getUserName());
			 
			

			// b4 thuc hien va kiem tra
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("ban da thuc thi :" + sql);
				System.out.println("so dong bi thay doi :" + ketqua);
			}

			// b5 huy ket noi csdl
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;

	}

	@Override
	public int delete(User t) {
		int ketqua = 0;
		try {
			// b1 ket noi csdl
			Connection connect = JDBCUtil.getConnection();

			
			String sql = " DELETE FROM User "
			           + " WHERE "+"username=?"; 

			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1, t.getUserName());
			// b4 thuc hien va kiem tra
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("ban da thuc thi :" + sql);
				System.out.println("so dong bi thay doi :" + ketqua);
			}

			// b5 huy ket noi csdl
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketqua = new ArrayList<User>() ; 
		
		try {
			// b1 ket noi csdl 
			Connection connect = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM User";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			// b4 kiem tra 
		   ResultSet rs = pst.executeQuery();
		   while(rs.next()) {
			 String username = rs.getString("username");
			 String password = rs.getString("password");
			 String hoTen    = rs.getString("hoTen");
			   
			   User User = new User(username, password, hoTen);
			   ketqua.add(User);
		   }
		   
			
			
			// b5 dong csdl 
			JDBCUtil.closeConnection(connect);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ketqua;
	}

	public User selectById(User t) {
	    User ketqua = null;
	    
	    try {
	        // Step 1: Connect to the database
	        Connection connect = JDBCUtil.getConnection();
	        
	        // Correct SQL query
	        String sql = "SELECT * FROM User WHERE username = ?";
	        
	        // Prepare the statement
	        PreparedStatement pst = connect.prepareStatement(sql);
	        pst.setString(1, t.getUserName());
	        
	        // Step 4: Execute the query (without passing the SQL string)
	        ResultSet rs = pst.executeQuery();
	        
	        // Process the result set
	        while (rs.next()) {
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            String hoTen = rs.getString("hoTen");
	            ketqua = new User(username, password, hoTen);
	        }
	        
	        // Step 5: Close the database connection
	        JDBCUtil.closeConnection(connect);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return ketqua;
	}


	@Override
	public ArrayList selectByCondition(String condition) {
		
           ArrayList<User> ketqua = new ArrayList<User>() ; 
		
		try {
			// b1 ket noi csdl 
			Connection connect = JDBCUtil.getConnection();
			
			// b2 tao doi tuong statement
			Statement st       = connect.createStatement();
			
			// b3 thuc thi cau lenh sql
			String sql = "SELECT * FROM User WHERE " + condition;
			System.out.println(sql);
			// b4 kiem tra 
		   ResultSet rs = st.executeQuery(sql);
		   while(rs.next()) {
			   String username = rs.getString("username");
			   String password = rs.getString("password");
			   String hoTen    = rs.getString("hoTen");
			   
			   User User = new User(username, password, hoTen);
			   ketqua.add(User);
		   }
		   
			
			
			// b5 dong csdl 
			JDBCUtil.closeConnection(connect);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ketqua;
	}

}

package DataAccesObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import Database.JDBCUtil;
import Model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach t) {

		int ketqua = 0;
		try {
			// b1 ket noi csdl
			Connection connect = JDBCUtil.getConnection();

			// b2 tao doi tuong statement
			Statement st = connect.createStatement();

			// b3 thuc thi cau lenh sql
			String sql = "INSERT INTO sach(id, tenSach, giaBan, namXuanBan)" + "VALUES('" + t.getId() + "','"
					+ t.getTenSach() + "','" + t.getGiaBan() + "','" + t.getNamXuatBan() + "')";

			// b4 thuc hien va kiem tra
			ketqua = st.executeUpdate(sql);
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
	public int update(Sach t) {

		int ketqua = 0;
		try {
			// b1 ket noi csdl
			Connection connect = JDBCUtil.getConnection();

			// b2 tao doi tuong statement
			Statement st = connect.createStatement();

			// b3 thuc thi cau lenh sql
			 String sql = "UPDATE sach "
	                   + "SET tenSach='" + t.getTenSach() + "', "
	                   + "giaBan=" + t.getGiaBan() + ", "
	                   + "namXuanBan=" + t.getNamXuatBan() + " "
	                   + "WHERE id='" + t.getId() + "'";
			

			// b4 thuc hien va kiem tra
			ketqua = st.executeUpdate(sql);
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
	public int delete(Sach t) {
		int ketqua = 0;
		try {
			// b1 ket noi csdl
			Connection connect = JDBCUtil.getConnection();

			// b2 tao doi tuong statement
			Statement st = connect.createStatement();

			// b3 thuc thi cau lenh sql
			String sql = " DELETE FROM sach "
			           + " WHERE id='"+t.getId()+"'"; 

			// b4 thuc hien va kiem tra
			ketqua = st.executeUpdate(sql);
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
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketqua = new ArrayList<Sach>() ; 
		
		try {
			// b1 ket noi csdl 
			Connection connect = JDBCUtil.getConnection();
			
			// b2 tao doi tuong statement
			Statement st       = connect.createStatement();
			
			// b3 thuc thi cau lenh sql
			String sql = "SELECT * FROM sach";
			
			// b4 kiem tra 
		   ResultSet rs = st.executeQuery(sql);
		   while(rs.next()) {
			   String id = rs.getString("id");
			   String tenSach = rs.getString("tenSach");
			   float giaban  =  rs.getFloat("giaban");
			   int namXuanBan = rs.getInt("namXuanBan");
			   
			   Sach sach = new Sach(id, tenSach, giaban, namXuanBan);
			   ketqua.add(sach);
		   }
		   
			
			
			// b5 dong csdl 
			JDBCUtil.closeConnection(connect);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ketqua;
	}

	@Override
	public Sach selectById(Sach t) {
		
		Sach ketqua = null ;
		
		try {
			// b1 ket noi csdl 
			Connection connect = JDBCUtil.getConnection();
			
			// b2 tao doi tuong statement
			Statement st       = connect.createStatement();
			
			// b3 thuc thi cau lenh sql
			String sql = "SELECT *FROM sach "
					    +"WHERE id='"+t.getId()+"'";
			
			// b4 kiem tra 
		   ResultSet rs = st.executeQuery(sql);
		   while(rs.next()) {
			   String id = rs.getString("id");
			   String tenSach = rs.getString("tenSach");
			   float giaban  =  rs.getFloat("giaban");
			   int namXuanBan = rs.getInt("namXuanBan");
			   
			   ketqua = new Sach(id, tenSach, giaban, namXuanBan);
			   
		   }
		   
			
			
			// b5 dong csdl 
			JDBCUtil.closeConnection(connect);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ketqua ; 
	}

	@Override
	public ArrayList selectByCondition(String condition) {
		
           ArrayList<Sach> ketqua = new ArrayList<Sach>() ; 
		
		try {
			// b1 ket noi csdl 
			Connection connect = JDBCUtil.getConnection();
			
			// b2 tao doi tuong statement
			Statement st       = connect.createStatement();
			
			// b3 thuc thi cau lenh sql
			String sql = "SELECT * FROM sach WHERE " + condition;
			System.out.println(sql);
			// b4 kiem tra 
		   ResultSet rs = st.executeQuery(sql);
		   while(rs.next()) {
			   String id = rs.getString("id");
			   String tenSach = rs.getString("tenSach");
			   float giaban  =  rs.getFloat("giaban");
			   int namXuanBan = rs.getInt("namXuanBan");
			   
			   Sach sach = new Sach(id, tenSach, giaban, namXuanBan);
			   ketqua.add(sach);
		   }
		   
			
			
			// b5 dong csdl 
			JDBCUtil.closeConnection(connect);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return ketqua;
	}

}

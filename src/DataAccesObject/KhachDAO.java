package DataAccesObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import Database.JDBCUtil;
import Model.khachHang;

public class KhachDAO implements DAOInterface<khachHang> {

	public static KhachDAO getInstance() {
		return new KhachDAO();
	}

	@Override
	public int insert(khachHang t) {
		
		int ketqua = 0 ;
		
		try {
			//b1 ket noi vs csdl 
			Connection connect = JDBCUtil.getConnection();
			
			//b2 tao doi tương statement 
			Statement st       = connect.createStatement();
			
			//b3 thuc thi cau lenh sql 
			String sql = "INSERT INTO khachhang( id, hoTen, ngaySinh, diaChi)"
					    +"VALUES('"+t.getId()+"','"+t.getHoTen()+"','"+t.getNgaySinh()+"','"+t.getDiaChi()+"')";
			
			//b4 kiem tra
		    ketqua = st.executeUpdate(sql);
		    if( ketqua > 0 ) {
		    	System.out.println("ban da thuc thi :"+sql);
		    	System.out.println("so dong thay doi :"+ketqua);
		    }
		    // b5 dong csdl
		    JDBCUtil.closeConnection(connect);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ketqua ;
	}

	@Override
	public int update(khachHang t) {
		
		int ketqua  = 0 ;
		
	    try {
	    	// b1 
			Connection connect = JDBCUtil.getConnection();
			// b2
			Statement st = connect.createStatement();
			// b3
			String sql = "UPDATE khachhang " +
		             "SET hoTen = '" + t.getHoTen() + "', " +
		             "ngaySinh = '" + t.getNgaySinh() + "', " +
		             "diaChi = '" + t.getDiaChi() + "' " +
		             "WHERE id = " + t.getId();

			// b4 
			ketqua = st.executeUpdate(sql);
			if( ketqua > 0) {
				System.out.println("ban da thuc thi :"+sql);
				System.out.println("so dong thay doi :"+ketqua);
			}
			
			// b5 
			JDBCUtil.closeConnection(connect);
			
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
		return ketqua ;
	}

	@Override
	public int delete(khachHang t) {
int ketqua  = 0 ;
		
	    try {
	    	// b1 
			Connection connect = JDBCUtil.getConnection();
			// b2
			Statement st = connect.createStatement();
			// b3
			String sql = "DELETE FROM khachhang " +
		                 "WHERE id='"+t.getId()+"'";

			// b4 
			ketqua = st.executeUpdate(sql);
			if( ketqua > 0) {
				System.out.println("ban da thuc thi :"+sql);
				System.out.println("so dong thay doi :"+ketqua);
			}
			
			// b5 
			JDBCUtil.closeConnection(connect);
			
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
		return ketqua ;
	}

	@Override
	public ArrayList<khachHang> selectAll() {
		
		ArrayList<khachHang> ketqua = new ArrayList<khachHang>() ;
		
		try {
			//b1 
			Connection connect = JDBCUtil.getConnection();
			//b2 
			Statement st = connect.createStatement();
			//b3 
			String sql ="SELECT * FROM khachhang";
			//b4 
			
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoTen = rs.getString("hoTen");
			    Date   ngaySinh = rs.getDate("ngaySinh");
			    String diaChi   = rs.getString("diaChi");
			    
			    khachHang kh = new khachHang(id, hoTen, ngaySinh, diaChi);
			    ketqua.add(kh);
			}
			
			// b5 
			JDBCUtil.closeConnection(connect);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 
		return ketqua;
	}

	@Override
	public khachHang selectById(khachHang t) {
            
		khachHang ketqua = null ; 
		
		try {
			//b1 
			Connection connect = JDBCUtil.getConnection();
			//b2 
			Statement st = connect.createStatement();
			//b3 
			String sql ="SELECT * FROM khachhang WHERE id='"+t.getId()+"'";
			//b4 
			
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoTen = rs.getString("hoTen");
			    Date   ngaySinh = rs.getDate("ngaySinh");
			    String diaChi   = rs.getString("diaChi");
			    
			    ketqua = new khachHang(id, hoTen, ngaySinh, diaChi);
			}
			
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 
		return ketqua;
	}

	@Override
	public ArrayList<khachHang> selectByCondition(String condition) {
		
ArrayList<khachHang> ketqua = new ArrayList<khachHang>() ;
		
		try {
			//b1 
			Connection connect = JDBCUtil.getConnection();
			//b2 
			Statement st = connect.createStatement();
			//b3 
			String sql ="SELECT * FROM khachhang WHERE "+condition;
			//b4 
			
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoTen = rs.getString("hoTen");
			    Date   ngaySinh = rs.getDate("ngaySinh");
			    String diaChi   = rs.getString("diaChi");
			    
			    khachHang kh = new khachHang(id, hoTen, ngaySinh, diaChi);
			    ketqua.add(kh);
			}
			
			// b5 
			JDBCUtil.closeConnection(connect);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 
		return ketqua;
		
		
	}

}

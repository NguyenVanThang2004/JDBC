package Test;

import java.sql.Date;
import java.util.ArrayList;

import DataAccesObject.KhachDAO;
import Model.khachHang;

public class TestKhachDAO {
	public static void main(String[] args) {

		khachHang x = new khachHang(10, "thang", new Date(2004, 2, 2), "ha noi");

//	 for(int i = 3 ; i < 5 ; i++) {
//		 khachHang  a = new khachHang(i,"nguyen van"+i,new Date(2004, i+2, 10+i),"ha tinh");
//		 KhachDAO.getInstance().insert(a);
//		 
//	 }
//	 KhachDAO.getInstance().insert(x);
//	 KhachDAO.getInstance().delete(x);
//	          ArrayList<khachHang>  y =   KhachDAO.getInstance().selectAll();
//	          
//	          for (khachHang khachHang : y) {
//				System.out.println(khachHang.toString());
//			}
//	     
//	 khachHang find = new khachHang() ;
//	 find.setId(4);
//	 khachHang e    = KhachDAO.getInstance().selectById(find);
//	 System.out.println(e.toString());

		ArrayList<khachHang> y = KhachDAO.getInstance().selectByCondition("diaChi LIKE N'ha tinh'");

		for (khachHang khachHang : y) {
			System.out.println(khachHang.toString());
		}
	}
}

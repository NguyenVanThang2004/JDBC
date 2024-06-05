package Test;

import java.util.ArrayList;

import DataAccesObject.SachDAO;
import Model.Sach;

public class TestSachDAO {
  public static void main(String[] args) {
	 Sach sach1 = new Sach("01","siu",138,1);
	 Sach sach2 = new Sach("05","american", 77,2);
	 Sach sach3 = new Sach("08","su", 43, 2004);
	 
	 // insert
//	 SachDAO.getInstance().insert(sach2);
//	 SachDAO.getInstance().insert(sach3);
	 
	 // update 
//	 SachDAO.getInstance().update(sach1);
	 
	 // delete 
//	 SachDAO.getInstance().delete(sach1);

//	 ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//	 for(Sach sach : list) {
//		 System.out.println(sach.toString());
//	 }
	 
//	 Sach find = new Sach();
//	 find.setId("05");
//	 Sach sach5= SachDAO.getInstance().selectById(find);
//	 
//	 System.out.println(sach5.toString());
	 
	 ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("namXuanBan>2000");
	 
	 for(Sach sach : list2) {
		 System.out.println(sach.toString());
	 }
	 
	 
	 
	 
}
}

package DataAccesObject;

import java.util.ArrayList;

import Model.khachHang;

public class KhachDAO implements DAOInterface<khachHang> {

	public static KhachDAO getInstance() {
		return new KhachDAO();
	}

	@Override
	public int insert(khachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(khachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(khachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<khachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public khachHang selectById(khachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<khachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

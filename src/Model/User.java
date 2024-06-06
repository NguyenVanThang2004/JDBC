package Model;

public class User {
	private String userName;
	private String passWord;
	private String hoTen;

	public User(String userName, String passWord, String hoTen) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.hoTen = hoTen;
	}

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", hoTen=" + hoTen + "]";
	}

}

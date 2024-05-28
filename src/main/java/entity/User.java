package entity;

public class User implements BaseEntity {
	public static final String TITLE_ID_USER = "ユーザーID";
	public static final String TITLE_NM_USER = "ユーザー名";
	public static final String TITLE_PASSWORD = "パスワード";
	
	
	/** 社員ID */
	private Integer idUser;
	/** ユーザー名 */
	private String nmUser;
	/** パスワード */
	private String password;
	
	
	
	
	//ユーザーID
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	//ユーザー名
	public String getNmUser() {
		return nmUser;
	}
	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}
	
	//パスワード
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

package entity;

public class User implements BaseEntity {
	public static final String TITLE_ID_USER = "ユーザーID";
	public static final String TITLE_NM_USER = "ユーザー名";
	public static final String TITLE_PASSWORD = "パスワード";
	public static final String TITLE_ID_DIARY = "日記ID";
	public static final String TITLE_TITLE = "タイトル";
	public static final String TITLE_TEXT = "本文";
	public static final String TITLE_DATE = "更新日時";
	
	/** 社員ID */
	private Integer idUser;
	/** ユーザー名 */
	private String nmUser;
	/** パスワード */
	private String password;
	/** 日記ID */
	private Integer idDiary;
	/** タイトル */
	private String title;
	/** 本文 */
	private String text;
	/** 更新日時 */
	private String date;
	
	
	
	//ユーザーID
	public Integer getIdEmployee() {
		return idUser;
	}
	public void setIdEmployee(Integer idUser) {
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
	
	//日記ID
	public Integer getIdDiary() {
		return idDiary;
	}
	public void setIdDiary(Integer idDiary) {
		this.idDiary = idDiary;
	}
	
	//タイトル
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//本文
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//更新日時
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}

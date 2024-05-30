package entity;

public class Diary implements BaseEntity{
	
	public static final String TITLE_ID_DIARY = "日記ID";
	public static final String TITLE_TITLE = "タイトル";
	public static final String TITLE_TEXT = "本文";
	public static final String TITLE_DATE = "更新日時";
	
	/** 日記ID */
	private Integer idDiary;
	/** ユーザーID */
	private Integer idUser;
	/** タイトル */
	private String title;
	/** 本文 */
	private String text;
	/** 更新日時 */
	private String date;

	
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
		
		//ユーザーID
		public Integer getIdUser() {
			return idUser;
		}
		public void setIdUser(Integer idUser) {
			this.idUser = idUser;
		}
}

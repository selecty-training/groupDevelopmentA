package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Diary;

public class DiaryDao extends BaseDao<Diary>{
	
	public DiaryDao(Connection con) {
		super(con);
	}
	
	//日記の新規登録
	public void insertDiary(Diary diary) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO " + this.getTableName());
		sql.append("(");
		sql.append(" id_user, ");
		sql.append(" title, ");
		sql.append(" text, ");
		sql.append(" date ");
		sql.append(") VALUES ( ?, ?, ?, ? )");
		
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(
				diary.getIdDiary(),
				diary.getTitle(),
				diary.getText(),
				diary.getDate()			
		);
		
		this.stmt.executeUpdate();
		this.closeStatement();			
	}

	@Override
	protected String getTableName() {
		return "diary";
	}

	@Override
	protected Diary rowMapping(ResultSet rs) throws SQLException {
		Diary diary = new Diary();
		diary.setIdDiary((Integer) rs.getInt("id_diary"));
		diary.setTitle(rs.getString("title"));
		diary.setText(rs.getString("text"));
		diary.setDate(rs.getString("date"));
		return diary;
	}

	@Override
	protected String[] getColumnsList() {
		return new String[] {
				 "id_diary"
				,"title"
				,"text"
				,"date"
		};
	}

	@Override
	protected String[] getPrimaryKey() {
		return new String[] {
				 "id_diary"
		};
	}

}

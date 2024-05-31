package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		sql.append("id_user,");
		sql.append(" title, ");
		sql.append(" text, ");
		sql.append(" date ");
		sql.append(") VALUES ( ?,?, ?, CURTIME())");
		
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(
				diary.getIdUser(),
				diary.getTitle(),
				diary.getText()
		);
		
		this.stmt.executeUpdate();
		this.closeStatement();			
	}
	
	//
	public List<Diary> selectAll(int id) throws SQLException {
		Diary diary = null;
		List<Diary> diaryList= new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT * FROM " + this.getTableName());
		sql.append(" WHERE id_user = ?");
		
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(id);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			diary = rowMapping(rs);
			diaryList.add(diary);
		}
		
		this.closeStatement();
		return diaryList;	
	}

	@Override
	protected String getTableName() {
		return "diary";
	}

	@Override
	protected Diary rowMapping(ResultSet rs) throws SQLException {
		Diary diary = new Diary();
		diary.setIdUser((Integer) rs.getInt("id_user"));
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

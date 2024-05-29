package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao extends BaseDao<User>{
	
	public UserDao(Connection con) {
		super(con);
	}
	
	//ログインしているユーザーの情報を表示
	public User selectLoginInfo(String name, String pass) throws SQLException {
		User entity = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT * FROM " + this.getTableName());
		sql.append(" WHERE nm_user = ? AND password = ?");
		
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(name, pass);
		
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			entity = rowMapping(rs);
		}
		
		this.closeStatement();
		return entity;	
	}
	
	//ユーザーの新規登録
	public void insertUser(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO " + this.getTableName());
		sql.append("(");
		sql.append(" nm_user, ");
		sql.append(" password ");
		sql.append(") VALUES ( ?, ? )");
		
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(
				user.getNmUser(),
				user.getPassword()
		);
		
		this.stmt.executeUpdate();
		this.closeStatement();			
	}

	
	
	@Override
	protected String getTableName() {
		return "user";
	}

	@Override
	protected User rowMapping(ResultSet rs) throws SQLException {
		User user = new User();
		user.setIdUser(rs.getInt("id_user"));
		user.setNmUser(rs.getString("nm_user"));
		user.setPassword(rs.getString("password"));
		return user;
	}

	@Override
	protected String[] getColumnsList() {
		return new String[]{
				 "id_user"
				,"nm_user"
				,"password"
		};
	}

	@Override
	protected String[] getPrimaryKey() {
		return new String[]{
				"id_user"
		};
	}

}

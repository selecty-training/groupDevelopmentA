package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BaseEntity;

public abstract class BaseDao<T extends BaseEntity> {
	protected Connection con;
	protected PreparedStatement stmt;

	protected BaseDao(Connection con) {
		this.con = con;
	}

	//全件検索（使用するか未定）
	//@return 検索結果List
	public List<T> findAll() throws SQLException {
		List<T> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM " + this.getTableName());
		
		this.stmt = this.con.prepareStatement(sql.toString());
		
		ResultSet rs = this.stmt.executeQuery();

		while (rs.next()) {
			list.add(this.rowMapping(rs));
		}

		this.closeStatement();	
		return list;
	}
	
	//主キーを用いて検索
	//@return 検索結果DTO
	public T findByPramaryKey(Object...pkValue) throws SQLException {
		T entity = null;
		StringBuilder sql = new StringBuilder();
		String[] pkList = this.getPrimaryKey();

		// エラーチェック
		if (pkList.length == 0) {
			throw new SQLException("主キーが設定されていません");
		}
		if (pkList.length != pkValue.length) {
			throw new SQLException("主キーに設定されているカラムと条件に指定する値の数が一致しません");
		}
		
		// SQLを生成
		sql.append(" SELECT * FROM " + this.getTableName());
		sql.append(" WHERE ");
		sql.append(" 'X' = 'X' ");	// 汎用的な条件設定のため指定
		for (String column : pkList) {
			sql.append(" AND " + column + " = ?");
		}
		
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(pkValue);

		ResultSet rs = stmt.executeQuery();
		
		// 主キー検索のため、0件、または1件と想定
				if (rs.next()) {
					entity = rowMapping(rs);
				}
		
		this.closeStatement();
		return entity;
		
	}
	
	//全項目登録
	//
	public int insert(List<Object> insertValue) throws SQLException {
		int count = -1;
		StringBuilder sql = new StringBuilder();
		String[] columnsList = this.getColumnsList();

		// エラーチェック
		if (columnsList.length != insertValue.size()) {
			throw new SQLException("登録する値とカラムの値が一致していません");
		}

		// SQLを生成
		sql.append(" INSERT INTO " + this.getTableName());
		sql.append(" VALUES (");
		for (int i = 0; i < columnsList.length; i++) {
			sql.append("?, ");
		}
		sql.delete(sql.length() - 2, sql.length()); // 末尾のカンマを除去する
		sql.append(")");

		// Statementの生成および条件の設定
		this.stmt = con.prepareStatement(sql.toString());
		setParameter(insertValue.toArray());

		// 登録の実行
		count = this.stmt.executeUpdate();

		this.closeStatement();
		return count;
	}
	
	
	//主キーを用いて削除
	public int deleteByPrimaryKey(Object... pkValue) throws SQLException {
		int count = -1;
		StringBuilder sql = new StringBuilder();
		String[] pkList = this.getPrimaryKey();

		// エラーチェック
		if (pkList.length == 0) {
			throw new SQLException("主キーが設定されていません");
		}
		if (pkList.length != pkValue.length) {
			throw new SQLException("主キーに設定されているカラムと条件に指定する値の数が一致しません");
		}

		// SQLを生成
		sql.append(" DELETE FROM " + this.getTableName());
		sql.append(" WHERE");
		sql.append(" 'X' = 'X'");	// 汎用的な条件設定のため指定
		for (String column : pkList) {
			sql.append(" AND " + column + " = ?");
		}

		// Statementの生成および条件の設定
		this.stmt = con.prepareStatement(sql.toString());
		setParameter(pkValue);

		// 登録の実行
		count = this.stmt.executeUpdate();

		this.closeStatement();
		return count;
	}
	
	
	 //主キーを用いて更新
	public int updateByPrimaryKey(List<Object> updateValue, Object... pkValue) throws SQLException {
		int count = -1;
		StringBuilder sql = new StringBuilder();
		String[] columnsList = this.getColumnsList();
		String[] pkList = this.getPrimaryKey();

		// エラーチェック
		if (pkList.length == 0) {
			throw new SQLException("主キーが設定されていません");
		}
		if (pkList.length != pkValue.length) {
			throw new SQLException("主キーに設定されているカラムと条件に指定する値の数が一致しません");
		}
		if (columnsList.length != updateValue.size()) {
			throw new SQLException("カラムの数と引数に指定された更新値の数が一致しません");
		}

		// SQLを生成
		sql.append(" UPDATE " + this.getTableName());
		sql.append(" SET ");
		for (String column : columnsList) {
			sql.append(column + " = ?, ");
		}
		sql.delete(sql.length() - 2, sql.length()); // 末尾のカンマを除去する
		sql.append(" WHERE");
		sql.append(" 'X' = 'X'");	// 汎用的な条件設定のため指定
		for (String column : pkList) {
			sql.append(" AND " + column + " = ?");
		}

		// 更新値と主キー値をひとまとめにする
		Object[] paramList = new Object[updateValue.size() + pkValue.length];
		int index = 0;
		for (int i = 0; i < updateValue.size(); i++, index++) {
			paramList[index] = updateValue.get(i);
		}
		for (int i = 0; i < pkValue.length; i++, index++) {
			paramList[index] = pkValue[i];
		}

		// Statementの生成および条件の設定
		this.stmt = con.prepareStatement(sql.toString());
		setParameter(paramList);

		// 登録の実行
		count = this.stmt.executeUpdate();

		this.closeStatement();
		return count;
	}
	
	
	//値の設定　入力値がint,varcharであるか確認
	//Utilメソッド
	protected void setParameter(Object... paramValue) throws SQLException {
		for (int i = 0; i < paramValue.length; i++) {
			
			if (paramValue[i] instanceof String) {
				this.stmt.setString(i + 1, (String) paramValue[i]);
			} else if (paramValue[i] instanceof Integer) {
				this.stmt.setInt(i + 1, (Integer) paramValue[i]);
			} else {
				throw new SQLException("登録できない値が含まれています");
			}
		}
	}
	
	/**
	 * Statementを閉じる
	 */
	protected void closeStatement() {
		try {
			if (this.stmt != null) {
				this.stmt.close();
			}
		} catch (SQLException e) {
			/*
			 * Statementが閉じれない場合は
			 * 何かしらの理由でStatmentが空いていない可能性がある
			 * それならば特に問題はないので何もしない
			 */
		}
		stmt = null;
	}
	
	//テーブル名取得　抽象メソッド
	protected abstract String getTableName();
	
	//取得したデータをArrayList<BaseEntity>に格納　抽象メソッド
	protected abstract T rowMapping(ResultSet rs) throws SQLException;
	
	//カラム名一覧を取得　抽象メソッド
	protected abstract String[] getColumnsList();
	
	//主キーを取得　抽象メソッド
	protected abstract String[] getPrimaryKey();
}

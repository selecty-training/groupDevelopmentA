package Service;

import java.sql.Connection;

import util.DBUtil;

public class BaseService {
	protected Connection con;
	protected BaseService(boolean autoCommitFlg) throws Exception {
		
		try {
			this.con = DBUtil.getConnection(autoCommitFlg);
		} catch(Exception e) {
			throw new Exception("データベースに接続できません");
		}
	}
}

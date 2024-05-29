package Service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import dao.UserDao;
import util.DBUtil;


@WebServlet("/Search")
public class Search extends BaseService {
	public Search() throws Exception {
		super(true);
	}
	private static final long serialVersionUID = 1L;
       
	protected Connection con;
	public Map<String, Object> doLogin(String userNm, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
	
		UserDao dao = new UserDao(this.con);
		try {
			loginData.put("account", dao.selectLoginInfo(userNm, pass));
		} finally {
			DBUtil.closeConnection(this.con);
		}
		return loginData;
	}
}

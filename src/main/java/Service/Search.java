package Service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected Connection con;
	public Map<String, Object> doLogin(String userNm, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
	
//		EmployeeDao dao = new EmployeeDao(this.con);
//		try {
//			loginData.put("account", dao.selectLoginInfo(userNm, pass));
//		} finally {
//			DbUtil.closeConnection(this.con);
//		}
		return loginData;
	}
}

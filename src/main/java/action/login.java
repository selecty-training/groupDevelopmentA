package action;

import java.util.Map;

import javax.servlet.annotation.WebServlet;

import Service.Search;

@WebServlet("/login")
public class login extends BaseServlet {
	protected String doAction() throws Exception {
		
		String[] param = super.getInputParameter("userNm", "pass");

		Search service = new Search();
		Map<String, Object> loginData = service.doLogin(param[0], param[1]);

		if (loginData == null || loginData.get("account") == null) {
			throw new Exception("名前かパスワードが違うよ");
		}

		super.session.setAttribute("LOGIN", loginData.get("userNm"));
		return "menu";
	}

	@Override
	protected String getPageName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
    
	
}

package action;

import javax.servlet.annotation.WebServlet;

import entity.User;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/signup")
public class Signup extends BaseServlet {
	@Override
	protected String getPageName() {
		return "signup";
	}
	
	protected String doAction()throws Exception {
		
		String[] pageParam = super.getInputParameter(
				 "userNm"		// 0
				,"pass"			// 1
				,"passConfirm"	// 2
		);

		if (!pageParam[1].equals(pageParam[2])) {
			throw new Exception("さっきとパスワードが違うよ");
		}
		
		User user = new User();
		user.setNmUser(pageParam[0]);
		user.setPassword(pageParam[1]);
		return "insertMenu";
	}

}

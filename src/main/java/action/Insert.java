package action;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends BaseServlet {
	protected String doAction()throws Exception {

		String[] pageParam = super.getInputParameter(
				 "userNm"		// 0
				,"pass"			// 1
				,"passConfirm"	// 2
		);

		if (!pageParam[1].equals(pageParam[2])) {
			throw new Exception("パスワードが違う");
		}

		return "menu";
	}
}

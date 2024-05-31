package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public abstract class BaseServlet extends HttpServlet {       
   protected HttpServletRequest request;
   protected HttpServletResponse response;
   protected HttpSession session;
   protected String message;
   
   protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html; charset=UTF-8");
		arg1.setCharacterEncoding("UTF-8");

		this.request = arg0;
		this.response = arg1;
		this.session = arg0.getSession();
		this.message = null;
		String nextPage = this.getPageName();
		try {
			// ログインチェック
			if (!"login".equals(this.getPageName()) && !"signup".equals(this.getPageName())) {
				if (session != null) {
					User user = (User) session.getAttribute("LOGIN");
					if (
							(user == null || "".equals(user.getNmUser()))
							
						){
						nextPage = "login";
						throw new Exception("セッションバイバ～～イ");
					}
				}
			}

			// 画面ごとの処理
			nextPage = this.doAction();
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}

		arg0.setAttribute("errMsg", this.message);
		arg0.getRequestDispatcher(nextPage + ".jsp").forward(arg0, arg1);
	}

   protected String[] getInputParameter(String... names) {
		String[] values = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			values[i] = this.request.getParameter(names[i]);
			this.request.setAttribute(names[i],values[i]);
		}
		return values;
	}
   
   //抽象メソッド
   protected abstract String getPageName();

   protected abstract String doAction() throws Exception;
}

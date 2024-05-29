package action;

import javax.servlet.annotation.WebServlet;

import Service.Update;

/**
 * Servlet implementation class Delete
 */
@WebServlet(name="/Delete", urlPatterns={"/delete"})
public class Delete extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getPageName() {
		return "deleteConfirm";
	}

	@Override
	protected String doAction() throws Exception {
		
		String[] pageParam = super.getInputParameter(
				 "id_user"		// 0
		);
		
		Update service = new Update();
		service.deleteUser(Integer.parseInt(pageParam[0]));
		
		return "deleteResult";
	}

}

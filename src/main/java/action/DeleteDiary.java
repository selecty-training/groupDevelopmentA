package action;

import javax.servlet.annotation.WebServlet;

import Service.Update;

/**
 * Servlet implementation class DeleteDiary
 */
@WebServlet(name="/DeleteDiary")
public class DeleteDiary extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected String getPageName() {
		return "DeleteDiary";
	}

	@Override
	protected String doAction() throws Exception {
		
		String[] pageParam = super.getInputParameter(
				 "id_diary"		// 0
		);

		Update service = new Update();
		service.deleteDiary(Integer.parseInt(pageParam[0]));
		
		return "deleteResultDiary";
	}

}

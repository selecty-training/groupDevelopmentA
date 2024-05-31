package action;

import javax.servlet.annotation.WebServlet;

import Service.Update;
import Service.Update.UPDATE_MODE;
import entity.Diary;
import entity.User;

/**
 * Servlet implementation class InsertDiary
 */
@WebServlet("/insertDiary")
public class InsertDiary extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getPageName() {
		return "index";
	}

	@Override
	protected String doAction() throws Exception {
		
		String[] pageParam = super.getInputParameter(
				"title"		 	//0
				,"text"			//1
		);
		User user = (User) session.getAttribute("LOGIN");
		Diary diary = new Diary();
		diary.setTitle(pageParam[0]);
		diary.setText(pageParam[1]);
		diary.setIdUser(user.getIdUser());
		
		Update service = new Update();
		service.registDiary(diary, UPDATE_MODE.INSERT);
		
		return "menu";
	}

}

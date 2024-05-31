package action;

import javax.servlet.annotation.WebServlet;

import Service.Update;
import Service.Update.UPDATE_MODE;
import entity.Diary;

/**
 * Servlet implementation class InsertDiary
 */
@WebServlet("/insertDiary")
public class InsertDiary extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getPageName() {
		return "insertDiary";
	}

	@Override
	protected String doAction() throws Exception {
		
		String[] pageParam = super.getInputParameter(
				"title"		 	//0
				,"text"			//1
		);
		
		Diary diary = new Diary();
		diary.setTitle(pageParam[0]);
		diary.setText(pageParam[1]);
		
		Update service = new Update();
		service.registDiary(diary, UPDATE_MODE.INSERT);
		
		return "menu";
	}

}

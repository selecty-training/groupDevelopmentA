package action;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import Service.Search;
import entity.Diary;
import entity.User;

/**
 * Servlet implementation class CheckAction
 */
@WebServlet("/CheckAction")
public class CheckAction extends BaseServlet {
	
	@Override
	protected String getPageName() {
		return "menu";
	}

	@Override
	protected String doAction() throws Exception {
		
		User user = (User) session.getAttribute("LOGIN");
		Search search = new Search();
		List<Diary> diaryList = search.searchDiaryByPkey(user.getIdUser());
		request.setAttribute("diaryList", diaryList);
			
		return "myData";
			
	}

}

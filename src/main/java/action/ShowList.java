package action;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import Service.Search;
import entity.Diary;
import entity.User;


@WebServlet("/showlist")
public class ShowList extends BaseServlet {

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
		System.out.println(user.getIdUser());
		System.out.println(diaryList.get(0).getTitle());
		
		return "myData";
	}

}

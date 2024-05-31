package action;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import Service.Search;
import Service.Update;
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
		String[] param = super.getInputParameter("diaryId", "action");
		if(param[1].equals("delete")) {
			Update service = new Update();
			service.deleteDiary(Integer.parseInt(param[0]));
					
		}
		
		User user = (User) session.getAttribute("LOGIN");
		Search search = new Search();
		List<Diary> diaryList = search.searchDiaryByPkey(user.getIdUser());
		request.setAttribute("diaryList", diaryList);
		System.out.println(user.getIdUser());
		System.out.println(diaryList.get(0).getTitle());
		
		return "myData";
	}

}

package Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import dao.DiaryDao;
import dao.UserDao;
import entity.Diary;
import entity.User;
import util.DBUtil;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends BaseService {
       
   public Update() throws Exception {
        super(false);
   }
   
   public enum UPDATE_MODE {
		 INSERT
		,UPDATE
	}
   
   //日記の登録更新
   public void registDiary(Diary diary, UPDATE_MODE mode) throws Exception {
		DiaryDao dao = new DiaryDao(this.con);
		
		try {
			if(mode == UPDATE_MODE.INSERT) {
				dao.insertDiary(diary);
			}else if (mode == UPDATE_MODE.UPDATE){
				// DAO -> List<Object>（DAO#updateを呼び出すため）
				List<Object> paramList = new ArrayList<>();
				paramList.add(diary.getIdDiary());
				paramList.add(diary.getTitle());
				paramList.add(diary.getText());
				paramList.add(diary.getDate());
				dao.updateByPrimaryKey(paramList, diary.getIdDiary());
			}
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("登録できませんでした:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(this.con);
		}
   }
   
   //日記の削除
   public void deleteDiary(Integer diaryId) throws Exception {
		DiaryDao dao = new DiaryDao(this.con);

		try {
			dao.deleteByDiaryId(diaryId);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(this.con);
		}
	}
   
   
   public void registUser(User user, UPDATE_MODE mode) throws Exception {
 		UserDao dao = new UserDao(this.con);
 		
 		try {
 			if(mode == UPDATE_MODE.INSERT) {
 				dao.insertUser(user);
 			}else if (mode == UPDATE_MODE.UPDATE){
 				// DAO -> List<Object>（DAO#updateを呼び出すため）
 				List<Object> paramList = new ArrayList<>();
 				paramList.add(user.getIdUser());
 				paramList.add(user.getNmUser());
 				paramList.add(user.getPassword());
 				dao.updateByPrimaryKey(paramList, user.getIdUser());
 			}
 			this.con.commit();
 		} catch (Exception e) {
 			e.printStackTrace();
 			this.con.rollback();
 			throw new Exception("登録できませんでした:" + e.getMessage());
 		} finally {
 			DBUtil.closeConnection(this.con);
 		}
    }
 //ユーザー情報の削除
   public void deleteUser(Integer userId) throws Exception {
		UserDao dao = new UserDao(this.con);

		try {
			dao.deleteByPrimaryKey(userId);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(this.con);
		}
	}

}

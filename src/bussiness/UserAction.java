package bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.CommanCURDDao;
import dao.impl.CommenCURDDaoImpl;
import entity.User;

/**
 * 用户注册、登陆、修改密码的业务类
 * @author Doctor邓
 *
 */
public class UserAction {
	private CommanCURDDao commanDao;
	
	public UserAction() {
		commanDao = new CommenCURDDaoImpl();
	}
	
	public boolean verifyUser(String user_account, String user_pwd) {
		String selectUser ="SELECT id FROM users WHERE user_account = ? AND user_password = ?";
		List<String> userInfor = new ArrayList<>();
		
		userInfor.add(user_account);
		userInfor.add(user_pwd);
				
		Vector<String[]> vector = commanDao.select(selectUser, userInfor);
		if (vector.size() != 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isUser(String user_account) {
		String selectUser = "SELECT id FROM users WHERE user_account = ? ";
		List<String> account = new ArrayList<>();
		
		account.add(user_account);
		
		Vector<String[]> vector = commanDao.select(selectUser, account);
		if (vector.size() != 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean addScore(User user) {
		/**
		 * 当用户第一次上传分数时,执行插入分数操作
		 */
		if(!isScore(user.getUser_account())) {
			String addScore = "INSERT INTO score (user_account, user_score) VALUES (?,?)";
			List<String> infor = new ArrayList<>();
			
			infor.add(user.getUser_account());
			infor.add(String.valueOf(user.getUser_score()));
			
			return commanDao.insert(addScore, infor);
		} 
		/**
		 * 当用户第二次或n次上传分数时,执行更新分数的操作
		 */
		else {
			/**
			 * 当用户的分数比以前的分数高时才更新分数
			 */
			if(user.getUser_score() > getUserScore(user.getUser_account())) {
				String updateScore ="UPDATE score SET user_score = ? WHERE user_account = ?";
				List<String> infor = new ArrayList<>();
				
				infor.add(String.valueOf(user.getUser_score()));
				infor.add(user.getUser_account());
				
				return commanDao.update(updateScore, infor);
			} else {
				return true;
			}
		}
	}
	
	/**
	 * 判断用户是否曾经上传过分数
	 * @param user_account      指定的用户账户
	 * @return            false 为没有上传过分数<p>
	 *                    true  为上传过分数
	 */
	public boolean isScore(String user_account) {
		
		String isScore = "SELECT user_score FROM score WHERE user_account = ?";
		List<String> account = new ArrayList<>();
		
		account.add(user_account);
		
		Vector<String[]> vector = commanDao.select(isScore, account);
		if (vector.size() != 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public int getUserScore(String user_account) {
		String getScore = "SELECT user_score FROM score WHERE user_account = ?";
		List<String> account = new ArrayList<>();
		
		account.add(user_account);
		
		Vector<String[]> vector = commanDao.select(getScore, account);
		if (vector.size() != 1) {
			return 0;
		} else {
			return Integer.parseInt(vector.get(0)[0]);
		}
	}
}

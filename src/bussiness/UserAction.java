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
	
	/**
	 * 根据用户名和密码来验证用户的登陆信息是否正确
	 * @param user_account   :指定的用户名
	 * @param user_pwd       :指定用户的密码
	 * @return               <p>true: 登陆信息正确<p>
	 *                       <p>false: 登陆信息不正确（用户名或密码错误）<p>
	 */
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
	
	/**
	 * 通过用户名确认是否存在此用户
	 * @param user_account
	 * @return
	 */
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
	
	/**
	 * 根据指定User对象,为其添加或更新分数
	 * @param user     ：指定的用户对象
	 * @return         <p>true分数添加或更新成功
	 *                 <p>false分数添加或更新失败
	 */                            
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
	
	/**
	 * 获得指定用户名的历史最高分
	 * @param user_account     ：指定的用户名
	 * @return                 <p>返回指定用户名的分数
	 *                         <p>如果用户名不能存在或没有上传过分数,则返回： 0
	 */
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

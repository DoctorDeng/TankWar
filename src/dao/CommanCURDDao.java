package dao;

import java.util.List;
import java.util.Vector;

/**
 * 通用的想对数据库进行CURD操作的接口
 * @author Doctor邓
 *
 */
public interface CommanCURDDao {
	/**
	 * 向数据库添加信息
	 * @param sql   自定义的添加SQL语句
	 * @param str   自定义的添加的字段信息的列表
	 * @return		添加成功返回true，失败返回false
	 */
	public boolean insert(String sql, List<String> str);
	/**
	 * 向数据库删除信息
	 * @param sql   自定义的删除SQL语句
	 * @param str   自定义的删除的字段信息的列表
	 * @return		删除成功返回true，失败返回false
	 */
	public boolean delete(String sql, List<String> str);
	/**
	 * 向数据库更新信息
	 * @param sql   自定义的更新SQL语句
	 * @param str   自定义的更新的字段信息的列表
	 * @return		更新成功返回true，失败返回false
	 */
	public boolean update(String sql, List<String> str);
	/**
	 * 向数据库查询信息
	 * @param sql   自定义的添查询SQL语句
	 * @param str   自定义的查询的字段信息的列表
	 * @return		返回一个对象数组
	 */
	public Vector select(String sql, List<String> str);
}

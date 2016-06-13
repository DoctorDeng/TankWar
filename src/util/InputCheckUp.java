package util;
/**
 * 用于检查各种用户输入的统一的接口
 * @author Doctor邓
 *
 */
public interface InputCheckUp {
	/**
	 * 
	 * @param input    用户的输入信息
	 * @param symbol   对用户输入信息进行相关操作的标识
	 * @return         用户输入合法，返回true。不合法返回 false.
	 */
	public boolean checkInput(String input, String symbol);
}

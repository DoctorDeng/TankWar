package view.viewUtil;

import java.awt.Image;

/**
 * 使指定图片和指定主键大小自适应的类
 * @author Doctor邓
 *
 */
public class ImageAdapt {

	/**
	 * 将指定图片缩放为指定长度和宽度
	 * @param image     要缩放的图片
	 * @param width     要缩放的宽度
	 * @param height    要缩放的高度
	 * @return          已缩放为指定长度和宽度的图片
	 */
	public static Image imageAdapt(Image image,int width, int height) {
		Image image1 = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return image1;
	}
}

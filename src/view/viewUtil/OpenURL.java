package view.viewUtil;

import java.io.IOException;
import java.net.URI;

/**
 * 实现使用系统默认的浏览器打开指定网址（URL）
 * @author Doctor邓
 *
 */
public class OpenURL {
	
	/**
	 * windows系统下通过默认浏览器打开指定URL，默认可以忽略URL的"http://"
	 * @param url   需要打开网址的URL
	 */
	private void gotoUrlWindows(String url){
		String cmd = "rundll32 url.dll,FileProtocolHandler " + url;
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Linux系统下通过默认浏览器打开指定URL，默认不可以忽略URL的"http://"
	 * @param url   需要打开网址的URL
	 */
	private void gotoUrlLinux(String url){		
		try {
			URI uri = new URI(url);
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过默认浏览器打开指定URL
	 * @param url
	 */
	public void gotoUrl(String url){
		if((System.getProperty("os.name").toUpperCase()).indexOf("WINDOWS")!=-1){	
			this.gotoUrlWindows(url);
		}
		else if((System.getProperty("os.name").toUpperCase()).indexOf("LINUX")!=-1){	 
			this.gotoUrlLinux(url);
		}
	}
	
	
}

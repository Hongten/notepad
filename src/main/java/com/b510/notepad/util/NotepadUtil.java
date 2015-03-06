/**
 * 
 */
package com.b510.notepad.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.b510.notepad.common.Common;

/**
 * @author Hongten
 * @created Nov 19, 2014
 */
public class NotepadUtil {

	static Logger log = Logger.getLogger(NotepadUtil.class);

	public static void exit() {
		log.debug(Common.SYSTEM_EXIT);
		System.exit(0);
	}
	
	public static void accessURL(String url) {
		if (null == url || Common.EMPTY.equals(url)) {
			return;
		}
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * @return i.e. 3:49 PM 11/20/2014
	 */
	public static String getTimeDate(){
		SimpleDateFormat sdf = new SimpleDateFormat(Common.DATE_FORMAT);
		Date date = new Date();
		String timeDate = sdf.format(date);
		return timeDate;
	}
	
	/**
	 * @param path i.e. com/b510/resources/images/hongten.png
	 * @return i.e. png
	 */
	public static String getPostfix(String path) {
		if (path == null || Common.EMPTY.equals(path.trim())) {
			return Common.EMPTY;
		}
		if (path.contains(Common.POINT)) {
			return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
		}
		return Common.EMPTY;
	}
	
	public static String fileProperties(File file) {
		return "<html>"
				+ "File Name   : " + file.getName() + "<br/>"
				+ "File Type   : "+ getPostfix(file.getAbsolutePath()) +" file<br/>"
				+ "File Size   : " + file.length()/1024 +" KB<br/>"
				+ "Modify Date : " + new SimpleDateFormat().format(file.lastModified()) + "<br/>"
				+ "Location    : " + file.getParent() + "<br/>"
				+ "CanRead     : " + file.canRead() + "<br/>"
				+ "CanWrite    : " + file.canWrite() + "<html>";
	}
}

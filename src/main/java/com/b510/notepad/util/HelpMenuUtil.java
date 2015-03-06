/**
 * 
 */
package com.b510.notepad.util;

import org.apache.log4j.Logger;

import com.b510.notepad.common.Common;
import com.b510.notepad.ui.AboutUI;
import com.b510.notepad.ui.MainUI;

/**
 * @author Hongten
 * @created Nov 19, 2014
 */
public class HelpMenuUtil extends MainUI {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(HelpMenuUtil.class);

	private static AboutUI aboutUI;

	public HelpMenuUtil(String title) {
		super(title);
	}

	public void about(MainUI mainUI) {
		log.debug(Common.ABOUT_NOTEPAD);
		if (null == aboutUI) {
			aboutUI = new AboutUI(Common.ABOUT_NOTEPAD);
			aboutUI.setHelpMenuUtil(HelpMenuUtil.this);
		} else {
			aboutUI.setVisible(true);
			aboutUI.setFocusable(true);
		}
	}

	public void distoryAboutUI() {
		if (null != aboutUI) {
			aboutUI = null;
		}
	}
}

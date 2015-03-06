/**
 * 
 */
package com.b510.notepad.util;

import java.awt.Font;

import org.apache.log4j.Logger;

import com.b510.notepad.common.Common;
import com.b510.notepad.ui.FontManagerUI;
import com.b510.notepad.ui.FontSizeManagerUI;
import com.b510.notepad.ui.FontStyleManagerUI;
import com.b510.notepad.ui.MainUI;

/**
 * @author Hongten
 * @created Nov 19, 2014
 */
public class FormatMenuUtil extends MainUI {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(FormatMenuUtil.class);
	
	private static FontManagerUI fontManagerUI;
	private static FontSizeManagerUI fontSizeManagerUI;
	private static FontStyleManagerUI fontStyleManagerUI;

	public FormatMenuUtil(String title) {
		super(title);
	}

	public static void wordWrap() {
		log.debug(Common.WORD_WRAP);
		if (lineWrap) {
			textArea.setLineWrap(false);
			lineWrap = false;
		} else {
			textArea.setLineWrap(true);
			lineWrap = true;
		}
	}
	
	public void resetFont(MainUI mainUI) {
		log.debug(Common.RESET_FONT);
		fontNum = Common.FONT_NUM;
		FontManagerUI.FONT_TYPE = Common.FONT_LUCIDA_CONSOLE;
		fontSizeNum = Common.FONT_SIZE_NUM;
		FontManagerUI.FONT_SIZE = Common.FONT_SIZE;
		FontManagerUI.FONT_STYPLE = Common.FONT_STYLE_DEFAULT;
		fontStyleNum = Common.FONT_STYLE_NUM;
		textArea.setFont(new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE));
		setJUI();
	}

	public void font(MainUI mainUI) {
		log.debug(Common.FONT);
		if (null == fontManagerUI) {
			fontManagerUI = new FontManagerUI(Common.FONT);
			fontManagerUI.setFormatMenuUtil(FormatMenuUtil.this);
		} else {
			fontManagerUI.setVisible(true);
			fontManagerUI.setFocusable(true);
		}
	}

	public void fontSize(MainUI mainUI) {
		log.debug(Common.FONT_SIZE_TITLE);
		if (null == fontSizeManagerUI) {
			fontSizeManagerUI = new FontSizeManagerUI(Common.FONT);
			fontSizeManagerUI.setFormatMenuUtil(FormatMenuUtil.this);
		} else {
			fontSizeManagerUI.setVisible(true);
			fontSizeManagerUI.setFocusable(true);
		}
	}
	
	public void fontStyle(MainUI mainUI) {
		log.debug(Common.FONT_SIZE_TITLE);
		if (null == fontStyleManagerUI) {
			fontStyleManagerUI = new FontStyleManagerUI(Common.FONT_STYLE);
			fontStyleManagerUI.setFormatMenuUtil(FormatMenuUtil.this);
		} else {
			fontStyleManagerUI.setVisible(true);
			fontStyleManagerUI.setFocusable(true);
		}
	}
	
	public void distoryFontManagerUI() {
		if (null != fontManagerUI) {
			fontManagerUI = null;
		}
	}
	
	public void distoryFontSizeManagerUI() {
		if (null != fontSizeManagerUI) {
			fontSizeManagerUI = null;
		}
	}
	
	public void distoryFontStyleManagerUI() {
		if (null != fontSizeManagerUI) {
			fontSizeManagerUI = null;
		}
	}
}

/**
 * 
 */
package com.b510.notepad.client;

import com.b510.notepad.common.Common;
import com.b510.notepad.ui.MainUI;

/**
 * @author Hongten
 * @created Nov 19, 2014
 */
public class Client {

	public static void main(String[] args) {
		start();
	}

	public static MainUI start() {
		MainUI ui = new MainUI(Common.TITLE);
		ui.init();
		return ui;
	}
}

/**
 * 
 */
package com.b510.notepad.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The <code>NotepadUI</code> class extends <code>JUI</code> and implements
 * <code>ActionListener</code>.
 * 
 * @author Hongten
 * @created Nov 19, 2014
 */
public class NotepadUI extends JUI implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private MainUI mainUI;

	public NotepadUI(String title) {
		super(title);
	}

	public void init() {
		if (null == mainUI) {
			mainUI = new MainUI(title);
		}
		mainUI.init();
	}

	public void actionPerformed(ActionEvent e) {
	}
}
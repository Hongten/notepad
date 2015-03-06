package com.b510.notepad.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;

import com.b510.notepad.common.Common;
import com.b510.notepad.util.FormatMenuUtil;

/**
 * @author Hongten
 * @created Nov 20, 2014
 */
public class FontStyleManagerUI extends MainUI {
	private static final long serialVersionUID = -37011351219515242L;

	private JLabel currentFontStyleDescJLabel;
	private JLabel currentFontStyleJLabel;
	private JLabel descJlabel;
	private JSeparator line;
	private JComboBox<String> fontStyleJComboBox;
	
	private FormatMenuUtil format;
	
	String fontStyles[] = {"Regular", "Italic", "Bold", "Bold Italic"};
	
	public FontStyleManagerUI(String title) {
		super(title);
		initComponents();

		initSelf();
		setAlwaysOnTop(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FontStyleManagerUI.this.setVisible(false);
				format.distoryFontSizeManagerUI();
			}
		});
	}

	public void initSelf() {
		this.setVisible(true);
		setResizable(false);
		this.setLocation(MainUI.pointX + 100, MainUI.pointY + 150);
	}

	private void initComponents() {
		initElement();
		currentFontStyleJLabel.setText(Common.CURRENT_FONT_STYLE);

		fontStyleJComboBox.setModel(new DefaultComboBoxModel<String>(fontStyles));
		int i = 0;
		for(String 	style : fontStyles){
			if(style.equals(FontManagerUI.FONT_STYPLE)){
				fontStyleNum = i;
			}
			i++;
		}
		fontStyleJComboBox.setSelectedIndex(fontStyleNum);
		fontStyleJComboBox.addActionListener(this);

		descJlabel.setText(Common.DESCRIPTION_WITH_COLOR);
		// do here...
		currentFontStyleDescJLabel.setFont(new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE));
		currentFontStyleDescJLabel.setText(Common.SIMPLE);
		pageGourpLayout();
	}

	private void initElement() {
		currentFontStyleJLabel = new JLabel();
		fontStyleJComboBox = new JComboBox<String>();
		descJlabel = new JLabel();
		currentFontStyleDescJLabel = new JLabel();
		line = new JSeparator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fontStyleJComboBox) {
			updateSkin();
		}
	}

	public synchronized void updateSkin() {
		fontStyleNum = fontStyleJComboBox.getSelectedIndex();
		FontManagerUI.FONT_STYPLE = (String) fontStyleJComboBox.getSelectedItem();
		currentFontStyleDescJLabel.setFont(new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE));
		currentFontStyleDescJLabel.setText(Common.SIMPLE);
		textArea.setFont(new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE));
		setJUI();
	}

	public void setFormatMenuUtil(FormatMenuUtil formatMenuUtil){
		this.format = formatMenuUtil;
	}
	
	/**
	 * If not necessary, please do not change
	 */
	private void pageGourpLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		horizontalGroupLayout(layout);
		verticalGroupLayout(layout);
		pack();
	}

	private void verticalGroupLayout(GroupLayout layout) {
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(40, 40, 40)
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(currentFontStyleJLabel)
										.addComponent(fontStyleJComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(26, 26, 26)
						.addComponent(line, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(descJlabel).addGap(18, 18, 18).addComponent(currentFontStyleDescJLabel).addContainerGap(47, Short.MAX_VALUE)));
	}

	private void horizontalGroupLayout(GroupLayout layout) {
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(21, 21, 21)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(currentFontStyleDescJLabel)
												.addComponent(descJlabel)
												.addGroup(
														layout.createSequentialGroup().addComponent(currentFontStyleJLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(fontStyleJComboBox, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addComponent(line, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
	}
}

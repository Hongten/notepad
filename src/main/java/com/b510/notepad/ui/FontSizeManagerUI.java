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
public class FontSizeManagerUI extends MainUI {
	private static final long serialVersionUID = -37011351219515242L;

	private JLabel currentFontSizeDescJLabel;
	private JLabel currentFontSizeJLabel;
	private JLabel descJlabel;
	private JSeparator line;
	private JComboBox<String> fontSizeJComboBox;
	
	private FormatMenuUtil format;
	
	String fontSizes[] = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
	
	public FontSizeManagerUI(String title) {
		super(title);
		initComponents();

		initSelf();
		setAlwaysOnTop(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FontSizeManagerUI.this.setVisible(false);
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
		currentFontSizeJLabel.setText(Common.CURRENT_FONT_SIZE);

		fontSizeJComboBox.setModel(new DefaultComboBoxModel<String>(fontSizes));
		int i = 0;
		for(String size : fontSizes){
			if(Integer.valueOf(size) == FontManagerUI.FONT_SIZE){
				fontSizeNum = i;
			}
			i++;
		}
		fontSizeJComboBox.setSelectedIndex(fontSizeNum);
		fontSizeJComboBox.addActionListener(this);

		descJlabel.setText(Common.DESCRIPTION_WITH_COLOR);

		currentFontSizeDescJLabel.setFont(new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE));
		currentFontSizeDescJLabel.setText(Common.SIMPLE);
		pageGourpLayout();
	}

	private void initElement() {
		currentFontSizeJLabel = new JLabel();
		fontSizeJComboBox = new JComboBox<String>();
		descJlabel = new JLabel();
		currentFontSizeDescJLabel = new JLabel();
		line = new JSeparator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fontSizeJComboBox) {
			updateSkin();
		}
	}

	public synchronized void updateSkin() {
		fontNum = fontSizeJComboBox.getSelectedIndex();
		log.debug(fontSizeJComboBox.getSelectedItem().toString());
		FontManagerUI.FONT_SIZE = Integer.valueOf((String) fontSizeJComboBox.getSelectedItem());
		currentFontSizeDescJLabel.setFont(new Font(FontManagerUI.FONT_TYPE, Font.PLAIN, FontManagerUI.FONT_SIZE));
		currentFontSizeDescJLabel.setText(Common.SIMPLE);
		textArea.setFont(new Font(FontManagerUI.FONT_TYPE, Font.PLAIN, FontManagerUI.FONT_SIZE));
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
								layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(currentFontSizeJLabel)
										.addComponent(fontSizeJComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(26, 26, 26)
						.addComponent(line, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(descJlabel).addGap(18, 18, 18).addComponent(currentFontSizeDescJLabel).addContainerGap(47, Short.MAX_VALUE)));
	}

	private void horizontalGroupLayout(GroupLayout layout) {
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(21, 21, 21)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(currentFontSizeDescJLabel)
												.addComponent(descJlabel)
												.addGroup(
														layout.createSequentialGroup().addComponent(currentFontSizeJLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(fontSizeJComboBox, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addComponent(line, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
	}
}

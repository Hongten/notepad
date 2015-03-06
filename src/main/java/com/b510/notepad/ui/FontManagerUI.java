package com.b510.notepad.ui;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
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
public class FontManagerUI extends MainUI {
	private static final long serialVersionUID = -37011351219515242L;

	private JLabel currentFontDescJLabel;
	private JLabel currentFontJLabel;
	private JLabel descJlabel;
	private JSeparator line;
	private JComboBox<String> fontJComboBox;
	
	private FormatMenuUtil format;
	
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String fontNames[] = ge.getAvailableFontFamilyNames();
	
	public static String FONT_TYPE = Common.FONT_TYPE;
	public static int FONT_SIZE = Common.FONT_SIZE;
	public static String FONT_STYPLE = Common.FONT_STYLE_DEFAULT;
	
	public FontManagerUI(String title) {
		super(title);
		initComponents();

		initSelf();
		setAlwaysOnTop(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FontManagerUI.this.setVisible(false);
				format.distoryFontManagerUI();
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
		currentFontJLabel.setText(Common.CURRENT_FONT);

		fontJComboBox.setModel(new DefaultComboBoxModel<String>(fontNames));
		int i = 0;
		for(String name : fontNames){
			if(FontManagerUI.FONT_TYPE.equals(name)){
				fontNum = i;
			}
			i++;
		}
		fontJComboBox.setSelectedIndex(fontNum);
		fontJComboBox.addActionListener(this);

		descJlabel.setText(Common.DESCRIPTION_WITH_COLOR);

		currentFontDescJLabel.setFont(new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE));
		currentFontDescJLabel.setText(Common.THIS_IS_A_SIMPLE);
		pageGourpLayout();
	}

	private void initElement() {
		currentFontJLabel = new JLabel();
		fontJComboBox = new JComboBox<String>();
		descJlabel = new JLabel();
		currentFontDescJLabel = new JLabel();
		line = new JSeparator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fontJComboBox) {
			updateSkin();
		}
	}

	public synchronized void updateSkin() {
		fontNum = fontJComboBox.getSelectedIndex();
		log.debug(fontJComboBox.getSelectedItem().toString());
		FontManagerUI.FONT_TYPE = fontJComboBox.getSelectedItem().toString();
		currentFontDescJLabel.setFont(new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE));
		currentFontDescJLabel.setText(Common.THIS_IS_A_SIMPLE);
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
								layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(currentFontJLabel)
										.addComponent(fontJComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(26, 26, 26)
						.addComponent(line, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(descJlabel).addGap(18, 18, 18).addComponent(currentFontDescJLabel).addContainerGap(47, Short.MAX_VALUE)));
	}

	private void horizontalGroupLayout(GroupLayout layout) {
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(21, 21, 21)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(currentFontDescJLabel)
												.addComponent(descJlabel)
												.addGroup(
														layout.createSequentialGroup().addComponent(currentFontJLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(fontJComboBox, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addComponent(line, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
	}
}

package com.b510.notepad.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import org.apache.log4j.Logger;

import com.b510.notepad.common.Common;
import com.b510.notepad.util.EditMenuUtil;

public class ReplaceManagerUI extends MainUI {
	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(ReplaceManagerUI.class);

	private JPanel bGJPanel;
	private JButton cancelJButton;
	private JCheckBox caseSensitiveJCheckBox;
	private JButton findNextJButton;
	private JLabel findWhatJLabel;
	private JTextField findWordJTextField;
	private JButton replaceAllJButton;
	private JLabel replaceToJLabel;
	private JTextField replaceToJTextField;
	private JButton replaceJButton;

	public static boolean isCaseSensitive = false;

	private EditMenuUtil edit;
	public static String replaceWord = Common.EMPTY;
	public static int replaceCount = 0;

	public ReplaceManagerUI(String title) {
		super(title);
		initComponents();

		initSelf();
		setAlwaysOnTop(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				distoryReplaceManagerUI();
			}
		});
	}

	public void initSelf() {
		this.setVisible(true);
		setResizable(false);
		this.setLocation(MainUI.pointX + 100, MainUI.pointY + 150);
	}

	/**
	 * If not necessary, please do not change the order.
	 */
	private void initComponents() {
		initElement();
		initLabel();
		initFindWordTextField();
		initReplaceToTextField();
		initCaseSensitiveCheckBox();
		initFindNextButton();
		initReplaceButton();
		initReplaceAllButton();
		initCancleButton();
		initLayout();
	}

	private void initElement() {
		bGJPanel = new JPanel();
		findWhatJLabel = new JLabel();
		replaceToJLabel = new JLabel();
		findWordJTextField = new JTextField();
		replaceToJTextField = new JTextField();
		caseSensitiveJCheckBox = new JCheckBox();
		findNextJButton = new JButton();
		replaceJButton = new JButton();
		replaceAllJButton = new JButton();
		cancelJButton = new JButton();
	}

	private void initLabel() {
		findWhatJLabel.setText(Common.FIND_WHAT);
		replaceToJLabel.setText(Common.REPLACE_TO);
	}

	private void initFindWordTextField() {
		if (null == textArea.getSelectedText() || Common.EMPTY.equals(textArea.getSelectedText().trim())) {
			findWordJTextField.setText(findWhat);
		} else if(null != textArea.getSelectedText() && !Common.EMPTY.equals(textArea.getSelectedText().trim())){
			findWordJTextField.setText(textArea.getSelectedText());
		}else{
			findWordJTextField.setText(findWhat);
		}
	}

	private void initReplaceToTextField() {
		replaceToJTextField.setText(Common.EMPTY);
	}

	private void initCaseSensitiveCheckBox() {
		caseSensitiveJCheckBox.setText(Common.CASE_SENSITIVE);
		caseSensitiveJCheckBox.addActionListener(this);
	}

	private void initFindNextButton() {
		findNextJButton.setText(Common.FIND_NEXT);
		findNextJButton.setMaximumSize(new Dimension(99, 23));
		findNextJButton.setMinimumSize(new Dimension(99, 23));
		findNextJButton.setPreferredSize(new Dimension(99, 23));
		findNextJButton.addActionListener(this);
	}

	private void initReplaceButton() {
		replaceJButton.setText(Common.REPLACE);
		replaceJButton.setMaximumSize(new Dimension(99, 23));
		replaceJButton.setMinimumSize(new Dimension(99, 23));
		replaceJButton.setPreferredSize(new Dimension(99, 23));
		replaceJButton.addActionListener(this);
	}

	private void initReplaceAllButton() {
		replaceAllJButton.setText(Common.REPLACE_ALL);
		replaceAllJButton.addActionListener(this);
	}

	private void initCancleButton() {
		cancelJButton.setText(Common.CANCEL);
		cancelJButton.setMaximumSize(new Dimension(99, 23));
		cancelJButton.setMinimumSize(new Dimension(99, 23));
		cancelJButton.setPreferredSize(new Dimension(99, 23));
		cancelJButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findNextJButton) {
			if(!isEmptyForFindWordJTextField()){
				edit.findNext();
			}else{
				typingFindWhat();
			}
		} else if (e.getSource() == replaceAllJButton) {
			if(!isEmptyForFindWordJTextField()){
				edit.replaceAllOperation();
			}else{
				typingFindWhat();
			}
		} else if (e.getSource() == replaceJButton) {
			if(!isEmptyForFindWordJTextField()){
				edit.replaceOperation();
			}else{
				typingFindWhat();
			}
		} else if (e.getSource() == cancelJButton) {
			distoryReplaceManagerUI();
		} else if (e.getSource() == caseSensitiveJCheckBox) {
			caseSensitiveSwitch();
		}
	}

	private void typingFindWhat() {
		JOptionPane.showMessageDialog(ReplaceManagerUI.this, Common.WHAT_DO_YOU_WANT_TO_FIND, Common.NOTEPAD, JOptionPane.INFORMATION_MESSAGE);
		findWordJTextField.setFocusable(true);
	}
	
	private boolean isEmptyForFindWordJTextField(){
		findWhat = findWordJTextField.getText();
		replaceWord = replaceToJTextField.getText();
		if(!Common.EMPTY.equals(findWordJTextField.getText())){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * Operation for Cancel button
	 */
	private void distoryReplaceManagerUI() {
		ReplaceManagerUI.this.setVisible(false);
		edit.distoryReplaceeManagerUI();
	}

	/**
	 * Case Sensitive Switch
	 */
	private void caseSensitiveSwitch() {
		if (null == caseSensitiveJCheckBox.getSelectedObjects()) {
			isCaseSensitive = false;
		} else {
			isCaseSensitive = true;
		}
		log.debug(isCaseSensitive);
	}

	public void setEditMenuUtil(EditMenuUtil editMenuUtil) {
		this.edit = editMenuUtil;
	}

	/**
	 * If not necessary, please do not change.
	 */
	private void initLayout() {
		GroupLayout bGJPanelLayout = new GroupLayout(bGJPanel);
		bGJPanel.setLayout(bGJPanelLayout);
		bGJPanelLayout.setHorizontalGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				bGJPanelLayout.createSequentialGroup().addContainerGap().addGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(bGJPanelLayout.createSequentialGroup().addComponent(findWhatJLabel).addGap(18, 18, 18).addComponent(findWordJTextField, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)).addGroup(bGJPanelLayout.createSequentialGroup().addComponent(replaceToJLabel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(replaceToJTextField))).addComponent(caseSensitiveJCheckBox)).addGap(18, 18, 18).addGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(findNextJButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(replaceJButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(replaceAllJButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(cancelJButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));
		bGJPanelLayout.setVerticalGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				bGJPanelLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(bGJPanelLayout.createSequentialGroup().addGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(findWhatJLabel).addComponent(findWordJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(12, 12, 12).addGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(replaceToJLabel).addComponent(replaceToJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(replaceJButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).addComponent(findNextJButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(replaceAllJButton)
						.addGroup(bGJPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(bGJPanelLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(cancelJButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(bGJPanelLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(caseSensitiveJCheckBox))).addContainerGap(8, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(bGJPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(bGJPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

		pack();
	}
}

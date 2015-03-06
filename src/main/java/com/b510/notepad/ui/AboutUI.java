package com.b510.notepad.ui;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.b510.notepad.common.Common;
import com.b510.notepad.util.HelpMenuUtil;
import com.b510.notepad.util.NotepadUtil;

/**
 * Location : MainUI --> Help --> About Notepad<br>
 * <p>
 * The <code>AboutUI</code> display the information about this application.<br>
 * <p>
 * i.e., Author, Application Name, Application description, Version, Blog.etc.<br>
 * <p>
 * If you have a try to double-click the row which name is 'Blog', then the dialog will be displaying in front of this page.<br>
 * The dialog is a access URL request dialog, and you will access the URL(<a href='http://www.cnblogs.com/hongten'>http://www.cnblogs.com/hongten</a>) if you click 'Yes'.<br>
 * <p>
 * If you want to use this class, you should do as below:<br>
 * <p><blockquote><pre>
 *     <code>AboutUI aboutUI = new AboutUI("About Notepad");</code>
 * </pre></blockquote><p>
 * 
 * @author Hongten
 * @created Nov 20, 2014
 */
public class AboutUI extends MainUI {
	
	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(AboutUI.class);

	private JLabel descriptionLabel;
	private JButton hongtenButton;
	private JTable aboutUITable;
	private JPanel mainPanel;
	private JScrollPane rightScrollPane;
	
	private HelpMenuUtil help;

	public AboutUI(String title) {
		super(title);
		initComponents();
		initSelf();
		setAlwaysOnTop(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				AboutUI.this.setVisible(false);
				help.distoryAboutUI();
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
		initHongtenButton();
		initAboutUITable();
		initDescriptionLabel();
		mainPanelLayout();
	}

	private void initHongtenButton() {
		hongtenButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource(Common.HONGTEN_PIC)));
		hongtenButton.setToolTipText(Common.ABOUT_NOTEPAD);
	}

	private void initAboutUITable() {
		Object[][] values = new Object[][] { { Common.AUTHOR, Common.AUTHOR_NAME }, { Common.APPLICATION_NAME, Common.NOTEPAD_APP }, { Common.APPLICATION_DESCRIPTION, Common.APPLICATION_DESCRIPTION_DETAIL }, { Common.VERSION, Common.VERSION_VALUE }, { Common.BLOG, Common.HOME_PAGE } };

		String[] titles = new String[] { Common.ITEM, Common.DESCRIPTION };

		aboutUITable.setModel(new DefaultTableModel(values, titles) {
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		aboutUITable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		aboutUITable.setOpaque(false);
		aboutUITable.setRowHeight(Common.TABLE_ROW_HEIGHT);
		aboutUITable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aboutUITable.setSurrendersFocusOnKeystroke(true);
		aboutUITable.getTableHeader().setReorderingAllowed(false);
		aboutUITable.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					matchUrlOperation();
				}
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {

			}
		});
		rightScrollPane.setViewportView(aboutUITable);
	}

	private void matchUrlOperation() {
		int id = aboutUITable.getSelectedRow();
		String url = (String) aboutUITable.getValueAt(id, 1);
		if (url.equals(Common.HOME_PAGE)) {
			askAccessBlogOperation();
		}
	}

	// Show a dialog to access URL request.
	// You will access the URL if you click 'Yes'.
	protected void askAccessBlogOperation() {
		int option = JOptionPane.showConfirmDialog(AboutUI.this, Common.ACCESS_URL + Common.HOME_PAGE + Common.BLANK + Common.QUESTION_MARK, Common.ACCESS_URL_REQUEST, JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			NotepadUtil.accessURL(Common.HOME_PAGE);
		}
	}

	private void initDescriptionLabel() {
		descriptionLabel.setFont(new java.awt.Font(Common.FONT_LUCIDA_CONSOLE, 1, 18));
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setText(Common.AUTHOR_DESC);
	}

	private void initElement() {
		mainPanel = new JPanel();
		hongtenButton = new JButton();
		rightScrollPane = new JScrollPane();
		aboutUITable = new JTable();
		descriptionLabel = new JLabel();
	}
	
	public void setHelpMenuUtil(HelpMenuUtil helpMenuUtil){
		this.help = helpMenuUtil;
	}

	/**
	 * If not necessary, please do not change
	 */
	private void mainPanelLayout() {
		GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(hongtenButton).addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addComponent(rightScrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(rightScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGroup(mainPanelLayout.createSequentialGroup().addComponent(hongtenButton, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))).addGap(0, 0, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

		pack();
	}
}

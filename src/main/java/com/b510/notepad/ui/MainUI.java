/**
 * 
 */
package com.b510.notepad.ui;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import org.apache.log4j.Logger;

import com.b510.notepad.common.Common;
import com.b510.notepad.util.EditMenuUtil;
import com.b510.notepad.util.FileMenuUtil;
import com.b510.notepad.util.FormatMenuUtil;
import com.b510.notepad.util.HelpMenuUtil;
import com.b510.notepad.util.NotepadUtil;
import com.b510.notepad.util.ViewMenuUtil;

/**
 * @author Hongten
 * @created Nov 19, 2014
 */
public class MainUI extends NotepadUI {

	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(MainUI.class);

	JMenuBar menuBar;
	JSeparator line;
	// Menus
	JMenu file, edit, format, view, help, viewHelp, source;
	// PopupMenu
	JPopupMenu textAreaPopupMenu;
	// File Items
	JMenuItem news, open, save, saveAs, properties, exit;
	// Edit Items
	JMenuItem undo, copy, paste, cut, find, findNext, replace, selectAll, timeDate;
	// PopupMenu
	JMenuItem popUndo, popCopy, popPaste, popCut, popSelectAll, popTimeDate;
	// Format Items
	JMenuItem wordWrap, resetFont, font, fontSize, fontStyle;
	// View Items
	JMenuItem skin;
	// Help Items
	JMenuItem about, homePage, skinPage, sourceCode, sourceCodeDownload, api;
	// textArea
	public static JTextArea textArea;
	// textArea font
	Font textAreaFont;
	// textArea scroll
	JScrollPane textAreaScroll;
	
	public static UndoManager undoManager;
	
	public static String filePath = Common.EMPTY;
	boolean saved = false;
	public static boolean lineWrap = true;
	// Default position is (0, 0)
	public static int pointX = 0;
	public static int pointY = 0;
	public static String savedText = Common.EMPTY;
	public static int fontNum = Common.FONT_NUM;
	public static int fontSizeNum = Common.FONT_SIZE_NUM;
	public static int fontStyleNum = Common.FONT_STYLE_NUM;
	public static String findWhat = Common.EMPTY;	
	
	private void setMainUIXY() {
		pointX = getMainUIX();
		pointY = getMainUIY();
	}
	
	private int getMainUIY() {
		return (int) getLocation().getY();
	}

	private int getMainUIX() {
		return (int) getLocation().getX();
	}

	public MainUI(String title) {
		super(title);
		setTitle(title);
	}

	public void init() {
		initMenu();
		initTextArea();
		this.setResizable(true);
		this.setBounds(new Rectangle(150, 100, 800, 550));
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileMenuUtil file = new FileMenuUtil(Common.EMPTY);
				file.exit(MainUI.this);
			}
		});
		
		setMainUIXY();
	}
	
	private void initMenu() {
		menuBar();
		menuFile();
		menuEdit();
		menuFormat();
		menuView();
		menuHelp();
		setJMenuBar(menuBar);
		initTextAreaPopupMenu();
		setDisabledMenuAtCreating(false);
	}

	private void menuBar() {
		menuBar = new JMenuBar();
	}

	private void menuFile() {
		file = new JMenu(Common.FILE);

		news = new JMenuItem(Common.NEW);
		news.addActionListener(this);
		news.setAccelerator(KeyStroke.getKeyStroke(Common.N, InputEvent.CTRL_MASK));
		file.add(news);

		open = new JMenuItem(Common.OPEN);
		open.addActionListener(this);
		open.setAccelerator(KeyStroke.getKeyStroke(Common.O, InputEvent.CTRL_MASK));
		file.add(open);

		save = new JMenuItem(Common.SAVE);
		save.addActionListener(this);
		save.setAccelerator(KeyStroke.getKeyStroke(Common.S, InputEvent.CTRL_MASK));
		file.add(save);

		saveAs = new JMenuItem(Common.SAVE_AS);
		saveAs.addActionListener(this);
		saveAs.setAccelerator(KeyStroke.getKeyStroke(Common.S, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
		file.add(saveAs);

		line = new JSeparator();
		file.add(line);

		properties = new JMenuItem(Common.PROPERTIES);
		properties.addActionListener(this);
		file.add(properties);

		line = new JSeparator();
		file.add(line);

		exit = new JMenuItem(Common.EXIT);
		exit.addActionListener(this);
		file.add(exit);

		menuBar.add(file);
	}

	private void menuEdit() {
		edit = new JMenu(Common.EDIT);

		undo = new JMenuItem(Common.UNDO);
		undo.addActionListener(this);
		undo.setAccelerator(KeyStroke.getKeyStroke(Common.Z, InputEvent.CTRL_MASK));
		edit.add(undo);

		line = new JSeparator();
		edit.add(line);

		cut = new JMenuItem(Common.CUT);
		cut.addActionListener(this);
		cut.setAccelerator(KeyStroke.getKeyStroke(Common.X, InputEvent.CTRL_MASK));
		edit.add(cut);
		
		copy = new JMenuItem(Common.COPY);
		copy.addActionListener(this);
		copy.setAccelerator(KeyStroke.getKeyStroke(Common.C, InputEvent.CTRL_MASK));
		edit.add(copy);

		paste = new JMenuItem(Common.PASTE);
		paste.addActionListener(this);
		paste.setAccelerator(KeyStroke.getKeyStroke(Common.V, InputEvent.CTRL_MASK));
		edit.add(paste);

		line = new JSeparator();
		edit.add(line);

		find = new JMenuItem(Common.FIND);
		find.addActionListener(this);
		find.setAccelerator(KeyStroke.getKeyStroke(Common.F, InputEvent.CTRL_MASK));
		edit.add(find);

		findNext = new JMenuItem(Common.FIND_NEXT);
		findNext.addActionListener(this);
		findNext.setAccelerator(KeyStroke.getKeyStroke(Common.F, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
		edit.add(findNext);

		replace = new JMenuItem(Common.REPLACE);
		replace.addActionListener(this);
		replace.setAccelerator(KeyStroke.getKeyStroke(Common.H, InputEvent.CTRL_MASK));
		edit.add(replace);

		line = new JSeparator();
		edit.add(line);

		selectAll = new JMenuItem(Common.SELECT_ALL);
		selectAll.addActionListener(this);
		selectAll.setAccelerator(KeyStroke.getKeyStroke(Common.A, InputEvent.CTRL_MASK));
		edit.add(selectAll);

		timeDate = new JMenuItem(Common.TIME_DATE);
		timeDate.addActionListener(this);
		timeDate.setAccelerator(KeyStroke.getKeyStroke(Common.T, InputEvent.CTRL_MASK));
		edit.add(timeDate);
		
		menuBar.add(edit);
	}

	private void initTextAreaPopupMenu() {
		textAreaPopupMenu = new JPopupMenu();
		
		popUndo = new JMenuItem(Common.UNDO);
		popUndo.addActionListener(this);
		textAreaPopupMenu.add(popUndo);

		line = new JSeparator();
		textAreaPopupMenu.add(line);

		popCut = new JMenuItem(Common.CUT);
		popCut.addActionListener(this);
		textAreaPopupMenu.add(popCut);
		
		popCopy = new JMenuItem(Common.COPY);
		popCopy.addActionListener(this);
		textAreaPopupMenu.add(popCopy);

		popPaste = new JMenuItem(Common.PASTE);
		popPaste.addActionListener(this);
		textAreaPopupMenu.add(popPaste);

		line = new JSeparator();
		textAreaPopupMenu.add(line);

		popSelectAll = new JMenuItem(Common.SELECT_ALL);
		popSelectAll.addActionListener(this);
		textAreaPopupMenu.add(popSelectAll);

		popTimeDate = new JMenuItem(Common.TIME_DATE);
		popTimeDate.addActionListener(this);
		textAreaPopupMenu.add(popTimeDate);
	}

	private void menuFormat() {
		format = new JMenu(Common.FORMAT);

		wordWrap = new JMenuItem(Common.WORD_WRAP);
		wordWrap.addActionListener(this);
		wordWrap.setAccelerator(KeyStroke.getKeyStroke(Common.W, InputEvent.CTRL_MASK));
		format.add(wordWrap);
		
		resetFont = new JMenuItem(Common.RESET_FONT);
		resetFont.addActionListener(this);
		format.add(resetFont);
		
		line = new JSeparator();
		format.add(line);

		font = new JMenuItem(Common.FONT);
		font.addActionListener(this);
		format.add(font);

		fontSize = new JMenuItem(Common.FONT_SIZE_TITLE);
		fontSize.addActionListener(this);
		format.add(fontSize);
		
		fontStyle = new JMenuItem(Common.FONT_STYLE);
		fontStyle.addActionListener(this);
		format.add(fontStyle);

		menuBar.add(format);
	}

	private void menuView() {
		view = new JMenu(Common.VIEW);

		skin = new JMenuItem(Common.SKIN);
		skin.addActionListener(this);
		view.add(skin);

		menuBar.add(view);
	}

	private void menuHelp() {
		help = new JMenu(Common.Help);

		viewHelp = new JMenu(Common.VIEW_HELP);
		help.add(viewHelp);
		
		homePage = new JMenuItem(Common.NOTEPAD_HOME_PAGE);
		homePage.addActionListener(this);
		viewHelp.add(homePage);
		
		skinPage = new JMenuItem(Common.NOTEPAD_SKINS);
		skinPage.addActionListener(this);
		viewHelp.add(skinPage);

		source = new JMenu(Common.SOURCE);
		viewHelp.add(source);
		
		sourceCode = new JMenuItem(Common.SOURCE_CODE);
		sourceCode.addActionListener(this);
		source.add(sourceCode);
		
		sourceCodeDownload = new JMenuItem(Common.SOURCE_CODE_DOWNLOAD);
		sourceCodeDownload.addActionListener(this);
		source.add(sourceCodeDownload);
		
		api = new JMenuItem(Common.NOTEPAD_API);
		api.addActionListener(this);
		viewHelp.add(api);

		line = new JSeparator();
		help.add(line);

		about = new JMenuItem(Common.ABOUT_NOTEPAD);
		about.addActionListener(this);
		help.add(about);

		menuBar.add(help);
	}

	private void initUndoManager(){
		undoManager = new UndoManager();
	}
	
	private void setDisabledMenuAtCreating(boolean b){
		undo.setEnabled(b);
		popUndo.setEnabled(b);
		cut.setEnabled(b);
		popCut.setEnabled(b);
		copy.setEnabled(b);
		popCopy.setEnabled(b);
		find.setEnabled(b);	
		findNext.setEnabled(b);
	}
	
	private void setDisabledMenuAtSelecting(boolean b){
		cut.setEnabled(b);
		popCut.setEnabled(b);
		copy.setEnabled(b);
		popCopy.setEnabled(b);
	}
	
	private void initTextArea() {
		textArea = new JTextArea(Common.EMPTY);
		textArea.setLineWrap(true);
		lineWrap = true;
		textAreaFont = new Font(FontManagerUI.FONT_TYPE, fontStyleNum, FontManagerUI.FONT_SIZE);
		textArea.setFont(textAreaFont);
		
		textArea.add(textAreaPopupMenu);
		
		initUndoManager();
		// add Undoable edit listener
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
			}
		});
		// add caret listener
		textArea.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (null != savedText && null != textArea.getText()) {
					if (savedText.equals(textArea.getText())) {
						setSaved(true);
					} else {
						setSaved(false);
					}
				}
				textArea.setFocusable(true);
				setDisabledMenuAtCreating(true);
			}
		});
		// add mouse motion listener
		textArea.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				isSelectedText();
			}
			
			public void mouseDragged(MouseEvent e) {
				isSelectedText();
			}
		});
		textArea.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					isSelectedText();
				}
			}
			
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					isSelectedText();
					textAreaPopupMenu.show(textArea, e.getX(), e.getY());
				}
			}
			
			public void mouseExited(MouseEvent e) {
			}
			
			public void mouseEntered(MouseEvent e) {
				
			}
			
			public void mouseClicked(MouseEvent e) {
			}
		});
		textAreaScroll = new JScrollPane(textArea);
		this.add(textAreaScroll);
	}
	
	private void isSelectedText() {
		textArea.setFocusable(true);
		String selectText = textArea.getSelectedText();
		if(null != selectText){
			setDisabledMenuAtSelecting(true);
		}else{
			setDisabledMenuAtSelecting(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		actionForFileItem(e);
		actionForEditItem(e);
		actionForFormatItem(e);
		actionForViewItem(e);
		actionForHelpItem(e);
	}

	private void actionForFileItem(ActionEvent e) {
		if (e.getSource() == news) {
			FileMenuUtil.news(MainUI.this);
		} else if (e.getSource() == open) {
			FileMenuUtil file = new FileMenuUtil(Common.EMPTY);
			file.open(MainUI.this);
		} else if (e.getSource() == save) {
			FileMenuUtil.save(MainUI.this);
		} else if (e.getSource() == saveAs) {
			FileMenuUtil.saveAs(MainUI.this);
		} else if (e.getSource() == properties) {
			FileMenuUtil file = new FileMenuUtil(Common.EMPTY);
			file.readProperties(MainUI.this);
		} else if (e.getSource() == exit) {
			FileMenuUtil file = new FileMenuUtil(Common.EMPTY);
			file.exit(MainUI.this);
		}
	}

	private void actionForEditItem(ActionEvent e) {
		if (e.getSource() == undo) {
			EditMenuUtil.undo();
		} else if (e.getSource() == popUndo) {
			EditMenuUtil.undo();
		} else if (e.getSource() == copy) {
			EditMenuUtil.copy();
		} else if (e.getSource() == popCopy) {
			EditMenuUtil.copy();
		} else if (e.getSource() == paste) {
			EditMenuUtil.paste();
		} else if (e.getSource() == popPaste) {
			EditMenuUtil.paste();
		} else if (e.getSource() == cut) {
			EditMenuUtil.cut();
		} else if (e.getSource() == popCut) {
			EditMenuUtil.cut();
		} else if (e.getSource() == find) {
			setMainUIXY();
			EditMenuUtil edit = new EditMenuUtil(Common.EMPTY);
			edit.find();
		} else if (e.getSource() == findNext) {
			EditMenuUtil edit = new EditMenuUtil(Common.EMPTY);
			edit.findNext();
		} else if (e.getSource() == replace) {
			setMainUIXY();
			EditMenuUtil edit = new EditMenuUtil(Common.EMPTY);
			edit.replace();
		} else if (e.getSource() == selectAll) {
			EditMenuUtil.selectAll();
		} else if (e.getSource() == popSelectAll) {
			EditMenuUtil.selectAll();
		} else if (e.getSource() == timeDate) {
			EditMenuUtil.timeDate();
		}else if (e.getSource() == popTimeDate) {
			EditMenuUtil.timeDate();
		}
	}

	private void actionForFormatItem(ActionEvent e) {
		if (e.getSource() == wordWrap) {
			FormatMenuUtil.wordWrap();
		} else if(e.getSource() == resetFont){
			FormatMenuUtil format = new FormatMenuUtil(Common.EMPTY);
			format.resetFont(MainUI.this);
		}else if (e.getSource() == font) {
			setMainUIXY();
			FormatMenuUtil format = new FormatMenuUtil(Common.EMPTY);
			format.font(MainUI.this);
		} else if (e.getSource() == fontSize) {
			setMainUIXY();
			FormatMenuUtil format = new FormatMenuUtil(Common.EMPTY);
			format.fontSize(MainUI.this);
		}else if(e.getSource() == fontStyle){
			setMainUIXY();
			FormatMenuUtil format = new FormatMenuUtil(Common.EMPTY);
			format.fontStyle(MainUI.this);
		}
	}

	private void actionForViewItem(ActionEvent e) {
		if (e.getSource() == skin) {
			setMainUIXY();
			ViewMenuUtil view = new ViewMenuUtil(Common.EMPTY);
			view.skin(MainUI.this);
		}
	}

	private void actionForHelpItem(ActionEvent e) {
		if (e.getSource() == homePage) {
			log.debug(Common.NOTEPAD_HOME_PAGE);
			NotepadUtil.accessURL(Common.NOTEPAD_PUBLISHED_PAGE);
		} else if(e.getSource() == skinPage){
			log.debug(Common.NOTEPAD_SKINS);
			NotepadUtil.accessURL(Common.NOTEPAD_SUBSTANCE_SKINS_PAGE);
		}else if(e.getSource() == sourceCode){
			log.debug(Common.SOURCE_CODE);
			NotepadUtil.accessURL(Common.NOTEPAD_PUBLISHED_BOOKMARK_PAGE + Common.SOURCE_CODE_BOOKMARK);
		}else if(e.getSource() == sourceCodeDownload){
			log.debug(Common.SOURCE_CODE_DOWNLOAD);
			NotepadUtil.accessURL(Common.NOTEPAD_PUBLISHED_BOOKMARK_PAGE + Common.SOURCE_CODE_DOWNLOAD_BOOKMARK);
		}else if(e.getSource() == api){
			log.debug(Common.NOTEPAD_API);
			NotepadUtil.accessURL(Common.NOTEPAD_PUBLISHED_BOOKMARK_PAGE + Common.NOTEPAD_API_BOOKMARK);
		}else if (e.getSource() == about) {
			setMainUIXY();
			HelpMenuUtil help = new HelpMenuUtil(Common.EMPTY);
			help.about(MainUI.this);
		}
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}
}

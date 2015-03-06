package com.b510.notepad.common;

/**
 * @author Hongten
 * @created Nov 19, 2014
 */
public class Common {

	public static final String HYPHEN = "-";
	public static final String EMPTY = "";
	public static final String NEW_LINE = "\r\n";
	public static final String BLANK = " ";
	public static final String QUESTION_MARK = "?";
	public static final String POINT = ".";
	public static final String COLOR = ":";
	public static final String START = "*";
	public static final String TXT = "txt";
	public static final String TXT_FILE = START + POINT + TXT;

	public static final String UNTITLE = "Untitled";
	public static final String NOTEPAD = "Notepad";
	public static final String NOTEPAD_NOTEPAD = BLANK + HYPHEN + BLANK + NOTEPAD;
	public static final String TITLE = UNTITLE + NOTEPAD_NOTEPAD;
	public static final String SYSTEM_EXIT = "System exit";
	public static final String SYSTEM_OPEN = "System open";

	public static final String FILE = "File";
	public static final String EDIT = "Edit";
	public static final String FORMAT = "Format";
	public static final String VIEW = "View";
	public static final String Help = "Help";

	// File Items
	public static final String NEW = "New";
	public static final String OPEN = "Open...";
	public static final String SAVE = "Save";
	public static final String SAVE_AS = "Save as...";
	public static final String PROPERTIES = "Properties";
	public static final String EXIT = "Exit";

	// Edit Items
	public static final String UNDO = "Undo";
	public static final String COPY = "Copy";
	public static final String PASTE = "Paste";
	public static final String CUT = "Cut";
	public static final String DELETE = "Delete";
	public static final String FIND = "Find...";
	public static final String FIND_NEXT = "Find Next";
	public static final String REPLACE = "Replace";
	public static final String GO_TO = "Go To...";
	public static final String SELECT_ALL = "Select All";
	public static final String TIME_DATE = "Time/Date";

	// Format Items
	public static final String WORD_WRAP = "Word Wrap";
	public static final String RESET_FONT = "Reset Font";
	public static final String FONT = "Font";
	public static final String FONT_STYLE = "Font Style";
	public static final String FONT_SIZE_TITLE = "Font Size";

	// View
	public static final String STATUS_BAR = "Status Bar";
	public static final String SKIN = "Change Skin";

	// Help Items
	public static final String VIEW_HELP = "View Help";
	public static final String ABOUT_NOTEPAD = "About NotePad";

	// KeyStroke
	public static final char A = 'A';
	public static final char N = 'N';
	public static final char O = 'O';
	public static final char L = 'L';
	public static final char Z = 'Z';
	public static final char C = 'C';
	public static final char D = 'D';
	public static final char W = 'W';
	public static final char H = 'H';
	public static final char F = 'F';
	public static final char V = 'V';
	public static final char X = 'X';
	public static final char G = 'G';
	public static final char S = 'S';
	public static final char P = 'P';
	public static final char T = 'T';
	public static final char SPACE = ' ';

	// notepad\src\main\resources\images
	public static final String IMAGE_PATH = "images/";

	public static final String HONGTEN_PIC = IMAGE_PATH + "hongten.png";

	// About UI
	public static final String AUTHOR = "Author";
	public static final String AUTHOR_NAME = "Hongten";
	public static final String AUTHOR_DESC = "I'm " + AUTHOR_NAME;
	public static final String ITEM = "Item";
	public static final String DESCRIPTION = "Desctiption";
	public static final String APPLICATION = "Application";
	public static final String NAME = "Name";
	public static final String APPLICATION_NAME = APPLICATION + BLANK + NAME;
	public static final String NOTEPAD_APP = NOTEPAD;
	public static final String APPLICATION_DESCRIPTION = APPLICATION + BLANK + DESCRIPTION;
	public static final String APPLICATION_DESCRIPTION_DETAIL = "A " + NOTEPAD;
	public static final String VERSION = "Version";
	public static final String VERSION_VALUE = "1.0";
	public static final String BLOG = "Blog";
	public static final String HOME_PAGE = "http://www.cnblogs.com/hongten";
	public static final String NOTEPAD_PUBLISHED_PAGE = HOME_PAGE + "/p/hongten_notepad_index.html";
	public static final String NOTEPAD_SUBSTANCE_SKINS_PAGE = HOME_PAGE + "/p/hongten_notepad_substance_skins.html";
	public static final String SUBSTANCE_SKINS_PAGE = NOTEPAD_SUBSTANCE_SKINS_PAGE + "#";
	public static final String NOTEPAD_PUBLISHED_BOOKMARK_PAGE = NOTEPAD_PUBLISHED_PAGE + "#";

	public static final int TABLE_ROW_HEIGHT = 20;

	// Dialog messages and titles
	public static final String CONFIM_EXIT = "Confim Exit";
	public static final String ACCESS_URL_REQUEST = "Access URL Request";
	public static final String ACCESS_URL = "Access URL : ";

	public static final String FONT_LUCIDA_CONSOLE = "Lucida Console";
	public static final String FONT_TYPE = "宋体";
	public static final int FONT_SIZE = 12;
	public static final int FONT_NUM = 148;
	public static final int FONT_SIZE_NUM = 4;
	public static final int FONT_STYLE_NUM = 0;
	public static final String FONT_STYLE_DEFAULT = "Regular";
	public static final String DATE_FORMAT = "HH:mm MM/dd/yyyy";
	public static final String THIS_IS_A_SIMPLE = "This is a Simple";
	public static final String SIMPLE = "Simple";

	public static final String CURRENT_SINK = "Current Skin" + BLANK + COLOR + BLANK;
	public static final String DESCRIPTION_WITH_COLOR = DESCRIPTION + BLANK + COLOR + BLANK;
	public static final String CURRENT_FONT = "Current Font" + BLANK + COLOR + BLANK;
	public static final String CURRENT_FONT_SIZE = "Current Font Size" + BLANK + COLOR + BLANK;
	public static final String CURRENT_FONT_STYLE = "Current Font Style" + BLANK + COLOR + BLANK;

	public static final String DO_YOU_WANT_TO_SAVE_CHANGES = "Do you want to save changes?";
	public static final String WHAT_DO_YOU_WANT_TO_FIND = "Please type what do you want to find.";
	public static final String CAN_NOT_FIND = "Cannot find ";
	public static final String MATCHES_REPLACED = " matches replaced!";

	public static final String FIND_WHAT = "Find What :";
	public static final String REPLACE_TO = "Replace To :";
	public static final String REPLACE_ALL = "Replace All";
	public static final String CASE_SENSITIVE = "Case Sensitive";
	public static final String FORWARD = "Forward";
	public static final String BACKWARD = "Backward";
	public static final String CANCEL = "Cancel";
	public static final String GB2312 = "GB2312";
	
	public static final String NOTEPAD_HOME_PAGE = "Home Page";
	public static final String NOTEPAD_SKINS = "Notepad Skins";
	public static final String SOURCE = "Source";
	public static final String SOURCE_CODE = SOURCE + " Code";
	public static final String SOURCE_CODE_DOWNLOAD = SOURCE_CODE + " Download";
	public static final String NOTEPAD_API = "Notepad API";
	
	public static final String SOURCE_CODE_BOOKMARK = "Source.Code";
	public static final String SOURCE_CODE_DOWNLOAD_BOOKMARK = SOURCE_CODE_BOOKMARK + ".Download";
	public static final String NOTEPAD_API_BOOKMARK = "Notepad.API";
}

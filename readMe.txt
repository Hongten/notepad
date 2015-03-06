=================================================
How to add substance to your project build path?
=================================================

NOTE:
   Your computer should install the Maven(apache-maven-3.2.2 is good choice) before running this project!
   
There are TWO ways to provided.

1. Using eclipse tool to add the substance-1.0.jar to project build path.
   1.1.Finding the substance-1.0.jar with the path "notepad/lib/skin/substance-1.0.jar".
       Right Click --> Build Path --> Add to Build Path.
   
   1.2.Then open the opm.xml(with the path "notepad/pom.xml")
	   Deleting the substance dependency:
	   <dependency>
			<groupId>org.jvnet.substance</groupId>
			<artifactId>substance</artifactId>                              
			<version>1.0</version>
		</dependency>


2. Copy the substance-1.0.jar to your repository.
   2.1.Finding the substance-1.0.jar with the path "notepad/lib/skin/substance-1.0.jar".
       Copying the substance-1.0.jar file to your repository.
       The default path of the repository is "${user.home}/.m2/repository/org/jvnet/substance/substance/1.0/substance-1.0.jar"
       
       
=================================================
How to run notepad project?
=================================================
	Using the eclipse tool and finding the Client.java file with the path "notepad/src/main/java/com/b510/notepad/client/Client.java".
	Right Click --> Run As --> Java Application
	
	
=================================================
The structure of the project:
=================================================
  -src/main/java
      -com.b510.notepad
          -client
              -Client.java
          -common
              -Common.java
          -ui
              -AboutUI.java
              -FindManagerUI.java
              -FontManagerUI.java
              -FontSizeManagerUI.java
              -JUI.java
              -MainUI.java
              -NotepadUI.java
              -ReplaceManagerUI.java
              -SkinManagerUI.java
          -util
              -EditMenuUtil.java
              -FileMenuUtil.java
              -FormatMenuUtil.java
              -HelpMenuUtil.java
              -NotepadUtil.java
              -ViewMenuUtil.java
          -log4j.properties   
  -lib
       -skin
          -substance-1.0.jar
  -pom.xml
  
=================================================
Describe for all files: 
=================================================

  -Client.java                -->  The entry of the notepad application. It contains the main method.
  -Common.java                -->  All constants in here.
  -AboutUI.java               -->  About notepad page.
  -FindManagerUI.java         -->  Find page.
  -FontManagerUI.java         -->  Font setting page.
  -FontSizeManagerUI.java     -->  Font sizt setting page.
  -JUI.java                   -->  The parent class for the NotepadUI, It extends JFrame.
  -MainUI.java                -->  The main page of the notepad.
  -NotepadUI.java             -->  The parent class for the MainUI, It extends JUI and implements ActionListener.  
  -ReplaceManagerUI.java      -->  Replace page. 
  -SkinManagerUI.java         -->  Skin setting page.
  -EditMenuUtil.java          -->  Edit menu functions provider.
  -FileMenuUtil.java          -->  File menu functions provider.
  -FormatMenuUtil.java        -->  Format menu functions provider.
  -HelpMenuUtil.java          -->  Help menu functions provider.
  -NotepadUtil.java           -->  Common functions provider.
  -ViewMenuUtil.java          -->  View menu functions provider.
  -log4j.properties           -->  A properties for the log4j.
  -substance-1.0.jar          -->  substance dependency.
  -pom.xml                    -->  pom.xml
  
  
=================================================
More Information About Notepad:
=================================================
  
  Author            : Hongten
  E-mail            : hongtenzone@foxmail.com
  Home Page         : http://www.cnblogs.com/hongten
  Notepad Page      : http://www.cnblogs.com/hongten/p/hongten_notepad_index.html
  Notepad Skin Page : http://www.cnblogs.com/hongten/p/hongten_notepad_substance_skins.html
  Windows Notepad   : http://windows.microsoft.com/en-us/windows/notepad-faq#1TC=windows-7
  

  
  
  
  
  
  
  
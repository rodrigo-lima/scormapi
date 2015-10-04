package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class code_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n");

/*******************************************************************************
**
** Filename:  code.jsp
**
** File Description:   This file implements a menu built from the SCOs in 
** the current course.  It includes code from mtmcode.js which contains 
** the copyright information for this menu implemention.  
**
**
**
**
**
** Author: ADL Technical Team
**
** Contract Number:
** Company Name: CTC
**
** Module/Package Name: Sample RTE
** Module/Package Description:
**
** Design Issues:
**
** Implementation Issues:
** Known Problems:
** Side Effects:
**
** References: ADL SCORM
**
/*******************************************************************************
**
** Concurrent Technologies Corporation (CTC) grants you ("Licensee") a non-
** exclusive, royalty free, license to use, modify and redistribute this
** software in source and binary code form, provided that i) this copyright
** notice and license appear on all copies of the software; and ii) Licensee
** does not utilize the software in a manner which is disparaging to CTC.
**
** This software is provided "AS IS," without a warranty of any kind.  ALL
** EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
** IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NON-
** INFRINGEMENT, ARE HEREBY EXCLUDED.  CTC AND ITS LICENSORS SHALL NOT BE LIABLE
** FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
** DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES.  IN NO EVENT WILL CTC  OR ITS
** LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
** INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
** CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
** OR INABILITY TO USE SOFTWARE, EVEN IF CTC HAS BEEN ADVISED OF THE POSSIBILITY
** OF SUCH DAMAGES.
**
*******************************************************************************/
/* This menu uses  
** Morten's JavaScript Tree Menu
** version 2.3.0, dated 2001-04-30
** http://www.treemenu.com/

** Copyright (c) 2001, Morten Wang & contributors
** All rights reserved.
***************************************************************************/

      out.write("\r\n\r\n<html>\r\n<head>\r\n<title>Menu</title>\r\n\r\n<script type=\"text/javascript\" src=\"mtmcode.js\">\r\n</script>\r\n\r\n<script type=\"text/javascript\">\r\n\r\n \r\n/******************************************************************************\r\n* User-configurable options.                                                  *\r\n******************************************************************************/\r\n\r\n// Menu table width, either a pixel-value (number) or a percentage value.\r\nvar MTMTableWidth = \"100%\";\r\n\r\n// Name of the frame where the menu is to appear.\r\nvar MTMenuFrame = \"menu\";\r\n\r\n// variable for determining whether a sub-menu always gets a plus-sign\r\n// regardless of whether it holds another sub-menu or not\r\nvar MTMSubsGetPlus = \"Never\";\r\n\r\n// variable that defines whether the menu emulates the behaviour of\r\n// Windows Explorer\r\nvar MTMEmulateWE = true;\r\n\r\n// Directory of menu images/icons\r\nvar MTMenuImageDirectory = \"menu-images/\";\r\n\r\n// Variables for controlling colors in the menu document.\r\n// Regular BODY atttributes as in HTML documents.\r\n");
      out.write("var MTMBGColor = \"white\";\r\nvar MTMBackground = \"\";\r\nvar MTMTextColor = \"black\";\r\n\r\n// color for all menu items\r\nvar MTMLinkColor = \"black\";\r\n\r\n// Hover color, when the mouse is over a menu link\r\nvar MTMAhoverColor = \"red\";\r\n\r\n// Foreground color for the tracking & clicked submenu item\r\nvar MTMTrackColor =\"yellow\";\r\nvar MTMSubExpandColor = \"black\";\r\nvar MTMSubClosedColor = \"black\";\r\n\r\n// All options regarding the root text and it's icon\r\n//var MTMRootIcon = \"menu_new_root.gif\";\r\nvar MTMRootIcon = \"adl_tm_24x16.jpg\";\r\nvar MTMenuText = \"\";\r\nvar MTMRootColor = \"black\";\r\nvar MTMRootFont = \"Arial, Helvetica, sans-serif\";\r\nvar MTMRootCSSize = \"84%\";\r\nvar MTMRootFontSize = \"-1\";\r\n\r\n// Font for menu items.\r\nvar MTMenuFont = \"Arial, Helvetica, sans-serif\";\r\nvar MTMenuCSSize = \"84%\";\r\nvar MTMenuFontSize = \"-1\";\r\n\r\n// Variables for style sheet usage\r\n// 'true' means use a linked style sheet.\r\nvar MTMLinkedSS = false;\r\nvar MTMSSHREF = \"style/menu.css\";\r\n\r\n// Additional style sheet properties if you're not using a linked style sheet.\r\n");
      out.write("// See the documentation for details on IDs, classes & elements used in the menu.\r\n// Empty string if not used.\r\nvar MTMExtraCSS = \"\";\r\n\r\n// Header & footer, these are plain HTML.\r\n// Leave them to be \"\" if you're not using them\r\n\r\nvar MTMHeader = \"\";\r\nvar MTMFooter = \"\";\r\n\r\n// Whether you want an open sub-menu to close automagically\r\n// when another sub-menu is opened.  'true' means auto-close\r\nvar MTMSubsAutoClose = false;\r\n\r\n// This variable controls how long it will take for the menu\r\n// to appear if the tracking code in the content frame has\r\n// failed to display the menu. Number if in tenths of a second\r\n// (1/10) so 10 means \"wait 1 second\".\r\nvar MTMTimeOut = 10;\r\n\r\n// Cookie usage.  First is use cookie (yes/no, true/false).\r\n// Second is cookie name to use.\r\n// Third is how many days we want the cookie to be stored.\r\nvar MTMUseCookies = false;\r\nvar MTMCookieName = \"MTMCookie\";\r\nvar MTMCookieDays = 3;\r\n\r\n// Tool tips.  A true/false-value defining whether the support\r\n// for tool tips should exist or not.\r\n");
      out.write("var MTMUseToolTips = true;\r\n\r\n/******************************************************************************\r\n* User-configurable list of icons.                                            *\r\n******************************************************************************/\r\n\r\nvar MTMIconList = null;\r\nMTMIconList = new IconList();\r\nMTMIconList.addIcon(new MTMIcon(\"menu_link_external.gif\", \"http://\", \"pre\"));\r\nMTMIconList.addIcon(new MTMIcon(\"menu_link_pdf.gif\", \".pdf\", \"post\"));\r\n\r\nvar menu = new MTMenu();\r\n\r\n");

 //  Get the information needed to build the menu
 Vector title_vector = new Vector();
 Vector id_vector = new Vector();
 Vector level_vector = new Vector();
 Vector parent_vector = new Vector();
 Vector item_number_vector = new Vector();
 String userID = "";
 String courseID = "";
 String control = "";

 int length;
 int current_int_level;
 int current_index;
 int z;
 String previous_level = new String();
 int parent_index;
 String course_title = new String();
 String menu_name = new String();
 int new_level;
 
try
{
   // Get the course and item info from the database
   Connection conn; 
   PreparedStatement stmtSelectUserSCO;
   PreparedStatement stmtSelectCourse;
   String sqlSelectUserSCO
    = "SELECT * FROM ItemInfo WHERE CourseID = ? ORDER BY Sequence";
           
   String sqlSelectCourse
    = "SELECT * FROM CourseInfo WHERE CourseID = ?";
                     
   String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
   String connectionURL = "jdbc:odbc:SampleRTE";

   Class.forName(driverName).newInstance();
   conn = DriverManager.getConnection(connectionURL);
         
   stmtSelectUserSCO= conn.prepareStatement( sqlSelectUserSCO );
   stmtSelectCourse= conn.prepareStatement( sqlSelectCourse );
   
   userID = (String)session.getAttribute( "USERID" );
   
   courseID = (String)session.getAttribute( "COURSEID" );
    
   control = (String)session.getAttribute( "control" );
    
   if (courseID != "") 
   {//  Execute the course info database query
      ResultSet courseInfo = null;
      synchronized( stmtSelectCourse )
      {
         stmtSelectCourse.setString( 1, courseID );
         courseInfo = stmtSelectCourse.executeQuery();
      }
   
    // Move into the first record in the record set
      while ( courseInfo.next() )
      {
      //  Get the CONTROL column
         control = courseInfo.getString("Control");
      //get course name
         course_title = courseInfo.getString("CourseTitle");
      }
      }
      userID = (String)session.getAttribute( "USERID" );
  
      ResultSet itemInfo = null;
      if ((courseID != "")  && ((control != null) && ((control.equals( "mixed")) || (control.equals( "choice")))))
      {
         synchronized( stmtSelectUserSCO )
         {
            stmtSelectUserSCO.setString( 1, courseID );
            itemInfo = stmtSelectUserSCO.executeQuery();
         }  
         int i = 0;
         while(itemInfo.next())
         {
            // add the info to the vectors
            title_vector.addElement(itemInfo.getString("Title"));
            id_vector.addElement(itemInfo.getString("Identifier"));
            level_vector.addElement(itemInfo.getString("TheLevel"));
         } //end while
      }  // end if
    
} // end try
  catch(Exception e)
{
   e.printStackTrace();   
}
  
      out.write("  \r\n    \r\n    \r\n");
 // begin menu construction
   if ((courseID != "")  && (courseID != null) && ((control != null) && ((control.equals( "mixed")) || (control.equals( "choice")))))
   {  
      int i = 0;
    
      out.write("var MTMenuText = \"");
      out.print(course_title);
      out.write("\";\r\n      ");
 String previous_parent = "menu";
      previous_level = level_vector.elementAt(i).toString();
      out.write("\r\n      // first item is menu root\r\n      menu.MTMAddItem(new MTMenuItem(\"");
      out.print(title_vector.elementAt(i).toString());
      out.write("\", \"javascript:launchItem('");
      out.print(id_vector.elementAt(i).toString());
      out.write("')\", \"code\"));\r\n      ");
 parent_index = 0;
      parent_vector.addElement("menu");
      length = title_vector.size();
      item_number_vector.addElement("0");
      current_index = 0; 
      i++;
      while ( i < length )
      {   // if nesting level of current item is same as that of previous item
            if (level_vector.elementAt(i).toString().equals(previous_level))
            { 
      out.write("\r\n                ");
      out.print(parent_vector.elementAt(parent_index).toString());
      out.write(".MTMAddItem(new MTMenuItem(\"");
      out.print(title_vector.elementAt(i).toString());
      out.write("\", \"javascript:launchItem('");
      out.print(id_vector.elementAt(i).toString());
      out.write("')\", \"code\"));\r\n               ");
 //increment item_number_vector at current_index so know which item are at
               Integer inc = new Integer(item_number_vector.elementAt(current_index).toString());
               new_level = inc.intValue();
               new_level++;
               item_number_vector.setElementAt(inc.toString(new_level), current_index);
               i++;
            }// end if
            //if level is greater, get new menu name, add name to 
            //parent_vector and use as current menu name
            else if ( (previous_level.compareTo(level_vector.elementAt(i).toString()))<0)
            {  
               menu_name = "sub"+parent_index;
               Integer tempInt = new Integer(item_number_vector.elementAt(current_index).toString()); 
               int item_number = tempInt.intValue();
               
      out.write("var ");
      out.print(menu_name);
      out.write(" = new MTMenu();\r\n               ");
      out.print( parent_vector.elementAt(parent_index).toString());
      out.write(".items[");
      out.print(item_number);
      out.write("].MTMakeSubmenu(");
      out.print(menu_name);
      out.write(");\r\n               ");
 parent_vector.addElement(menu_name);
               parent_index++;
               item_number_vector.addElement("0");
               current_index++;
      out.write("                 \r\n               ");
      out.print(menu_name);
      out.write(".MTMAddItem(new MTMenuItem(\"");
      out.print(title_vector.elementAt(i).toString());
      out.write("\", \"javascript:launchItem('");
      out.print(id_vector.elementAt(i).toString());
      out.write("')\", \"code\")); \r\n               ");

               previous_level = level_vector.elementAt(i++).toString();
            } //end else if
            else
              //if level is less
            { 
               Integer int1 = new Integer(previous_level);
               Integer int2 = new Integer(level_vector.elementAt(i).toString());
               current_int_level = int1.intValue() - int2.intValue(); 
               for (z = 0; z<current_int_level; z++)
               {  
                  parent_vector.removeElementAt(parent_index--);
                  item_number_vector.removeElementAt(current_index--);
               }// end for 
      out.write("\r\n                                  ");
      out.print(parent_vector.elementAt(parent_index).toString());
      out.write(".MTMAddItem(new MTMenuItem(\"");
      out.print(title_vector.elementAt(i).toString());
      out.write("\", \"javascript:launchItem('");
      out.print(id_vector.elementAt(i).toString());
      out.write("')\", \"code\")); \r\n               ");
 //increment item_number_vector at current_index so know which item are at
               Integer inc = new Integer(item_number_vector.elementAt(current_index).toString());
               new_level = inc.intValue();
               new_level++;
               item_number_vector.setElementAt(inc.toString(new_level), current_index);
               previous_level = level_vector.elementAt(i++).toString();
            }// end else
    } //end while
 } // end menu creation
      out.write("\r\n \r\n      </script>\r\n</head> \r\n\r\n<body onload=\"MTMStartMenu()\" bgcolor=\"#FFFFFF\" text=\"#black\" link=\"yellow\" vlink=\"lime\" alink=\"red\"  >\r\n</body>\r\n\r\n</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (pageContext != null) pageContext.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }
}

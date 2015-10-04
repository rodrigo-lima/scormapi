package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public final class LMSLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


   Connection conn;
   PreparedStatement stmtSelectUser;
   
   /*********************************************************************
   * Method: jspInit()
   * Input: none
   * Output: conn is given the value of the database connection and
   *         stmtSelectUser is assigned the query.
   *
   * Description: This method sets the driverName and connectionURL
   *              variables and establishes the database connection.  The
   *              SQL string is also assigned and converted to a prepared
   *              statement.
   *********************************************************************/
   public void jspInit()
   {
      try
      {
         // Creating a query string to query the UserInfo table for the
         // information of the user who logged in.
         String sqlSelectUser
          = "SELECT * FROM UserInfo Where UserID = ?";

         String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
			String connectionURL = "jdbc:odbc:SampleRTE";
			Class.forName(driverName).newInstance();
			conn = DriverManager.getConnection(connectionURL);
         stmtSelectUser= conn.prepareStatement( sqlSelectUser );
      }
      catch(SQLException e) 
		{
		   e.printStackTrace();
		}
      catch(Exception e) 
		{
		    e.printStackTrace();
		}
   }

   /*********************************************************************
   * Method: jspDestroy()
   * Input: none
   * Output: none
   *
   * Description: Closes statements and the database connection.    
   *********************************************************************/
   public void jspDestroy()
   {
      try
      {
         stmtSelectUser.close();
         conn.close();          
      }
      catch(SQLException e) {e.printStackTrace();}
   } 

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

      out.write('\r');
      out.write('\n');

/*******************************************************************************
**
** Filename:  LMSLogin.jsp
**
** File Description:   This file implements the login function.  It checks 
** username and password that were entered by user against those in 
** database and redirects to login2.htm if values were not found, else 
** sends to menu page. 
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
** Module/Package Name:
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
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n");

try
{
   String UserName = new String("");
   String Password = new String("");
	String action = new String("");
	
   UserName = request.getParameter("uname");
   Password = request.getParameter("pwd");
	action = null;
	
   ResultSet userRS = null;

   synchronized( stmtSelectUser )
   {
      stmtSelectUser.setString( 1, UserName);
      userRS = stmtSelectUser.executeQuery();
	}

   // Verifies that the username was found by checking to see if the result set
   // 'userRS' is empty.  If the username was found, it checks to see if the
   // entered password is correct.  If the username was not found, the variable
   // 'action' is changed to indicate this.
   if( (userRS != null) && (userRS.next()) )
   {
      String passwd = userRS.getString("Password");
      boolean active = userRS.getBoolean("Active");
      
      if (! active )
      {
         action = "deactivated";
      }
      
      // Verifies that the password that was entered is not blank and that it
      // matches the password found to belong to the username.  If either of
      // these conditions is incorrect, the variable 'action' is changed
      // to indicate this.
      if( (Password != null) && (!Password.equals(passwd)) )
      {
         action = "invalidpwd";      
      }
      
   }
   else
   {
      action = "invaliduname";
   }
	
   // Verifies that no errors were found with the login by checking to see if
   // the action variable has been assigned anything.  If 'action' is null, no
   // errors were found and the session variables 'USERID' and 'RTEADMIN'
   // are set.  
   if ( action == null )
   {
      session.putValue("USERID", UserName);
      String admin = userRS.getString("Admin"); 
      
      // Checks to see if the user has admin rights and sets the 'RTEADMIN'
      // variable accordingly.
      if ( (admin != null) && (admin.equals("1")) ) 
      {
        session.putValue("RTEADMIN", new String("true"));
      }
      else
      {
        session.putValue("RTEADMIN", new String("false"));
      }
   }

   // checks to see if the action variable is null.  If it is then no error
   // was found and the page is redirected to the menu page, otherwise it
   // is redirected to the second login page.
   if ( action != null )
   {
      response.sendRedirect( "LMSLogin2.htm" );
   }
   else
   {
      response.sendRedirect( "LMSMenu.jsp" );
   }
}
catch(Exception e)
{  
      out.write("\r\n   Caught exception ");
      out.print( e );
      out.write('\r');
      out.write('\n');

} 
      out.write('\r');
      out.write('\n');
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

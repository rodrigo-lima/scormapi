<!--
/*******************************************************************************
**
** Filename:  updateComp.jsp
**
** File Description: This page contains a form which enables the user to change
**                   information in a competency record.  It submits this
**                   information to the processUpdateComp.jsp page.
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
** notice and license appear on all copies of the software; and ii) Licensee does
** not utilize the software in a manner which is disparaging to CTC.
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
** OR INABILITY TO USE SOFTWARE, EVEN IF CTC  HAS BEEN ADVISED OF THE POSSIBILITY
** OF SUCH DAMAGES.
**
*******************************************************************************/
-->


<%@page import = "java.sql.*, java.util.*, org.adl.util.*, java.io.*" %>
<HTML>
<HEAD>
   <TITLE>ADL Sample Run-Time Environment Version 1.2.2 Update Competency</TITLE>
   <META HTTP-EQUIV-equiv="Content-Type" CONTENT="text/html; charset=iso-8859-1">
   <SCRIPT LANGUAGE="JavaScript">
   <!--
   function MM_reloadPage(init)
   { //reloads the window if Nav4 resized
       if (init==true) with (navigator)
       {
          if ((appName=="Netscape")&&(parseInt(appVersion)==4))
          {
             document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage;
          }
       }
       else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
   }
   MM_reloadPage(true);
     // -->
   </script>
</HEAD>

<BODY BGCOLOR="#FFFFFF">
   <jsp:include page="gotoMenu.jsp" flush="true" />
   <form method="post" action="processUpdateComp.jsp" name="frmUpdateComp">
   <TABLE WIDTH="458" BORDER="0">
   <%!
      Connection conn;
      PreparedStatement stmtSelectComp;
      
      /*********************************************************************
      * Method: jspInit()
      * Input: none
      * Output: conn and stmtSelectComp are given new values
      *
      * Description: This function sets the driverName and connectionURL
      *              variables and establishes the database connection.  The
      *              SQL string is also assigned and converted to a prepared
      *              statement.
      *********************************************************************/
      public void jspInit()
      {
         try
         {
            String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";
            String connectionURL = "jdbc:odbc:SampleRTE";
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(connectionURL);

            String sqlSelectComp = "SELECT * FROM Competency where CompID = ?";
            stmtSelectComp = conn.prepareStatement( sqlSelectComp );
         }
         catch(SQLException e){}
         catch(ClassNotFoundException e){}
         catch(Exception e){}
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
            stmtSelectComp.close();
            conn.close();
         }
         catch(SQLException e){}
      }
   %>
   <%
      // The competency ID is inserted into stmtSelectComp and that statement
      // is executed.
      try
      {
         ResultSet compRS;
         String compID = null;
         String passFail = null;

         /*********************************************************************
         * Method: synchronized()
         * Input: stmtSelectComp
         * Output: stmtSelectComp
         *
         * Description: Inserts the competency ID into the prepared statement
         *              'stmtDeleteComp'.
         *********************************************************************/
         synchronized( stmtSelectComp )
         {
            stmtSelectComp.setString(1, request.getParameter( "ID" ));
         }

         compRS = stmtSelectComp.executeQuery();

         // Displays the information from the competency record if one
         // with an ID equal to the one chosen by the user on the
         // previous page is found.
         if( compRS.next() )
         {
            compID = compRS.getString("CompID");
            passFail = compRS.getString("PassFail");
            %>
            <TR>
               <TD>
                  Competency ID:
               </TD>
               <TD>
                  <%=compID%>
               </TD>
            </TR>
            <TR>
               <TD>
                  Results:
               </TD>
               <TD>
                  <select NAME="selPassFail">
                     <OPTION value="pass">Pass</OPTION>
                     <OPTION <% if (passFail.equals("fail")){ %> selected <% } %> VALUE="fail">Fail</OPTION>
                  </SELECT>
                  <INPUT TYPE="hidden" NAME="ID" VALUE="<%=compID%>">
               </TD>
            </TR>
            <%
         }
      }
      catch(Exception e){}
   %>
      <TR>
         <TD>
            <INPUT TYPE="submit" name="Submit" VALUE="Submit">
          </TD>
      </TR>
   </TABLE>
</BODY>
</HTML>

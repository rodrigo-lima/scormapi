package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LMSFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n<!--\r\n/*******************************************************************************\r\n**\r\n** Filename: LMSFrame.jsp\r\n**\r\n** File Description: This page contains the API Adapter applet.  The API \r\n**                   Adapter applet has no visual display elements and is \r\n**                   therefore invisible to the user.  Note that the API \r\n**                   Adapter object is exposed to SCOs via the LMSMain.htm \r\n**                   page.  The SCOs communicate with the Run-time \r\n**                   Environment through this API.  This page also contains\r\n**                   the Run-time Environment login and logout buttons and the\r\n**                   button for Next, Previous, and Quit.\r\n** Author: ADL Technical Team\r\n**\r\n** Contract Number:\r\n** Company Name: CTC\r\n**\r\n** Module/Package Name:\r\n** Module/Package Description:\r\n**\r\n** Design Issues:\r\n**\r\n** Implementation Issues:\r\n** Known Problems:\r\n** Side Effects:\r\n**\r\n** References: ADL SCORM\r\n**\r\n/*******************************************************************************\r\n");
      out.write("**\r\n** Concurrent Technologies Corporation (CTC) grants you (\"Licensee\") a non-\r\n** exclusive, royalty free, license to use, modify and redistribute this\r\n** software in source and binary code form, provided that i) this copyright\r\n** notice and license appear on all copies of the software; and ii) Licensee does\r\n** not utilize the software in a manner which is disparaging to CTC. \r\n**\r\n** This software is provided \"AS IS,\" without a warranty of any kind.  ALL\r\n** EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY\r\n** IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NON-\r\n** INFRINGEMENT, ARE HEREBY EXCLUDED.  CTC AND ITS LICENSORS SHALL NOT BE LIABLE\r\n** FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR\r\n** DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES.  IN NO EVENT WILL CTC  OR ITS\r\n** LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,\r\n** INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER\r\n** CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF\r\n");
      out.write("** OR INABILITY TO USE SOFTWARE, EVEN IF CTC  HAS BEEN ADVISED OF THE POSSIBILITY\r\n** OF SUCH DAMAGES.\r\n**\r\n*******************************************************************************/\r\n-->\r\n<head>\r\n<meta http-equiv=\"expires\" content=\"Tue, 20 Aug 1999 01:00:00 GMT\">\r\n<meta http-equiv=\"Pragma\" content=\"no-cache\">\r\n<title>ADL Sample Run-Time Environment Version 1.2.2</title>\r\n<script language=javascript>\r\n/****************************************************************************\r\n**\r\n** Function: LMSIsInitialized()\r\n** Input:   none\r\n** Output:  boolean\r\n**\r\n** Description:  This function returns a boolean that represents where or \r\n**               no LMSInitialize() has been called by the SCO.\r\n**\r\n***************************************************************************/\r\nfunction LMSIsInitialized()\r\n{\r\n   // Determines if the API (LMS) is in an initialized state.\r\n   // There is no direct method for determining if the LMS API is initialized\r\n   // for example an LMSIsInitialized function defined on the API so we'll try\r\n");
      out.write("   // a simple LMSGetValue and trap for the LMS Not Initialized Error\r\n   \r\n   var value = API.LMSGetValue(\"cmi.core.student_name\");\r\n   var errCode = API.LMSGetLastError().toString();\r\n   if (errCode == 301)\r\n   {\r\n      return false;\r\n   }\r\n   else\r\n   {\r\n      return true;\r\n   }\r\n}\r\n\r\n/****************************************************************************\r\n**\r\n** Function: login_onclick()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function changes the content frame to the login page,\r\n**               as \"hides\" the login button.\r\n**\r\n***************************************************************************/\r\nfunction login_onclick() \r\n{\r\n   window.parent.frames[3].document.location.href = \"LMSLogin.htm\";\r\n   if ( document.layers != null )\r\n   {\r\n      swapLayers();\r\n   }\r\n   else if ( document.all != null )\r\n   {\r\n      window.document.forms[0].login.style.visibility = \"hidden\";\r\n   }\r\n   else\r\n   {\r\n      //Niether IE nor Netscape is being used\r\n      alert(\"your browser may not be supported\");\r\n");
      out.write("   }\r\n}\r\n\r\n/****************************************************************************\r\n**\r\n** Function: logout_onclick()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function redirects to logout.jsp, but first checks\r\n**               to see if there is a course executing.\r\n**\r\n***************************************************************************/\r\nfunction logout_onclick() \r\n{\r\n   // two known potential difficulties exist with having the logout\r\n   // button in this frame...   The first is that the user may not\r\n   // have exited the lesson before attempting to log out.  The second\r\n   // problem is that a child window may be open containing the lesson\r\n   // if the user has not exited.   To deal with these two cases, we'll\r\n   // force the user to exit the lesson before we allow a logout.\r\n\r\n   if (LMSIsInitialized() == true)\r\n   {\r\n      // we're making an assumtion that the user is trying\r\n      // to log out without first exiting the lesson via the\r\n      // appropriate means - because if the user had exited\r\n");
      out.write("      // the lesson, the LMS would not still be initialized.\r\n      var  mesg = \"You must exit the lesson before you logout\";\r\n      alert(mesg);\r\n   }\r\n   else\r\n   {\r\n      window.parent.frames[3].location.href=\"logout.jsp\";\r\n   }\r\n\r\n   return;\r\n}\r\n\r\n/****************************************************************************\r\n**\r\n** Function: changeSCOContent()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function enables the appropriate controls so that\r\n**               the user can progress to the next item.\r\n**\r\n***************************************************************************/\r\nfunction changeSCOContent()\r\n{\r\n   //This function is called by the APIAdapterApplet during \r\n   //LMSFinish.\r\n   if ( document.layers != null )\r\n   {\r\n     swapLayers();\r\n   }\r\n   else if ( document.all != null )\r\n   {\r\n     ctrl = window.document.forms[0].control.value; \r\n     \r\n     if ( ctrl == \"mixed\" || ctrl == \"flow\" || ctrl == \"\" || ctrl == null )\r\n     {\r\n         window.top.frames[0].document.forms[0].next.style.visibility = \"visible\"; \r\n");
      out.write("         window.top.frames[0].document.forms[0].previous.style.visibility = \"visible\";\r\n         window.top.frames[0].document.forms[0].quit.style.visibility = \"visible\";\r\n         window.top.frames[0].document.forms[0].next.disabled = false;\r\n         window.top.frames[0].document.forms[0].previous.disabled = false;\r\n     }\r\n     else if ( ctrl == \"choice\" )\r\n      { \r\n         window.top.frames[0].document.forms[0].next.style.visibility = \"hidden\"; \r\n         window.top.frames[0].document.forms[0].previous.style.visibility = \"hidden\"; \r\n         window.top.frames[0].document.forms[0].quit.style.visibility = \"visible\";\r\n      }  \r\n      else if ( ctrl = \"auto\" )\r\n      {\r\n         window.top.contentWindow.document.location.href = \"sequencingEngine.jsp\";\r\n      }\r\n   }\r\n        \r\n   else\r\n   {\r\n     //Neither IE nor Netscape is being used\r\n     alert(\"your browser may not be supported\");\r\n   }\r\n\r\n\r\n}\r\n\r\n/****************************************************************************\r\n**\r\n** Function: nextSCO()\r\n** Input:   none\r\n");
      out.write("** Output:  none\r\n**\r\n** Description:  This function is called when the user clicks the \"next\"\r\n**               button.  The Sequencing Engine is called, and all relevant\r\n**               controls are affected. \r\n**\r\n***************************************************************************/\r\nfunction  nextSCO()\r\n{\r\n   // This is the launch line for the next SCO...\r\n   // The Sequencing Engine determines which to launch and\r\n   // serves it up into the LMS's content frame or child window - depending\r\n    //on the method that was used to launch the content in the first place.\r\n   var scoWinType = typeof(window.parent.frames[3].scoWindow);\r\n   var theURL = \"pleaseWait.jsp?button=next\";\r\n  \r\n   if (scoWinType != \"undefined\" && scoWinType != \"unknown\")\r\n   {\r\n      if (window.parent.frames[3].scoWindow != null)\r\n      {\r\n         // there is a child content window so display the sco there.\r\n         window.parent.frames[3].scoWindow.document.location.href = theURL;\r\n         window.parent.frames[2].document.location.href = \"code.jsp\";\r\n");
      out.write("      }\r\n      else\r\n      {\r\n         window.parent.frames[3].document.location.href = theURL;\r\n         window.parent.frames[2].document.location.href = \"code.jsp\";\r\n      }\r\n   }\r\n   else\r\n   {\r\n      window.parent.frames[3].document.location.href = theURL;\r\n      window.parent.frames[2].document.location.href = \"code.jsp\";\r\n   }\r\n   if ( document.layers != null )\r\n   {\r\n      swapLayers();\r\n   }\r\n   else if ( document.all != null )\r\n   {\r\n     // window.top.frames[0].document.forms[0].next.disabled = true;\r\n     // window.top.frames[0].document.forms[0].previous.disabled = true;\r\n   }\r\n   else\r\n   {\r\n      //Neither IE nor Netscape is being used\r\n      alert(\"your browser may not be supported\");\r\n   }  \r\n}\r\n\r\n\r\n/****************************************************************************\r\n**\r\n** Function: previousSCO()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function is called when the user clicks the \"previous\"\r\n**               button.  The Sequencing Engine is called, and all relevant\r\n");
      out.write("**               controls are affected. \r\n**\r\n***************************************************************************/\r\nfunction  previousSCO()\r\n{\r\n\r\n   // This function is called when the \"Previous\" button is clicked.\r\n   // The LMSLesson servlet figures out which SCO to launch and\r\n   // serves it up into the LMS's content frame or child window - depending\r\n   //on the method that was used to launch the content in the first place.\r\n\r\n   var scoWinType = typeof(window.parent.frames[3].scoWindow);\r\n   var theURL = \"pleaseWait.jsp?button=prev\";\r\n   \r\n   if (scoWinType != \"undefined\" && scoWinType != \"unknown\")\r\n   {\r\n      if (window.parent.frames[3].scoWindow != null)\r\n      {\r\n         // there is a child content window so display the sco there.\r\n         window.parent.frames[3].scoWindow.document.location.href = theURL;\r\n         window.parent.frames[2].document.location.href = \"code.jsp\";\r\n      }\r\n      else\r\n      {\r\n         window.parent.frames[3].document.location.href = theURL;\r\n         window.parent.frames[2].document.location.href = \"code.jsp\";\r\n");
      out.write("      }\r\n   }\r\n   else\r\n   {\r\n      window.parent.frames[3].document.location.href = theURL;\r\n      window.parent.frames[2].document.location.href = \"code.jsp\";\r\n\r\n      //  scoWindow is undefined which means that the content frame\r\n      //  does not contain the lesson menu at this time.\r\n   }\r\n   if ( document.layers != null )\r\n   {\r\n      swapLayers();\r\n   }\r\n   else if ( document.all != null )\r\n   {\r\n     // window.document.forms[0].next.disabled = true;\r\n     // window.document.forms[0].previous.disabled = true;\r\n   }\r\n   else\r\n   {\r\n     //Neither IE nor Netscape is being used\r\n      alert(\"your browser may not be supported\");\r\n   }\r\n  \r\n}\r\n\r\n/****************************************************************************\r\n**\r\n** Function: closeSCOContent()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function exits out of the current lesson and presents\r\n**               the RTE menu. \r\n**\r\n***************************************************************************/\r\nfunction closeSCOContent()\r\n");
      out.write("{\r\n   var scoWinType = typeof(window.parent.frames[3].window);\r\n   \r\n   ctrl = window.document.forms[0].control.value;\r\n   \r\n   if ( ctrl == \"auto\" )\r\n   {\r\n      window.parent.frames[2].document.location.href = \"code.jsp\";\r\n      window.top.frames[3].location.href = \"LMSMenu.jsp\"\r\n      window.top.contentWindow.close();\r\n   }\r\n   else\r\n   {\r\n      window.parent.frames[2].document.location.href = \"code.jsp\";   \r\n      if (scoWinType != \"undefined\" && scoWinType != \"unknown\")\r\n      {\r\n         if (window.parent.frames[3].scoWindow != null)\r\n         {      \r\n            // there is a child content window so close it.\r\n            window.parent.frames[3].scoWindow.close();\r\n            window.parent.frames[3].scoWindow = null;\r\n         }\r\n         window.parent.frames[3].document.location.href = \"LMSMenu.jsp\";\r\n      }\r\n      else\r\n      {\r\n         //  scoWindow is undefined which means that the content frame\r\n         //  does not contain the lesson menu so do nothing...\r\n      }\r\n   }   \r\n}\r\n\r\n/****************************************************************************\r\n");
      out.write("**\r\n** Function: swapLayers()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function is used to swap the login and logout buttons\r\n**\r\n***************************************************************************/\r\nfunction swapLayers()\r\n{\r\n   if ( document.loginLayer.visibility == \"hide\" )\r\n   {\r\n      document.logoutLayer.visibility = \"hide\";\r\n      document.loginLayer.visibility = \"show\";\r\n   }\r\n   else\r\n   {\r\n      document.loginLayer.visibility = \"hide\";\r\n      document.logoutLayer.visibility = \"show\";\r\n   }\r\n}\r\n\r\n/****************************************************************************\r\n**\r\n** Function: init()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function sets the API variable and hides the\r\n**               the navigation buttons\r\n**\r\n***************************************************************************/\r\nfunction init()\r\n{\r\n   API = this.document.APIAdapter;\r\n   window.top.frames[0].document.forms[0].next.style.visibility = \"hidden\"; \r\n   window.top.frames[0].document.forms[0].previous.style.visibility = \"hidden\";\r\n");
      out.write("}\r\n\r\n/****************************************************************************\r\n**\r\n** Function: doConfirms()\r\n** Input:   none\r\n** Output:  none\r\n**\r\n** Description:  This function prompts the user that they may lose\r\n**               data if they exit the course\r\n**\r\n***************************************************************************/\r\nfunction doConfirm()\r\n{\r\n    if( confirm(\"If you quit now the course information may not be saved.  Do you wish to quit?\") )\r\n    {\r\n       window.parent.frames[3].document.location.href = \"LMSMenu.jsp\";\r\n    }\r\n    else\r\n    {\r\n    }\r\n}\r\n</script>\r\n</head>\r\n\r\n<body onload=\"init();\">\r\n\r\n<!--  For MS IE Use the Java 1.3 JRE Plug-in instead of the Browser's JVM\r\n      Netscape 4.x can't use the plug-in because it's liveconnect doesn't work with the Plug-in\r\n-->\r\n<form name=\"buttonform\">\r\n\r\n    <object classid=\"clsid:8AD9C840-044E-11D1-B3E9-00805F499D93\"\r\n            width=\"0\" height=\"0\" id=\"APIAdapter\"\r\n            codebase=\"http://java.sun.com/products/plugin/1.3/jinstall-13-win32.cab#Version=1,3,0,0\">\r\n");
      out.write("    <param name = \"code\" value = \"org/adl/samplerte/client/APIAdapterApplet.class\" >\r\n    <param name = \"codebase\" value = \"/adl\" >\r\n    <param name = \"type\" value=\"application/x-java-applet;version=1.3\">\r\n    <param name = \"mayscript\" value=\"true\" >\r\n    <param name = \"scriptable\" value=\"true\" >\r\n    <param name = \"archive\" value = \"cmidatamodel.jar,lmsclient.jar,debug.jar\" >\r\n    <comment>\r\n    <applet code=\"org/adl/samplerte/client/APIAdapterApplet.class\" \r\n            archive=\"cmidatamodel.jar,lmsclient.jar,debug.jar\" \r\n            codebase=\"/adl\"\r\n            src=\"/adl\" \r\n            height=\"1\" \r\n            id=\"APIAdapter\" \r\n            name=\"APIAdapter\" \r\n            width=\"1\" \r\n            mayscript=\"true\">\r\n    </applet>\r\n    </comment>\r\n    </object>\r\n       \r\n         \r\n    <table width=\"800\">\r\n    <tr valign=\"top\"> \r\n       <td>\r\n          <!--IMG ALIGN=\"Left\" SRC=\"/adl/adlLogo.gif\"/-->\r\n          <img align=\"Left\" src=\"/adl/tiertwo.gif\"/>\r\n       </td>\r\n       <td align=\"center\">   \r\n          <font color=\"purple\" face=\"Tahoma\" size=\"2\"><b>\r\n");
      out.write("             Advanced Distributed Learning <br>\r\n             Sharable Content Object Reference Model (SCORM&reg;) Version 1.2<br>\r\n          </b></font>\r\n          <font color=\"purple\" face=\"Tahoma\" size=\"2\"><b>\r\n             Sample Run-Time Environment<br>\r\n          </b></font>\r\n          <font color=\"purple\" face=\"Tahoma\" size=\"2\"><b>\r\n             Version 1.2.2\r\n          </b></font>\r\n       </td>\r\n    </tr>\r\n    </table> \r\n    \r\n     \r\n    <input type=\"hidden\" name=\"control\" value=\"\" />            \r\n    \r\n       \r\n    <!--NOLAYER-->\r\n    <table width=\"600\" align=\"left\" cellspacing=0>\r\n    <tr>\r\n       <td> \r\n          <input type=\"button\" value=\"Log In\" id=\"login\" name=\"login\" language=\"javascript\"\r\n                 onclick=\"return login_onclick();\">&nbsp;       \r\n          </td>\r\n       <td align=\"left\">\r\n          <input type=\"button\" value=\"Log Out\" id=\"logout\" name=\"logout\" style=\"visibility: hidden\"\r\n                 language=\"javascript\" onclick=\"return logout_onclick();\"> \r\n       </td>\r\n       <TD ALIGN=\"center\">\r\n");
      out.write("             <INPUT type=\"button\" ALIGN = \"right\" VALUE=\"    Quit    \" name=\"quit\" language=\"javascript\"\r\n                ONCLICK=\"doConfirm();\" STYLE=\"visibility: hidden\">\r\n       </TD>\r\n       <td align=\"left\">\r\n          <input type=\"button\" align =\"left\" value=\"Glossary\" id=\"glossary\" name=\"glossary\"  language=\"javascript\"\r\n                 onclick=\"return nextSco();\"  style=\"visibility: hidden\" disabled>&nbsp; \r\n       </td>\r\n       <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n       <td align=\"center\"> \r\n          \r\n          <input type=\"button\" align =\"right\" value=\"<- Previous\" id=\"previous\" name=\"previous\"  language=\"javascript\"\r\n                      onclick=\"return previousSCO();\"  style=\"visibility: hidden\"> \r\n          \r\n       </td>\r\n       <td align=\"center\">\r\n             \r\n             <input type=\"button\" align =\"right\" value=\"    Next ->    \" id=\"next\" name=\"next\"  language=\"javascript\"\r\n                    onclick=\"return nextSCO();\" style=\"visibility: hidden\">   \r\n");
      out.write("       </td>\r\n    </tr>\r\n</table>\r\n    \r\n<!--/NOLAYER-->\r\n</form>\r\n\r\n</body>\r\n</html>\r\n");
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
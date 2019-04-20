import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Cancelorder extends HttpServlet
 {

  
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
{
    PrintWriter pw = response.getWriter();
    String username = request.getParameter("username");
    String OrderId = request.getParameter("id");
    Utilities utility = new Utilities(request,pw);
	utility.printHtml("HeaderLogout.html");
    

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0L);
    

    pw.println("<section id=\"content\">");
  MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
	HttpSession session=request.getSession(false);
	mydata.CancelOrder(OrderId);
    pw.println("<br>");
    pw.println("<br>");
    pw.println("<br>");
    pw.println("<label><b><font size = \"15\">Your application is Succssfully canceled</font></b></label>");
    
    pw.println("</section>");
 	utility.printHtml("Sidebar.html");	
	utility.printHtml("Footer.html");
  }
}

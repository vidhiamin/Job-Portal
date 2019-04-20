import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class ViewOrder extends HttpServlet
{

  
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
    PrintWriter out = response.getWriter();
   String username = request.getParameter("username");
    Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\WEB-INF\\classes\\JobCatalog.xml");
		HashMap<String, Job> hm3 = handler.getJobs();		 
		HttpSession session=request.getSession();
		Users user =(Users)session.getAttribute("user");
		String uname = user.username;
    	MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		HashMap<String, OrderP> or = mydata.orderView(uname);
		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");	
    for (Map.Entry<String,OrderP> entry : or.entrySet())
    {
     OrderP job =(OrderP)entry.getValue();
      out.println("<section id=\"content\">");
      out.println("<h1>Candidate Applied for job</h1>");
      out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
      out.println("<thead>");
      out.println("<tr class=\"headings\">");
      out.println("<th class=\"\">Username</td>");
      out.println("<th class=\"\">ApplicationId</td>");
      out.println("<th class=\"\">Salary</td>");
      out.println("<th class=\"\">Cancel Application</td>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");
      out.println("<tr>");
      out.println("<td class=\"productName\">");
      out.println(job.getUsername());
      out.println("</td>");
      out.println("<td class=\"productName\">");
      out.println(job.getOrderId());
      out.println("</td>");
      out.println("<td class=\"productName\">");
      out.println(job.getsalary());
      out.println("</td>");
      out.println("<td class=\"productName\">");
      out.println("<a href=\"Cancelorder?id=" + job.getOrderId() + "\" class=\"btn btn-success\" role=\"button\">Withdraw Application</a></p>");
      out.println("</td>");
      out.println("</tr>");
      out.println("</tbody>");
      
      out.println("</table>");
      out.println("</section>");
    }
    utility.printHtml("Sidebar.html");
    utility.printHtml("Footer.html");
  }
}

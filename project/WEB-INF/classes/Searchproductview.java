import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;





public class Searchproductview
  extends HttpServlet
{
  AjaxUtilities au = new AjaxUtilities();
  HttpSession session;
  public PrintWriter out;
	Utilities utility;
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
	  HttpSession session=request.getSession();  
		PrintWriter out= response.getWriter();
		MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
		Job job = (Job)request.getAttribute("Job_obj");
		utility = new Utilities(request,out);
		Users users  = new Users();
		users= (Users)session.getAttribute("user");
    if (session.getAttribute("user")!= null)
    {
      utility.printHtml("HeaderLogout.html");
    }
    else
    {
      utility.printHtml("Header.html");
    }
    out.println("<div id=\"body\">");
    out.println("<section id=\"content\">");
    out.println("<article>");
    out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
    out.println("<thead>");
    out.println("<tr class=\"headings\">");
    out.println("<th class=\"link\">&nbsp;</th>");
    out.println("<th class=\"link\">&nbsp;</th>   ");
    out.println("</tr>");
    out.println("</thead>");
    out.println("<tbody>");
    out.println("<tr>");
    out.println("<ul>");
    out.println("<li class=\"desc\"> Company Name : " + job.getCompanyName() + "</li>");
    out.println("<li>Salary: $" + job.getSalary() + "</li>");
    out.println("<li><a href=\"ViewJob?id=" + job.getId() + "&&category=" + job.getCategory() + "\" class=\"btnreview\">View Job</a></li>");
    
    out.println("</ul>");
    out.println("</tr>");
    out.println("</tbody>");
    out.println("</table>");
    out.println("</article>");
    out.println("</section>");
    utility.printHtml("Sidebar.html");
    utility.printHtml("Footer.html");
  }

}

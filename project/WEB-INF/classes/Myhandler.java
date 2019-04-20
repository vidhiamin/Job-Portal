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



public class Myhandler extends HttpServlet
{
	public 	PrintWriter out;
	Utilities utility;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
	PrintWriter out= response.getWriter();
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\WEB-INF\\classes\\JobCatalog.xml");
		String makers= request.getParameter("category");
		//out.println(makers);
		HashMap<String, Job> hm2 = ms.checkjob(makers);
		utility = new Utilities(request,out);
		HttpSession session=request.getSession(); 
		Users user = (Users)session.getAttribute("user");
		if(session.getAttribute("user")!= null )  
		{
		
			utility.printHtml("HeaderLogout.html");
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
			for(Map.Entry<String,Job> entry : hm2.entrySet())
			{
				Job job=(Job)entry.getValue();
				out.println("  <div class=\"col-sm-12 col-md-6\">" +
								"    <div class=\"thumbnail\">" +
								/* " <h3>Name:" + job.getCompanyName() + "</h3>" + */
								"      <div class=\"caption text-center\">" +
								"        <p align=\"left\"><b>Company Name:</b>" + job.getCompanyName() + "</p>" +
								"        <p align=\"left\"><b>Category:</b>" + job.getCategory() + "</p>" +
								"        <p align=\"left\"><b>Job Type:</b> " + job.getJobType() + "</p>" +
								"        <p align=\"left\"><b>Salary:</b> " + job.getSalary() + "</p>" +
								"        <p align=\"left\"><b>Job Position:</b> " + job.getJobPosition() + "</p>" +
								"        <p align=\"left\"><b>State:</b> " + job.getState() + "</p>" +
								
								"        <p><a href=\"ViewJob?id="+job.getId()+"&&category=" +job.getCategory()+"\"class=\"btn btn-primary\" role=\"button\">View Job</a></p>" +												
								"      </div>" +
								"    </div>" +
								"	</div>");
				
			}
				out.println("</tr>");
				out.println("</tbody>");
				out.println("</table>");
				out.println("</article>");
				out.println("</section>");
				utility.printHtml("Sidebar.html");
				utility.printHtml("Footer.html");
		
		}
		else
		{
			utility.printHtml("Header.html");
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
			for(Map.Entry<String,Job> entry : hm2.entrySet())
			{
				Job job=(Job)entry.getValue();
				
				out.println("  <div class=\"col-sm-12 col-md-6\">" +
								"    <div class=\"thumbnail\">" +
								/* " <h3>Name:" + job.getCompanyName() + "</h3>" + */
								"      <div class=\"caption text-center\">" +
								"        <p align=\"left\"><b>Company Name:</b>" + job.getCompanyName() + "</p>" +
								"        <p align=\"left\"><b>Category:</b>" + job.getCategory() + "</p>" +
								"        <p align=\"left\"><b>Job Type:</b> " + job.getJobType() + "</p>" +
								"        <p align=\"left\"><b>Salary:</b> " + job.getSalary() + "</p>" +
								"        <p align=\"left\"><b>State:</b> " + job.getState() + "</p>" +
								"        <p align=\"left\"><b>Job Position:</b> " + job.getJobPosition() + "</p>" +
						/* 							"        <p align=\"left\"><b>Job Description:</b> " + job.getJobDescription() + "</p>" + */
								"        <p><a href=\"ViewJob?id="+job.getId()+"&&category=" +job.getCategory()+"\"class=\"btn btn-primary\" role=\"button\">View Job</a></p>" +												
								"      </div>" +
								"    </div>" +
								"	</div>");
				
			}
				out.println("</tr>");
				out.println("</tbody>");
				out.println("</table>");
				out.println("</article>");
				out.println("</section>");
				utility.printHtml("Sidebar.html");
				utility.printHtml("Footer.html");
			
			
			
			
			
		}

	}
}
    

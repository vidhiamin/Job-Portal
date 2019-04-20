import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Review extends HttpServlet 
{
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		out= response.getWriter();
		String companyname = request.getParameter("companyname");
		String salary = request.getParameter("salary");
		//String image =  request.getParameter("image") ;
		String category = request.getParameter("category");
		//String JobDescription = request.getParameter("description");
		String jobtype = request.getParameter("jobtype");
		String jobposition = request.getParameter("jobposition");
		String state = request.getParameter("state");
		MongoDbDataStoreUtility mg = new MongoDbDataStoreUtility();
		HttpSession session=request.getSession();  
		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");
		Users user =(Users)session.getAttribute("user");

		
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
		out.println("<li class=\"desc\">Company Name : " + companyname +"</li>");
		out.println("<li>Salary: $" + salary + "</li>");	
		out.println("<li>category:" + category + "</li>");
		out.println("<li>Job Type:" + jobtype + "</li>");
		out.println("<li>Job Position:" + jobposition + "</li>");
		out.println("<li>State:" + state + "</li>");
		out.println("</ul>");
		
		out.println("<form action =\"ShowReview\"  method=\"get\">");
		out.println("<div class=\"container username\">");
		out.println("<input type=\"hidden\"  value= "+ companyname +" name=\"companyname\" >");
		out.println("<input type=\"hidden\"  value= "+ salary +" name=\"salary\" >");
		out.println("<input type=\"hidden\"  value= "+ category +" name=\"category\" >");
		out.println("<input type=\"hidden\"  value= "+ jobtype +" name=\"jobtype\" >");
		out.println("<input type=\"hidden\"  value= "+ jobposition +" name=\"jobposition\" >");
		out.println("<input type=\"hidden\"  value= "+ state +" name=\"state\" >");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Full Name:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" placeholder=\"Enter Full Name\" name=\"fullname\" >");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Email Address:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" placeholder=\"Enter email\" name=\"email\" >");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Gender:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" placeholder=\"Enter your Gender\" name=\"gender\" >");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Occupation:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" placeholder=\"Enter Occupation\" name=\"occupation\" >");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Age:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" placeholder=\"Enter your Age\" name=\"age\" >");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Address:</b></label>");
		out.println("<textarea rows=\"4\" cols=\"20\" class=\"form-control\" name =\"address\" required>");
		out.println("</textarea>");
		out.println("</div>");
	
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Experience History:</b></label>");
		out.println("<textarea rows=\"4\" cols=\"20\" class=\"form-control\" name =\"experience\" required>");
		out.println("</textarea>");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Education and Experience:</b></label>");
		out.println("<textarea rows=\"4\" cols=\"20\" class=\"form-control\" name =\"education\" required>");
		out.println("</textarea>");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Related Projects and Skills:</b></label>");
		out.println("<textarea rows=\"4\" cols=\"20\" class=\"form-control\" name =\"projects\" required>");
		out.println("</textarea>");
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<a class=\"lbutton\"><button type=\"submit\">Submit Application</button></a>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");

		
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</article>");
		//  out.println("</div>");
		out.println("</section>");
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");	
	}
}
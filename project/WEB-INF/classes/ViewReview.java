      import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewReview extends HttpServlet
{
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
	out= response.getWriter();
	//String rating = request.getParameter("usertype");
	//String Price = request.getParameter("TextReview");
	String companyname =  request.getParameter("companyname") ;
	//String Uname =  request.getParameter("username7") ;
	//String Textreview = request.getParameter("TextReview");
	MongoDbDataStoreUtility mg = new MongoDbDataStoreUtility();
	//	mg.insertReview(rating,name,Textreview,Uname);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("HeaderLogout.html");
	//out.println(rating);
	//out.println(Price);
	HashMap<String, ArrayList<ReviewP>> reviewHashmap =mg.selectReview();
		if(reviewHashmap.containsKey(companyname))
		{
		ArrayList<ReviewP> reviews = reviewHashmap.get(companyname);
		out.println("<section id=\"content\">");
		out.println("<h1>Candidate Applications</h1>");
		out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
		out.println("<thead>");
		out.println("<tr class=\"headings\">");
		out.println("<th class=\"\">fullname</td>");
		out.println("<th class=\"\">category</td>");
		out.println("<th class=\"\">companyname</td>");
		out.println("<th class=\"\">state</td>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(ReviewP pojo : reviews)
		{
			out.println("<tr>"); 
			out.println("<td class=\"fullname\">");
			out.println(pojo.getfullname());
			out.println("</td>");
			out.println("<td class=\"category\">");
			out.println(pojo.getcategory());
			out.println("</td>");
			out.println("<td class=\"companyname\">");
			out.println(pojo.getcompanyname());
			out.println("</td>");
			out.println("<td class=\"state\">");
			out.println(pojo.getstate());
			//System.out.println("========	Uname is viewreview in pojo is here================="+pojo.getusername()+"=====================");
			out.println("</td>");
			out.println("</tr>");
		}
		
		out.println("</tbody>");
		out.println("</table>");
		out.println("</section>");
		}
	
	utility.printHtml("Sidebar.html");
	utility.printHtml("Footer.html");	
	}
}
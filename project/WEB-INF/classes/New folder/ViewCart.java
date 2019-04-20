import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ViewCart extends HttpServlet
{
  Utilities utility;
  PrintWriter out;
  java.util.List<Cart> arraylist;
  
  public ViewCart() {}
  
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
		out= response.getWriter();
		String username = request.getParameter("username");
		Utilities utility = new Utilities(request,out);
		Random rand = new Random();
		//Users user =(Users)session.getAttribute("user");
		int  n = rand.nextInt(50) + 1;
		String ran = "OA2038" + n;
		HttpSession session=request.getSession();
		arraylist = (ArrayList<Cart>)session.getAttribute("cartitem");  
		String check = request.getParameter("input");
    if (arraylist != null)
    {
      utility.printHtml("HeaderLogout.html");
      
      out.println("<section id=\"content\">");
      
      out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
      out.println("<thead>");
      out.println("<tr class=\"headings\">");
      out.println("<th class=\"link\">&nbsp;</th>");
      out.println("<th class=\"link\">&nbsp;</th>   ");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");
      out.println("<tr>");
      int j = 0;
      for (Cart cart : arraylist)
      {
        out.println("<article>");
        out.println("<ul>");
        out.println("<li class=\"desc\">Company Name : " + cart.getCompanyName() + "</li>");
        out.println("<li>Salary: $" + cart.getSalary() + "</li>");
        out.println("<li>Category:" + cart.getCategory() + "</li>");
        out.println("<li>JobType:" + cart.getJobType() + "</li>");
        out.println("<li>JobPosition:" + cart.getJobPosition() + "</li>");
        System.out.println("===========job position in viewcart=====" + cart.getJobPosition());
        out.println("<li>State:" + cart.getState() + "</li>");
        out.println("</ul>");
        out.println("</article>");
      }
      

      out.println("<form action=\"Order\" method=\"get\">");
      out.println("<div class=\"container username\">");
      out.println("<div class=\"username1\">");
      out.println("<a class=\"lbutton\"  ><button type=\"submit\">Submit</button></a>");
      out.println("</div>");
      out.println("</div>");
      out.println("</form>");
      out.println("</tr>");
      out.println("</tbody>");
      out.println("</table>");
      out.println("</section>");
      utility.printHtml("Sidebar.html");
	   utility.printHtml("Footer.html");
    }
    else
    {
			utility.printHtml("HeaderLogout.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
    }
  }
}

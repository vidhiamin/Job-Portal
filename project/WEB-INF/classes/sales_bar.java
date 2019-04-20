import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class sales_bar extends HttpServlet
{
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
                     
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		HttpSession session=request.getSession();  
		Users user = (Users)session.getAttribute("user");
		Utilities utility = new Utilities(request,out);
		if(session.getAttribute("user")!= null )  
		{
			utility.printHtml("HeaderAdmin.html");
			out.println("<div id=\"body\">");
			out.println("<section id=\"content\">");
			out.println("<article>");
			out.println("<h2 align=\"center\" margin-top=\"60px\">Category Vised Application</h2>");
			out.println("<div id=\"piechart_sales\" ></div>" );
			out.println("</article>");
			out.println("</section>");
			utility.printHtml("SidebarAdmin.html");
			utility.printHtml("Footer.html");
		}
		else
		{
			utility.printHtml("Header.html");
			utility.printHtml("job.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	}
}
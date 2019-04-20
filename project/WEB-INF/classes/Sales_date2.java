import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Sales_date2 extends HttpServlet
{
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
                         
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		HttpSession session=request.getSession();  
		ArrayList<OrderP> Orders;
		Users user = (Users)session.getAttribute("user");
		Utilities utility = new Utilities(request,out);
		if(session.getAttribute("user")!= null )  
		{
		Orders=ms.checkSalesdate2();
		utility.printHtml("HeaderAdmin.html");
		out.println("<div id=\"body\">");
		out.println("<section id=\"content\">");
		out.println("<article>");
		out.println("<h2 align=\"center\" margin-top=\"60px\">Category Vised Application</h2>");
		out.println("<table cellspacing=\"0\" class=\"shopping-cart\"  style=\"Height:50px\"> ");
		out.println("<thead>");
		out.println("<tr class=\"headings\">");
		out.println("<th class=\"\">No.</td>");
		out.println("<th class=\"\">Date</td>");
		out.println("<th class=\"\">CompanyName</td>");
		out.println("<th class=\"\">Count</td>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		out.println("<tr>");
		int i= 1;
		for(OrderP order : Orders)
		{
			out.println("<tr>"); 
			out.println("<td class=\"productName\">");
			out.println(i++);
			out.println("</td>");
			out.println("<td class=\"productName\">");
			out.println(order.getDate());
			out.println("</td>");
			out.println("<td class=\"productName\">");
			out.println(order.getCompanyName());
			out.println("</td>");
			
			out.println("<td class=\"productName\">");
			out.println(order.getCount());
			out.println("</td>");
			
			
			
			out.println("</tr>");
		}
				out.println("</tr>");
				out.println("</tbody>");
				out.println("</table>");
				out.println("</article>");
				out.println("</section>");
			utility.printHtml("SidebarAdmin.html");
			utility.printHtml("Footer.html");
		}
		else
		{

		utility.printHtml("Header.html");
		utility.printHtml("product.html");
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");
		}

	
	}
}
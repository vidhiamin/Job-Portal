import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Order extends HttpServlet {
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;

  
 
  
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
                   
    MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();  

    String salary = request.getParameter("salary");
    
    String jobtype = request.getParameter("jobtype");
    String state = request.getParameter("state");
    String jobposition = request.getParameter("jobposition");
	String companyname = request.getParameter("companyname");
    String experiencelevel = request.getParameter("experiencelevel");
    System.out.println("============job position in order class=========" + jobposition);
    
	System.out.println("============CompanyNAME in order class=========" + companyname);

    System.out.println("============jobtype=========" + jobtype);
    out = response.getWriter();
    String jobid = "";
    HttpSession session=request.getSession();
    Utilities utility = new Utilities(request, out);
    if (session.getAttribute("user") != null)
    {
      utility.printHtml("HeaderLogout.html");
      Random rand = new Random();
      Users user =(Users)session.getAttribute("user");
      System.out.println("==========in order in username" + user);
      ArrayList<Cart> list =(ArrayList<Cart>)session.getAttribute("cartitem");
    int  n = rand.nextInt(50) + 1;
	String username = (String)user.getusername();
	java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
      for (Cart cart : list)
      {
        jobid = cart.getJobId();
        salary = cart.getSalary();
        jobtype = cart.getJobType();
        state = cart.getState();
        jobposition = cart.getJobPosition();
		companyname = cart.getCompanyName();
		experiencelevel = cart.getExperienceLevel();
		
        
        String ran = "OA2038" + n;
		System.out.println("============random number in order ======" + ran);
        mydata.insertJobOrder(ran,companyname, username, salary, jobid, sqlDate,jobtype, jobposition, state, list);
      }
	   out.println("<form action=\"Form\" method=\"get\">");
	   out.println("</form>");
      
      utility.printHtml("Sidebar.html");
      utility.printHtml("Footer.html");
      request.getRequestDispatcher("/Form").forward(request, response);
    }
    else
    {
      out.println("Not e to Order Anything");
    }
  }
}

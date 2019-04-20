import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class dproduct extends HttpServlet
{
  Job jobup;
  PrintWriter out;
  HashMap<String, Job> jobdelete = null;
  
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
	HttpSession session=request.getSession();  
	out= response.getWriter();
	
    String product_id = request.getParameter("id");
    String product_category = request.getParameter("category");
    String product_companyname = request.getParameter("companyname");
    String product_jobtype = request.getParameter("jobtype");
    String product_jobposition = request.getParameter("jobposition");
    String product_jobdescription = request.getParameter("jobdescription");
    String product_state = request.getParameter("state");
    int product_salary = Integer.parseInt(request.getParameter("salary"));
    String product_experiencelevel = request.getParameter("experiencelevel");
    
    Utilities utility = new Utilities(request,out);
    
    jobup = new Job();
    jobup.setId(product_id);
    jobup.setCompanyName(product_companyname);
    jobup.setCategory(product_category);
    jobup.setJobType(product_jobtype );
    
    jobup.setSalary(product_salary);
    jobup.setJobPosition(product_jobposition);
    jobup.setJobDescription(product_jobdescription);
    jobup.setState(product_state );
    jobup.setExperienceLevel(product_experiencelevel);
    System.out.println("=============after");
    if(session.getAttribute("ProductMap")!= null)
    {
      jobdelete = (HashMap<String,Job>)session.getAttribute("JobMap");
      if (jobdelete.containsKey(product_companyname))
      {
        jobdelete.remove(product_companyname);
		
      }
      session.setAttribute("JobMap", jobdelete);
    }
		utility.printHtml("HeaderAdd.html");
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		int hm2;
		hm2 = mydata.deletejob(product_id,product_category);
		System.out.println("===============Successfully deleted");
		
		out.println("<section id=\"content\">");
		out.println("<h2 style=\"color:red\"> Your job is succesfully Deleted </h2>"); 
		out.println("</section>"); 
		utility.printHtml("SidebarManager.html");
		utility.printHtml("Footer.html");
  }
}

import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ShowReview extends HttpServlet
{
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		out= response.getWriter();
		String companyname = request.getParameter("companyname");
		System.out.println("********************************************"+companyname);
		String salary = request.getParameter("salary");
		String category = request.getParameter("category");
		String jobtype = request.getParameter("jobtype");
		String jobposition = request.getParameter("jobposition");
		String state = request.getParameter("state");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String occupation = request.getParameter("occupation");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String experience = request.getParameter("experience");
		String education = request.getParameter("education");
		String projects = request.getParameter("projects");
		
		
		/* String rating = request.getParameter("usertype");
		String Price = request.getParameter("TextReview");
		String name =  request.getParameter("username5") ;
		String Uname =  request.getParameter("username7") ;
		String price= request.getParameter("price");
		String date = request.getParameter("date");
		String category= request.getParameter("category");
		String gender = request.getParameter("gender");
		String occupation = request.getParameter("occupation");
		String age = request.getParameter("age");
		String manufactureRebate= request.getParameter("manufactureRebate");
	
		String RetailerName = "SmartPortables";
		String RetailerZip = "60616";
		String RetailerCity = "Chicago";
		String RetailerState = "IL";
		String ProductOnSale = "Yes"; */
		
		
		String manufacture= request.getParameter("manufacture");
		//System.out.println("========	Uname is showreview is here================="+Uname+"=====================");
		//System.out.println("========date is here================="+date+"=====================");
		String Textreview = request.getParameter("TextReview");
		MongoDbDataStoreUtility mg = new MongoDbDataStoreUtility();
		mg.insertReview(companyname, salary, category, jobtype, jobposition, state, fullname, email, gender, occupation, age, address, experience, education, projects);
		request.getRequestDispatcher("/ViewReview?companyname="+companyname).forward(request, response);
		
	}
}
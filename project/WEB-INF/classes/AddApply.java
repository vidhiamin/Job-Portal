import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class AddApply extends HttpServlet
{
  PrintWriter out;
	List<Cart> arraylist;
  

  
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
    out= response.getWriter();
    String username = request.getParameter("username");
    String jobid = request.getParameter("id");
    //System.out.println("==========job id is here========" + str2);
    String companyname = request.getParameter("companyname");
    String salary = request.getParameter("salary");
    String jobtype = request.getParameter("jobtype");
    String category = request.getParameter("category");
    String state = request.getParameter("state");
    String jobposition = request.getParameter("jobposition");
	String experiencelevel = request.getParameter("experiencelevel");
    

    System.out.println("==========compaany name========" + companyname);
    System.out.println("==========jobtype name========" + jobtype);
    System.out.println("==========jobposition name========" + jobposition);
    

   arraylist = new ArrayList<Cart>();
    addToCart(companyname,username ,jobid, salary, jobtype, category, state, jobposition, experiencelevel,request);
    request.getRequestDispatcher("/ViewCart").forward(request, response);
  }
  
  public void addToCart(String companyname, String username,String jobid, String salary, String jobtype, String category, String state, String jobposition,String experiencelevel, HttpServletRequest request)
  {
		int id=0;
        HttpSession session = request.getSession();
		out.println("addcart method");       
        List<Cart> list = (ArrayList) session.getAttribute("cartitem");
		MySqlDataStoreUtilities mySqlDataStoreUtilities = new MySqlDataStoreUtilities();
        if(list==null)
		{
			id += 1;
			Cart cart = new Cart(companyname,username,salary,category,jobid,jobtype,jobposition,id, state ,experiencelevel);
			arraylist.add(cart);
            session.setAttribute("cartitem", arraylist);
			out.println("hi-if");

    }
    else
    {
			id = list.size() + 1;
			Cart cart = new Cart(companyname,username,salary,category,jobid,jobtype,jobposition,id, state,experiencelevel );
			arraylist = list;
            arraylist.add(cart);
            session.setAttribute("cartitem", arraylist);
			out.println("hi-else");
    }
  }
}

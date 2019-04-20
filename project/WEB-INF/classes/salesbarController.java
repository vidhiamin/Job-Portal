import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.json.JSONObject;
import com.google.gson.Gson;

public class salesbarController extends HttpServlet
 {
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	public void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		HttpSession session=request.getSession();  
		ArrayList<Job> jobs;
		Users user = (Users)session.getAttribute("user");
		Utilities utility = new Utilities(request,out);
		
		if(session.getAttribute("user")!= null )  
		{	
			jobs = ms.checkSales();
			Gson gson = new Gson();
			String jsonString=gson.toJson(jobs);
			out.println(jsonString);
			System.out.println("");
		}
	}
}

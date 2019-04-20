import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class DealMatches extends HttpServlet {
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
	HashMap<String,Job> selectjob = null;
	HashMap<String,Job> jobs = null;
	ArrayList<String> tweets;
	
	
	
	public ArrayList<String> getTweets()
	{
		return tweets;
	}
	
	
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		out= response.getWriter();
Utilities utility = new Utilities(request,out);
	  }
	  
	  
		
		public HashMap<String,Job> getJobData()
		{
			
			MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
			jobs = mydata.getJobData();
		
			String TOMCAT = System.getenv("CATALINA_HOME");
			selectjob = new HashMap<String,Job>();
			tweets = new ArrayList<String>();

			try
			{
				String line = null;
				for(Map.Entry<String,Job> entry : jobs.entrySet())
				{					
				  if(selectjob.size() < 2 && !(selectjob.containsKey(entry.getKey())))
				  {
					  BufferedReader br = new BufferedReader(new FileReader(new File("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\Html\\jobmatches.txt")));
					  
					  line = br.readLine();					  
					  
					  if(line != null)
					  {
						do
						{	
						
							if(line.contains(entry.getKey()))
							{								
								tweets.add(line);
								selectjob.put(entry.getKey(),entry.getValue());
								
								break;
							}								
						}while((line = br.readLine()) != null);  
					  }
					  else
					  {
						  System.out.println("line is null");
						  return null;						
					  }
					  
				  }
					
				}
				
			}
			
			catch(Exception e)
			{
					e.printStackTrace();
					return null;
			}	
			return selectjob;
		}
}
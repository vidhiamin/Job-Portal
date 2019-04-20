
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.lang.Object;
import java.net.URLConnection;
import java.net.*;
import java.util.*;

public class Utilities extends HttpServlet{
	
	HttpServletRequest req;
	PrintWriter pw;
	HttpSession session;
	String url;
  Users user;
	
	public Utilities(HttpServletRequest req, PrintWriter pw)
	{
		this.req=req;
		this.pw=pw;
		this.url=this.fetchURL();
	}
	
	public void printHtml(String htmlFile)
	{	
	//pw.println("hi");
		String result=HtmlToString(htmlFile);
		//pw.println("hi");
		StringBuffer sb = new StringBuffer();
		sb.append("");
		//pw.println(sb);
		
		/*if(htmlile == "Header.Html")
		{
			HttpSession session=req.getSession(); 
			if(session.getAttribute("user") != null)
			{
				Users user= (Users)session.getAttribute("user");
				sb.append("<li class=\"register\"> <a href=\"./Registration\" >register</a></li><li class=\"login\"> <a href=\"LogoutServlet\" >logout</a></li><li class=\"login\">"+user.getfirstname()+"</li>");
			}
			else
			{
				sb.append("<li class=\"register\"> <a href=\"./Registration\" >register</a></li><li class=\"login\"> <a href=\"./Login\" >login</a></li>");
			}
			
		}*/
		
		
	}
	
	public String fetchURL()
	{
		String scheme=req.getScheme();
		//pw.println(scheme);
		String server=req.getServerName();
		//pw.println(server);
		int port=req.getServerPort();
		//pw.println(port);
		String path=req.getContextPath();
		//pw.println(path);
		StringBuffer sb=new StringBuffer();
		sb.append(scheme).append("://").append(server);
		if((port!=80))
		{
			sb.append(":").append(port);
		}
		sb.append(path).append("/Html/");
		return sb.toString();
	}
	
	public String HtmlToString(String htmlFile)
	{
		String text=null;
		String newPage=url+ htmlFile;
		//pw.print(newPage);
		try
		{
			URL url = new URL(newPage);
			//pw.println(url);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			InputStreamReader inr= new InputStreamReader(in);
			int readChars;
			char[] arr=new char[1024];
			StringBuffer sb=new StringBuffer();
			while((readChars=inr.read(arr)) > 0)
			{
				sb.append(arr,0,readChars);
			}
			
			text=sb.toString();
			pw.println(text);
			//log(text);
			//System.out.println(text);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//e.printStace();
		}
		
		return text;
	}
	
}
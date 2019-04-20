import java.sql.*;
import java.io.*; 
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class AjaxUtilities
{	
	Connection con = null;
	PreparedStatement ps= null;
	public boolean getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
			if(con!=null)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		} 
	}
    public HashMap<String, Job> getJob()
	{
		HashMap<String, Job> hm = new HashMap<String, Job>();
        Job job = new Job();
        try {
            Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
			ps = con.prepareStatement("select * from job"); 
			ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                Job item = new Job();
                item.setCompanyName(rs.getString("companyname"));
                item.setSalary(rs.getInt("salary"));
                System.out.println("=======jobtype=========");
                item.setJobType(rs.getString("jobtype"));
                item.setCategory(rs.getString("category"));
                item.setExperienceLevel(rs.getString("experiencelevel"));
                hm.put(item.getCompanyName(), item);
            }
            
            return hm;
        }
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		finally 
		{
			try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
    }
}

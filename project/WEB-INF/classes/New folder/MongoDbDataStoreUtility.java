import com.mongodb.*;
import java.util.*;
import java.io.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.*;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import static java.util.Arrays.asList;

public class MongoDbDataStoreUtility
{
	  DBCollection myApplications;
	public  void getConnection()
	{
		
		MongoClient mongo;
		mongo = new MongoClient("localhost",27017);
		
		DB db = mongo.getDB("Applications");
		myApplications =db.getCollection("myApplications");
		
	}


	public  void insertReview(String companyname, String salary,String category, String jobtype,String jobposition,String state,String fullname,String email,String gender,String occupation, String age,String address, String experience, String education,String projects)
	{
		getConnection();
		BasicDBObject doc = new BasicDBObject("title","myApplications").
		append("companyname",companyname).
		append("salary",salary).
		append("category",category).
		append("jobtype",jobtype).
		append("jobposition",jobposition).
		append("state",state).
		append("fullname",fullname).
		append("email",email).
		append("gender",gender).
		append("occupation",occupation).
		append("age",age).
		append("address",address).
		append("experience",experience).
		append("education",education).
		append("projects",projects);
		//append("ProductOnSale",ProductOnSale).
		
		//append("Review",Review);
		myApplications.insert(doc);
		
	}
	public  HashMap<String, ArrayList<ReviewP>> selectReview()

	{

		getConnection();

		HashMap<String, ArrayList<ReviewP>> reviewHashmap=new HashMap<String, ArrayList<ReviewP>>();
		DBCursor cursor = myApplications.find();

		while (cursor.hasNext())				
					
		{							
		BasicDBObject obj = (BasicDBObject) cursor.next();		
		if(! reviewHashmap.containsKey(obj.getString("companyname")))
		{							
									
		ArrayList<ReviewP> arr = new ArrayList<ReviewP>();				
		reviewHashmap.put(obj.getString("companyname"), arr);		
		}							
		ArrayList<ReviewP> listReview = reviewHashmap.get(obj.getString("companyname"));
		ReviewP review =new	ReviewP(obj.getString("companyname"),obj.getString("salary"),obj.getString("category"),obj.getString("jobtype"),obj.getString("jobposition"),obj.getString("state"),obj.getString("fullname"), obj.getString("email"),obj.getString("gender"),obj.getString("occupation"),obj.getString("age"),obj.getString("address"),obj.getString("education"), obj.getString("projects"));		
		listReview.add(review);							
	}					//Iterate through Cursor	
							
						//and Store each review	
	return  reviewHashmap;					
					//into class object	
}
/* public  ArrayList <Bestrating> LikedProducts(){
	  ArrayList <Bestrating> Bestrate = new ArrayList <Bestrating> ();
	  try{
		  System.out.println("top5");
	  //getConnection();
	  MongoClient mongo;
		mongo = new MongoClient("localhost",27017);
		
		DB db = mongo.getDB("Review");
		myReviews =db.getCollection("myReviews");
	  int retlimit =5;
	  DBObject sort = new BasicDBObject();
	  sort.put("rating",-1);
	  DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
	  //System.out.println(cursor);
	  while(cursor.hasNext()) {
		  //System.out.println("alsiddi");
		  BasicDBObject obj = (BasicDBObject) cursor.next();
		  System.out.println(obj.get("prodcutname").toString()+obj.get("rating").toString());		  		   
		  String prodcutnm = obj.get("prodcutname").toString();
		  String rating = obj.get("rating").toString();
	      Bestrating best = new Bestrating(prodcutnm,rating);
		  Bestrate.add(best);
	  }
	
	}catch (Exception e){ System.out.println(e.getMessage());}
   return Bestrate;
  }			 */				
	
}
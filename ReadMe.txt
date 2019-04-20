Readme Instruction:


•	MySql Server :

•	You need to refer Mysql.docx file which is attached. You need to follow instruction given in that file to setup the MySql database for project.


•	MongoDb Server : 

•	To use MongoDb server you need to first run the mongod.exe file from your c drive. After running mongod.exe file you need to run mongo.exe file.
•	You can see “>” arrow like this. Now to go to database file you need to write command as given below.

•	Use Applications

•	To see collection in the database you need to write command given below.

•	Db.myApplications.find()

•	You can see screenshot of it in output.pdf file which is attached in folder.


•	Python file Steps:
	
•	Start Anaconda prompt, Launch jupyter notebook put the path C:\tomcat-7.0.34-preconfigured\apache-tomcat-7.0.34\webapps\project\Html

•	Refresh the localhost terminal.

•	Run the Python file BestBuyDealMatches.ipynb by running all cells.

• 	It will generate jobmatches.txt file.

•	We have reffered python file given by proffesor for assignments and also added some python code to implement our api to show Jobs on Home page.


•	Project Configuration Steps:

•	To setup the project in your local machine, first of all you need to
	Unzip the folder named project to your machine and put it under your webapps folder.

•	Set the class path C:\tomcat-7.0.34-preconfigured\apache-tomcat-7.0.34\webapps\project\WEB-INF\classes

•	Run the java classes javac *.java

•	After putting folder in the webapps you need to open cmd there and go to project/WEB-INF/Classes using cd command and after reaching there you can run below command to compile all java files.

•	Javac *.java

•	After Compiling it you can run the project in your machine. You need to open browser and type URL like localhost/project/Home which redirects you to Home Page of the application.
 
•	Approximately, 5000 lines of code is written to implement this Job board Web Application.


Assignment Implemented Featuresin our Website:
User(Candidate)
    Establish own Profile
    View and Search Job Opportunities
    Apply for the Job
	Withdraw Application
    Trending Jobs(Twitter API)
Company Recruiter
    Post Detailed Job Position
	Update Job Position
	Withdraw Job Position
Admin
	Review List of all Job Positions
    Review daily job application report
    Review Category wise application report
	Chart for Category Vised Application

Not Implemented Assignment Features
-recommender
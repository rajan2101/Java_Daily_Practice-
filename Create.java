import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class Create {

	public static void main(String[] args) 
	{
	
		String url="jdbc:mysql://localhost:3306/ClientDB";
		String user="root";
		String Upass="Rajan@123";
		String Create="create table demo1011 (std_id varchar(20) primary key,std_name varchar(20))";
		try {
			//1.Register driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Create connection
			Connection con=DriverManager.getConnection(url, user, Upass);
			//3.Execute Statement
			Statement st=con.createStatement();
			//4.Execute Query
			st.execute(Create);
			System.out.println("Table Created");
			//5.Close connection 
			con.close();
			
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

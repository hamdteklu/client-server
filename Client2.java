import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Client2
{
	public static void main(String args[])
	{
		ArrayList<University> universityList= new ArrayList<University>();
		Socket connection;
		ObjectOutputStream output;
		ObjectInputStream inputFromServer;
		double totalTution;
		Object obj;
	
		try
		{
			
			connection= new Socket("localhost", 8000);// machine port
			
			output=new ObjectOutputStream(connection.getOutputStream());
			inputFromServer= new ObjectInputStream(connection.getInputStream());

			universityList.add(new University("UNT", 20, 5));
			universityList.add(new University("SMU", 33, 7));
			universityList.add(new University("TWU", 9, 8));

			output.writeObject(universityList);
			output.flush();

			obj= inputFromServer.readObject();
			universityList= (ArrayList<University>)obj;

			for(University u: universityList)
				{

					System.out.println(u.toString());

				}
		}
		
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
			
		
		
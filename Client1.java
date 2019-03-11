import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Client1
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

			universityList.add(new University("UTA", 10, 5));
			universityList.add(new University("TCU", 13, 7));
			universityList.add(new University("UTD", 19, 8));

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
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.util.ArrayList;

public class Server
{
	public static void main(String args[])
	{		
		ServerSocket serverSocket;
		Socket connection;
		
		try
		{
			serverSocket= new ServerSocket(8000);// connect to client 
			int clientNo= 1;
			ExecutorService threadExecutor= Executors.newCachedThreadPool();
			
			while (true)
			{
				connection= serverSocket.accept();
				System.out.println("");
				System.out.println("Started thread for client "+clientNo);
				
				HandleAClient thread= new HandleAClient(connection, clientNo);
				
				threadExecutor.execute(thread);
				
				clientNo++;		
			}
		}


		catch(EOFException eofe)
		{
			eofe.printStackTrace();
		}

		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}	
	}
}
	
	class HandleAClient implements Runnable
	{
		int clientNo;
		Socket connection;
	
		
		public HandleAClient(Socket connection, int clientNo)
		{
			this.connection= connection;
			this.clientNo=clientNo;
		}

		
		public void run()
		{
			ObjectOutputStream output;
			ObjectInputStream input;
			Object obj;

			ArrayList<University> universityList= new ArrayList<University>();
			try
			{
				System.out.println("In run method....");
				output= new ObjectOutputStream (connection.getOutputStream());
				input= new ObjectInputStream(connection.getInputStream());
				obj= input.readObject();
				universityList=(ArrayList<University>)obj;
				
				
				for (University u: universityList)
				{
					u.setTotalTuition();
				}

				output.writeObject(universityList);
				output.flush();
				
				System.out.println("Thread "+ clientNo+ ": "+"Ended");
				System.out.println("");

			}
			catch(NullPointerException npe)
			{
				npe.printStackTrace();
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

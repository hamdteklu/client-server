# client-server
A multi-threaded server that accepts an array list of university from a client(s):

Class University has attributes name, total credit hours, cost per credit hour, and total tuition.
  
setTuition is called by the server to set the total tuition to total credit hours * cost per credit hour.

There are two clients each with their own university arraylist.  The client does not continuously run.  

The first client data is: 

UTA, 10, 5
TCU, 13, 7
UTD, 19, 8

The second client data is: 

UNT, 20, 5
SMU, 33, 7
TWU, 9, 8

The multi-threaded server accepts an array list of university from a client, walks through the arraylist, sets the total tuition for each university, and returns the arraylist to the client.  

The client then prints the arraylist at the prompt.  The server prints which client it is connected to.  The server will run continuously.

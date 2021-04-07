package sample;


import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServerThread extends Thread {
    protected Socket socket       = null;
    protected PrintWriter out     = null;
    protected BufferedReader in   = null;
    public String message = null;
    public   String UserName = null;




    protected boolean bLoggedIn   = false;
    protected String strUserID    = null;
    protected String strPassword  = null;

    protected Vector messages     = null;

    public ChatServerThread(Socket socket, Vector messages) {
        super();
        this.socket = socket;
        this.messages = messages;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("IOEXception while opening a read/write connection");
        }
    }
    


    public void run() {
        // initialize interaction
        out.println("Connected to Chat Server");
        out.println("200 Ready For Chat");

        boolean endOfSession = false;
        while(!endOfSession) {
            endOfSession = processCommand();
        }
        try {
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean processCommand() {
        String message = null;
        try {
            message = in.readLine();
        } catch (IOException e) {
            System.err.println("Error reading command from socket.");
            return true;
        }
        if (message == null) {
            return true;
        }
        StringTokenizer st = new StringTokenizer(message);
        String command = st.nextToken();
        String args = null;
        String args2 = null;
        if (st.hasMoreTokens()) {
            args = message.substring(command.length()+1, message.length());
        }

        return processCommand(command, args);
    }

    protected boolean processCommand(String command, String arguments) {
        if (command.equalsIgnoreCase("message")) {
            message = arguments;
        }
        if (command.equalsIgnoreCase("Username")) {
            UserName = arguments;

        }
        if (command.equalsIgnoreCase("sendToController")) {
            Controller data = new Controller();
            data.getUserNameAndMessage(UserName, message);
        }

        return false;
    }

    public String Getdata(){
        return UserName + ": "+message;
    }



}
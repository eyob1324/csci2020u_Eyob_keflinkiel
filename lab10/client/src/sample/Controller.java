package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Controller {

    @FXML
    private TextField UserName;
    @FXML
    private TextField Message;
    @FXML
    private Button Send;
    @FXML
    private Button exit;




    public void btnOnPressSend(ActionEvent actionEvent) {
        Socket clientSocket = null;
        PrintWriter out = null;
        try{
            //creates socket
            clientSocket = new Socket("localhost",8080);
            out = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()));
            //sends upload command with the file name as second argument
            out.println("message"+" "+Message.getText());
            out.println("Username"+" "+UserName.getText());
            out.println("sendToController");

            //takes client_folder and makes it a list of files;


            out.flush();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnOnPressExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}

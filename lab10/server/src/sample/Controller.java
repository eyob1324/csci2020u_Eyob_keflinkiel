package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextArea ChatBox  = new TextArea();

    @FXML
    private TextField Username;
    String Input;

    public void initialize(){

    }




    public void btnOnPressExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void getUserNameAndMessage(String UserName, String Message){
        Input = UserName+": "+Message;
        System.out.println(Input);
        ChatBox.setText(Input);

    }





}

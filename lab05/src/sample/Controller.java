package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TableView  tabview1;
    @FXML
    private TableColumn SID;
    @FXML
    private TableColumn Assignment;
    @FXML
    private TableColumn Midterm;
    @FXML
    private TableColumn Final_exam;
    @FXML
    private TableColumn Final_Mark;
    @FXML
    private TableColumn Letter_Grade;

    private TableView<StudentRecord> marks;

    @FXML
    private void initialize(){
        SID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        Assignment.setCellValueFactory(new PropertyValueFactory<>("Midterm"));
        Midterm.setCellValueFactory(new PropertyValueFactory<>("Assignmnets"));
        Final_exam.setCellValueFactory(new PropertyValueFactory<>("Final_exam"));
        Final_Mark.setCellValueFactory(new PropertyValueFactory<>("Final_Mark"));
        Letter_Grade.setCellValueFactory(new PropertyValueFactory<>("Letter_grade"));
        tabview1.setItems(DataSource.getAllMarks());
    }


}

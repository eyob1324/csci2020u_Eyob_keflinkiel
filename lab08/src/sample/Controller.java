package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;

public class Controller {
    @FXML
    private TableView tabview1;
    @FXML
    private TableColumn SID;
    @FXML
    private TextField SIDT;
    @FXML
    private TableColumn Assignment;
    @FXML
    private TextField assignmentT;
    @FXML
    private TableColumn Midterm;
    @FXML
    private TextField MidtermT;
    @FXML
    private TableColumn Final_exam;
    @FXML
    private TextField Final_ExamT;
    @FXML
    private TableColumn Final_Mark;
    @FXML
    private TableColumn Letter_Grade;

    ObservableList<StudentRecord> marks = FXCollections.observableArrayList();
    public File CurrentFileName;
    @FXML
    private void initialize(){
        SID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        Assignment.setCellValueFactory(new PropertyValueFactory<>("Midterm"));
        Midterm.setCellValueFactory(new PropertyValueFactory<>("Assignmnets"));
        Final_exam.setCellValueFactory(new PropertyValueFactory<>("Final_exam"));
        Final_Mark.setCellValueFactory(new PropertyValueFactory<>("Final_Mark"));
        Letter_Grade.setCellValueFactory(new PropertyValueFactory<>("Letter_grade"));
        tabview1.setItems(marks);
    }

    public void btnOnPress(ActionEvent actionEvent) {
       try {
           marks.add(new StudentRecord(SIDT.getText(), Float.valueOf(MidtermT.getText()), Float.valueOf(assignmentT.getText()), Float.valueOf(Final_ExamT.getText())));
            SIDT.clear();
            assignmentT.clear();
            MidtermT.clear();
            Final_ExamT.clear();

       } catch (Exception e) {
           e.printStackTrace();
       }

        }


    public void EXITonPress(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void NewonPress(ActionEvent actionEvent) {
        marks.remove(0,marks.size());
    }

    public void openonPress(ActionEvent actionEvent){

        FileChooser File_chooser = new FileChooser();
        File_chooser.setInitialDirectory(new File("."));

        CurrentFileName = File_chooser.showOpenDialog(null);
        if (null != CurrentFileName){
            load();
        }
    }


   public void load(){
       String line = "";

       String[] CSvData = null;

       try {

           BufferedReader br = new BufferedReader(new FileReader(CurrentFileName.getName()));
           while ((line = br.readLine()) != null)   //returns a Boolean value
           {
               CSvData = line.split(",");    // use comma as separator

                   if(CSvData[0].toString().equals("SID") ||CSvData[1].toString().equals("assignment") || CSvData[2].toString().equals("Midterm") || CSvData[3].toString().equals("Final Exam") ){

                   }else {
                       marks.add(new StudentRecord(CSvData[0],Float.valueOf(CSvData[1]),Float.valueOf(CSvData[2]),Float.valueOf(CSvData[3])));
                   }


           }


           br.close();

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void Save() {
        try {
            FileWriter csvWriter = new FileWriter(CurrentFileName,true);

            for (int i = 0; i < marks.size(); i++) {

                csvWriter.append('\n');
                csvWriter.append(marks.get(i).getStudentID());
                csvWriter.append(',');
                csvWriter.append(Float.toString(marks.get(i).getMidterm()));
                csvWriter.append(',');
                csvWriter.append(Float.toString(marks.get(i).getAssignmnets()));
                csvWriter.append(',');
                csvWriter.append(Float.toString(marks.get(i).getFinal_exam()));

            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public void saveonPress(ActionEvent actionEvent) {
        try {
            String line = "";
            int endlength = 0;
            BufferedReader br = new BufferedReader(new FileReader(CurrentFileName.getName()));
            while ((line = br.readLine()) != null){
                endlength++;

            }
            br.close();
            FileWriter csvWriter = new FileWriter(CurrentFileName,true);
            for(int i =endlength-1; i < marks.size();i++){
                csvWriter.append('\n');
                csvWriter.append(marks.get(i).getStudentID());
                csvWriter.append(',');
                csvWriter.append(Float.toString(marks.get(i).getMidterm()));
                csvWriter.append(',');
                csvWriter.append(Float.toString(marks.get(i).getAssignmnets()));
                csvWriter.append(',');
                csvWriter.append(Float.toString(marks.get(i).getFinal_exam()));

            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveASonPress(ActionEvent actionEvent) {
        FileChooser File_chooser = new FileChooser();
        File_chooser.setInitialDirectory(new File("."));
        CurrentFileName = File_chooser.showOpenDialog(null);
        if (null != CurrentFileName){
            Save();
        }

    }
}

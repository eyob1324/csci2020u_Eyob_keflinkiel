package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private  TextField phoneField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button enterBtn;

    private DateTimeFormatter dateTimeFormatter;


    @FXML
    public void initialize() {
        System.out.println("App is running...");

        final String datePattern = "M/dd/yyyy";
        dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
        datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                String finalDate = null;
                if (date != null)
                    finalDate = dateTimeFormatter.format(date);
                return finalDate;
            }

            @Override
            public LocalDate fromString(String string) {
                LocalDate date = null;
                if (string != null)
                    date = LocalDate.parse(string, dateTimeFormatter);
                return date;
            }
        });
    }

    @FXML
    public void btnOnPress(ActionEvent event) {
        if (nameField.getText().length() > 0) {
            System.out.println(userNameField.getText());
            System.out.println(passwordField.getText());
            System.out.println(nameField.getText());
            System.out.println(emailField.getText());
            System.out.println(phoneField.getText());
            System.out.println(datePicker.getEditor().getText());
        }
    }
}

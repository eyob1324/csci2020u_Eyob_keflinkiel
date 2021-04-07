package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    primaryStage.setTitle("Server v1.0");
                    primaryStage.setScene(new Scene(root, 500, 475));
                    primaryStage.show();


        Thread thread = new Thread(task);

        thread.start();


    }

    Runnable task = () -> {
        Server Client = new Server();
    };


    public static void main(String[] args) {

        launch(args);
    }
}

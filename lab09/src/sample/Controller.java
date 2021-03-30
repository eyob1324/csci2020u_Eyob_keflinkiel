package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Canvas canvas1;
    @FXML
    public GraphicsContext gc;


    @FXML
    private void initialize(){
        gc = canvas1.getGraphicsContext2D();
        ArrayList<String> google =  downloadFile("https://query1.finance.yahoo.com/v7/finance/download/GOOG?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true%22");
        ArrayList<String> apple = downloadFile("https://query1.finance.yahoo.com/v7/finance/download/AAPL?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true%22");
        DrawLine(gc,google,apple);
    }


    public static ArrayList<String> downloadFile(String urlGoogle) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            InputStream input = new URL(urlGoogle).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            String line;
            while((line = reader.readLine()) != null) {

                String[] row = line.split(",");

                data.add(row[4]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void DrawLine(GraphicsContext gc,ArrayList<String> data1,ArrayList<String> data2){
        gc.strokeLine(100,50,100,800);
        gc.strokeLine(100,800,900,800);
        DrawLineGraph(gc,data1,Color.RED);
        DrawLineGraph(gc,data2,Color.BLUE);
    }




    public void DrawLineGraph(GraphicsContext gc,ArrayList<String> data1,Color c){
        gc.setStroke(c);
        double x_width = 100;
        for(int i = 1; i < data1.size()-1;i++){
            int next = i+1;

            double value = Double.parseDouble(data1.get(i));
            double Nextvalue = Double.parseDouble(data1.get(next));
            System.out.println(value+"  "+Nextvalue);
            gc.strokeLine(x_width,800-value,x_width+10,800-Nextvalue);
            x_width += 10;

        }

    }


}

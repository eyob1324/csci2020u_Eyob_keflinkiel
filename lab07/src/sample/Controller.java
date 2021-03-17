package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {
    @FXML
    private Canvas canvas1;
    @FXML
    public GraphicsContext gc;


    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };



    LoadFile test = new LoadFile("weatherwarnings-2015.csv");


    @FXML
    private void initialize(){
        test.Load();
        gc = canvas1.getGraphicsContext2D();
        drawPieChart(gc);
        DrawLAbels(gc);
    }

    private void drawPieChart(GraphicsContext gc) {
        int[] WeatherDataType ={
                test.getFlasfloodcounter(), test.getThunderStormCounter(), test.getSpecialMarineCounter(), test.getTornadoCounter()
        };

        int weather = 0;

        for(int TypeofWeather: WeatherDataType){
            weather += TypeofWeather;
        }

        double startAngle = 0.0;
        for(int i = 0; i < WeatherDataType.length; i++){
            double slicePercent = (double) WeatherDataType[i] / (double) weather;
            double sweepAngle = slicePercent * 360.0;
            gc.setFill(pieColours[i]);
            gc.fillArc(350, 150, 300, 300, startAngle, sweepAngle, ArcType.ROUND);
            startAngle += sweepAngle;
        }
    }

    private void DrawLAbels(GraphicsContext gc){
        gc.setFill(Color.AQUA);
        gc.setStroke(Color.AQUA);
        gc.strokeRect(100,100,50,50);
        gc.fillRect(100,100,50,50);

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.strokeText("Flash Flood", 160,125);
        gc.fillText("Flash Flood", 160,125);


        gc.setFill(Color.GOLD);
        gc.setStroke(Color.GOLD);
        gc.strokeRect(100,200,50,50);
        gc.fillRect(100,200,50,50);

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.strokeText("SEVERE THUNDERSTORM", 160,225);
        gc.fillText("SEVERE THUNDERSTORM", 160,225);


        gc.setFill(Color.DARKORANGE);
        gc.setStroke(Color.DARKORANGE);
        gc.strokeRect(100,300,50,50);
        gc.fillRect(100,300,50,50);

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.strokeText("SPECIAL MARINE", 160,325);
        gc.fillText("SPECIAL MARINE", 160,325);

        gc.setFill(Color.DARKSALMON);
        gc.setStroke(Color.DARKSALMON);
        gc.strokeRect(100,400,50,50);
        gc.fillRect(100,400,50,50);

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.strokeText("TORNADO", 160,425);
        gc.fillText("TORNADO", 160,425);
    }



}

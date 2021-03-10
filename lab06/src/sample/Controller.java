package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Controller {

    @FXML
    public GraphicsContext gc;

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };

    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };

    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };

    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    @FXML
    private Canvas Canvas;

    @FXML
    private void initialize(){
         gc = Canvas.getGraphicsContext2D();

        drawBarGraph(100, 500, 100, 500, avgHousingPricesByYear, avgCommercialPricesByYear,  Color.RED, Color.BLUE);
        drawPieChart(gc);
    }
    public void drawBarGraph(int weight, int hieght, int weight2, int height2, double[] avgHousingPricesByYear, double[] avgCommercialPricesByYear, Color C1, Color C2) {
        gc.setFill(C1);

        double barWidth = weight / avgHousingPricesByYear.length;
        double x = 0;
        int i = 0;
        for (double val : avgHousingPricesByYear) {
            double barHeight = avgHousingPricesByYear[i] /avgCommercialPricesByYear[avgCommercialPricesByYear.length - 1] * hieght;
            gc.fillRect(x, (hieght - barHeight), barWidth, barHeight);
            x += barWidth + 20;
            i++;
        }

        gc.setFill(C2);

        double barWidth1 = weight2 / avgCommercialPricesByYear.length;
        double y = 10;
        int k = 0;
        for (double val1 : avgCommercialPricesByYear) {
            double barHeight1 = avgCommercialPricesByYear[k] /avgCommercialPricesByYear[avgCommercialPricesByYear.length - 1] * height2 ;
            gc.fillRect(y, (height2 - barHeight1), barWidth1, barHeight1);
            y += barWidth1 + 20;
            k++;
        }
    }




    private void drawPieChart(GraphicsContext gc) {
        int Age = 0;


        for(int purchasesAgeGroup: purchasesByAgeGroup){
            Age += purchasesAgeGroup;
        }

        double startAngle = 0.0;
        for(int i = 0; i < purchasesByAgeGroup.length; i++){
            double slicePercent = (double) purchasesByAgeGroup[i] / (double) Age;
            double sweepAngle = slicePercent * 360.0;
            gc.setFill(pieColours[i]);
            gc.fillArc(350, 150, 300, 300, startAngle, sweepAngle, ArcType.ROUND);
            startAngle += sweepAngle;
        }
    }


}

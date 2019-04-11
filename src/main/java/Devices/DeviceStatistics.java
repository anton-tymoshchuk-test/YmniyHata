package Devices;

import Devices.Device;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class DeviceStatistics {
    public static void showStat(Device device)
    {
        Stage stage = new Stage();
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("My sample chart");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Test float data");
        //populating the series with data
        //And assumption has been made that your Date[] and float[] arrays are
        //of the same size and have one to one mapping.

        //Date[] dates = ...  // here is your Date[] array
        //float[] someData = ... // here is your float[] array

    /*        for (int i = 0; i < dates.length; i++) {
        series.getData().add(new XYChart.Data(dates[i], someData[i]));
    }*/
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

}

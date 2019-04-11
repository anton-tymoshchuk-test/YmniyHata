package Devices;

import Devices.Device;
import Helpers.Database;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class DeviceStatistics {
    public static void showStat(Device device)
    {
        Stage stage = new Stage();
        stage.setTitle(device.getName() + " - Statistics");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle(device.getName() + " - Statistics");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Power per hour");
        Database.connect();
        List<Device> saves = Database.getSaves(device.getID());
        Database.close();
        for (int i = 0; i < saves.size(); i++) {
            series.getData().add(new XYChart.Data( i,saves.get(i).usingElectricity));
        }
         /*for (Device device:saves){
            series.getData().add(new XYChart.Data( device.getLatestCloudUpdate(),device.usingElectricity));
        }
        for (int i = 0; i < dates.length; i++) {
            series.getData().add(new XYChart.Data(dates[i], someData[i]));
        }*/
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

}

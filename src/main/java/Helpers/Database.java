package Helpers;

import Devices.Device;

import java.sql.*;
import java.util.*;


public class Database {

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:YmniyHmara.s3db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS `Saves` (`ID` INTEGER PRIMARY KEY  AUTOINCREMENT ,`Content` BLOB,`UnixTime` TEXT,`DeviceID` TEXT);");

            //create();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void putSerializedDevice(byte[] array, String unixtime, String device_id) {
        Connection localconnection = connect();

        try {
            Statement localstatement = localconnection.createStatement();
            String sql = "INSERT INTO `Saves` (`Content`,`UnixTime`,`DeviceID`) VALUES (?,?,?); ";
            PreparedStatement pstmt = localconnection.prepareStatement(sql);
            pstmt.setBytes(1, array);
            pstmt.setString(2, unixtime);
            pstmt.setString(3, device_id);
            pstmt.executeUpdate();
            pstmt.close();
            localstatement.close();
            localconnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void clearOldContent(String currentUnixTime) {
        try {
            statement.execute(String.format("DELETE FROM `Saves` WHERE `UnixTime` != '%s';", currentUnixTime));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    //Якщо передамо null то виведе всі сейви
    public static List<Device> getSaves(String ID) {
        Connection localconnection = connect();
        List<Device> devices = new ArrayList<Device>();
        String query = "SELECT * FROM `Saves`";
        if (ID != null)
            query += String.format(" Where `DeviceID` = %s", ID);
        System.out.println(query);
        try {
            Statement localstatement = localconnection.createStatement();
            ResultSet result = localstatement.executeQuery(query);
            while (result.next())
                devices.add(SerializeHelper.deserializeDevice(result.getBytes("Content")));
            localstatement.close();
            localconnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }

    //Передаємо список підключенних на данний момент девайсів, та знаходимо їхні сейви
    public static List<Device> getLatestSaves(List<Device> connected_devices) {
        List<Device> devices = new ArrayList<Device>();
        for (Device device : connected_devices)
            devices.add(Collections.max(getSaves(device.getIdentificator()), Comparator.comparing(dev -> dev.getLatestCloudUpdate())));

        return devices;
    }
}
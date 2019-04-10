import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Database {
    public static Connection conn;
    public static Statement statement;
    public static ResultSet resSet;

    public static void connect() {
        conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:YmniyHmara.s3db");
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void create() {
        try {
            connect();
            statement = conn.createStatement();
            //Date date = Date.from( Instant.ofEpochSecond( timeStamp ) );
            statement.execute("CREATE TABLE IF NOT EXISTS `Saves` (`ID` INTEGER PRIMARY KEY  AUTOINCREMENT ,`Content` BLOB,`UnixTime` TEXT)");
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void putSerializedDevice(byte[] array, String unixtime) {
        try {
            String sql = "INSERT INTO `Saves` (`Content`,`UnixTime`) VALUES (?,?); ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBytes(1, array);
            pstmt.setString(2, unixtime);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearOldContent(String currentUnixTime) {
        try {
            statement.execute(String.format("DELETE FROM `Saves` WHERE `UnixTime` != '%s';", currentUnixTime));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Device> getDevices() {
        List<Device> devices = new ArrayList<Device>();
        String query = "SELECT * FROM `Saves`";
        try {
            resSet = Database.statement.executeQuery(query);
            while (resSet.next()) {
                devices.add(SerializeHelper.deserializeDevice(resSet.getBytes("Content")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }

    public static void close() {
        try {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resSet != null)
                resSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
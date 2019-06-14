package sample;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager implements AutoCloseable {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBManager() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {
        // TODO: program this method
        try {
            String url = "jdbc:mysql://localhost:3306/bdcarros"+ "?useUnicode=true" +
                    "&useJDBCCompliantTimezoneShift=true" + "&useLegacyDatetimeCode=false"
                    + "&serverTimezone=UTC";
            connection = DriverManager.getConnection(url,
                    "root", "");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setGraphic(new ImageView(this.getClass().getResource("conex.png").toString()));
            //alert.getIcons().add(new Image(this.getClass().getResourceAsStream("images.png")));
            alert.setTitle("Aviso de conexión");
            alert.setHeaderText("Conexion exitosa a la base de datos: bdCarros");
            alert.showAndWait();


        } catch (SQLException ex) {
            connection = null;
            ex.printStackTrace();
            System.out.println("SQLException:â£" + ex.getMessage());
            System.out.println("SQLState:â£" + ex.getSQLState());
            System.out.println("VendorError:â£" + ex.getErrorCode());
        }
    }

    /**
     * Close the connection to the database if it is still open.
     *
     */
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

}
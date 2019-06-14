package sample;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class OperacionesVehiculo {
    Connection connection;

    public OperacionesVehiculo(Connection conn) {
        this.connection = conn;
    }


    public Vehiculo getVehiculo(int id) {
        int Id_Vehiculo = 0;
        int Modelo = 0, Precio = 0;
        String Nom_Vehiculo = "", Marca = "";

        String query = "SELECT Id_Vehiculo, Nom_Vehiculo, Marca, Modelo, Precio " +
                "FROM vehiculos " +
                "WHERE Id_Vehiculo = " + id;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                Id_Vehiculo = rs.getInt("Id_Vehiculo");
                Nom_Vehiculo = rs.getString("Nom_Vehiculo");
                Marca = rs.getString("Marca");
                Modelo = rs.getInt("Modelo");
                Precio = rs.getInt("Precio");
            }


            System.out.println(Id_Vehiculo + ", " + Nom_Vehiculo + " " + Marca + ", " + Modelo + ", " + Precio);

            return new Vehiculo(Id_Vehiculo, Nom_Vehiculo, Marca, Modelo, Precio);

        } catch (java.sql.SQLException ex) {
            System.out.println("SQLException:â£" + ex.getMessage());
            System.out.println("SQLState:â£" + ex.getSQLState());
            System.out.println("VendoError:â£" + ex.getErrorCode());
            return null;
        }


    }
    public Vehiculo getLista(ObservableList<Vehiculo> lista){
        int Id_Vehicul=0, Model=0, Preci=0;
        String Nom_Vehicul="", Marc="";
        String query = "SELECT Id_Vehiculo, Nom_Vehiculo, Marca, Modelo, Precio " +
                "FROM vehiculos" ;
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs= stmt.executeQuery(query);

            while (rs.next()){
                lista.add(new Vehiculo(Id_Vehicul = rs.getInt("Id_Vehiculo"),
                        Nom_Vehicul = rs.getString("Nom_Vehiculo"),
                        Marc = rs.getString("Marca"),
                        Model = rs.getInt("Modelo"),
                        Preci = rs.getInt("Precio")
                ));
            }
            return new Vehiculo(Id_Vehicul ,Nom_Vehicul ,Marc ,Model ,Preci);
        }
        catch (java.sql.SQLException ex){
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());

            return null;
        }
    }
    public void agregar(int id, String Nombre, String Marca, int Modelo, int precio){
        String query = "insert into vehiculos(Id_Vehiculo, Nom_Vehiculo, Marca, Modelo, Precio)" + "values ('"+ id + "', '" + Nombre + "', '" + Marca + "','" + Modelo + "','" + precio + "')";
        int numRegs=0;
        try{
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);
            System.out.println("Cantidad de registros afectados: " + numRegs);
        } catch (java.sql.SQLException e){
            e.getStackTrace();
            System.out.println("SQLException:␣" + e.getMessage());
            System.out.println("SQLState:␣" + e.getSQLState());
            System.out.println("VendorError:␣" + e.getErrorCode());
        }
    }

    public int eliminar(int id){

        String query = "delete from vehiculos where Id_Vehiculo = " + id;
        int numRegs = 0;
        try{
            Statement stmt = connection.createStatement();
            numRegs = stmt.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " +e.getErrorCode());
        }
        return numRegs;
    }

    public int editar(int id, String nom, String marc, int model, int preci) {

        int numRegistrados = 0;
        try {
            String query = "UPDATE vehiculos SET Nom_Vehiculo = '"+nom+"',Marca = '"+marc+"', Modelo = '"+model+"',Precio = '"+preci+"' WHERE vehiculos.Id_Vehiculo= "+id;
            Statement stmt = connection.createStatement();
            numRegistrados = stmt.executeUpdate(query);

            System.out.println("Cantidad de números registrados " + numRegistrados);

        } catch (java.sql.SQLException ex) {
            System.out.println("SQLException:â£" + ex.getMessage());
            System.out.println("SQLState:â£" + ex.getSQLState());
            System.out.println("VendoError:â£" + ex.getErrorCode());
        }
        return numRegistrados;

    }


    }


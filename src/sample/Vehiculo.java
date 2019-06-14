package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Vehiculo {


        private SimpleIntegerProperty Id_Vehiculo;
        private SimpleStringProperty Nom_Vehiculo;
        private SimpleStringProperty Marca;
        private SimpleIntegerProperty Modelo;
        private SimpleIntegerProperty Precio;


        public Vehiculo(Integer Id_Vehicul, String Nom_Vehicul,
                        String Marc,
                        int Model, Integer Preci) {
            this.Id_Vehiculo = new SimpleIntegerProperty(Id_Vehicul);
            this.Nom_Vehiculo = new SimpleStringProperty(Nom_Vehicul);
            this.Marca = new SimpleStringProperty(Marc);
            this.Modelo = new SimpleIntegerProperty(Model);
            this.Precio = new SimpleIntegerProperty(Preci);
        }


    public int getId_Vehiculo() {
        return Id_Vehiculo.get();
    }

    public SimpleIntegerProperty id_VehiculoProperty() {
        return Id_Vehiculo;
    }

    public void setId_Vehiculo(int id_Vehiculo) {
        this.Id_Vehiculo.set(id_Vehiculo);
    }

    public String getNom_Vehiculo() {
        return Nom_Vehiculo.get();
    }

    public SimpleStringProperty nom_VehiculoProperty() {
        return Nom_Vehiculo;
    }

    public void setNom_Vehiculo(String nom_Vehiculo) {
        this.Nom_Vehiculo.set(nom_Vehiculo);
    }

    public String getMarca() {
        return Marca.get();
    }

    public SimpleStringProperty marcaProperty() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca.set(marca);
    }

    public int getModelo() {
        return Modelo.get();
    }

    public SimpleIntegerProperty modeloProperty() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        this.Modelo.set(modelo);
    }

    public int getPrecio() {
        return Precio.get();
    }

    public SimpleIntegerProperty precioProperty() {
        return Precio;
    }

    public void setPrecio(int precio) {
        this.Precio.set(precio);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Id_Vehiculo=" + Id_Vehiculo +
                ", Nom_Vehiculo=" + Nom_Vehiculo +
                ", Marca=" + Marca +
                ", Modelo=" + Modelo +
                ", Precio=" + Precio +
                '}';
    }
}

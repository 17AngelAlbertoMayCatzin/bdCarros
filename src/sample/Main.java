package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Registro de vehiculos");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("images.png")));
        primaryStage.setWidth(700);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();

        int id=0, modeloo=0, precio=0;
        String Nom_vehiculo="", marca ="";

        //----------------Se crea accesoBD para interactuar con la clase DBManager-------------------------//
        DBManager accesoBD = new DBManager();

        //----------------Se crea un objeto(opVehiculo) de la clase operaciones Vehiculo-------------------//
        OperacionesVehiculo opVehiculo = new OperacionesVehiculo(accesoBD.getConnection());



        //--------------Tabla donde se meustran los datos de la base de datos------------------------//

        //--------------Creación del tableView del tipo de la clase Vehiculo-------------------------//
        TableView <Vehiculo>table = new TableView<Vehiculo>();

        //--------------- Creación de un label-------------------------------------------------------//
        Label label = new Label("Registro de vehiculos");
        label.setFont(new Font("Arial", 20));

        //------------------Creando las columnas del table View---------------------------------------//
        TableColumn <Vehiculo, Integer> Id_vehiculo = new TableColumn<>("ID Vehiculo");
        TableColumn <Vehiculo, String> Nom_Vehiculo = new TableColumn<>("Nombre Vehiculo");
        TableColumn <Vehiculo, String> Marca = new TableColumn<>("Marca del vehiculo");
        TableColumn <Vehiculo, Integer> Modelo = new TableColumn<>("Modelo del vehiculo");
        TableColumn <Vehiculo, Integer> Precio = new TableColumn<>("Precio Vehiculo");
        table.getColumns().addAll(Id_vehiculo,Nom_Vehiculo,Marca,Modelo,Precio);

        //-------------------------Se le asigna los valores a la columna------------------------------//
        Id_vehiculo.setCellValueFactory( new PropertyValueFactory<Vehiculo, Integer>("Id_Vehiculo"));
        Nom_Vehiculo.setCellValueFactory( new PropertyValueFactory<Vehiculo, String>("Nom_Vehiculo"));
        Marca.setCellValueFactory( new PropertyValueFactory<Vehiculo, String>("Marca"));
        Modelo.setCellValueFactory( new PropertyValueFactory<Vehiculo, Integer>("Modelo"));
        Precio.setCellValueFactory( new PropertyValueFactory<Vehiculo, Integer>("Precio"));


        //-----------------------------Se crea un ObservableList (datos) del tipo Clase Vehiculo------------------------------------//
        ObservableList<Vehiculo> datos =FXCollections.observableArrayList();
        // Se obtienen los datos de la BD
        opVehiculo.getLista(datos);
        table.getItems().addAll(datos);
        table.setEditable(true);

        //-----------------------Se crea un VBox----------------------------------------------------------------------------------//
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 0, 0, 20));
        vbox.getChildren().addAll(label, table);



       //-----------------Se crea un label para botones---------------------------------//
        Label botones = new Label("Opciones");
        botones.setFont(new Font("Arial", 20));

        //-----------------------Se crea VBox para botones --------------------------------------------//
        final VBox vboxBtn = new VBox();
        vboxBtn.setSpacing(5);
        vboxBtn.setPadding(new Insets(100, 0, 0, 500));
        ((Group) scene.getRoot()).getChildren().addAll(vbox,vboxBtn);



        //-------------------------Botones---------------------------------------//
        Button btnAgregar= new Button ("Agregar Registro");
        btnAgregar.setStyle("-fx-background-color:#58FAF4");
        Button btnEliminar= new Button ("Eliminar");
        btnEliminar.setStyle("-fx-background-color:#fc0e32");
        Button btnEditar= new Button ("Editar");
        btnEditar.setStyle("-fx-background-color:#f2fa04");
        Button btnBuscar= new Button ("Buscar");
        btnBuscar.setStyle("-fx-background-color:#0e3dfc");
        Button btnRegresar = new Button("Regresar");
        btnRegresar.setStyle("-fx-background-color:#dce0e1");
        Button btnAceptar = new Button("Aceptar");
        btnAceptar.setStyle("-fx-background-color:#1898f6");
        vboxBtn.getChildren().addAll(botones,btnAgregar,btnEliminar,btnEditar,btnBuscar );


        //------------------------Proceso de operación----------------------------------------------//

        //+++++++++++++++++++++++++++++Acción del botón para agregar++++++++++++++++++++++++++++++++//
        btnAgregar.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {

                //------------------------Se crea un nuevo escenario--------------------------------//
                Stage window = new Stage();
                Group root = new Group();
                window.setScene(new Scene(root,275,350));
                window.setTitle("Agregar nuevo registro");
                window.getIcons().add(new Image(Main.class.getResourceAsStream("anadir.png")));
                window.show();

                //------------------------Se crea un label------------------------------------------//
                Label lblIdVeh = new Label("Ingrese el Id del nuevo Vehiculo: ");
                lblIdVeh.setStyle("-fx-font-size: 10pt;");

                //------------------------Se crea un TextField--------------------------------------//
                TextField IdVe = new TextField();
                IdVe.setPrefWidth(70);
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
                Label lblNomV = new Label("Ingrese el nombre del nuevo Vehiculo: ");
                lblNomV.setStyle("-fx-font-size: 10pt;");
                TextField nombreV = new TextField();
                nombreV.setPrefWidth(70);
                Label lblMarca = new Label("Ingrese la marca del nuevo Vehiculo: ");
                lblNomV.setStyle("-fx-font-size: 10pt;");
                TextField marcaV = new TextField();
                marcaV.setPrefWidth(70);
                Label lblmodV = new Label("Ingrese el modelo del nuevo Vehiculo: ");
                lblmodV.setStyle("-fx-font-size: 10pt;");
                TextField modeV = new TextField();
                modeV.setPrefWidth(70);
                Label lblpreV = new Label("Ingrese el precio del nuevo Vehiculo: ");
                lblpreV.setStyle("-fx-font-size: 10pt;");
                TextField precV = new TextField();
                precV.setPrefWidth(70);
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

                //-------------------------------Se crea un VBox-------------------------------------------------------//
                VBox vboxop = new VBox();
                vboxop.setSpacing(5);
                vboxop.setPadding(new Insets(0, 0, 0, 10));
                vboxop.getChildren().addAll(lblIdVeh,IdVe,lblNomV,nombreV,lblMarca,marcaV,lblmodV,modeV,lblpreV,precV,btnAceptar,btnRegresar);
                root.getChildren().addAll(vboxop);
                //-----------------------Asignación de operaciones para el botón aceptar---------------------------------------------------//
              btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) {
                      int IDVe =0;
                      try{
                          IDVe= Integer.valueOf(IdVe.getText());
                      }
                      catch(Exception ime){

                      }
                      String Nom ="";
                      try{
                          Nom= String.valueOf(nombreV.getText());
                      }
                      catch(Exception ime){

                      }

                      String Marcaa ="";
                      try{
                          Marcaa= String.valueOf(marcaV.getText());
                      }
                      catch(Exception ime){

                      }

                      int Mod =0;
                      try{
                          Mod= Integer.valueOf(modeV.getText());
                      }
                      catch(Exception ime){

                      }

                      int Pre =0;
                      try{
                          Pre= Integer.valueOf(precV.getText());
                      }
                      catch(Exception ime){

                      }

                      opVehiculo.agregar(IDVe, Nom,Marcaa,Mod,Pre);
                      Alert alert = new Alert(Alert.AlertType.WARNING);
                      alert.setTitle("Warning Dialog");
                      alert.setHeaderText("Inserción completada");
                      alert.setGraphic(new ImageView(this.getClass().getResource("Listo.jpg").toString()));
                      alert.setContentText("Usted agrego al vehiculo con Id:  "
                              + IDVe+ ""+ " y con nombre: " + Nom + ""+ "a la base de datos: bdCarros");

                      alert.showAndWait();
                      opVehiculo.getLista(datos);
                      datos.clear();
                      table.getItems().clear();
                      table.getItems().addAll(datos);
                      opVehiculo.getLista(datos);
                      table.getItems().addAll(datos);
                  }
              });

              btnRegresar.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) {
                      window.close();
                  }
              });
                ObservableList<Vehiculo> datos = FXCollections.observableArrayList();

            }

        });

        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage window1 = new Stage();
                Group root = new Group();
                window1.setScene(new Scene(root,275,275));
                window1.getIcons().add(new Image(Main.class.getResourceAsStream("clear.png")));
                window1.setTitle("Eliminar Registro");
                window1.show();
                Label lblId = new Label("Ingrese el Id del vehiculo a eliminar: ");
                lblId.setStyle("-fx-font-size: 10pt;");
                TextField ID = new TextField();
                ID.setPrefWidth(70);
                VBox vboxop1 = new VBox();
                vboxop1.setSpacing(5);
                vboxop1.setPadding(new Insets(0, 0, 0, 10));
                vboxop1.getChildren().addAll(lblId,ID,btnAceptar,btnRegresar);
                root.getChildren().addAll(vboxop1);



               btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
                   @Override
                   public void handle(ActionEvent event) {
                       ////Operaciones
                       //ID.clear();
                       int Id =0;
                       try{
                           Id= Integer.valueOf(ID.getText());
                       }
                       catch(Exception ime){

                       }
                       opVehiculo.eliminar(Id);
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                       alert.setTitle("Warning Dialog");
                       alert.setHeaderText("Eliminación completada");
                       alert.setContentText("Usted a eliminado correctamente al vehiculo con Id:  "
                               + Id+ ""+ "de la base de datos: bdCarros");

                       alert.showAndWait();
                       datos.clear();
                       opVehiculo.getLista(datos);

                       table.getItems().clear();
                       //opVehiculo.getLista(datos);
                       table.getItems().addAll(datos);
                   }
               });

                btnRegresar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        window1.close();
                    }
                });
            }


        });

        btnEditar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage window2 = new Stage();
                Group root = new Group ();
                window2.setScene(new Scene (root,275,350));
                window2.setTitle("Editar Registro");
                window2.getIcons().add(new Image(Main.class.getResourceAsStream("conf.png")));
                window2.show();
                Label lblId1 = new Label("Ingrese el Id del vehiculo a editar: ");
                lblId1.setStyle("-fx-font-size: 10pt;");
                TextField ID1 = new TextField();
                ID1.setPrefWidth(70);
                Label lblNomV = new Label("Ingrese el nombre del nuevo Vehiculo: ");
                lblNomV.setStyle("-fx-font-size: 10pt;");
                TextField nombreV = new TextField();

                nombreV.setPrefWidth(70);

                Label lblMarca = new Label("Ingrese la marca del nuevo Vehiculo: ");
                lblNomV.setStyle("-fx-font-size: 10pt;");
                TextField marcaV = new TextField();
                marcaV.setPrefWidth(70);
                Label lblmodV = new Label("Ingrese el modelo del nuevo Vehiculo: ");
                lblmodV.setStyle("-fx-font-size: 10pt;");
                TextField modeV = new TextField();
                modeV.setPrefWidth(70);
                Label lblpreV = new Label("Ingrese el precio del nuevo Vehiculo: ");
                lblpreV.setStyle("-fx-font-size: 10pt;");
                TextField precV = new TextField();
                precV.setPrefWidth(70);
                VBox vboxop2 = new VBox();
                vboxop2.setSpacing(5);
                vboxop2.setPadding(new Insets(0, 0, 0, 10));
                vboxop2.getChildren().addAll(lblId1,ID1,lblNomV,nombreV,lblMarca,marcaV,lblmodV,modeV,lblpreV,precV,btnAceptar,btnRegresar);
                root.getChildren().addAll(vboxop2);

                btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        int IDVe =0;
                        try{
                            IDVe= Integer.valueOf(ID1.getText());
                        }
                        catch(Exception ime){

                        }
                        String Nom ="";
                        try{
                            Nom= String.valueOf(nombreV.getText());
                        }
                        catch(Exception ime){

                        }

                        String Marcaa ="";
                        try{
                            Marcaa= String.valueOf(marcaV.getText());
                        }
                        catch(Exception ime){

                        }

                        String Mod ="";
                        try{
                            Mod= String.valueOf(modeV.getText());
                        }
                        catch(Exception ime){

                        }

                        String Pre ="";
                        try{
                            Pre= String.valueOf(precV.getText());
                        }
                        catch(Exception ime){

                        }

                        Vehiculo regVehiculo = opVehiculo.getVehiculo(id);
                        String NOMBREVEHICULO = regVehiculo.getNom_Vehiculo();
                        String MARCAVEHICULO = regVehiculo.getMarca();
                        int MODELOVEHICULO = regVehiculo.getModelo();
                        int PRECIOVEHICULO = regVehiculo.getPrecio();


                        if (Nom.equals("")){
                            Nom=NOMBREVEHICULO;
                        }

                        if (Marcaa.equals("")){
                            Marcaa=MARCAVEHICULO;
                        }

                        if (Mod.equals("")){
                            if(Pre.equals("")){
                                opVehiculo.editar(IDVe, Nom,Marcaa,MODELOVEHICULO,PRECIOVEHICULO);
                            }
                            PRECIOVEHICULO = Integer.valueOf(Pre);
                            opVehiculo.editar(IDVe, Nom,Marcaa,MODELOVEHICULO,PRECIOVEHICULO);
                        }
                        MODELOVEHICULO = Integer.valueOf(Mod);
                        PRECIOVEHICULO = Integer.valueOf(Pre);

                        opVehiculo.editar(IDVe, Nom,Marcaa,MODELOVEHICULO,PRECIOVEHICULO);

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warn");
                        alert.setHeaderText("Inserción completada");
                        alert.setContentText("Usted agrego al vehiculo con Id:  "
                                + IDVe+ ""+ " y con nombre: " + Nom + ""+ "a la base de datos: bdCarros");

                        alert.showAndWait();
                        opVehiculo.getLista(datos);
                        datos.clear();
                        table.getItems().clear();
                        table.getItems().addAll(datos);
                        opVehiculo.getLista(datos);
                        table.getItems().addAll(datos);
                    }
                });
// simple-searching-in-java
                //drdobsss
                btnRegresar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        window2.close();
                    }
                });

            }
        });

        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage window3 = new Stage();
                Group root = new Group ();
                window3.setScene(new Scene (root,275,275));
                window3.getIcons().add(new Image(Main.class.getResourceAsStream("buscar.png")));
                window3.setTitle("Buscar Registro");
                window3.show();
                Label lblId2 = new Label("Ingrese el Id del vehiculo a buscar: ");
                lblId2.setStyle("-fx-font-size: 10pt;");
                TextField ID2 = new TextField();
                ID2.setPrefWidth(70);
                VBox vboxop3 = new VBox();
                vboxop3.setSpacing(5);
                vboxop3.setPadding(new Insets(0, 0, 0, 10));
                vboxop3.getChildren().addAll(lblId2,ID2,btnAceptar,btnRegresar);
                root.getChildren().addAll(vboxop3);




                btnAceptar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ////Operaciones
                        int Id =0;
                        try{
                            Id= Integer.valueOf(ID2.getText());
                        }
                        catch(Exception ime){

                        }
                        Vehiculo regVehiculo = opVehiculo.getVehiculo(Id);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        window3.getIcons().add(new Image(Main.class.getResourceAsStream("buscar.png")));
                        alert.setGraphic(new ImageView(this.getClass().getResource("iconB.png").toString()));
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Busqueda completada");
                        alert.setContentText("Su busqueda es \n"+regVehiculo);
                        alert.showAndWait();

                    }

                });

                btnRegresar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        window3.close();
                    }

                });

            }
        });


    }


    public static void main(String[] args) {
        launch(args);
    }
}
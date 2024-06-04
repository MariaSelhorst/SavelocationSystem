package main.java.com.savelocation;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import main.java.com.savelocation.model.City;

public class MainSceneController {

    public static Scene CreateScene() throws Exception {
        URL sceneUrl = MainSceneController.class.getResource("main-page-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }


    @FXML
    private TextField tfcity;

    @FXML 
    private Button btnsave;

    @FXML 
    private Pane pnsalvar;

    @FXML
    private ComboBox cbstate;

    @FXML 
    public class ComboBox extends Application{
        public void start(Stage stage){

            @FXML ComboBox cbstate = new ComboBox();
            cbstate.getItems().addAll ("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espirito Santo", "Goiás", "Maranhão", 
            "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
            "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", 
            "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia","Roraima",
            "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", "Distrito Federal");
        
        TilePane tilePane = new TilePane(cbstate);

        Scene scene = new Scene(tilePane, 300, 300);
        stage.setScene(scene);
        stage.show();
        }

    }

    @FXML 
    protected void addsavelocation(ActionEvent e){
        City newlocation = new City();
        newlocation.setnameCity(tfcity.getText());
        newlocation.setnameState(cbstate.getItems());

        Addcity newcity = new Addcity();
        newcity.insertCity(newlocation);

        Alert alert = new Alert(
            AlertType.INFORMATION,
            "Localização Adicionada!",
            ButtonType.OK);

        alert.showAndWait(); 
    }
    }




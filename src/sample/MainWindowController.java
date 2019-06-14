package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button profile;

    @FXML
    private Button createcontract;

    @FXML
    private Button contracts;

    @FXML
    void initialize() {
        contracts.setOnAction(event -> {
            openNewScene("/sample/contracts.fxml");
        });

        createcontract.setOnAction(event -> {
            openNewScene1("/sample/createcontract.fxml");
        });
    }

    public void openNewScene(String window) {
        //contracts.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/contracts.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void openNewScene1(String window) {
        //contracts.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/createcontract.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}




package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuResultat {

    @FXML
    // methode action pour le button retour
    private void retourMenuPrincipal(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    @FXML
    //methode action pour le button quiter
    private void quiter(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }


}

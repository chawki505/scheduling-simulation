package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by chawki on 27/03/2017.
 */

class ChangeMenu {


    //methode static pour afficher le menu resulta
    static void afficheMenuResultat(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(ChangeMenu.class.getResource("/Interface/MenuResultat.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Menu Resultat");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    //methode static pour affiche un des menu algo de scheduling
    static void afficheMenuAlgo(ActionEvent event, String path, String name) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(ChangeMenu.class.getResource(path));
        Stage primaryStage = new Stage();
        primaryStage.setTitle(name);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

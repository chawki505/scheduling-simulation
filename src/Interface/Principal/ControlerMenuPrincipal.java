package Interface.Principal;

import Interface.Other.ChangeMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chawki on 08/04/2017.
 */
public class ControlerMenuPrincipal implements Initializable {

    /**
     * Attribut
     **/

    // interface bouton
    @FXML
    private RadioButton Manuel;
    @FXML
    private RadioButton Aleatoire;
    @FXML
    private RadioButton csv;

    // variable pour le nom et le chemin de linterface fxml
    private static String choix;

    public static String getChoix() {
        return choix;
    }

    public static void setChoix(String choix) {
        ControlerMenuPrincipal.choix = choix;
    }

    // action du bouton suivant dans le menu principal
    @FXML
    private void buttonSuivant(ActionEvent event) throws IOException {
        choseMode();
        if (!ControlerMenuPrincipal.getChoix().equals("csv")) {
            ChangeMenu.afficheMenuChoixAlgo(event);
        } else {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(ChangeMenu.class.getResource("/Interface/Principal/MenuCSV.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("CSV Menu");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }

    //methode pour le choix du mode de saisi
    private void choseMode() {

        if (Manuel.isSelected()) {
            choix = "Manuel";
        }

        if (Aleatoire.isSelected()) {
            choix = "Aleatoire";
        }

        if (csv.isSelected()) {
            choix = "csv";
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choix = "Manuel Menu";
    }
}

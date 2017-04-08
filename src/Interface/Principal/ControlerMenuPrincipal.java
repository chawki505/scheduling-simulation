package Interface.Principal;

import Interface.Other.ChangeMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

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
        ChangeMenu.afficheMenuChoixAlgo(event);
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
            choix = "csv Menu";
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choix = "Manuel Menu";
    }
}

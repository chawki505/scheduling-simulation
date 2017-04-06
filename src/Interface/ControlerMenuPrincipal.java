package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuPrincipal implements Initializable {

    @FXML
    private RadioButton FCFS;
    @FXML
    private RadioButton SJF;
    @FXML
    private RadioButton RR;
    @FXML
    private RadioButton Priority;

    private String path, name;


    // action du bouton suivant dans le menu principal
    @FXML
    private void buttonSuivant(ActionEvent event) throws IOException {
        choseAlgo();
        ChangeMenu.afficheMenuAlgo(event, path, name);
    }


    //methode pour le choix de l'algorithme
    private void choseAlgo() {

        if (FCFS.isSelected()) {
            path = "/Interface/MenuFCFS.fxml";
            name = "FCFS Menu";
        }

        if (SJF.isSelected()) {
            path = "/Interface/MenuSJF.fxml";
            name = "SJF Menu";
        }

        if (Priority.isSelected()) {
            path = "/Interface/MenuPriority.fxml";
            name = "Priority Menu";
        }

        if (RR.isSelected()) {
            path = "/Interface/MenuRR.fxml";
            name = "RR Menu";
        }

    }







    //methode pour l'initialisation par default au lancement du programme( par defaut = fcfs)
    //methode lancer automatiquement au lancement de la fenetre fxml
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        path = "/Interface/MenuFCFS.fxml";
        name = "FCFS Menu";

        Listes.getListProcessusesFCFS().clear();
        Listes.getListProcessusesRR().clear();
        Listes.getListProcessusesPriority().clear();
        Listes.getListProcessusesSJF().clear();
        Listes.getAvg().clear();
    }
}

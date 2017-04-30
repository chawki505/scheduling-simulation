package Interface.Principal;

import Interface.Other.ChangeMenu;
import Interface.Other.Listes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuChoixAlgo implements Initializable {

    /**
     * Attribut
     **/

    // interface bouton
    @FXML
    private RadioButton FCFS;
    @FXML
    private RadioButton SJF;
    @FXML
    private RadioButton RR;
    @FXML
    private RadioButton Priority;

    // variable pour le nom et le chemin de linterface fxml
    private String path, name;


    /**
     * Methodes
     **/


    // action du bouton suivant dans le menu principal
    @FXML
    private void buttonSuivant(ActionEvent event) throws IOException {
        choseAlgo();
        ChangeMenu.afficheMenuAlgo(event, path, name);


    }


    //methode pour le choix de l'algorithme
    private void choseAlgo() {

        if (FCFS.isSelected()) {
            path = "/Interface/AlgorithmeMenu/MenuFCFS.fxml";
            name = "FCFS Menu";
        }

        if (SJF.isSelected()) {
            path = "/Interface/AlgorithmeMenu/MenuSJF.fxml";
            name = "SJF Menu";
        }

        if (Priority.isSelected()) {
            path = "/Interface/AlgorithmeMenu/MenuPriority.fxml";
            name = "Priority Menu";
        }

        if (RR.isSelected()) {
            path = "/Interface/AlgorithmeMenu/MenuRR.fxml";
            name = "RR Menu";
        }

    }


    //methode pour l'initialisation par default au lancement du programme( par defaut = fcfs)
    //methode lancer automatiquement au lancement de la fenetre fxml
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        path = "/Interface/AlgorithmeMenu/MenuFCFS.fxml";
        name = "FCFS Menu";

        Listes.getListProcessusesFCFS().clear();
        Listes.getListProcessusesRR().clear();
        Listes.getListProcessusesPriority().clear();
        Listes.getListProcessusesSJF().clear();
        Listes.getAvg().clear();
    }
}

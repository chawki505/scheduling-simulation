package Interface.AlgorithmeMenu;

import Algorithme.FCFS;


import Interface.Other.Aleatoire;
import Interface.Other.ChangeMenu;
import Interface.Principal.ControlerMenuPrincipal;
import Interface.Resultat.ControlerMenuResultat;
import Interface.Other.DetectionErreur;
import Interface.Other.Listes;
import Interface.Model.Processus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuFCFS implements Initializable {

    /**
     * Attribut
     **/

    // attribue de l'interface graphique (tableView)
    @FXML
    private TableView<Processus> tableProcessusFCFS;
    @FXML
    private TableColumn<Processus, String> nomProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> cpuTimeProcessusColumn;
    @FXML
    private TextField cpuTimeField;


    //variable pour compter le nombre de processus
    private int compteurProcessus;


    // instence de la methode fcfs
    private FCFS fcfs = new FCFS();


    /**
     * Methodes
     **/

    //methode pour ajouter les processus dans le tab
    private void add() {
        Listes.getListProcessusesFCFS().add(new Processus((compteurProcessus + 1), Integer.parseInt(cpuTimeField.getText())));
        compteurProcessus++;
        cpuTimeField.setText("");
    }


    //button ajouter processus
    @FXML
    private void ajouterProcessus(ActionEvent event) {
        if (DetectionErreur.isInputValid(cpuTimeField, "CPUtime")) {
            add();
            tableProcessusFCFS.setItems(Listes.getListProcessusesFCFS());
        }
    }


    //button calculer dans le menu fcfs
    @FXML
    private void calculerFCFS(ActionEvent event) throws Exception {
        if (!Listes.getListProcessusesFCFS().isEmpty()) {
            fcfs.runFCFSmethode();
            ControlerMenuResultat.setChoix("FCFS");
            ChangeMenu.afficheMenuResultat(event);
        }
    }

    //methode d'ajout aleatoirement
    private void addProcessusAleatoirement() {
        Aleatoire aleatoire = new Aleatoire();
        int nbr = aleatoire.getNbrProcessus();
        for (int i = 0; i < nbr; i++) {
            Listes.getListProcessusesFCFS().add(new Processus((i + 1), aleatoire.getCpuTime()));
            compteurProcessus++;
            aleatoire = new Aleatoire();
        }
        tableProcessusFCFS.setItems(Listes.getListProcessusesFCFS());
    }


    //methode par default pour l'initialisation
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        cpuTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().cpuTimeProperty());
        compteurProcessus = 0;
        cpuTimeField.setText("");

        if (ControlerMenuPrincipal.getChoix().equals("Aleatoire")) {
            addProcessusAleatoirement();
        }

    }


}
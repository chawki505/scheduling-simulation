package Interface.AlgorithmeMenu;

import Algorithme.Roundrobin;

import Interface.Other.ChangeMenu;
import Interface.Other.Aleatoire;
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


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuRR implements Initializable {

    /**
     * Attribut
     **/

    @FXML
    private TableView<Processus> tableProcessusRR;
    @FXML
    private TableColumn<Processus, String> nomProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> cpuTimeProcessusColumn;
    @FXML
    private TextField cpuTimeField;
    @FXML
    private TextField quantumField;


    //variable pour compter le nombre de processus
    private int compteurProcessus;

    private static int quantum;

    public static int getQuantum() {
        return quantum;
    }


    private Roundrobin roundrobin = new Roundrobin();


    /**
     * Methodes
     **/

    //methode pour ajouter les processus dans le tab
    private void add() {
        Listes.getListProcessusesRR().add(new Processus((compteurProcessus + 1), Integer.parseInt(cpuTimeField.getText())));
        compteurProcessus++;
        cpuTimeField.setText("");
    }


    //button ajouter processus
    @FXML
    private void ajouterProcessus(ActionEvent event) {
        if (DetectionErreur.isInputValid(cpuTimeField, "CPUtime")) {
            add();
            tableProcessusRR.setItems(Listes.getListProcessusesRR());
        }
    }


    @FXML
    //button calculer dans le menu RR
    private void calculerRR(ActionEvent event) throws IOException {
        if (DetectionErreur.isInputValid(quantumField, "Quantum") && !Listes.getListProcessusesRR().isEmpty() && Integer.parseInt(quantumField.getText()) > 0) {
            quantum = Integer.parseInt(quantumField.getText());
            roundrobin.runRRmethode();
            ControlerMenuResultat.setChoix("RR");
            ChangeMenu.afficheMenuResultat(event);
        }
    }

    //methode d'ajout aleatoirement
    private void addProcessusAleatoirement() {
        Aleatoire aleatoire = new Aleatoire();
        int nbr = aleatoire.getNbrProcessus();
        for (int i = 0; i < nbr; i++) {
            Listes.getListProcessusesRR().add(new Processus((i + 1), aleatoire.getCpuTime()));
            compteurProcessus++;
            aleatoire = new Aleatoire();
        }
        tableProcessusRR.setItems(Listes.getListProcessusesRR());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        cpuTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().cpuTimeProperty());
        compteurProcessus = 0;
        quantum = 1;
        cpuTimeField.setText("");
        quantumField.setText("");
        if (ControlerMenuPrincipal.getChoix().equals("Aleatoire")) {
            addProcessusAleatoirement();
        }
    }
}

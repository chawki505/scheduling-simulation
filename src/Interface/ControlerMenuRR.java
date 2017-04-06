package Interface;

import Interface.Calcule.TestCalcul;
import Model.Processus;
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

    public static void setQuantum(int quantum) {
        ControlerMenuRR.quantum = quantum;
    }


    private TestCalcul testCalcul = new TestCalcul();

    //methode pour ajouter les processus dans le tab
    private void add() {
        Listes.getListProcessusesRR().add(new Processus("P" + (compteurProcessus + 1), Integer.parseInt(cpuTimeField.getText())));
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
        if (DetectionErreur.isInputValid(quantumField, "Quantum")) {
            quantum = Integer.parseInt(quantumField.getText());
            testCalcul.runRR();
            ControlerMenuResultat.setChoix("RR");
            ChangeMenu.afficheMenuResultat(event);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        cpuTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().cpuTimeProperty());
        compteurProcessus = 0;
        quantum = 1;
        cpuTimeField.setText("");
        quantumField.setText("");
    }
}

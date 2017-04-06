package Interface;

import Interface.Calcule.TestCalcul;
import Model.Processus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuSJF implements Initializable {


    /**
     * attribut
     **/

    @FXML
    private TableView<Processus> tableProcessusSJF;
    @FXML
    private TableColumn<Processus, String> nomProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> cpuTimeProcessusColumn;
    @FXML
    private TextField cpuTimeField;


    //variable pour compter le nombre de processus
    private int compteurProcessus;


    private TestCalcul testCalcul = new TestCalcul();

    //methode pour ajouter les processus dans le tab
    private void add() {
        Listes.getListProcessusesSJF().add(new Processus("P" + (compteurProcessus + 1), Integer.parseInt(cpuTimeField.getText())));
        compteurProcessus++;
        cpuTimeField.setText("");
    }


    //button ajouter processus
    @FXML
    private void ajouterProcessus(ActionEvent event) {
        if (DetectionErreur.isInputValid(cpuTimeField,"CPUtime")) {
            add();
            tableProcessusSJF.setItems(Listes.getListProcessusesSJF());
        }
    }


    @FXML
    //button calculer dans le menu sjf
    private void calculerSJF(ActionEvent event) throws IOException {
        testCalcul.runSJFmethode();
        ControlerMenuResultat.setChoix("SJF");
        ChangeMenu.afficheMenuResultat(event);


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        cpuTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().cpuTimeProperty());
        compteurProcessus = 0;
        cpuTimeField.setText("");
    }
}

package Interface;

import Interface.Calcule.TestCalcul;
import Model.Processus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuFCFS implements Initializable {

    /**
     * attribut
     **/

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



    private TestCalcul testCalcul = new TestCalcul();



    /**
     * Methodes
     **/



    //methode pour ajouter les processus dans le tab
    private void add() {
        Listes.getListProcessusesFCFS().add(new Processus("P" + (compteurProcessus + 1), Integer.parseInt(cpuTimeField.getText())));
        compteurProcessus++;
        cpuTimeField.setText("");
    }


    //button ajouter processus
    @FXML
    private void ajouterProcessus(ActionEvent event) {
        if (DetectionErreur.isInputValid(cpuTimeField,"CPUtime")) {
            add();
            tableProcessusFCFS.setItems(Listes.getListProcessusesFCFS());
        }
    }


    //button calculer dans le menu fcfs
    @FXML
    private void calculerFCFS(ActionEvent event) throws Exception {
        testCalcul.runFCFSmethode();
        ControlerMenuResultat.setChoix("FCFS");
        ChangeMenu.afficheMenuResultat(event);
    }




    //methode par default pour l'initialisation
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        cpuTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().cpuTimeProperty());
        compteurProcessus = 0;
        cpuTimeField.setText("");
    }


}

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
public class ControlerMenuPriority implements Initializable {


    /**
     * attribut
     **/

    @FXML
    private TableView<Processus> tableProcessusPriority;
    @FXML
    private TableColumn<Processus, String> nomProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> cpuTimeProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> priorityProcessusColumn;
    @FXML
    private TextField cpuTimeField;
    @FXML
    private TextField priorityField;


    //variable pour compter le nombre de processus
    private int compteurProcessus;


    private TestCalcul testCalcul = new TestCalcul();


    //methode pour ajouter les processus dans le tab
    private void add() {
        Listes.getListProcessusesPriority().add(new Processus("P" + (compteurProcessus + 1), Integer.parseInt(cpuTimeField.getText()), Integer.parseInt(priorityField.getText())));
        compteurProcessus++;
        cpuTimeField.setText("");
        priorityField.setText("");
    }


    //button ajouter processus
    @FXML
    private void ajouterProcessus(ActionEvent event) {
        if (DetectionErreur.isInputValid(cpuTimeField,"CPUtime") && DetectionErreur.isInputValid(priorityField,"Priority")) {
            add();
            tableProcessusPriority.setItems(Listes.getListProcessusesPriority());
        }
    }


    @FXML
    //button calculer dans le menu priority
    private void calculerPriority(ActionEvent event) throws IOException {

        testCalcul.runPriority();
        ControlerMenuResultat.setChoix("Priority");
        ChangeMenu.afficheMenuResultat(event);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        cpuTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().cpuTimeProperty());
        priorityProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().priorityProperty());
        compteurProcessus = 0;
        cpuTimeField.setText("");
        priorityField.setText("");
    }
}

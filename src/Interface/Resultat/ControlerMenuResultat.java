package Interface.Resultat;

import Interface.Other.Listes;
import Interface.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuResultat implements Initializable {

    /**
     * Attribut
     **/

    @FXML
    private TableView<Processus> tableProcessusResulta;
    @FXML
    private TableColumn<Processus, String> nomProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> arriveProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> cpuTimeProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> priorityProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> waitingTimeProcessusColumn;
    @FXML
    private TableColumn<Processus, Number> turnAroundTimeProcessusColumn;

    @FXML
    private Label moyWaitingTime;
    @FXML
    private Label moyTurnAroundTime;

    private static String choix;


    /**
     * Methode
     **/

    @FXML
    // methode action pour le button retour
    private void retourMenuPrincipal(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/Principal/MenuPrincipal.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    @FXML
    //methode action pour le button quiter
    private void quiter(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }


    public static String getChoix() {
        return choix;
    }

    public static void setChoix(String choix) {
        ControlerMenuResultat.choix = choix;
    }

    //methode par default pour l'initialisation
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        arriveProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().arriveProperty());
        cpuTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().cpuTimeProperty());
        priorityProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().priorityProperty());
        waitingTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().waitTimeProperty());
        turnAroundTimeProcessusColumn.setCellValueFactory(cellData -> cellData.getValue().turnAroundTimeProperty());

        if (choix.equals("FCFS"))
            tableProcessusResulta.setItems(Listes.getListProcessusesFCFS());
        if (choix.equals("SJF"))
            tableProcessusResulta.setItems(Listes.getListProcessusesSJF());
        if (choix.equals("Priority"))
            tableProcessusResulta.setItems(Listes.getListProcessusesPriority());
        if (choix.equals("RR"))
            tableProcessusResulta.setItems(Listes.getListProcessusesRR());

        moyWaitingTime.setText(String.valueOf(Listes.getAvg().get(0)));
        moyTurnAroundTime.setText(String.valueOf(Listes.getAvg().get(1)));

    }

}

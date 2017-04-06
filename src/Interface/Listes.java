package Interface;

import Model.Processus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by chawki on 06/04/2017.
 */
public class Listes {

    private static ArrayList<Float> avg = new ArrayList<>();


    //tab des donnés des processus
    private static ObservableList<Processus> listProcessusesFCFS = FXCollections.observableArrayList();

    //tab des donnés des processus
    private static ObservableList<Processus> listProcessusesSJF = FXCollections.observableArrayList();


    //tab des donnés des processus
    private static ObservableList<Processus> listProcessusesPriority = FXCollections.observableArrayList();


    //tab des donnés des processus
    private static ObservableList<Processus> listProcessusesRR = FXCollections.observableArrayList();


    public static ArrayList<Float> getAvg() {
        return avg;
    }

    public static void setAvg(ArrayList<Float> avg) {
        Listes.avg = avg;
    }

    public static ObservableList<Processus> getListProcessusesFCFS() {
        return listProcessusesFCFS;
    }

    public static void setListProcessusesFCFS(ObservableList<Processus> listProcessusesFCFS) {
        Listes.listProcessusesFCFS = listProcessusesFCFS;
    }

    public static ObservableList<Processus> getListProcessusesSJF() {
        return listProcessusesSJF;
    }

    public static void setListProcessusesSJF(ObservableList<Processus> listProcessusesSJF) {
        Listes.listProcessusesSJF = listProcessusesSJF;
    }

    public static ObservableList<Processus> getListProcessusesPriority() {
        return listProcessusesPriority;
    }

    public static void setListProcessusesPriority(ObservableList<Processus> listProcessusesPriority) {
        Listes.listProcessusesPriority = listProcessusesPriority;
    }

    public static ObservableList<Processus> getListProcessusesRR() {
        return listProcessusesRR;
    }

    public static void setListProcessusesRR(ObservableList<Processus> listProcessusesRR) {
        Listes.listProcessusesRR = listProcessusesRR;
    }
}

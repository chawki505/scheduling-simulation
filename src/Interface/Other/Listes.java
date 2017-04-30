package Interface.Other;

import Interface.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by chawki on 06/04/2017.
 */
public abstract class Listes {

    private static ArrayList<Float> avg = new ArrayList<>();


    //tab des donnés des processus FCFS
    private static ObservableList<Processus> listProcessusesFCFS = FXCollections.observableArrayList();


    //tab des donnés des processus SJF
    private static ObservableList<Processus> listProcessusesSJF = FXCollections.observableArrayList();


    //tab des donnés des processus Priority
    private static ObservableList<Processus> listProcessusesPriority = FXCollections.observableArrayList();


    //tab des donnés des processus RR
    private static ObservableList<Processus> listProcessusesRR = FXCollections.observableArrayList();


    /**
     * Getters des listes
     **/

    public static ArrayList<Float> getAvg() {
        return avg;
    }


    public static ObservableList<Processus> getListProcessusesFCFS() {
        return listProcessusesFCFS;
    }


    public static ObservableList<Processus> getListProcessusesSJF() {
        return listProcessusesSJF;
    }


    public static ObservableList<Processus> getListProcessusesPriority() {
        return listProcessusesPriority;
    }


    public static ObservableList<Processus> getListProcessusesRR() {
        return listProcessusesRR;
    }


}

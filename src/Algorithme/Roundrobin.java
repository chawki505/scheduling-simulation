package Algorithme;

/**
 * Created by ibtissem on 21/03/2017.
 */

import Interface.AlgorithmeMenu.ControlerMenuRR;
import Interface.Model.Processus;
import Interface.Other.Listes;

import java.util.ArrayList;


public class Roundrobin extends Comparator {


    /**
     * Methodes
     **/


    //methode pour active les P dans la liste
    private void activeP(ArrayList<Processus> list, int horloge) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getArrive() <= horloge && list.get(i).getCpuTime() > 0 && !list.get(i).isStatus()) {
                list.get(i).setStatus(true);
            }
        }

    }

    //methode du RR
    public void runRRmethode() {

        float tempWaitingTime = 0;
        float tempTurnAroundTime = 0;
        int horloge;

        int quantum = ControlerMenuRR.getQuantum(); //recuperation de la valeur du quantum
        boolean status; //condition pour soritre de la boucle do while

        //trier par arrive
        Listes.getListProcessusesRR().sort(comparatorArrive);

        //liste d'attente
        ArrayList<Processus> tempListe = new ArrayList<>();


        //boucle pour add les processus dans la liste
        for (int i = 0; i < Listes.getListProcessusesRR().size(); i++) {
            tempListe.add(new Processus(Listes.getListProcessusesRR().get(i)));
        }


        //initialiser l'horloge au temp d'arivé du 1er
        horloge = tempListe.get(0).getArrive();


        do {
            status = false;

            activeP(tempListe, horloge); //activer les procesus selon l horloge  en cour

            //boucle de traitement horloge et waiting time
            for (int i = 0; i < tempListe.size(); i++) {

                //cpu time >= quantum
                if (tempListe.get(i).getCpuTime() >= quantum && tempListe.get(i).isStatus()) {
                    //decrementer le cpu time
                    tempListe.get(i).setCpuTime(tempListe.get(i).getCpuTime() - quantum);

                    //incrementé l'horloge
                    horloge = horloge + quantum;

                    //boucle de calcule du wait time
                    for (int j = 0; j < tempListe.size(); j++) {
                        if (j != i && tempListe.get(j).getCpuTime() != 0 && tempListe.get(i).isStatus()) {
                            tempListe.get(j).setWaitTime(tempListe.get(j).getWaitTime() + quantum);
                        }
                    }
                    //cpu time < quantum
                } else if (tempListe.get(i).getCpuTime() > 0 && tempListe.get(i).isStatus()) {

                    //boucle de calcule du wait time
                    for (int j = 0; j < tempListe.size(); j++) {
                        if (j != i && tempListe.get(j).getCpuTime() > 0 && tempListe.get(j).isStatus()) {
                            tempListe.get(j).setWaitTime(tempListe.get(j).getWaitTime() + tempListe.get(i).getCpuTime());
                        }
                    }
                    //cpu time = 0 dans le else
                    tempListe.get(i).setCpuTime(0);
                    //incrementé l'horloge
                    horloge = horloge + quantum;
                }


            }

            //boucle pour verifier si on a fini le traitement de tous les processus pour sortire du do while
            for (int k = 0; k < tempListe.size(); k++) {
                if (tempListe.get(k).getCpuTime() > 0) {
                    status = true;
                    break;
                }
            }

        } while (status);


        //boucle pour recuperer le waiting time de la list temp
        for (int i = 0; i < tempListe.size(); i++) {

            Listes.getListProcessusesRR().get(i).setWaitTime(tempListe.get(i).getWaitTime());
            //increment le waittime total
            tempWaitingTime = tempWaitingTime + Listes.getListProcessusesRR().get(i).getWaitTime();
            // calcule le turn arrond = cpu time + wait time
            Listes.getListProcessusesRR().get(i).setTurnAroundTime(Listes.getListProcessusesRR().get(i).getWaitTime() + Listes.getListProcessusesRR().get(i).getCpuTime());
            //increment le turn arrond total
            tempTurnAroundTime = tempTurnAroundTime + Listes.getListProcessusesRR().get(i).getTurnAroundTime();
        }


        //retrier la liste selon le num
        Listes.getListProcessusesRR().sort(comparatorNum);


        //calcule de la moy waiting et turnarround et save dans la liste avg
        float moyWait = (tempWaitingTime / Listes.getListProcessusesRR().size());
        float moyTurn = (tempTurnAroundTime / Listes.getListProcessusesRR().size());

        //save dans la list avg
        Listes.getAvg().add(moyWait);
        Listes.getAvg().add(moyTurn);


    }


}




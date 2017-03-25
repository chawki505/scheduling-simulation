package Main;

import Algorithme.FCFS;
import Algorithme.SJF;

/**
 * Created by chawki on 21/03/2017.
 */

public class Main {

    public static void main(String[] args) {

        FCFS fcfs = new FCFS();
        //fcfs.runFCFSmethode();

        SJF sjf = new SJF();
        sjf.runSJFmethode();


    }
}

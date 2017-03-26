package Main;

import Algorithme.FCFS;
import Algorithme.Priority;
import Algorithme.Roundrobin;

/**
 * Created by chawki on 21/03/2017.
 */
public class Main {

    public static void main(String[] args) {


        //FCFS fcfs = new FCFS();
        //fcfs.runFCFSmethode();

//main de roundrobin
       // Scanner s=new Scanner(System.in);
        //System.out.print("Enter the no of process:");
        //int n=s.nextInt();
        //Roundrobin obj = new Roundrobin(n);
        //obj.get();
        //obj.round();
        //obj.display();


        Priority p=new Priority();
        p.runPriority();

    }
}

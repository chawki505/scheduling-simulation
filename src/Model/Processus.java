package Model;

import javafx.beans.property.*;

/**
 * Created by chawki on 28/03/2017.
 */
public class Processus {

    private final StringProperty nom;
    private final IntegerProperty cpuTime;
    private final FloatProperty waitTime;
    private final FloatProperty turnAroundTime;
    private final IntegerProperty priority;


    public Processus() {
        this(null, 0, 0, 0, 0);
    }

    public Processus(String nom, int cpuTime) {
        this.nom = new SimpleStringProperty(nom);
        this.cpuTime = new SimpleIntegerProperty(cpuTime);
        this.priority = new SimpleIntegerProperty(0);
        this.waitTime = new SimpleFloatProperty(0);
        this.turnAroundTime = new SimpleFloatProperty(0);
    }

    public Processus(String nom, int cpuTime, int priority) {
        this.nom = new SimpleStringProperty(nom);
        this.cpuTime = new SimpleIntegerProperty(cpuTime);
        this.priority = new SimpleIntegerProperty(priority);
        this.waitTime = new SimpleFloatProperty(0);
        this.turnAroundTime = new SimpleFloatProperty(0);
    }

    public Processus(String nom, int cpuTime, int priority, float waitTime, float turnAroundTime) {
        this.nom = new SimpleStringProperty(nom);
        this.cpuTime = new SimpleIntegerProperty(cpuTime);
        this.priority = new SimpleIntegerProperty(priority);
        this.waitTime = new SimpleFloatProperty(waitTime);
        this.turnAroundTime = new SimpleFloatProperty(turnAroundTime);
    }


    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public int getCpuTime() {
        return cpuTime.get();
    }

    public IntegerProperty cpuTimeProperty() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime.set(cpuTime);
    }

    public int getPriority() {
        return priority.get();
    }

    public IntegerProperty priorityProperty() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority.set(priority);
    }

    public float getWaitTime() {
        return waitTime.get();
    }

    public FloatProperty waitTimeProperty() {
        return waitTime;
    }

    public void setWaitTime(float waitTime) {
        this.waitTime.set(waitTime);
    }

    public float getTurnAroundTime() {
        return turnAroundTime.get();
    }

    public FloatProperty turnAroundTimeProperty() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(float turnAroundTime) {
        this.turnAroundTime.set(turnAroundTime);
    }
}

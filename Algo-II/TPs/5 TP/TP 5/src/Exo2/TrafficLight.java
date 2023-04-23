package Exo2;
import java.util.ArrayList;
public class TrafficLight {
    ArrayList<Vehicule> queue;
    public TrafficLight(ArrayList<Vehicule> queue){
        this.queue = queue;
    }
    public void add(Vehicule other){
        Vehicule temp;
        if(other.canPass()){
            queue.add(0,other);

        }else {
            queue.add(other);
        }
    }
    @Override
    public String toString(){
        String temp = "";
        for (int i = 0; i < this.queue.size(); i++) {
            temp += queue.get(i).toString() + "\n";
        }
        return temp;
    }
}

package Model;

import java.awt.*;
import java.util.Random;

public class TrafficLight {
    private double CHANGE = 0.4;
    private String GREEN = "green";
    private String RED = "red";
    private String ID;
    private String state;
    private int position;
    private Road currentRoad_t;

    public TrafficLight(String ID, Road road) {
        this.ID = "light_"+ID;
        state = RED;
        this.currentRoad_t = road;
        position = this.currentRoad_t.getLength();//灯在路的尽头
        this.currentRoad_t.getLightsOnRoad().add(this);
    }

    public void operate(int seed){
        Random random = new Random(seed);
        double probability = random.nextDouble();
        if(probability>CHANGE){
            setState(RED);
        }else {
            setState(GREEN);
        }
    }

    public void printLightStatus(){
        System.out.printf("%s is %s on %s at position:%s%n",getID(),getState(),this.getCurrentRoad_t().getId(),this.getPosition());
    }

    public void draw(Graphics g,int scale){
        if(currentRoad_t.getOrientation()== Road.Orientation.HORIZONTAL){
            switch (state){
                case "red":
                    g.setColor(Color.red);
                    break;
                case "green":
                    g.setColor(Color.green);
            }
            int[] startLocation = getCurrentRoad_t().getStartLocation();
            int x = (getPosition() + startLocation[0]) * scale;
            int y = startLocation[1] * scale;
            int height = (getCurrentRoad_t().getWidth() / 2) * scale;
            g.fillRect(x, y, scale, height);
        }


    }


    public String getID() {
        return ID;
    }

    public String getState() {
        return state;
    }

    public int getPosition() {
        return position;
    }

    public Road getCurrentRoad_t() {
        return currentRoad_t;
    }

    public void setState(String state) {
        this.state = state;
    }
}

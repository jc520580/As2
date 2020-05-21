package Model;

import java.awt.*;
import java.util.Random;

public class Verhricle {
    private int STOPPED =  0;
    private int START_POSITION = 0;
    int length;
    int width;
    int speed;
    String Id;
    int position;
    private Color color;
    private Random random =new Random();
    private Road currentRoad;

    public  Verhricle(Road currentRoad){
        Id = "000";
        length = 4;
        width = 2;
        speed = 0;
        this.currentRoad = currentRoad;
        currentRoad.getVerhriclesOnRoad().add(this);
        color = randomColour();
    }

    public Verhricle() {
        Id = "000";
        length = 0;
        width = 0;
        speed = 0;
        position = 0;
    }

    public void Move(){
        Random random = new Random();
        int nextPosition = position+length+speed;
        for(Verhricle nextVehicle:currentRoad.getVerhriclesOnRoad()){
            if(nextVehicle.position>position&&nextVehicle.position<=nextPosition+4){
                speed =STOPPED;
                break;//检查前面有没有车
            }else {
                speed = currentRoad.getLimitedSpeed();
            }
        }

        if(speed==STOPPED){}
        else{

        }

    }

    public void draw(Graphics g,int scale){
        int x ;
        int y ;
        if(currentRoad.getOrientation()== Road.Orientation.HORIZONTAL){
            int[] startPosition = currentRoad.getStartLocation();
            int width = getLength() * scale;
            int height = getWidth() * scale;
            x = (getPosition()+startPosition[0])*scale;
            y = (startPosition[1]*scale)+scale;
            g.setColor(color);
            g.fillRect(x,y,width,height);
        }else if (currentRoad.getOrientation() == Road.Orientation.VERTICAL) {
            int[] startLocation = getCurrentRoad().getStartLocation();
            int width = getWidth() * scale;
            int height = getLength() * scale;
            x = (startLocation[0] * scale) + ((currentRoad.getWidth() * scale) - (width + scale));
            y = (getPosition() + startLocation[1]) * scale;
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    public void printStatus() {
        System.out.printf("%s going:%dm/s on %s at position:%s%n", this.getId(), this.getSpeed(), this.getCurrentRoad().
                getId(), this.getPosition());
    }
    private Color randomColour() {
        int r = random.nextInt(245 + 1) + 10;
        int g = random.nextInt(245 + 1) + 10;
        int b = random.nextInt(245 + 1) + 10;
        return new Color(r, g, b);
    }

    public int getSTART_POSITION() {
        return START_POSITION;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getSpeed() {
        return speed;
    }

    public String getId() {
        return Id;
    }

    public int getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public Road getCurrentRoad() {
        return currentRoad;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

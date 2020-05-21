package Model;

import java.awt.*;
import java.util.ArrayList;

public class Road {

    public enum Orientation {
        HORIZONTAL,VERTICAL
    }

    private Orientation orientation;
    private String id;
    int limitedSpeed;
    private int length;
    private int width;
    int[] startLocation;
    int[] endLocation;
    private ArrayList<Verhricle> verhriclesOnRoad = new ArrayList<>();
    private ArrayList<Road> connectedRoad = new ArrayList<>();
    private ArrayList<TrafficLight> lightsOnRoad = new ArrayList<>();

    public Road(String id, int limitedSpeed, int length,int[] startLocation,Orientation orientation) {
        this.id = id + "_road";
        this.limitedSpeed = limitedSpeed;
        this.length = length;
        this.width = 8;
        this.startLocation = startLocation;
        this.orientation =  orientation;
        //setEndLocation()
    }

    public void draw(Graphics g,int scale){//制表功能
        if(orientation==Orientation.HORIZONTAL){
            int[] startLocation = this.startLocation;
            int x = startLocation[0]*scale;
            int y = startLocation[1]*scale;
            int width = length*scale;
            int height = this.width*scale;
            g.setColor(Color.DARK_GRAY);//制表颜色
            g.fillRect(x,y,width,height);
            //设置中线
            g.setColor(Color.WHITE);
            g.fillRect(x, y + (height / 2) - scale / 6, width, scale / 6);
            g.fillRect(x, y + (height / 2) + scale / 6, width, scale / 6);
        }else if (orientation==Orientation.VERTICAL){
            int[] startLocation = this.startLocation;
            int x = startLocation[0] * scale;
            int y = startLocation[1] * scale;
            int width = this.width * scale;
            int height = length * scale;
            g.setColor(Color.darkGray);
            g.fillRect(x, y, width, height);
            g.setColor(Color.white);
            g.fillRect(x + (width / 2) - scale / 6, y, scale / 6, height);
            g.fillRect(x + (width / 2) + scale / 6, y, scale / 6, height);
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getId() {
        return id;
    }

    public int getLimitedSpeed() {
        return limitedSpeed;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int[] getStartLocation() {
        return startLocation;
    }

    public int[] getEndLocation() {
        return endLocation;
    }

    public ArrayList<Verhricle> getVerhriclesOnRoad() {
        return verhriclesOnRoad;
    }

    public ArrayList<Road> getConnectedRoad() {
        return connectedRoad;
    }

    public ArrayList<TrafficLight> getLightsOnRoad() {
        return lightsOnRoad;
    }
}

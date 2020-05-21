package Model;

public class Motor extends Verhricle {
    public Motor(String id, Road currentRoad) {
        super(currentRoad);
        this.Id = ("bike_" + id);
        setLength(super.getLength() / 2);
        width = super.getWidth() / 2;
        position = -length;
    }
}

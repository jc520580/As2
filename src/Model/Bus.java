package Model;

public class Bus extends Verhricle{
    public Bus(String id, Road currentRoad) {
        super(currentRoad);
        this.Id = ("bus_" + id);
        setLength(super.getLength() * 3);
        position = -length;
    }
}

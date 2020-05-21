package Model;

public class Car extends Verhricle {
    public Car(String id, Road currentRoad) {
        super(currentRoad);
        this.Id = "car_" + id;
        setLength(super.getLength());
        width = length / 2;
        position = -length;
    }
}

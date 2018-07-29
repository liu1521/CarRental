package indi.liu;

public class Pickup extends Car {

    private int seating;

    private float loadWeight;

    public Pickup(int id, String name, int price, int seating, float loadWeight) {
        super(id, name, price);
        this.seating = seating;
        this.loadWeight = loadWeight;
    }

    public int getSeating() {
        return seating;
    }

    public float getLoadWeight() {
        return loadWeight;
    }

    @Override
    public String toString() {
        return "[ 序号:" + getId() + ", 名称:" + getName() + ", 租车费用（元/（车·天））:" + getPrice() + ", 最大载人（人）:" + seating + ", 最大载货（吨）:" + loadWeight + " ]";
    }
}

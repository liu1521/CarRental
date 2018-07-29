package indi.liu;

public class Truck extends Car {

    private float loadWeight;

    public Truck(int id, String name, int price, float loadWeight) {
        super(id, name, price);
        this.loadWeight = loadWeight;
    }

    public float getLoadWeight() {
        return loadWeight;
    }

    @Override
    public String toString() {
        return "[ 序号:" + getId() + ", 名称:" + getName() + ", 租车费用（元/（车·天））:" + getPrice() + ", 最大载货（吨）:" + loadWeight + " ]";

    }
}

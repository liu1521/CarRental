package indi.liu;

/**
 * Create by : liu
 * Create on : 2018/7/25
 * Create for : 载客车类
 */

public class Bus extends Car {

    //座位数
    private int seating;

    public Bus(int id, String name, int price, int seating) {
        super(id, name, price);
        this.seating = seating;
    }

    public int getSeating() {
        return seating;
    }

    @Override
    public String toString() {
        return "[ 序号:" + getId() + ", 名称:" + getName() + ", 租车费用（元/（车·天））:" + getPrice() + ", 最大载人（人）:" + seating + " ]";
    }
}

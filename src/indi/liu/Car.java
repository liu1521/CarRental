package indi.liu;

/**
 * Create by : liu
 * Create on : 2018/7/25
 * Create for : 汽车类
 */

public class Car {

    //序号
    private int id;

    //名称
    private String name;

    //价格
    private int price;

    public Car(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalPrice(int day) {
        return day * price;
    }
}

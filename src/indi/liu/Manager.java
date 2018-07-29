package indi.liu;

import java.util.*;

/**
 * create by : liu
 * Create on : 2018/7/25
 * Create for : 汽车租赁管理
 */

public class Manager {

    //保存汽车信息
    private List<Car> cars = new ArrayList<>();
    //用户输入
    private Scanner in = new Scanner(System.in);
    //总的载客量
    private int totalSeating = 0;
    //总的载货量
    private float totalLoadWeight = 0;
    //总价格
    private int totalPrice = 0;
    //总租赁车辆数
    private int totalNumber = 0;
    //保存每种车的租赁信息
    private Map<Integer, int[]> carsInfo = new HashMap<>();


    //初始化已有车辆信息
    private Manager() {
        cars.add(new Bus(1, "小轿车", 40, 4));
        cars.add(new Bus(2, "面包车", 65, 7));
        cars.add(new Bus(3, "大巴车", 180, 20));
        cars.add(new Truck(4, "低栏车", 30, 1.5f));
        cars.add(new Truck(5, "高栏车", 47, 2.5f));
        cars.add(new Truck(6, "厢式车", 80, 4.5f));
        cars.add(new Pickup(7, "日式皮卡车", 60, 5, 1));
        cars.add(new Pickup(8, "美式皮卡车", 60, 2, 3));
    }

    //显示已有车辆信息
    private void show() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
        }
    }

    //租车操作,记录租车的序号、数量、天数
    private void leasehold() {
        System.out.println("请选择你要租赁的车辆序号");
        String choice;
        //当用户输入1-8时才进行租车数量和天数的记录
        while ((choice = in.nextLine()).matches("[1-8]")) {
            int i = Integer.valueOf(choice) - 1;
            System.out.println("你选择的车辆名称是" + cars.get(i).getName());
            int num;
            int day;
            System.out.println("请输入要租赁的数量");
            while ((num = in.nextInt()) <= 0) {
                System.out.println("输入有误,请重新输入");
            }
            System.out.println("请输入要租赁的天数");
            while ((day = in.nextInt()) <= 0) {
                System.out.println("输入有误,请重新输入");
            }
            int[] info = {num, day};
            carsInfo.put(i, info);
        }
    }

    //显示当前的租车信息
    private void showInfo() {
        for (int i = 0; i < carsInfo.size(); i++) {
            int[] info = carsInfo.get(i);
            if (info == null) continue;
            System.out.println(cars.get(i).getName() + info[0] + "辆,租赁" + info[1] + "天");
        }
    }

    //结算,得到总租车数量、价格、载客量和载货量
    private void settlement() {
        for (int i = 0; i < carsInfo.size(); i++) {
            int[] info = carsInfo.get(i);
            if (info == null) continue;
            totalPrice += cars.get(i).getPrice() * info[0] * info[1];
            totalNumber++;

            //因为有3种类型的车,他们的载客、载货信息不一样、这里分别处理
            if (i < 3) totalSeating += ((Bus) cars.get(i)).getSeating() * info[0];
            else if (i < 6) totalLoadWeight += ((Truck) cars.get(i)).getLoadWeight() * info[0];
            else {
                Pickup p = (Pickup) cars.get(i);
                totalSeating += p.getSeating() * info[0];
                totalLoadWeight += p.getLoadWeight() * info[0];
            }
        }
    }

    //菜单,控制程序流程走向
    private void menu() {
        System.out.println("欢迎来到租车系统");
        System.out.println("请问您是否需要租车\ty/n");
        //如果输入不是y就退出
        if (!in.nextLine().equals("y")) {
            System.out.println("欢迎下次使用！");
            in.close();
            return;
        }
        System.out.println("现有车辆信息如下:");
        show();
        while (true) {
            leasehold();
            System.out.println("请问是否还要租其他车\ty/n");
            if (!in.nextLine().equals("y")) break;
        }
        System.out.println("你目前的租赁信息如下:");
        showInfo();
        System.out.println("是否需要修改?\ty/n");
        if (in.nextLine().equals("y")) {
            while (true) {
                leasehold();
                System.out.println("是否还要修改\ty/n");
                if (!in.nextLine().equals("y")) break;
            }
        }
        settlement();
        System.out.println("你目前租赁信息如下:");
        showInfo();
        System.out.println("一共租车" + totalNumber + "辆,共可载人" + totalSeating + "人,可载货" + +totalLoadWeight + "吨,共计" + totalPrice + "元");
        in.nextLine();
    }

    public static void main(String[] args) {
        new Manager().menu();
    }
}

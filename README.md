# CarRental
v1.0

Car类
    所有汽车类的超类，包含序号id，名称name，价格price三个属性和计算价格getTotalPrice()方法
    
Bus类
    载客车，继承自Car类，增加座位seating属性，重写toString()方法以展示车辆信息
    
Truck类
    载货车，继承自Car类，增加载货量loadWeight属性，重写toString()方法以展示车辆信息
        
Pickup类
    皮卡车，继承自Car类，增加座位seating和载货量loadWeight属性，重写toString()方法以展示车辆信息    
    
Manager类
    整个程序的管理，控制程序的流程走向
    

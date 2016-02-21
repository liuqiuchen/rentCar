package com.rentcar;
import java.util.Scanner;
import java.util.Arrays;

/**
 * 控制台版的答答租车系统
功能：
1.展示所有可租车辆
2.选择车型、租车量
3.展示租车清单，包含：总金额、总载货量及其车型、总载人量以及车型
项目分析：
1.数据模型分析【集成度较高】（把生活中的事提取成数据结构：操作（方法）、属性）
载客车（载客量）：小客车（5人以下）、大客车（10人以上）
载货车（载货量）：轻型车（5吨）、重型车（5吨-20吨）
既能载货又能载客（载客量和载货量）
2.业务模型分析（考虑用户选车、租车天数、统计金额、载客、货量）
3.显示和流程分析（Scanner）：请选择车辆->请输入序号->输出总金额

//数据参考：
欢迎使用答答租车系统：
您是否要租车：1是0否
1
您可租车的类型及其价目表：
序号	汽车名称	租金	容量
1. 	奥迪A4	500元/天	载人：4人
2. 	马自达6	400元/天	载人：4人
3. 	皮卡雪6	450元/天	载人：4人 载货：2吨
4. 	金龙	800元/天	载人：20人
5. 	松花江	400元/天	载货：4吨
6. 	依维柯 	1000元/天	载货：20吨
请输入您要租汽车的数量：
4
请输入第1辆车的序号：
1
请输入第2辆车的序号：
2
请输入第3辆车的序号：
3
请输入第4辆车的序号：
4
请输入租车天数：
3
您的账单：
***可载人的车有：
奥迪A4 马自达6 皮卡雪6 金龙 共载人：32人
***载货的车有：
皮卡雪6 共载货：2.0吨
***租车总价格：6450.0元*/

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用答答租车系统");
		
		Scanner input1 = new Scanner(System.in);
		System.out.println("您是否要租车（1.是 0.否）：");
		int result = input1.nextInt();
		if(result == 1){
			//System.out.println("展示租车信息");
			/**
			  	序号	汽车名称	租金	容量
				1. 	奥迪A4	500元/天	载人：4人
				2. 	马自达6	400元/天	载人：4人
				3. 	皮卡雪6	450元/天	载人：4人 载货：2吨
				4. 	金龙	800元/天	载人：20人
				5. 	松花江	400元/天	载货：4吨
				6. 	依维柯 	1000元/天	载货：20吨
			**/
			Cars[] cars = {
								new Bus(4,500,"奥迪A4"),
								new Bus(4,400,"马自达6"),
								new DoubleCars(4,450,"皮卡雪6",2),
								new Bus(20,800,"金龙"),
								new GoodsTrain(4,400,"松花江"),
								new GoodsTrain(40,1000,"依维柯")
							}; 
			//System.out.println(cars[0].name);
			
			System.out.println("序号 汽车名称 租金 容量");
			for(int i = 0;i < cars.length;i++){	
				if((cars[i].people > 0) && (cars[i].goods == 0)){
					System.out.println((i + 1) + 
							" " + cars[i].name +
							" " + cars[i].money + 
							"元/天 " + cars[i].people + "人"
							);
				}
				if((cars[i].goods > 0) && (cars[i].people == 0)){
					System.out.println((i + 1) + 
							" " + cars[i].name +
							" " + cars[i].money + 
							"元/天 " + cars[i].goods + "吨"
							);
				}
				if((cars[i].goods > 0) && (cars[i].people > 0)){
					System.out.println((i + 1) + 
							" " + cars[i].name +
							" " + cars[i].money + 
							"元/天 " + cars[i].people + "人 " +
							cars[i].goods + "吨"
							);
				}
				
			}
			
			System.out.println("请输入您要租汽车的数量：");
			Scanner input2 = new Scanner(System.in);
			int carNum = input2.nextInt();
			
			//用户租车序号储存的数组
			int[] orderCars = new int[carNum];
			
			for(int j = 0;j < carNum;j++){
				System.out.println("请输入第" + (j + 1) + "辆车的序号：");
				orderCars[j] = new Scanner(System.in).nextInt();
			}
			
			System.out.println("您的账单：");
			
			//初始化统计共载人量、载货量
			int sumPeople = 0;
			int sumGoods = 0;
			
			System.out.println("***可载人的车有：");
			//循环遍历拿到用户租车的序号值
			for(int k = 0;k < orderCars.length;k++){
				if(cars[orderCars[k] - 1].people > 0){
					System.out.println(cars[orderCars[k] - 1].name);
					sumPeople = sumPeople + cars[orderCars[k] - 1].people;
				}
			}
			
			System.out.println("***可载货的车有：");
			for(int k = 0;k < orderCars.length;k++){
				if(cars[orderCars[k] - 1].goods > 0){
					System.out.println(cars[orderCars[k] - 1].name);
					sumGoods = sumGoods + cars[orderCars[k] - 1].goods;
				}
			}
			
			//初始化总金额
			int sumMoney = 0;
			for(int k = 0;k < orderCars.length;k++){
				sumMoney += cars[orderCars[k] - 1].money;
			}
						
			System.out.println("***共载人：" + sumPeople);
			System.out.println("***共载货：" + sumGoods);
			System.out.println("***租车总金额：" + sumMoney);
			
		}else{
			System.out.println("再见！答答租车系统欢迎您的下次到来~");
		}
	}

}

package com.rentcar;
import java.util.Scanner;
import java.util.Arrays;

/**
 * ����̨��Ĵ���⳵ϵͳ
���ܣ�
1.չʾ���п��⳵��
2.ѡ���͡��⳵��
3.չʾ�⳵�嵥���������ܽ����ػ������䳵�͡����������Լ�����
��Ŀ������
1.����ģ�ͷ��������ɶȽϸߡ����������е�����ȡ�����ݽṹ�������������������ԣ�
�ؿͳ����ؿ�������С�ͳ���5�����£�����ͳ���10�����ϣ�
�ػ������ػ����������ͳ���5�֣������ͳ���5��-20�֣�
�����ػ������ؿͣ��ؿ������ػ�����
2.ҵ��ģ�ͷ����������û�ѡ�����⳵������ͳ�ƽ��ؿ͡�������
3.��ʾ�����̷�����Scanner������ѡ����->���������->����ܽ��

//���ݲο���
��ӭʹ�ô���⳵ϵͳ��
���Ƿ�Ҫ�⳵��1��0��
1
�����⳵�����ͼ����Ŀ��
���	��������	���	����
1. 	�µ�A4	500Ԫ/��	���ˣ�4��
2. 	���Դ�6	400Ԫ/��	���ˣ�4��
3. 	Ƥ��ѩ6	450Ԫ/��	���ˣ�4�� �ػ���2��
4. 	����	800Ԫ/��	���ˣ�20��
5. 	�ɻ���	400Ԫ/��	�ػ���4��
6. 	��ά�� 	1000Ԫ/��	�ػ���20��
��������Ҫ��������������
4
�������1��������ţ�
1
�������2��������ţ�
2
�������3��������ţ�
3
�������4��������ţ�
4
�������⳵������
3
�����˵���
***�����˵ĳ��У�
�µ�A4 ���Դ�6 Ƥ��ѩ6 ���� �����ˣ�32��
***�ػ��ĳ��У�
Ƥ��ѩ6 ���ػ���2.0��
***�⳵�ܼ۸�6450.0Ԫ*/

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��ӭʹ�ô���⳵ϵͳ");
		
		Scanner input1 = new Scanner(System.in);
		System.out.println("���Ƿ�Ҫ�⳵��1.�� 0.�񣩣�");
		int result = input1.nextInt();
		if(result == 1){
			//System.out.println("չʾ�⳵��Ϣ");
			/**
			  	���	��������	���	����
				1. 	�µ�A4	500Ԫ/��	���ˣ�4��
				2. 	���Դ�6	400Ԫ/��	���ˣ�4��
				3. 	Ƥ��ѩ6	450Ԫ/��	���ˣ�4�� �ػ���2��
				4. 	����	800Ԫ/��	���ˣ�20��
				5. 	�ɻ���	400Ԫ/��	�ػ���4��
				6. 	��ά�� 	1000Ԫ/��	�ػ���20��
			**/
			Cars[] cars = {
								new Bus(4,500,"�µ�A4"),
								new Bus(4,400,"���Դ�6"),
								new DoubleCars(4,450,"Ƥ��ѩ6",2),
								new Bus(20,800,"����"),
								new GoodsTrain(4,400,"�ɻ���"),
								new GoodsTrain(40,1000,"��ά��")
							}; 
			//System.out.println(cars[0].name);
			
			System.out.println("��� �������� ��� ����");
			for(int i = 0;i < cars.length;i++){	
				if((cars[i].people > 0) && (cars[i].goods == 0)){
					System.out.println((i + 1) + 
							" " + cars[i].name +
							" " + cars[i].money + 
							"Ԫ/�� " + cars[i].people + "��"
							);
				}
				if((cars[i].goods > 0) && (cars[i].people == 0)){
					System.out.println((i + 1) + 
							" " + cars[i].name +
							" " + cars[i].money + 
							"Ԫ/�� " + cars[i].goods + "��"
							);
				}
				if((cars[i].goods > 0) && (cars[i].people > 0)){
					System.out.println((i + 1) + 
							" " + cars[i].name +
							" " + cars[i].money + 
							"Ԫ/�� " + cars[i].people + "�� " +
							cars[i].goods + "��"
							);
				}
				
			}
			
			System.out.println("��������Ҫ��������������");
			Scanner input2 = new Scanner(System.in);
			int carNum = input2.nextInt();
			
			//�û��⳵��Ŵ��������
			int[] orderCars = new int[carNum];
			
			for(int j = 0;j < carNum;j++){
				System.out.println("�������" + (j + 1) + "��������ţ�");
				orderCars[j] = new Scanner(System.in).nextInt();
			}
			
			System.out.println("�����˵���");
			
			//��ʼ��ͳ�ƹ����������ػ���
			int sumPeople = 0;
			int sumGoods = 0;
			
			System.out.println("***�����˵ĳ��У�");
			//ѭ�������õ��û��⳵�����ֵ
			for(int k = 0;k < orderCars.length;k++){
				if(cars[orderCars[k] - 1].people > 0){
					System.out.println(cars[orderCars[k] - 1].name);
					sumPeople = sumPeople + cars[orderCars[k] - 1].people;
				}
			}
			
			System.out.println("***���ػ��ĳ��У�");
			for(int k = 0;k < orderCars.length;k++){
				if(cars[orderCars[k] - 1].goods > 0){
					System.out.println(cars[orderCars[k] - 1].name);
					sumGoods = sumGoods + cars[orderCars[k] - 1].goods;
				}
			}
			
			//��ʼ���ܽ��
			int sumMoney = 0;
			for(int k = 0;k < orderCars.length;k++){
				sumMoney += cars[orderCars[k] - 1].money;
			}
						
			System.out.println("***�����ˣ�" + sumPeople);
			System.out.println("***���ػ���" + sumGoods);
			System.out.println("***�⳵�ܽ�" + sumMoney);
			
		}else{
			System.out.println("�ټ�������⳵ϵͳ��ӭ�����´ε���~");
		}
	}

}

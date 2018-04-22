package cn.lym77.chess.game;

import java.awt.Point;

public class Rule {
	/**
	 * ��ȡĬ�����Ӳ���
	 * @return
	 */
	public static int[] getDefaultMap() {
		return new int[] {
				// 1
				17, 15, 12, 11, 14, 11, 12, 15, 17,
				// 2
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				// 3
				0, 13, 0, 0, 0, 0, 0, 13, 0,
				// 4
				16, 0, 16, 0, 16, 0, 16, 0, 16,
				// 5
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				// 5
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				// 4
				26, 0, 26, 0, 26, 0, 26, 0, 26,
				// 3
				0, 23, 0, 0, 0, 0, 0, 23, 0,
				// 2
				0, 0, 0, 0, 0, 0, 0, 0, 0,
				// 1
				27, 25, 22, 21, 24, 21, 22, 25, 27 };
	}

	// 1��ʿ��2����3���ڣ�4������5����6���䣻7����
	/**
	 * ������Գԣ������յ�û�����ӵ������
	 * @param map ���Ӳ���
	 * @param start ���
	 * @param aim �յ�
	 * @return ������ӿ����߹�ȥ��������
	 */
	public static boolean canEat(int[] map, int start, int aim) {
		Point p1 = intToPoint(start);
		Point p2 = intToPoint(aim);
		if (map[start] % 10 == 1) {
			// ��������ʿ
			// 3,0---3,9
			// 4,1---4,8
			// 5,2---5,7
			// 3,2---3,7
			// 5,0---5,9
			int center1 = pointToInt(4, 1);
			int center2 = pointToInt(4, 8);
			if ((start == center1) || (start == center2) || (aim == center1) || (aim == center2)) {
				if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 1){
					return true;
				}
			}
			return false;
		}
		if (map[start] % 10 == 2) {
			// ����������
			if(aim<45&&start>45){
				return false;
			}
			if(aim>45&&start<45){
				return false;
			}
			//�������
			if (Math.abs(p1.x - p2.x) == 2 && Math.abs(p1.y - p2.y) == 2){
				//���û�б�����
				if(map[pointToInt((p1.x+p2.x)/2, (p1.y+p2.y)/2)]%10==0){
					return true;
				};
			}
			return false;
		}
		if (map[start] % 10 == 3) {
			// ����������
			if(p1.y==p2.y){
				if(p1.x>p2.x){
					//����
					//�ϵK��
					int temp = 0;
					for (int i = 1; i < p1.x-p2.x; i++) {
						if(map[pointToInt(p1.x-i, p1.y)]%10!=0){
							temp++;
						}
					}
					//����K�c����
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}else{
					//����
					//�ϵK��
					int temp = 0;
					for (int i = 1; i < p2.x-p1.x; i++) {
						if(map[pointToInt(p1.x+i, p1.y)]%10!=0){
							temp++;
						}
					}
					//����K�c����
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}
			}
			if(p1.x==p2.x){
				if(p1.y>p2.y){
					//����
					//�ϵK��
					int temp = 0;
					for (int i = 1; i < p1.y-p2.y; i++) {
						if(map[pointToInt(p1.x, p1.y-i)]%10!=0){
							temp++;
						}
					}
					//����K�c����
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}else{
					//����
					//�ϵK��
					int temp = 0;
					for (int i = 1; i < p2.y-p1.y; i++) {
						if(map[pointToInt(p1.x, p1.y+i)]%10!=0){
							temp++;
						}
					}
					//����K�c����
					if(map[aim]%10!=0){
						if(temp==1){
							return true;
						}
					}else{
						if(temp==0){
							return true;
						}
					}
				}
			}
		}
		if (map[start] % 10 == 4) {
			// �������ǽ�
			if(map[aim] % 10 == 4){
				//����K�cҲ�ǌ�
				if(p1.x==p2.x){
					if(p1.y>p2.y){
						//����
						for (int i = 1; i < p1.y-p2.y; i++) {
							if(map[pointToInt(p1.x, p1.y-i)]%10!=0){
								return false;
							}
						}
						return true;
					}else{
						//����
						for (int i = 1; i < p2.y-p1.y; i++) {
							if(map[pointToInt(p1.x, p1.y+i)]%10!=0){
								return false;
							}
						}
						return true;
					}
				}
			}
			if(Math.abs(p1.x - p2.x)+Math.abs(p1.y - p2.y)==1){
				if(p2.x>=3&&p2.x<=5){
					if(p2.y>=0&&p2.y<=2){
						return true;
					}
					if(p2.y>=7&&p2.y<=9){
						return true;
					}
				};
			}
			return false;
		}
		if (map[start] % 10 == 5) {
			// ����������
			if(Math.abs(p1.x - p2.x)+Math.abs(p1.y - p2.y)==3){
				if(p1.x - p2.x==2){
					//����
					if(map[pointToInt(p1.x-1, p1.y)]%10==0){
						return true;
					}
				}
				if(p1.x - p2.x==-2){
					//����
					if(map[pointToInt(p1.x+1, p1.y)]%10==0){
						return true;
					}
				}
				if(p1.y - p2.y==2){
					//����
					if(map[pointToInt(p1.x, p1.y-1)]%10==0){
						return true;
					}
				}
				if(p1.y - p2.y==-2){
					//����
					if(map[pointToInt(p1.x, p1.y+1)]%10==0){
						return true;
					}
				}
			}
		}

		if (map[start] % 10 == 6) {
			// ����������
			if(Math.abs(p1.x - p2.x)+Math.abs(p1.y - p2.y)==1){
				if(p1.y-p2.y==-1){
					return false;
				}
				if(p1.y==p2.y){
					if(start>=45){
						return false;
					}
				}
				return true;
			}
		}
		if (map[start] % 10 == 7) {
			// �������ǳ�
			if(p1.y==p2.y){
				if(p1.x>p2.x){
					//����
					for (int i = 1; i < p1.x-p2.x; i++) {
						if(map[pointToInt(p1.x-i, p1.y)]%10!=0){
							return false;
						}
					}
					return true;
				}else{
					//����
					for (int i = 1; i < p2.x-p1.x; i++) {
						if(map[pointToInt(p1.x+i, p1.y)]%10!=0){
							return false;
						}
					}
					return true;
				}
			}
			if(p1.x==p2.x){
				if(p1.y>p2.y){
					//����
					for (int i = 1; i < p1.y-p2.y; i++) {
						if(map[pointToInt(p1.x, p1.y-i)]%10!=0){
							return false;
						}
					}
					return true;
				}else{
					//����
					for (int i = 1; i < p2.y-p1.y; i++) {
						if(map[pointToInt(p1.x, p1.y+i)]%10!=0){
							return false;
						}
					}
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * ����ת��Ϊ����ָ������
	 * @param x ������
	 * @param y ������
	 * @return ��������
	 */
	public static int pointToInt(int x, int y) {
		return x + y * 9;
	}

	/**
	 * ������ָ��ת��Ϊ�����
	 * @param num ����ָ��
	 * @return ���������
	 */
	public static Point intToPoint(int num) {
		return new Point(num % 9, num / 9);
	}

	/**
	 * �����Ӳ��ַ�ת
	 * @param map ���Ӳ���
	 * @return �������Ӳ�������
	 */
	public static int[] rotateMap(int map[]) {
		// ��1�е���10��
		// 1-->10,2-->9,3-->8,4-->7,5-->6
		int re[] = new int[map.length];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				// 12345 54321
				// ��1������λ��9
				// 9��7��5��3��1
				int p = 9 - i * 2;
				p = p * 9;
				re[i * 9 + j + p] = map[i * 9 + j];
				re[i * 9 + j] = map[i * 9 + j + p];
			}
		}
		return re;
	}
}

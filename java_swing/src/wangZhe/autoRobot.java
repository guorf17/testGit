package wangZhe;

/**
 * <p>机器操作模块--简易智能.
 * @author grf
 * <p>智能机器人分为两种--一种为机器法师，另一种为机器战士
 * <p>英雄符号'f'代表机器法师，能够进行障碍物搜索操作，
 * <p>如果战场上有障碍物，机器法师会朝着障碍物一步一步移动靠近,如果战场上没有障碍物或者已经到达障碍物旁边，机器法师会进行发呆操作
 * <p>符号'z'代表机器战士，能够进行战场英雄搜索，如果有其他英雄在攻击范围之内，就会对距离最近的英雄进行攻击
 * <p>如果机器战士附近没其他英雄在攻击范围之内，就会进行发呆操作.
 */
public class autoRobot implements Runnable, Map, heroList {

		protected int a = 1, b = 2;
/**
 * override the function run.
 */
		@Override
		public void run() {
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
			}

			synchronized (this) {
				Thread t = Thread.currentThread();
				// TODO Auto-generated method stub
				autoFaShi AutoFaShi = new autoFaShi();
				AutoFaShi.initAutoMap();
				autoZhanShi AutoZhanShi = new autoZhanShi();
				AutoZhanShi.initAutoMap();
				while (gameOver[0] == "1") {
					try {
						//System.out.println("AutoFaShi 法师正在进行操作！");
						String action=AutoFaShi.searchObstacle();
						if(action.compareTo("null")==0||action.compareTo("arrive")==0) {
							//stay or other action
							System.out.println("AutoFaShi机器法师正在发呆！");
						}else {
							heroMove(AutoFaShi,action);
						}
				
						Thread.sleep(4000);
					} catch (InterruptedException e) {
					}
					try {
						//System.out.println("AutoZhanShi 战士正在进行操作！");
						if(AutoZhanShi.searchHero()!=null) {
							attackHero(AutoZhanShi.searchHero(),AutoZhanShi.attackHeroNum);
						}else {
							System.out.println("AutoZhanShi机器战士正在发呆！");
						}
						
						Thread.sleep(4000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(t.getName() + "-finished");
			}
		}
		
	
		/**
	     * <p>英雄进行移动操作
	     * <p>每次只能选上下左右其中一个方向移动1步.
	     * <p>移动之前进行是否可以移动判断，判断可以移动之后进行移动操作，并在地图上做相应的修改
	     * <p>每次成功移动移动一步，英雄的经验值Exp+2;
	     * @param hero(传入英雄对象)
	     * @param direction(传入英雄移动的方向)
	     */
		public void heroMove(hero hero, String direction) {
			int posX = hero.posX;
			int posY = hero.posY;
			if (direction.compareTo("up") == 0) {
				if (posX == 0 || map[posX - 1][posY].compareTo("-") != 0) {
					System.out.println(hero.getName()+" move up failure!");
				} else {//move操作成功，对英雄新的位置进行设置，把原来的设为正常符号“-”
					map[posX - 1][posY] = hero.name;
					hero.setPosXPosY(posX - 1, posY);
					map[posX][posY] = "-";
					//hero.setExp(hero.getExp()+2);//移动成功，经验值增加2
				}
				hero.basicDisplay();
			} else if (direction.compareTo("down") == 0) {
				if (posX == 13 || map[posX + 1][posY].compareTo("-") != 0) {
					System.out.println(hero.getName()+"move down failure!");
				} else {
					map[posX + 1][posY] = hero.name;
					hero.setPosXPosY(posX + 1, posY);
					map[posX][posY] = "-";
					//hero.setExp(hero.getExp()+2);//移动成功，经验值增加2
				}
				hero.basicDisplay();
			} else if (direction.compareTo("left") == 0) {
				if (posY == 1 || map[posX][posY - 1].compareTo("-") != 0) {
					System.out.println(hero.getName()+"move left failure!");
				} else {
					map[posX][posY - 1] = hero.name;
					hero.setPosXPosY(posX, posY - 1);
					map[posX][posY] = "-";
					//hero.setExp(hero.getExp()+2);//移动成功，经验值增加2
				}
				hero.basicDisplay();
			} else if (direction.compareTo("right") == 0) {
				if (posY == 13 || map[posX][posY + 1].compareTo("-") != 0) {
					System.out.println(hero.getName()+"move right failure!");
				} else {
					map[posX][posY + 1] = hero.name;
					hero.setPosXPosY(posX, posY + 1);
					map[posX][posY] = "-";
					//hero.setExp(hero.getExp()+2);//移动成功，经验值增加2
				}
				hero.basicDisplay();
			}
		}
		/**
		 * <p>英雄攻击方法
		 * <p>英雄指定一个敌方英雄攻击，如果在敌方英雄在攻击距离之内，则攻击成功
		 * <p>如果攻击成功，对方英雄生命值HP-10，经验值Exp+10；己方英雄魔法值MP+10，经验值Exp=10；
		 * <p>同时输出攻击的具体信息和攻击之后双方英雄的基本信息
		 * @param hero
		 * @param beAttackHeroNum
		 */
		public void attackHero(hero beAttackHero, int beAttackHeroNum) {			
				beAttackHero.beAttacked();//英雄被攻击，调用英雄被攻击函数，HP-10,Exp+10;
				System.out.println(beAttackHero.getCountry()+"战队的"+beAttackHeroNum+"号英雄"+beAttackHero.getName()+" 被智能机器战士攻击了！!");
				beAttackHero.basicDisplay();
				if(beAttackHero.heroDie()) {
					System.out.println(beAttackHero.getCountry()+"战队的"+beAttackHeroNum+"号英雄"+beAttackHero.getName()+" 死亡!");
					deleteHero(beAttackHero,beAttackHeroNum);
				}		
		}
		/**
		 * <p>移除英雄操作
		 * <p>当某个英雄被杀死之后，移除英雄在战场上的的位置，把初始位置设置为&字符
		 * @param beAttackHero(传入被杀死的英雄对象)
		 */
		public void deleteHero(hero beAttackHero,int number){		
			if(beAttackHero.getCountryBool()==1) {
				hero dieHero = redHeroList.get(number);
				map[dieHero.getPosX()][dieHero.getPosY()]="-";
				map[0][5+number]="&";//原来英雄的位置变为&号，代表英雄死亡
			}
			else {
				hero dieHero = blueHeroList.get(number);
				map[dieHero.getPosX()][dieHero.getPosY()]="-";
				map[13][5+number]="&";//原来英雄的位置变为&号，代表英雄死亡
			}
		}
		
}

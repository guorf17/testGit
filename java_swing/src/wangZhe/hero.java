package wangZhe;

//快捷键Alt+Shift+R 全部替换变量名
interface constantValue {
	int maxHP=50;
	int maxMP=100;
	int maxExp=150;	
}

public class hero implements Map,heroList{
/**
 * 生命值HP、魔法值MP、经验值Exp（回调）等；h
 * 能力招式包括主动技能、被动技能
 */
		int HP;//生命值
	    int MP;//魔法值
	    int Exp;//经验值
	    int posX;//坐标X
	    int posY;//坐标Y
	    int attackDistance;//攻击距离
	    String name;//人物字符
	    String country;//人物所属战队
	    int countryBool;//进行战队区分，默认蓝队为0，红队为1
	    /** 
	    * <p>Title:无参构造函数 </p> 
	    * <p>Description:进行人物角色基类的初始化 </p>  
	    */
	    hero(){
	    	HP=30;
	    	MP=30;
	    	Exp=0;
	    	attackDistance=1;
	    	name = null;
	    	country = null;
	    }
	    public int getHP() {
	    	return HP;
	    }
	    public int getMP() {
	    	return MP;
	    }
	    public int getExp() {
	    	return Exp;
	    }
	    public int getPosX() {
	    	return posX;
	    }
	    public int getPosY() {
	    	return posY;
	    }
	    public String getName() {
	    	return name;
	    }
	    public String getCountry() {
	    	return country;
	    }
	    public int getCountryBool() {
	    	return countryBool;
	    }
	    public int getAttackDistance() {
	    	return attackDistance;
	    }
	    public void setHP(int _HP) {
	    	HP = _HP;
	    }
	    public void setMP(int _MP) {
	    	MP = _MP;
	    }
	    public void setExp(int _Exp) {
	    	Exp = _Exp;
	    }
	    public void setPosX(int _posX) {
	    	posX = _posX;
	    }
	    public void setPosY(int _posY) {
	    	posY = _posY;
	    }
	    public void setAttackDistance(int _attackDis) {
	    	attackDistance = _attackDis;
	    }
	    public void setCountry(String _country,int _countryBool) {
	    	country = _country;
	    	countryBool = _countryBool;
	    }
	    /**   
	    * @param @param _posX  位置坐标X
	    * @param @param _posY  位置坐标Y
	    * @return void    返回类型 
	    */
	    public void setPosXPosY(int _posX,int _posY) {
	    	posX=_posX;
	    	posY=_posY;
	    }
	    public void basicDisplay() {
	    	System.out.println("英雄角色:"+name+"  所属战队:"+country+"  生命值:"+HP+"  魔法值:"+MP+"  经验值:"+Exp+"  坐标位置:X="+posX+" Y="+posY);
	    }
		/**
		 * 攻击其他英雄，魔法值MP+10，经验值+20；
		 */
	    public void attackOthers() {
	    	MP+=10;
	    	Exp+=20;
	    	//System.out.println(country+"战队的"+name+"攻击敌方英雄成功！");
	    }
	    /**
	     * 受到其他英雄攻击，生命值HP-10；经验值+10；
	     */
	    public void beAttacked() {
	    	HP = HP-10;	
			Exp+=10;
			//System.out.println(country+"战队的"+name+"被攻击了 !");
	    }
        public boolean heroDie() {
        	if(HP<=0) {
            	HP=0;
            	MP=0;
            	Exp=0;
            	return true;
        	}else
        		return false;
        }
        public void skill(String direction, int distance) {
	    	
	    }
	}

	/** 
	* 法师类 
	*/
	class faShi extends hero implements Map,heroList{
		/** 
		* <p>Title:无参构造函数 </p> 
		* <p>Description: 对法师类进行初始化</p>  
		*/
		faShi(){
			HP=30;//法师默认生命值跟所有英雄相等
	    	MP=40;//魔法值是40，正常值是30
	    	Exp=10;//法师默认的经验值是10
	    	name = "F";
	    	attackDistance=2;
	    	country = null;
		}
		/**
		 * <p>法师的技能是在相应的位置设置障碍物“♦”
		 * <p>新增设置障碍类并在每次设置障碍的时候把障碍的位置信息存入obstacleList中
		 */
        public void skill(String direction, int distance) {
        	String obsName = "♦";
        	if (direction.compareTo("up") == 0) {
    			map[posX-distance][posY]="♦";
    			obstacle newObstacle = new obstacle();
    			newObstacle.setNewObstacle(posX-distance, posY,obsName);
    			obstacleList.add(newObstacle);   			
    		} else if (direction.compareTo("down") == 0) {
    			map[posX+distance][posY]="♦";
    			obstacle newObstacle = new obstacle();
    			newObstacle.setNewObstacle(posX+distance, posY,obsName);
    			obstacleList.add(newObstacle);
    		} else if (direction.compareTo("left") == 0) {
    			map[posX][posY-distance]="♦";
    			obstacle newObstacle = new obstacle();
    			newObstacle.setNewObstacle(posX, posY-distance,obsName);
    			obstacleList.add(newObstacle);
    		} else if (direction.compareTo("right") == 0) {
    			map[posX][posY+distance]="♦";
    			obstacle newObstacle = new obstacle();
    			newObstacle.setNewObstacle(posX, posY+distance,obsName);
    			obstacleList.add(newObstacle);
    		}
        	System.out.println(country+"阵营的英雄"+name+"设置了一个新的障碍物"+obsName);
	    }
	}

	/** 
	* 战士类 
	*/
	class zhanShi extends hero{
		/** 
		* <p>Title:无参构造函数 </p> 
		* <p>Description: </p>  
		*/
		zhanShi(){
			HP=30;//战士默认生命值跟所有英雄相等
	    	MP=30;//魔法值是30，正常值是30
	    	Exp=0;//默认的经验值是0
			name="Z";
	    	attackDistance=2;
	    	country = null;
		}
		/**
		 * 战士的技能是设置炸弹☀◎☌
		 */
        public void skill(String direction, int distance) {
        	if (direction.compareTo("up") == 0) {
    			map[posX-distance][posY]="◑";
    		} else if (direction.compareTo("down") == 0) {
    			map[posX+distance][posY]="◑";
    		} else if (direction.compareTo("left") == 0) {
    			map[posX][posY-distance]="◑";
    		} else if (direction.compareTo("right") == 0) {
    			map[posX][posY+distance]="◑";
    		}
        	System.out.println(country+"阵营的英雄"+name+"设置了一个新的炸弹'◑'");
	    }
	}

	/**  
	* 刺客类 
	*/
	class ciKe extends hero{
		ciKe(){
			HP=30;//刺客默认生命值跟所有英雄相等
	    	MP=30;//魔法值是30，正常值是30
	    	Exp=30;//刺客的经验值是30,默认的经验值是0
	    	name = "C";
	    	attackDistance=2;
	    	country = null;
		}
		/**
		 * 刺客的技能是瞬移，能朝某个方向进行相应距离的瞬间移动
		 * <p>移动后对相应坐标进行设置，并修改地图
		 */
        public void skill(String direction, int distance) {
        	if (direction.compareTo("up") == 0) {
    			map[posX-distance][posY]=name;
    			map[posX][posY]="-";
    			posX = posX-distance;
    		} else if (direction.compareTo("down") == 0) {
    			map[posX+distance][posY]=name;
    			map[posX][posY]="-";
    			posX = posX+distance;
    		} else if (direction.compareTo("left") == 0) {
    			map[posX][posY-distance]=name;
    			map[posX][posY]="-";
    			posY = posY-distance;
    		} else if (direction.compareTo("right") == 0) {
    			map[posX][posY+distance]=name;
    			map[posX][posY]="-";
    			posY = posY+distance;
    		}
        	System.out.println(country+"阵营的英雄"+name+"进行了瞬移");
	    }
	}
	/**
	 * <p>智能控制的法师类、继承普通英雄类并进行功能拓展
	 * @author grf
	 *
	 */
	class autoFaShi extends hero{
		/**
		 * <p>智能法师的构造函数
		 * <p>字符为' f'，所属战队为'autoRobot'，初始位置为战场正中间，坐标为[7,5]
		 */
		autoFaShi(){
	    	name = "f";
	    	country = "autoRobot";
	    	posX = 7;
	    	posY = 5;
		}
		public void initAutoMap() {
			map[posX][posY]=name;
		}
		/**
		 * <p>对地图范围内进行英雄法师设置的障碍物搜索
		 * <p>如果找到障碍物，返回障碍物的坐标，并向着障碍物移动	
		 * @return(障碍物的坐标)
		 */
		public String searchObstacle() {
			int n = obstacleList.size();
			int i;
			int obsX = 0,obsY = 0;
			double x,y,distance,minDistance=100;
			if(n>0) {
				for(i=0;i<n;i++) {
					x = obstacleList.get(i).posX;
					y = obstacleList.get(i).posY;
					distance = Math.sqrt((posX-x)*(posX-x)+(posY-y)*(posY-y));
					if(distance<minDistance) {
						minDistance = distance;
						obsX = (int) x;
						obsY = (int) y;
					}
				}
				if(minDistance>1) {
					if(posX<obsX)
						return "down";
					else if(posX>obsX)
						return "up";
					else if(posY<obsY)
						return "right";
					else
						return "left";
				}
				else 
					return "arrive";				
			}
			else
				return "null";
		}
	}
	/**
	 * <p>智能控制的战士类、继承普通英雄类并进行功能拓展
	 * @author grf
	 *
	 */
	class autoZhanShi extends hero{
		/**
		 * <p>智能战士的构造函数
		 * <p>战士字符为' Z'，所属战队为'autoRobot'，初始位置为战场正中间，坐标为[7,9]
		 */
		public int attackHeroNum;
		autoZhanShi(){
	    	name = "z";
	    	country = "autoRobot";
	    	posX = 7;
	    	posY = 9;
	    	attackDistance = 2;//攻击距离
		}
		public void initAutoMap() {
			map[posX][posY]=name;
		}
		public hero searchHero() {
			int i,k=0;
			double x,y,distance,minDistance=100;
			String heroCountry = null;
			for(i=0;i<5;i++) {
				x = blueHeroList.get(i).getPosX();
				y = blueHeroList.get(i).getPosY();
				distance = Math.sqrt((posX-x)*(posX-x)+(posY-y)*(posY-y));
				if(distance<minDistance) {
					minDistance = distance;
					heroCountry = "Blue";
					k=i;
				}	
			}
			for(i=0;i<5;i++) {
				x = redHeroList.get(i).getPosX();
				y = redHeroList.get(i).getPosY();
				distance = Math.sqrt((posX-x)*(posX-x)+(posY-y)*(posY-y));
				if(distance<minDistance) {
					minDistance = distance;
					heroCountry = "Red";
					k=i;
				}
			}
			if(minDistance<=attackDistance) {
				attackHeroNum = k;
				if(heroCountry.compareTo("Blue")==0)
				    return blueHeroList.get(k);
				else
					return redHeroList.get(k);
			}else 
				return null;

		}
	}



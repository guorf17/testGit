package wangZhe;

public class obstacle {
 public
	int posX;
    int posY;
    String name;
    boolean ifSet;
    obstacle(){
    	ifSet = false;
    	name = null;
    }
    public void setIfSet() {
    	ifSet = false;
    }
    public void setNewObstacle(int X,int Y,String _name) {
    	posX = X;
    	posY = Y;
    	name = _name;
    	ifSet = true;
    }
    
}

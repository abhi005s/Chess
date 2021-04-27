package base;

public class Cords {
    public int x;
    public int y;

    public Cords(){
        this.x=0;
        this.y=0;
    }

    public Cords(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void settingCoordinates(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getXaxis(){
        return this.x;
    }

    public int getYaxis(){
        return this.y;
    }
}

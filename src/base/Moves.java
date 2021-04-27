package base;

import java.util.Map;

public class Moves {
    //there are intersection in moves

    public boolean diagonal(Cords c1,Cords c2, Piece piece, Map<String, Piece> boardState){
        if(c2.x<0||c2.y<0||c2.x>=8||c2.y>=8)return false;

        int dir[][] = {{-1,-1},{-1,1},{1,-1},{1,1}};
        int direction;
        if(c1.x<c2.x){
            if(c1.y<c2.y){
                direction=3;
            }else direction =2;

        }else{
            if(c1.y<c2.y){
                direction=1;
            }else direction =0;
        }
        System.out.println("direction: "+direction);
        int travX=c1.x+dir[direction][0],travY=c1.y+dir[direction][1];
        while(travX>=0&&travY>=0&&travX<8&&travY<8){

            String key=getKey(travX,travY);
            System.out.println("Keys are: "+key);
            if(boardState.containsKey(key))return false;
            if(travX==c2.x&&travY==c2.y)break;
            travX+=dir[direction][0];
            travY+=dir[direction][1];
        }

        String sourceKey=getKey(c1.x,c1.y);
        String destKey=getKey(c2.x,c2.y);

        boardState.put(destKey,boardState.get(sourceKey));
        boardState.remove(sourceKey);


        return true;
    }

    public boolean straight(Cords c1,Cords c2, Piece piece, Map<String, Piece> boardState){
        if(c2.x<0||c2.y<0||c2.x>=8||c2.y>=8)return false;

        /*extend validation if anything is in between path

        if ours then return false
        otherwise kill other one

        */
        return false;
    }

    public boolean knight(Cords c1,Cords c2, Piece piece, Map<String, Piece> boardState){
        if(c2.x<0||c2.y<0||c2.x>=8||c2.y>=8)return false;

        /*extend validation if anything is in target path

        if ours then return false
        otherwise kill other one

        */
        return false;
    }


    public String getKey(int x,int y){
        String key ="";
        key+= (char)(y+97);
        key+= x;
        return key;
    }
}

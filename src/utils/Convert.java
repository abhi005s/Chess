package utils;

import base.Cords;

public class Convert {
    public static Cords getBoardCords(String ss){
        return new Cords( ss.charAt(1)-48,ss.charAt(0)-97);
    }

    /**
     * @param Cords
     * @return int
     *
     *   1 == straight move
     *   2 == diagonal move
     *   3 == rooks move
     */

    public static int getMoveType(Cords c1, Cords c2) {
        int x1 = c1.x;
        int y1 = c1.y;
        int x2 = c2.x;
        int y2 = c2.y;

        if(x1==x2||y1==y2)return 1;
        else if(Math.abs(x1-x2)==Math.abs(y1-y2))return 2;
        else if(Math.abs(x1-x2)==2 && Math.abs(y1-y2) ==1 || Math.abs(x1-x2)==1 && Math.abs(y1-y2) ==2) return 3;
        return -1;
    }
}

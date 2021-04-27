package base;

import utils.Convert;

import java.util.HashSet;
import java.util.Map;

public class Piece extends Moves {
    private PieceType pt;
    private boolean isWhite;
    private boolean isTop;

    public Piece(PieceType pt,boolean isWhite,boolean isTop){
        this.pt=pt;
        this.isWhite=isWhite;
        this.isTop=isTop;
    }

    public HashSet<Integer> getPieceMoves(){
        return PieceMove.getPieceMoves(this.pt);
    }

    public PieceType getPieceT(){
        return this.pt;
    }

    public boolean isPieceWhite(){
        return this.isWhite;
    }


    public boolean makeMove(Cords c1, Cords c2, Map<String, Piece> boardState){

        int moveType = Convert.getMoveType(c1,c2);
        System.out.println("Move type :"+moveType);


        if(moveType == 1) {
            if(PieceMove.getPieceMoves(this.pt).contains(moveType)){

            }
        }else if(moveType == 2) {
            if(PieceMove.getPieceMoves(this.pt).contains(moveType)){
                System.out.println("c1 :"+c1.x+" "+c1.y+" c2 :"+c2.x+" "+c2.y);
                return diagonal(c1,c2,this,boardState);
            }
        }else if(moveType == 3) {
            if(PieceMove.getPieceMoves(this.pt).contains(moveType)){

            }
        }
        return false;
    }
}

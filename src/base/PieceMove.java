package base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PieceMove {
    private static Map<PieceType,HashSet<Integer>> map;

    public static void moveAssociate(){
        map=new HashMap<>();

        map.put(PieceType.Pawn, new HashSet<>(Arrays.asList(1,2)));
        map.put(PieceType.Bishop, new HashSet<>(Arrays.asList(2)));
        map.put(PieceType.Knight, new HashSet<>(Arrays.asList(3)));
        map.put(PieceType.Rook, new HashSet<>(Arrays.asList(1)));
        map.put(PieceType.Queen, new HashSet<>(Arrays.asList(1,2)));
        map.put(PieceType.King, new HashSet<>(Arrays.asList(1,2)));
    }

    public static HashSet<Integer> getPieceMoves(PieceType p){
        return map.get(p);
    }

}

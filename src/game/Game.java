package game;

import base.Piece;
import base.PieceMove;
import base.PieceType;
import user.User;
import utils.Convert;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Game {


    String[] ptArray = {"Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn",
            "Rook", "Knight", "Bishop", "King", "Queen", "Bishop", "Knight", "Rook"};
    public Map<String, Piece> boardState;
    private User u1, u2;
    private boolean whiteToMove = true;
    private boolean gameOn = true;


    public void initGame(BufferedReader br) {
        initialiseUsers();
        initialiseBoard();
        PieceMove.moveAssociate();
        try {
            playNow(br);
        } catch (Exception e) {
        }
    }

    private void playNow(BufferedReader br) throws IOException {

        while (gameOn) {
            if (whiteToMove) {
                System.out.println("Player " + u1.getUserName() + "(white) to move now");
                String s = br.readLine();
                String d = br.readLine();

                if (proceedMove(u1, s, d))
                    whiteToMove = false;
            } else {
                System.out.println("Player " + u2.getUserName() + "(black) to move now");
                String s = br.readLine();
                String d = br.readLine();

                if (proceedMove(u2, s, d))
                    whiteToMove = true;
            }
        }
    }


    private boolean proceedMove(User user, String source, String dest) {

        boolean status = false;
        String msg = "Invalid Move";
        if (!boardState.containsKey(source)) {
            msg = "Piece is not there! Try Again";
        } else {
            Piece piece = boardState.get(source);
            if (piece.isPieceWhite() != user.isUserWhite()) {
                msg = "You are not allowed to touch other's pieces! Try Again";
            } else {
                System.out.print(source + " " + dest);
                status = piece.makeMove(Convert.getBoardCords(source), Convert.getBoardCords(dest), boardState);
                if (status) {
                    printBoard();
                }
            }
        }
        if (!status) System.out.println(msg);
        return status;
    }


    private void initialiseBoard() {
        boardState = new HashMap<>();

        for (int i = 0; false && i < 8; i++) {
            String yaxis = "g";

            boardState.put(yaxis + i, new Piece(PieceType.valueOf(ptArray[i]), true, false));
        }
        for (int i = 0; i < 8; i++) {
            String yaxis = "h";
            boardState.put(yaxis + i, new Piece(PieceType.valueOf(ptArray[i + 8]), true, false));
        }

        //init Black pieces
        for (int i = 0; false && i < 8; i++) {
            String yaxis = "b";
            boardState.put(yaxis + i, new Piece(PieceType.valueOf(ptArray[i]), false, true));
        }
        for (int i = 0; i < 8; i++) {
            String yaxis = "a";
            boardState.put(yaxis + i, new Piece(PieceType.valueOf(ptArray[i + 8]), false, true));
        }

        printBoard();
    }

    private void initialiseUsers() {

        u1 = new User("Player 1", true);
        u2 = new User("Player 2", false);
    }

    private void printBoard() {
        System.out.print("\n\n");
        System.out.print("Black");
        System.out.print("\n\n");
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i < 'i'; i++) {
            System.out.print(i + "    ");
            for (int j = 0; j < 8; j++) {
                sb.append(i);
                sb.append(j);
                if (boardState.containsKey(sb.toString())) {
                    System.out.print(boardState.get(sb.toString()).getPieceT() + " ");
                } else
                    System.out.print("     ");
                sb.setLength(0);
            }
            System.out.print("\n");
            if (i == 'h') {
                System.out.print("   ");
                for (int j = 0; j < 8; j++) {
                    System.out.print("   " + j + "  ");
                }
            }
        }
        System.out.print("\n\n");
        System.out.print("White");
        System.out.print("\n\n");
    }
}


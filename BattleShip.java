import java.io.*;
import java.util.*;

public class BattleShip
{
    static String board = "  1 2 3 4 5 6 7 8 9 10\na|_|_|_|_|_|_|_|_|_|_|\nb|_|_|_|_|_|_|_|_|_|_|\nc|_|_|_|_|_|_|_|_|_|_|\nd|_|_|_|_|_|_|_|_|_|_|\ne|_|_|_|_|_|_|_|_|_|_|\nf|_|_|_|_|_|_|_|_|_|_|\ng|_|_|_|_|_|_|_|_|_|_|\nh|_|_|_|_|_|_|_|_|_|_|\ni|_|_|_|_|_|_|_|_|_|_|\nj|_|_|_|_|_|_|_|_|_|_|";
    static int sqnum,plSet=0;
    static String dir,square;
   
       static int[] tile = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
   public static void main(String args[]){
       String play;
     do{
       System.out.println("set up the board for player 1");
       setUp();
       plSet+=100;
       System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n set up for player 2");
       setUp();
       int hit=0,hit2=0;
       String board2=board,board3=board;
       do{
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + board2);
        System.out.println("which square would you like to shoot?");
        Scanner kbReader=new Scanner(System.in);
            square = kbReader.next();
            numForm();
            if(tile[sqnum] == 1){
                System.out.println("hit");
                hit++;
                board2 = board2.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49+2) +22*(square.charAt(0)-64)-2) + "X" + board2.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)-2+3);
            }
            else{
                System.out.println("miss");
                board2 = board2.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49+2) +22*(square.charAt(0)-64)-2) + "M" + board2.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)-2+3);
        }
            System.out.println(board2);
            System.out.println("press any key to go on");
            kbReader.next();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + board3);
        System.out.println("which square would you like to shoot?");
        Scanner kbReader2=new Scanner(System.in);
            square = kbReader2.next();
            numForm();
            if(tile[sqnum] == 1){
                System.out.println("hit");
                hit++;
                board3 = board3.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49) +22*(square.charAt(0)-64)-2) + "X" + board3.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)-2+1);
            }
            else{
                board3 = board3.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49) +22*(square.charAt(0)-64)-2) + "M" + board3.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)-2+1);
        }
            System.out.println(board3);
            System.out.println("press any key to go on");
            kbReader.next();
            
        }while(hit < 17 && hit2 < 17);
        if(hit == 17)
            System.out.println("Player 1 wins!");
        else
            System.out.println("Player 2 wins!");
         System.out.println("Would you like to play again?");
         Scanner kbReader3=new Scanner(System.in);
         play = kbReader3.next();
         
        }while(play.toLowerCase() == "yes");    
    }
    public static void setUp(){
        System.out.println(board);
        int x,sub=0;
        for(x=5;x>1;x--){
            System.out.println("type where you want one end of your ("+x+") ship to go to be");
            Scanner kbReader=new Scanner(System.in);
            square = kbReader.next();
            numForm();
            System.out.println("Which way do you want it to go");
            dir = kbReader.next();
            dir = dir.toLowerCase();
            System.out.println(sqnum);
            int y=x;
            switch(dir){
                case "right":
                for(y=x;y>0;y--){
                if(tile[sqnum -(y-4)+plSet]==1){
                    System.out.println("you can't have two ships in the same place");
                    x++;
                    break;
                }
                tile[sqnum -(y-4)+plSet]=1;
                
                //if(square.charAt(2) == 48)
                board = board.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49) +22*(square.charAt(0)-64)+2*y-2) + "S" + board.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)+2*y-2+1);
            }
                System.out.println(board);
            break;
            case "left":
                for(y=x;y>0;y--){
                    if(tile[sqnum -(y-4)+plSet]==1){
                    System.out.println("you can't have two ships in the same place");
                    x++;
                    break;
                }
                tile[sqnum -(y-4)+plSet]=1;
                board = board.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49) +22*(square.charAt(0)-64)-2*y+2) + "S" + board.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)-2*y+2+1);
            }
                System.out.println(board);
            break;
            case "down":
                for(y=x;y>0;y--){
                    if(tile[sqnum -(y-4)+plSet]==1){
                    System.out.println("you can't have two ships in the same place");
                    x++;
                    break;
                }
                tile[sqnum -(y-4)+plSet]=1;
                board = board.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49) +22*(square.charAt(0)-64)+23*y-23) + "S" + board.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)+23*y-23+1);
            }
                System.out.println(board);
            break;
            case "up":
                for(y=x;y>0;y--){
                    if(tile[sqnum -(y-4)+plSet]==1){
                    System.out.println("you can't have two ships in the same place");
                    x++;
                    break;
                }
                tile[sqnum -(y-4)+plSet]=1;
                board = board.substring(0, sqnum +2*(square.charAt(1)-48)-10*(square.charAt(1)-49) +22*(square.charAt(0)-64)-23*y+23) + "S" + board.substring(sqnum + 2*(square.charAt(1)-48)-10*(square.charAt(1)-49)+22*(square.charAt(0)-64)-23*y+23+1);
            }
                System.out.println(board);
            break;
            default:
            System.out.println("enter up, down, left, or right");
            x++;
            continue;
            }
            if(sub == 0 && x==3){
                x++;
                sub++;
            }
        }
        board = "  1 2 3 4 5 6 7 8 9 10\na|_|_|_|_|_|_|_|_|_|_|\nb|_|_|_|_|_|_|_|_|_|_|\nc|_|_|_|_|_|_|_|_|_|_|\nd|_|_|_|_|_|_|_|_|_|_|\ne|_|_|_|_|_|_|_|_|_|_|\nf|_|_|_|_|_|_|_|_|_|_|\ng|_|_|_|_|_|_|_|_|_|_|\nh|_|_|_|_|_|_|_|_|_|_|\ni|_|_|_|_|_|_|_|_|_|_|\nj|_|_|_|_|_|_|_|_|_|_|";
    
    }
    public static int numForm(){
        square.toUpperCase();
        System.out.println(square);
        sqnum = square.charAt(0) + (square.charAt(1) - 48) * 10 -74;
       // if(square.length() == 3)
            //..sqnum+=10;
                  System.out.println(sqnum);  
        return sqnum;
    }
}

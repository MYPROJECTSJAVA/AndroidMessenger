//package com.example.myapplication;
//
//import android.widget.ImageButton;
//
//import java.util.Objects;
//
//public class Game {
//
//    ImageButton[] button_list;
//    private static String[] Board ;
//    String winner;
//    public Game() {
//        button_list = new ImageButton[9];
//        Board = new String[9];
//        winner="";
//            }
//    public void start(MainActivity obj){
//
//
//        int[] id_list={R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9};
//        for(int i=0;i<9;i++){
//            this.button_list[i]=obj.findViewById(id_list[i]);
//
//        }
//        for(ImageButton b:this.button_list){
//            b.setOnClickListener(v->{
//                b.setImageResource(R.drawable.zero);
//                this.moveRegister(b.getId());
//            });
//        }
//
//    }
//    public String logic(String[] arr) {
//        //row
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
//        for (int i : new int[]{0, 3, 6}) {
//            if (arr[i] != null && Objects.equals(arr[i], arr[i + 1]) && Objects.equals(arr[i], arr[i + 2])) {
//                System.out.println("I am here1");
//                winner=arr[i];
//                return arr[i];
//            }
//        }
//        //column
//        for (int i : new int[]{0, 1, 2}) {
//            if (arr[i] != null && Objects.equals(arr[i], arr[i + 3]) && Objects.equals(arr[i], arr[i + 6])) {
//                System.out.println("I am here2");
//                winner=arr[i];
//                return arr[i];
//            }
//        }
//        //diagonal
//        if (arr[4] != null && Objects.equals(arr[4], arr[0]) && Objects.equals(arr[4], arr[8])) {
//            System.out.println("I am here3");
//            winner=arr[4];
//            return arr[4];
//        }
//        if (arr[4] != null && Objects.equals(arr[4], arr[2]) && Objects.equals(arr[4], arr[6])) {
//            System.out.println("I am here4");
//            winner=arr[4];
//            return arr[4];
//
//        }
//        System.out.println("The logic winner is");
//        return "";
//    }
//    public void moveRegister(int point){
//        if(point<=9 && Objects.equals(Board[point - 1], "") & Board[point-1]==null){
//
//            Board[point-1]="O";//keep a player name or X or 0
//            //send this move to the other game state object I don't know how
//
//
//        }
//        this.logic(this.Board);
//    }
//
//}

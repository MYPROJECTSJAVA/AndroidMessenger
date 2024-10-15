package com.example.myapplication;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SimpleClient {
//    static Object[] readerAndWriter;
    static PrintWriter writer;
    static BufferedReader reader;
    static Socket clientSocket;
    public static void connect(int port){
        try{
            clientSocket = new Socket("192.168.5.244", port);
            System.out.println("Connected to server!!!");
            writer=new PrintWriter(clientSocket.getOutputStream(),true);
            reader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch(Exception e){

        }

    }
    public static void disConnect() throws IOException {
        clientSocket.close();

    }



}
public class Messenger {

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudpfarra;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class JavaUDPFarra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            InetAddress ia = InetAddress.getByName("10.10.10.21");
            int port = 1111;
//            Scanner s = new Scanner(System.in);
//            System.out.println("Masukkan Pesan = ");
//            String pesan = s.nextLine();
//----------Posisi kursor Anda
            PointerInfo a;
            Point b;
            int x;
            int y;
            while(true){
            a = MouseInfo.getPointerInfo();
            b = a.getLocation();
            x = (int)b.getX();
            y = (int)b.getY();
                String pesanX = String.valueOf(x);
                String pesanY = String.valueOf(y);
                String pesan = pesanX+"|"+pesanY+"|";
                byte[] data = pesan.getBytes();
                DatagramPacket dp = new DatagramPacket(data,data.length,ia,port);
                DatagramSocket ds = new DatagramSocket();
                Thread.sleep(100);
                ds.send(dp);
                System.out.println(pesan);
        }
        } catch (Exception e) {
        }
    }   
}
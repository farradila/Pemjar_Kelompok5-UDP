/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudpfarra;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author user
 */
public class PenerimaUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            byte[] buffer = new byte[65];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            DatagramSocket ds = new DatagramSocket(1111);
            while(true){
                ds.receive(dp);
            byte[] data = dp.getData();
            String pesan = new String(data,0,data.length);
            System.out.println("Pesan dari teman anda adalah = " + pesan);
//          -------100|200|
//          String[] posisi=pesan.split("|");
                String[] posisi=pesan.split("\\|");
                int x=Integer.parseInt(posisi[0]);
                int y=Integer.parseInt(posisi[1]);
                Robot rb=new Robot();
                rb.mouseMove(x, y);
                rb.delay(5);
                rb.mousePress(MouseEvent.BUTTON1_MASK);
                rb.mouseRelease(MouseEvent.BUTTON1_MASK);
            }
        } catch (Exception e) {
        }
    }
    
}

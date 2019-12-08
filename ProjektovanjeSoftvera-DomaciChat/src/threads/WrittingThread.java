/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.forme.GUIController;

/**
 *
 * @author Win10
 */
public class WrittingThread extends Thread{
    private final Socket socket;
    private GUIController controller;
    boolean signal = false;

    public WrittingThread(Socket socket, GUIController controller) {
        super();
        this.socket = socket;
        this.controller = controller;
    }
    
    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            signal = false;
            
            while(true) {
                if(signal) {
                    printWriter.println(controller.getMessage());
                    controller.addSentMessageToAllMs("Sent message: " + controller.getMessage());
                    signal = false;
                }
                Thread.sleep(200);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(WrittingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSignal() {
        signal = true;
    }

    
}

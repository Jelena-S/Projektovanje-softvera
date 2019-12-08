/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.Socket;
import threads.ReadingThread;
import threads.WrittingThread;
import ui.forme.GUIController;

/**
 *
 * @author Win10
 */
public class Client {
    private Socket socket;
    GUIController controller;

    public Client() {
        controller = new GUIController();
    }
    
    
    
    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }

    private void connect() {
        try {
            socket = new Socket("localhost", 9000);
            ReadingThread readingThread = new ReadingThread(socket, controller);
            readingThread.start();
            WrittingThread writtingThread = new WrittingThread(socket, controller);
            writtingThread.start();
            controller.setWrittingThread(writtingThread);
            
            readingThread.join();
            writtingThread.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

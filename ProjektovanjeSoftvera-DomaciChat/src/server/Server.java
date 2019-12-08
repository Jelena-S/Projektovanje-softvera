/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.ServerSocket;
import java.net.Socket;
import threads.ReadingThread;
import threads.WrittingThread;
import ui.forme.GUIController;

/**
 *
 * @author Win10
 */
public class Server {
    private ServerSocket serverSocket;
    GUIController controller;

    public Server() {
        controller = new GUIController();
    }
    
    
    
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void start() throws Exception {
        serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        
        ReadingThread readingThread = new ReadingThread(socket, controller);
        readingThread.start();
        WrittingThread writtingThread = new WrittingThread(socket, controller);
        writtingThread.start();
        controller.setWrittingThread(writtingThread);
        
        readingThread.join();
        writtingThread.join();
        
                
    }
}

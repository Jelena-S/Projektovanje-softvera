/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forme;

import java.awt.event.ActionEvent;
import threads.WrittingThread;

/**
 *
 * @author Win10
 */
public class GUIController {
    ChatForma form;
    WrittingThread writtingThread;

    public GUIController() {
        prepareForm();
    }

    private void prepareForm() {
        form = new ChatForma();
        form.setVisible(true);
        form.getjBtnSend().setEnabled(true);
        form.getjBtnSend().addActionListener((ActionEvent e) -> {
            jBtnSendActionPerformed(e);
        });
    }
    
    private void jBtnSendActionPerformed(ActionEvent e) {
        writtingThread.setSignal();
    }
    
    public void addReceivedMessageToAllMs(String message) {
        form.getjTxtLastMessage().setText(message);
        
        if(form.getjTxtAreaAllMessages().getText().isEmpty()) {
            form.getjTxtAreaAllMessages().append(message);
        } else {
            form.getjTxtAreaAllMessages().append("\n");
            form.getjTxtAreaAllMessages().append(message);
        }
    }
    
    public void addSentMessageToAllMs(String message) {
        if(form.getjTxtAreaAllMessages().getText().isEmpty()) {
            form.getjTxtAreaAllMessages().append(message);
        } else {
            form.getjTxtAreaAllMessages().append("\n");
            form.getjTxtAreaAllMessages().append(message);
        }
        form.getjTxtMessage().setText("");
    }
    
    public String getMessage() {
        return form.getjTxtMessage().getText();
    }
    
    public void setWrittingThread(WrittingThread writtingThread) {
        this.writtingThread = writtingThread;
    }
}

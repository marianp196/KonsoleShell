/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marian
 */
public class KonsoleInput{

    public KonsoleInput(IKonsoleInputAction consoleInputAction) {
        if(consoleInputAction == null)
            throw new NullPointerException("consoleInputAction");
        this.consoleInputAction = consoleInputAction;
        thread = new Thread(new ConsoleInputThread(consoleInputAction));
        thread.start();
    }
           
    private IKonsoleInputAction consoleInputAction;
    private Thread thread;   
    
    private class ConsoleInputThread implements Runnable{
        public ConsoleInputThread(IKonsoleInputAction consoleInputAction) {
            this.consoleInputAction = consoleInputAction;
        }
        
         @Override
        public void run() 
        {
             while(true)
            {
                try {
                    byte[] b = new byte[100];
                    int i = System.in.read(b);
                    String s = new String(b,0,i);
                    consoleInputAction.ActionConsoleInput(s);
                } catch (IOException ex) {
                    Logger.getLogger(KonsoleInput.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        private IKonsoleInputAction consoleInputAction;       
    }
}

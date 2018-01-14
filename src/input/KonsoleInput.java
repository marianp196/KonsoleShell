/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValueBase;

/**
 *
 * @author marian
 */
public class KonsoleInput extends Observable
{

    public KonsoleInput(Observer o) {      
        if(o == null)
            throw new NullPointerException("observer");
        addObserver(o);
        thread = new Thread(new ConsoleInputThread());
        thread.start();        
    } 
   
    private void triggerInput(String input)
    {
        setChanged();
        notifyObservers(input);        
    }
    
    private Thread thread;   
    
    private class ConsoleInputThread implements Runnable{
             
        @Override
        public void run() 
        {
            String input = "";
            while(true)
            {
                try {
                    byte[] b = new byte[100];
                    int i = System.in.read(b);
                    input += new String(b,0,i);
                    if(input.contains("\n"))
                    {
                        triggerInput(input);
                        input="";
                    }
                } catch (IOException ex) {
                    Logger.getLogger(KonsoleInput.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }       
       
    }
}

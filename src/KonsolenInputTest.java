/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import input.KonsoleInput;
import java.util.Observer;

/**
 *
 * @author marian
 */
class KonsolenInputTest implements Observer{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
        KonsoleInput ci = new KonsoleInput(new KonsolenInputTest());   
    }

    @Override
    public void update(java.util.Observable o, Object arg) 
    {
        System.out.print(arg);
    }

    
}

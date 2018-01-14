/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import input.KonsoleInput;
import java.util.Observer;
import output.IPrinter;
import output.StandardPrinter;
import shell.Shell;
import shell.abstractions.IShell;

/**
 *
 * @author marian
 */
class KonsolenInputTest implements Observer{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {   
        //KonsoleInput ci = new KonsoleInput(new KonsolenInputTest());
        testshell();
    }

    private static void testshell() throws Exception {
        KonsoleInput ci = new KonsoleInput();
        IPrinter print = new StandardPrinter();
        
        IShell shell = new Shell(print);        
        shell.AddProgramm(new TestProgramm());
        ci.addObserver((Observer) shell);
    }

    @Override
    public void update(java.util.Observable o, Object arg) 
    {
        System.out.print(arg);
    }

    
}

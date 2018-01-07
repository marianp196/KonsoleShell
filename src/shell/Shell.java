/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import input.IKonsoleInputAction;
import input.KonsoleInput;
import output.IPrinter;

/**
 *
 * @author marian
 */
public class Shell implements IShell,IKonsoleInputAction 
{

    public Shell(IPrinter printer) {       
        this.printer = printer;
        konsoleInput = new KonsoleInput(this);//scheiß design        
        printPrompt();
    }     
    
    @Override
    public void SetPrompt(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GetPromt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetPraeambel(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GetPraeambel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddProgramm(IProgramm p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void ActionConsoleInput(String inputText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    private void printPrompt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    private IPrinter printer;
    private KonsoleInput konsoleInput;
    
}

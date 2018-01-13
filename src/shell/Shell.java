/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.util.ArrayList;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import output.IPrinter;

/**
 *
 * @author marian
 */
/*ToDo
   -Das PraeambelProblem
   -

*/
public class Shell implements IShell,Observer 
{
    public Shell(IPrinter printer) {       
        this.printer = printer; 
        printPrompt();
    }     
    
    @Override
    public void SetPrompt(String prompt) 
    {
        if(promt == null)
            throw new NullPointerException("promt");
        this.promt = promt;
    }

    @Override
    public String GetPromt() 
    {
        return promt;
    }

    @Override
    public void SetPraeambel(String praeambel) 
    {
        if(praeambel == null)
            throw new NullPointerException("praeambel");
        this.praeambel = praeambel;
        printer.PrintLn(praeambel);
    }

    @Override
    public String GetPraeambel() 
    {
        return praeambel;
    }

    @Override
    public void AddProgramm(IProgramm p) throws Exception 
    {
        programmVerwalter.AddProgramm(p);
    }
    
    @Override
    public void update(java.util.Observable o, Object arg) 
    {     
        try {
            String befehl = (String)arg;
            entferneZeilenumbruch(befehl);
            doItOtze(befehl);           
        } catch (Exception ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            printPrompt();
        }
    }

    private boolean doItOtze(String befehl) throws Exception {
        BefehlsDecoder decoder = new BefehlsDecoder(befehl);
        
        if (!decoder.HasBefehl()) {
            printer.PrintLn("Befehl nicht interpretierbar!");
            return true;
        }               
        
        IProgramm programm = programmVerwalter.getProgramm(decoder.GetProgramm());
        
        invokeProgramm(decoder.GetParameter(), programm);
        return false;
    }
          
    private void printPrompt() 
    {
        printer.Print(promt);
    }  
      
     private void invokeProgramm(String[] parameter, IProgramm programm) throws Exception 
     {        
        programm.Invoke(parameter);
     }
     
    private void entferneZeilenumbruch(String befehl) {
       befehl = befehl.replace("\n", "");
    }

    
    private IPrinter printer; 
    private String promt = ">>>";
    private String praeambel = "*****************************************\n"
                              +"**************Standard-Shell*************\n"
                              +"*****************************************";
    private ProgrammVerwalter programmVerwalter = new ProgrammVerwalter();
    
}

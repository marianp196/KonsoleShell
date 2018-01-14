/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import shell.abstractions.IShell;
import shell.abstractions.IProgramm;
import java.util.ArrayList;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import output.IPrinter;
import shell.standardprogramme.Help;

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
        registerStandardProgramme();
    }  
    
    @Override
    public void Start() 
    {
        started = true;
        printPraeambel();
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
        if(!started)
            return;
        
        try {
            String befehl = (String)arg;            
            doItOtze(entferneZeilenumbruch(befehl));           
        } catch (Exception ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            printPrompt();
        }
    }

    private void doItOtze(String befehl) throws Exception {
        BefehlsDecoder decoder = new BefehlsDecoder(befehl);
        
        if (!decoder.HasBefehl()) {
            printer.PrintLn("Befehl nicht interpretierbar! " + befehl);
            return;
        }               
        
        IProgramm programm = programmVerwalter.getProgramm(decoder.GetProgramm());
        
        if(programm == null)
        {
            printer.PrintLn("Befehl nicht vorhanden: " + befehl);
            return;
        }
        
        invokeProgramm(decoder.GetParameter(), programm);
    }
          
    private void printPrompt() 
    {
        printer.Print(promt);
    }  
    
    private void printPraeambel() {
        printer.PrintLn(praeambel);
    }
          
    private void invokeProgramm(String[] parameter, IProgramm programm) throws Exception 
    {        
       programm.Invoke(parameter);
    }
     
    private String entferneZeilenumbruch(String befehl) {
       return befehl.replaceAll("\n", "");
    }
    
    private void registerStandardProgramme(){
        try {
            AddProgramm(new Help(programmVerwalter.List(), printer));
        } catch (Exception ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    private IPrinter printer; 
    private String promt = ">>> ";
    private String praeambel = "*****************************************\n"
                              +"**************Standard-Shell*************\n"
                              +"*****************************************";
   
    private ProgrammVerwalter programmVerwalter = new ProgrammVerwalter();
    private boolean started = false;  

    
}

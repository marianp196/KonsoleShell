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
        String[] befehlElemente = getBefehlElemente(befehl);
        if (befehlElemente.length == 0) {
            return true;
        }
        IProgramm programm = programmVerwalter.getProgramm(befehlElemente[0]);
        if (programm == null) {
            printer.PrintLn("Befehl nicht interpretierbar!");
            return true;
        }
        invokeProgramm(befehlElemente, programm);
        return false;
    }
          
    private void printPrompt() 
    {
        printer.Print(promt);
    }       
    
        
    private String[] getBefehlElemente(String befehl) 
    {
        String[] elemente = befehl.split(" ");
        ArrayList<String> resuList = new ArrayList<>();
        for(String element : elemente)
        {
            if(!(element.equals(" ") || element.equals("")))
                resuList.add(element);
        }
        return (String[])resuList.toArray();
    }

        
     private void invokeProgramm(String[] befehlElemente, IProgramm programm) throws Exception 
     {
         if(befehlElemente.length == 0)
             throw new Exception("Kein Befehl übergeben!");
         
        int length = befehlElemente.length -1;                  
        String[] parameter = new String[length];
        
        for(int i = 1; i < befehlElemente.length; i++)
        {
            parameter[i-1] = befehlElemente[i];
        }
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

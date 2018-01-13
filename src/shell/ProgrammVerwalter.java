/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.util.ArrayList;

/**
 *
 * @author marian
 */
public class ProgrammVerwalter {
    public void AddProgramm(IProgramm p) throws Exception 
    {
        if(!checkProgramm(p))
            throw new Exception("Programm schon hinzugefuegt!");
        programme.add(p);
    }
    
    public IProgramm getProgramm(String name) 
    {
        IProgramm result = null;
        
        for(IProgramm p : programme)
        {
           if(p.GetProgrammIdentifier().equals(name))
           {              
               result = p;
               break;
           }
        }        
        return result;
    }
    
    private boolean checkProgramm(IProgramm programm) 
    {
        return getProgramm(programm.GetProgrammIdentifier()) == null;
    }
    
    private ArrayList<IProgramm> programme = new ArrayList<>(); 
}

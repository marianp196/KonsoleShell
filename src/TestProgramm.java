
import shell.abstractions.IProgramm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marian
 */
public class TestProgramm implements IProgramm 
{

    @Override
    public String GetProgrammIdentifier() 
    {
        return "test";
    }

    @Override
    public String GetErklaerung() 
    {
        return "Zu Testzwecken gedacht";
    }

    @Override
    public void Invoke(String[] param) {
        String out = "";
        
        for(String s : param)
            out += s;
        
        System.out.println(out);
    }
    
}

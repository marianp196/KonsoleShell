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
public class BefehlsDecoder {
    public BefehlsDecoder(String befehl)
    {
        if(befehl == null)
            throw new NullPointerException("befehl");
        this.befehl = befehl;
        befehlToArray();
    }
    
    public boolean HasBefehl()
    {
        return befehlsElemente.length > 0;
    }
    
    public String GetProgramm() throws Exception
    {
        if(befehlsElemente.length == 0)
            throw new Exception("Befehl ist Leer..Nicht interpretierbar");
        return befehlsElemente[0];
    }
    
    public String[] GetParameter() throws Exception
    {
        if(befehlsElemente.length == 0)
             throw new Exception("Kein Befehl übergeben!");
         
        int length = befehlsElemente.length -1;                  
        String[] parameter = new String[length];
        
        for(int i = 1; i < befehlsElemente.length; i++)
        {
            parameter[i-1] = befehlsElemente[i];
        }
        return parameter;
    }
    
    private void befehlToArray() 
    {
        String[] elemente = befehl.split(" ");
        ArrayList<String> resuList = new ArrayList<>();
        for(String element : elemente)
        {
            if(!(element.equals(" ") || element.equals("")))
                resuList.add(element);
        }
        befehlsElemente = (String[])resuList.toArray();
    }
    
    private String befehl;
    private String[] befehlsElemente;
    
}

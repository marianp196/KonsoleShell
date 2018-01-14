/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell.standardprogramme;

import java.util.ArrayList;
import output.IPrinter;
import shell.abstractions.IProgramm;

/**
 *
 * @author marian
 */
public class Help implements IProgramm
{

    public Help(ArrayList<IProgramm> programme, IPrinter printer) 
    {
        this.programme = programme;
        this.printer = printer;
    }

    
    
    @Override
    public String GetProgrammIdentifier() 
    {
        return "help";
    }

    @Override
    public String GetErklaerung() 
    {
        return "Listet alle verfügbaren Programme auf.";
    }

    @Override
    public void Invoke(String[] param) 
    {
        printer.PrintLn("Interpretierung ist CaseSensitive");
        printer.PrintLn("Registrierte Programme: ");
        for(IProgramm programm : programme)
        {
            printer.PrintLn(programm.GetProgrammIdentifier() + "  ||  " + programm.GetErklaerung() );
        }
    }
    
    private ArrayList<IProgramm> programme;
    private IPrinter printer;
}

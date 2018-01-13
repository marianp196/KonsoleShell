/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell.abstractions;

/**
 *
 * @author marian
 */
public interface IProgramm 
{
    String GetProgrammIdentifier();
    String GetErklaerung();
    
    void Invoke(String[] param);
}

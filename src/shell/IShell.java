/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

/**
 *
 * @author marian
 */
public interface IShell {
    void SetPrompt(String prompt);
    String GetPromt();
    
    void SetPraeambel(String prompt);
    String GetPraeambel();

    void AddProgramm(IProgramm p) throws Exception;
}

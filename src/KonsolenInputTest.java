/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import input.IKonsoleInputAction;
import input.KonsoleInput;

/**
 *
 * @author marian
 */
class KonsolenInputTest implements IKonsoleInputAction{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
        KonsoleInput ci = new KonsoleInput(new KonsolenInputTest());
    }

    @Override
    public void ActionConsoleInput(String inputText) 
    {
        System.out.print(inputText);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BlockApp {
    

    /**
     * @param args the command line arguments
     */
    public static ReadFile rf = new ReadFile();
    public static ArrayList listapp = rf.readFile();
    public static void main(String[] args) throws IOException {

        
        
    }
    public static void run(){
        try {
            appOnWindow();
            
            while(true){
                try {
                    sleep(10000);
                    closeProgram();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BlockApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(BlockApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeProgram() throws IOException {
        Runtime rt = Runtime.getRuntime();
        for(int i=0;i<listapp.size();i++){
            rt.exec("taskkill /f /im " +listapp.get(i));
        }
//        rt.exec("taskkill /f /im devcpp.exe");
    }

    public static void appOnWindow() throws IOException {
        Process p = Runtime.getRuntime().exec("tasklist.exe");
    }
 
}

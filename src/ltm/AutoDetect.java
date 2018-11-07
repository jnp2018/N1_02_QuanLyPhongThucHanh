/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AutoDetect {

    static File[] oldListRoot = File.listRoots();

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static LocalDateTime now = LocalDateTime.now();
    public static WriteFile wf =new WriteFile();
    public static void main(String[] args) {
        

    }

    public static void waitForNotifying() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (File.listRoots().length > oldListRoot.length) {
//                        System.out.println("new drive detected");
                        oldListRoot = File.listRoots();
                        System.out.println("drive" + oldListRoot[oldListRoot.length - 1] + " detected");
                        String s = "Device detected:"+oldListRoot[oldListRoot.length - 1]+" ("+dtf.format(now)+")";
                        wf.writeFile(s);
                    } else if (File.listRoots().length < oldListRoot.length) {
                        
                        String s= oldListRoot[oldListRoot.length-1] +"removed" +" ("+dtf.format(now)+")";
                        System.out.println(oldListRoot[oldListRoot.length-1]+"removed");
                        oldListRoot = File.listRoots();
                        wf.writeFile(s);
                    }

                }
            }
        });
        t.start();
    }

    void run() {
        waitForNotifying();
    }
        
}

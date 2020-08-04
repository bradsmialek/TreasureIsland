package com.treasureisland.utilities;

import com.treasureisland.Attributes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:57 PM
 * Manages components of the game
 */
public class ComponentsManager {

    private static BufferedReader reader;

    //READS .txt FILES CONTAINING ISLANDS
    public static ArrayList<String> readIslandFile(String filename) {

        System.out.println("COMPONENT MANAGER CLASS: READING "+filename);

        ArrayList<String> strings = new ArrayList<String>();

        try{
            reader = new BufferedReader(new FileReader(filename));
        }catch (FileNotFoundException e) {
            System.out.println("COMPONENTS MANAGER CLASS: [ERROR]: FILE "+filename+" not found!");
        }

        try {
            String str = reader.readLine();
            strings.add(str);

            while(str!=null) {
                str = reader.readLine();
                strings.add(str);
            }

        }catch (IOException e) {
            System.out.println("COMPONENTS MANAGER CLASS [ERROR]: IOException");
        }
        return strings;

    }

}

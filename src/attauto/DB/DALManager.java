/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.DB;

import attauto.BE.Days;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author atilk
 */
public class DALManager 
{
    /*public ObservableList <Days> getDays(String days) throws FileNotFoundException, IOException
    {
        ObservableList <Days> days = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("MockDB/Days.csv")))
        {
            Scanner scanner = new Scanner(br);
            scanner.nextLine();
            while (scanner.hasNext())
            {
                String line =scanner.nextLine();
               String [] fields = line.split(",");
               Days day = new Days(fields[0],fields[1]);
               days.add(day);
               
            }
        }
        return days;
        
    }*/
}

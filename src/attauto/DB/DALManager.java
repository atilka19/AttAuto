/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.DB;

import attauto.BE.Students;
import java.io.BufferedReader;
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
    public ObservableList<Students> getStudents() throws IOException
    {
        ObservableList<Students> student = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("MockDB/Students.csv")))
    {
        Scanner sc = new Scanner(br);
        sc.nextLine();
        while(sc.hasNext())
        {
            String line = sc.nextLine();
            String[] fields = line.split(",");
            Students students = new Students (fields[0],fields[1],fields[2],fields[3]);
            student.add(students);
        }
    }
        return student;
    }
    
    
    
}

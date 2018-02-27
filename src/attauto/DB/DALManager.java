/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.DB;

import attauto.BE.Students;
import attauto.BE.Days;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author atilk
 */
public class DALManager 
{
    
    Calendar now = Calendar.getInstance();
    int cDate = now.get(Calendar.DATE);
    int cMonth = now.get(Calendar.MONTH) + 1;
    int cYear = now.get(Calendar.YEAR);
    String today = cMonth + "/" + cDate + "/" + cYear;
    
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
            Students students = new Students (fields[0],fields[1],fields[2],fields[3],fields[4]);
            student.add(students);
        }
    }
        return student;
    }
    
    
        public ObservableList<Days> getAllDay() throws IOException
    {
        ObservableList<Days> day = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("MockDB/Days.csv")))
    {
        Scanner sc = new Scanner(br);
        sc.nextLine();
        while(sc.hasNext())
        {
            String line = sc.nextLine();
            String[] fields = line.split(",");
            Days days = new Days (fields[0],fields[1]);
            day.add(days);
        }
    }
        return day;
    }
        public ObservableList<Days> getDays(String id) throws FileNotFoundException, IOException
        {
            ObservableList<Days> day = FXCollections.observableArrayList();
            try(BufferedReader br = new BufferedReader(new FileReader("MockDB/"+id+"Feb.csv")))
            {
               Scanner sc = new Scanner(br);
               sc.nextLine();
               while(sc.hasNext())
               {
                    String line = sc.nextLine();
                    String[] fields = line.split(",");
                    Days days = new Days (fields[0],fields[1]);
                    day.add(days);
               }
            }
            return day;
        }

    public void Present() throws IOException {
    try
        {
            String filename= "MockDB/Days.csv";
            FileWriter fw = new FileWriter(filename,true);
            fw.write("\n"+today+",Present");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    
    
    }
    
    public void Absent() throws IOException {
    try
        {
            String filename= "MockDB/Days.csv";
            FileWriter fw = new FileWriter(filename,true);
            fw.write("\n"+today+",Absent");
            fw.close();
        }
    catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    
    }
    
}

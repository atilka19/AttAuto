/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.BE;

/**
 *
 * @author atilk
 */
public class Students 
{


    private String name;
    private String attendance;
    private String percantage;
    private String attendedDays;
    
    
    public Students(String name, String attendance, String percantage, String attendedDays) {
        this.name = name;
        this.attendance = attendance;
        this.percantage = percantage;
        this.attendedDays = attendedDays;
    }
    
    public String getName() {
        return name;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getPercantage() {
        return percantage;
    }

    public String getAttendedDays() {
        return attendedDays;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public void setPercantage(String percantage) {
        this.percantage = percantage;
    }

    public void setAttendedDays(String attendedDays) {
        this.attendedDays = attendedDays;
    }
}

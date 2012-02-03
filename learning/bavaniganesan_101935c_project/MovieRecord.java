/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bavaniganesan_101935c_project;

/**
 *
 * @author user
 */
public class MovieRecord implements Comparable<MovieRecord>{
    //Declare all the to contain the field of the record
    String recNo;
    String creditNo;
    String name;
    String title;
    String date;
    String time;
    String place;
    
    //Constructor
    public MovieRecord(String recNo,String creditNo,String name,String title,String date,String time,String place ){
        this.recNo = recNo;
        this.creditNo = creditNo;
        this.name = name;
        this.title = title;
        this.date = date;
        this.time = time;
        this.place = place;
 
    }
    
    public String toString()
    {
        return (recNo + "|" + creditNo + "|" + name + "|" + title + "|" + date + "|" + time + "|" + place );
    }

    public int compareTo(MovieRecord o) {
        int result;
        
        if(title.equals(o.title)){
            result = title.compareTo(o.title);
        }
        else{
            result = title.compareTo(o.title);
        }
        return result;
    }
}

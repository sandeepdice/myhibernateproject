/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bavaniganesan_101935c_project;

import java.io.*;
import java.util.*;

/**
 *
 * @author user
 */
public class MovieSearch {

    //Declare global variable
    static LinkedList<MovieRecord> rr = new LinkedList<MovieRecord>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final String msg = "Please select one of the following options:\n"
                + "1)	Search movie with credit number:\n"
                + "2)	Search movie  by movie title:\n"
                + "3)	Display all bookings:\n"
                + "4)   Do you want to insert or remove a record?\n"
                + "5)	Exit program";
        //Declare variable
        String line;
        MovieSearch app = new MovieSearch();
        //call method to read record
        app.retrieveRecords();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            do {
                // Show Choice Menu
                System.out.println(msg);

                // readLine + BP
                line = br.readLine();

                switch (Integer.parseInt(line)) {
                    case 1:
                        app.searchCredit();
                        line = app.menu();
                        break;
                    case 2:
                        app.searchtitle();
                        line = app.menu();
                        break;
                    case 3:
                        app.display();
                        line = app.menu();
                        break;
                    case 4:
                        line = app.update();
                        break;
                    case 5:
                        line = "0";
                        break;
                    default:
                }
            } while (!line.equals("0"));
            br.close();
        } catch (Exception e) {
            System.out.println("main");
        }
        System.out.println("Thank you for using MovieSearch!!!");
    }

    private void retrieveRecords() {
        //Declare variables
        MovieRecord gr;
        StringTokenizer stk;
        String file = "101935C_TextFile.txt";
        String line = "";
        String recNo,creditNo,name,title,date,time,place;

        try {
            // File & BufferedReader
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // readLine from file + BP
            line = br.readLine();

            while (line != null) {
                // Tokenize the record + BP
                stk = new StringTokenizer(line, "|");

                recNo = stk.nextToken();
                creditNo = stk.nextToken();
                name = stk.nextToken();
                title = stk.nextToken();
                date = stk.nextToken();
                time = stk.nextToken();
                place = stk.nextToken();

                //Create RoomRecords Object to store info
                gr = new MovieRecord(recNo,creditNo,name,title,date,time,place);
                // Add to LinkedList
                rr.addLast(gr);
                // read another line
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("retrieveRecord error");
        }
    }

    private void searchCredit() {
        final String msg = "Please type in Passport number of person: ";
        String line = null;
        LinkedList<MovieRecord> mm = new LinkedList<MovieRecord>();
        final String msg1 = "Records of Movie with creditNo " + line
                + "\n<Record Number>|<Credit card number> | <Name> | <Movie Title> | <Date of Movie>|<Time of Movie>|<Place>|";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(msg);
            //read user input + BP
            line = br.readLine();
            System.out.println(msg1);
            //Looping through to search for matching data + BP
            for (int i = 0; i < rr.size(); i++) {
                if (rr.get(i).creditNo.toUpperCase().contains(line)) {
                    mm.add(rr.get(i));
                }
            }
            System.out.println("Number of records is: " + mm.size());
            //sorting the record + BP
            Collections.sort(mm);
            //Looping through to print the record
            for (int o = 0; o < mm.size(); o++) {
                System.out.println(mm.get(o));
            }
        } catch (Exception e) {
            System.out.println("searchIC error");
        }
    }

    private void searchtitle() {
        final String msg = "Please type in movite title: ";
        String line = null;
        LinkedList<MovieRecord> mm = new LinkedList<MovieRecord>();
        final String msg1 = "Record of Movies by title" + line + ":"
                + "\nRecord Number|IC number|Name|Location|Movie Title|Date of Movie|Starting Time of Movie|Place|";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(msg);
            //Reading user input
            line = br.readLine();
            System.out.println(msg1);
            //Looping through to search for matching record + BP
            for (int i = 0; i < rr.size(); i++) {
                if (rr.get(i).title.toUpperCase().contains(line.toUpperCase())) {
                    mm.add(rr.get(i));
                }
            }
            //sorting the record +BP
            Collections.sort(mm);
            System.out.println("Number of records is: " + mm.size());
            //Looping through to print the record
            for (int o = 0; o < mm.size(); o++) {
                System.out.println(mm.get(o));
            }
        } catch (Exception e) {
            System.out.println("searchTitle error");
        }

    }

    private void display() {
        final String msg = " Records of movies: "
                + "\n<Record Number>|<Credit card number> | <Name> | <Movie Title> | <Date of Movie>|<Time of Movie>|<Place>|";
        System.out.println(msg);
        //Looping through to print the record
        for (int i = 0; i < rr.size(); i++) {
            System.out.println(rr.get(i));
        }
        System.out.println("Number of records is: " + rr.size());
    }

    private String update() {
        final String msg = "Do you want to insert or remove a record?";
        String line;
        String answer1 = "2";
        String answer = "0";
        MovieSearch app = new MovieSearch();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            // Show Choice Menu
            System.out.println(msg);

            // read user input + BP
            line = br.readLine();
            do {
                if (line.equalsIgnoreCase("remove") || line.equalsIgnoreCase("3")) {
                    app.delete();
                    answer1 = app.submenu();
                }
                if (line.equalsIgnoreCase("insert") || line.equalsIgnoreCase("2")) {
                    app.insert();
                    answer1 = app.submenu();
                }
                if (answer1.equalsIgnoreCase("1")) {
                    line = "0";
                    answer = "1";
                }
                if (answer1.equalsIgnoreCase("0")) {
                    line = "0";
                    answer = "0";
                }
            } while (!line.equals("0"));
        } catch (Exception e) {
            System.out.println("update error");
        }
        return answer;
    }

    private String menu() {
        final String msg = "Press 1 to go back to menu, 2 to exit";
        String line;
        String answer = "0";
        System.out.println(msg);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //Read user input + BP
            line = br.readLine();

            if (Integer.parseInt(line) == 1) {
                answer = "1";
            } else {
                answer = "0";
            }
        } catch (Exception e) {
            System.out.println("menu error");
        }
        return answer;
    }

    private String submenu() {
        final String msg = "Please press 1 to go back to the main menu. Press 2 to enter another record. Press 3 to remove a record. Press 0 to exit the program.";
        String line;
        String answer = "0";
        System.out.println(msg);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //Read user input + BP
            line = br.readLine();

            if (Integer.parseInt(line) == 1) {
                answer = "1";
            } else if (Integer.parseInt(line) == 2) {
                answer = "2";
            } else if (Integer.parseInt(line) == 3) {
                answer = "3";
            } else if (Integer.parseInt(line) == 0) {
                answer = "0";
            }
        } catch (Exception e) {
            System.out.println("submenu error");
        }
        return answer;
    }

    private void delete() {
        final String msg = "<Record Number>|<Credit card number> | <Name> | <Movie Title> | <Date of Movie>|<Time of Movie>|<Place>|";
        final String msg1 = "Please select the record number you want to delete: ";
        String file = "101935C_TextFile.txt";
        String line;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(msg);

            for (int i = 0; i < rr.size(); i++) {
                System.out.println(rr.get(i));
            }
            System.out.println(msg1);
            //Read user input + BP
            line = br.readLine();
            //Loop through records to remove the correct record + BP
            for (int i = 0; i < rr.size(); i++) {
                if (rr.get(i).recNo.equalsIgnoreCase(line)) {
                    rr.remove(i);
                }
            }
            //Instantiate the file writers
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //Looping through to write out the records to the text file + BP
            for (int i = 0; i < rr.size(); i++) {
                pw.println(rr.get(i));
            }
            System.out.println("Record has been updated");
            pw.close();
        } catch (Exception e) {
            System.out.println("delete error");
        }
    }

    private void insert() {
        final String msg = "Please type in the data in the following format:\n"
                + "<Record Number>|<Credit card number> | <Name> | <Movie Title> | <Date of Movie>|<Time of Movie>|<Place>|\n";
        MovieRecord gr;

        StringTokenizer stk;
        String file = "101935C_TextFile.txt";
        String line = "";
        String recNo,creditNo,name,title,date,time,place;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(msg);
            // Read user input + BP
            line = br.readLine();

            // Tokenize input + BP
            stk = new StringTokenizer(line, "|");

            recNo = stk.nextToken();
            creditNo = stk.nextToken();
            name = stk.nextToken();
            title = stk.nextToken();
            date = stk.nextToken();
            time = stk.nextToken();
            place = stk.nextToken();
            //Create RoomRecords object to store input
            gr = new MovieRecord(recNo, creditNo, name, title , date , time , place );
            // Add to LinkedList
            rr.addLast(gr);
            System.out.println(gr.toString());
            System.out.println("Data has been recorded...");
            //Instantiate file writers
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //Looping through records to write into text file
            for (int i = 0; i < rr.size(); i++) {
                pw.println(rr.get(i));
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("insert error");
        }
    }
}

/** paypal interview questions **/
class A
{
  int method(int x) throws IOException
  {
    return 0;
  }
}

class B extends A
{
  /* will this signature give error */
  int method(int x) throws Exception
  {
    return 0;
  }  
  /* will this signature give error */
  float method(int x) throws Exception
  {
    return 0;
  }    
}

/*
    other questions:
    1. find middle of linkedlist in one iteration, what's time and space complexity
    2. find and delete duplicate rows in a DB table in single query
    3. find minimum number in a Queue - with minimum space and time complexity
    4. what are different design patterns used
    5. what are their advantages / disadvantages
    6. when do you don't use design pattern (anti pattern?)
    7. what's AOP in Spring
    8. what are advantages and disadvantages of AOP
    9. how the application's flow works
    10. what are different roles in application
    11. how's authentication done in application
    12. how's it passed to backend
    13. how's authorization done in application
    14. can variables in interface definition have static modifier? yes. they are implicitly public static final
    
    Round 2 - 20 jan 2014
    Print 1/n 23/n 456/n 78910/n
A big file contains dept and age of employees. Calculate avg age by dept.. Use data structures
What r two design problems you solved at work
What's your work on web services

Round 3 - 20 jan 2014
Program to swap instance variables of two objects

String as="too";
String as2="too";
String sb=new String("too");
System.out.println(as==sb);
System.out.println(as==as2);
System.out.println(as.equals(sb));

Write examples of factory, singleton, builder
Diff btwn stub n mock
What's mock frwrk u used for ut
Static class
Overriding n loading
Overrides annotations
who gets user stories in scrum
what is your day to day activities
do you have a QA team

Round 4 - 20 jan 2014
What's d recent thing u learned
What r different types of program lang
What do u think abt node.js
World is moving towards js..
Simple db normalization scenarios
Problem on not exists clause
How r user stories estimations quantified? Fibnoucii ( thEy call it poker)
Velocity?
WAP fibnoucci using recursion and without
How do u design an application that lists recent ten records from table contains billion records that receiving millions of requests every minute
Caching?
Where does caching layer go
How cache gets synced with db updates
Publish subscribe mechanism
Have u heard of materialized views
What's cache key..
Why shud pp hire you
*/
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
*/
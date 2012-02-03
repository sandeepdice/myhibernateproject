package snippets;

public class NewAlgo {


    public static void main(String... args)
    {



    StringBuilder inputStr= new StringBuilder("aaabbbcccccccccddd");
    char last=inputStr.charAt(0);
    int count=1;
    int start=0;
    int end=0;
    int intern=0;

    if(inputStr.length()<1)
    {
        System.out.println("Input String is empty"+inputStr);
        System.exit(1);

    }

    for(int i=1;i<inputStr.length();i++)
    {
    char next=inputStr.charAt(i);

    if(last==next)
    count++;
    else
    {
        end=count+start;

        inputStr.replace(start, end, last+Integer.toString(count));

        count=1;
        start=start+2;

        i=intern+start;
    }
    last=next;
    }

    inputStr.replace(start, inputStr.length(), last+Integer.toString(count));
    System.out.println(inputStr);


    }
       }

package snippets;

public class NewAlgo {


    public static void main(String... args)
    {



    StringBuilder InputStr= new StringBuilder("aaabbbcccccccccddd");
    char last=InputStr.charAt(0);
    int count=1;
    int start=0;
    int end=0;
    int intern=0;

    if(InputStr.length()<1)
    {
        System.out.println("Input String is empty"+InputStr);
        System.exit(1);

    }

    for(int i=1;i<InputStr.length();i++)
    {
    char next=InputStr.charAt(i);

    if(last==next)
    count++;
    else
    {
        end=count+start;

        InputStr.replace(start, end, last+Integer.toString(count));

        count=1;
        start=start+2;

        i=intern+start;
    }
    last=next;
    }

    InputStr.replace(start, InputStr.length(), last+Integer.toString(count));
    System.out.println(InputStr);


    }
       }

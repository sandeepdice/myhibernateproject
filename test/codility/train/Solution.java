package codility.train;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isPalindrome("abbs"));
		System.out.println(s.solution("baababa"));
	}

	boolean isPalindrome(String s)
	{
		int length = s.length();
			if(s.substring(0, length/2).compareTo(new StringBuilder(s.substring((length % 2 == 0)?(length/2):((length/2)+1), length)).reverse().toString()) == 0)
					return true;
			else
				return false;
	}
	
	public int solution(String S) {
        // write your code here...
		int startIndex = 0;
		int endIndex = 1;
		int palindromeCount = 0;
		int length;
		
		if(S == null) return 0;
		else if(S.length() == 0)
			return 0;
		else 
		{
			length = S.length();
			if(length > 100000000)
				return -1;
			else
			{
				while(startIndex <= length)
				{
					while(endIndex < length)
					{
						if(isPalindrome(S.substring(startIndex, endIndex+1))) palindromeCount++;
						endIndex++;
					}
					startIndex++;
					endIndex = startIndex+1;
				}
				return palindromeCount;
			}
		}
    }
}

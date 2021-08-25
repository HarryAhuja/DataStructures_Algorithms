package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ReverseString {

    public static int first = 0;
    
    public static void reverse_helper(char inp[],int last,int n)
    {
        if(last == n)   return;
        
        reverse_helper(inp, last+1,n);
        
        if(first>=last)         return;
        
        char  temp = inp[first];
        inp[first] = inp[last];
        inp[last]  = temp;
        
        first++;
    }
    public static void reverse(char inp[])
    {
        reverse_helper(inp,0,inp.length);
    }
    public static void main(String[] args) {
        char inp[] = {'h','e','l','l','o'};
        
        reverse(inp);
        
        System.out.println(inp);
    }

}

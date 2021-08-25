package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

public class ReverseString {

    public static void reverse(char inp[])
    {
        int i = 0;
        int j = inp.length-1;
        
        while(i<j)
        {
            char temp = inp[i];
            inp[i] = inp[j];
            inp[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        char inp[] = {'h','e','l','l','o'};
        
        reverse(inp);
        
        System.out.println(inp);
    }

}

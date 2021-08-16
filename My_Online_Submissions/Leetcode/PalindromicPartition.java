package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {
    
    public static boolean is_palindrome(String s, int low, int high){
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
    
    public static void print_partition_list_helper(String str,int level,int n,List<String> list,
                                                   List<List<String>> result)
    {
        if(level == n)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = level;i<n;i++)
        {
            if(is_palindrome(str,level,i) == true)
            {
                list.add(str.substring(level,i+1));
                print_partition_list_helper(str,i+1,n,list,result);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    public static List<List<String>> print_partition_list(String str)
    {
        List<List<String>> result = new ArrayList<>();
        int n = str.length();
        
        if(n == 0)  return result;
        
        print_partition_list_helper(str,0,n,new ArrayList<>(),result);
        
        return result;
    }
    public static void main(String[] args) {
        
        String str = "aabb";
        
        System.out.println(print_partition_list(str));
    }
}

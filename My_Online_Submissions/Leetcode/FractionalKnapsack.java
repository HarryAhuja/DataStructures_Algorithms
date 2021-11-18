package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

class FractionalKnapsackSolution
{
    static class Item
    {
        Double p_w_ratio;   // Double not double to invoke compareTo
        int weight;
        int price;
        
        public Item()
        {
            weight = 0;
            price  = 0;
        }
        
        public Item(int w,int p)
        {
            weight = w;
            price  = p;
            p_w_ratio  = (double)p/w;
        }
    }
    public double max_profit(int wt[],int profit[],int W)
    {
        int n = wt.length;
        int i = 0;
        if(n==0)    return 0;
        
        Item[] items = new Item[n];
        for(i=0;i<n;i++)
        {
            items[i] = new Item(wt[i],profit[i]);
        }
        
        Arrays.sort(items, new Comparator<Item>()
                {
                    public int compare(Item i1,Item i2)
                    {
                        return -1*i1.p_w_ratio.compareTo(i2.p_w_ratio);
                    }
                });
        
        int w = 0;
        double max_profit = 0;
        i = 0;
        
        while(w<=W)
        {
            // Full item
            if(w+wt[i]<=W)
            {
                w = w+items[i].weight;
                max_profit += items[i].price;
            }
            // fractional item
            else
            {
                max_profit = max_profit + ((W-w)/(double)items[i].weight)*items[i].price;
                w = W;
                break;      // At this point bag is filed completely
            }
            
            i++;
        }
        return max_profit;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;
        
        FractionalKnapsackSolution obj = new FractionalKnapsackSolution();
        System.out.println(obj.max_profit(wt, val, capacity));

    }

}

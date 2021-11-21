/*
 * Approach 1
 * 
 * sort entries acc to finishing time bcs I want max empty time after one end of meet
 * so that there is max space left for other meetins
 * 
 * if one meet is from 8am to 10am
 * and second is 7am to 9am
 * I want second meet to happen such that there are max slots left after 9am for
 * other meets
 * 
 * After sorting
 * 1st meet-> room is empty-> take place
 * 2nd meet-> it should start after only first meet is over
 * 
 * sorted array: 7am to 9am , 8am to 10am
 *                  0           1
 * bcs 1st index meet starts before end of 0th meet, it can't happen bcs one meet at 
 * one time
 * 
 * This also ensures that largest meeting(count only increases by 1) is given least priority
 * (even if it is sorted earlier acc to end time) but bcs start time will overlap then,
 * it will not take place
 * 
 * If while sorting , same ending time-> sort earlier index first irrespective of start time
 */

package datastructures.DataStructures_Algorithms.My_Online_Submissions.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

class MeetingRoomNode
{
    int start;
    int end;
    int index;
    
    public MeetingRoomNode() {
        start = 0;
        end   = 0;
        index = -1;
    }
    public MeetingRoomNode(int s,int e,int i) {
        start = s;
        end   = e;
        index = i;
    }
}
public class NMeetingsRoom {

    public static int find_max_meetings(int start[],int end[],int n)
    {
        if(n==0)    return 0;
        
        MeetingRoomNode sorted_arr[] = new MeetingRoomNode[n];
        
        // O(n)
        for(int i=0;i<n;i++)
        {
            sorted_arr[i] = new MeetingRoomNode(start[i],end[i],i);
        }
        
        // O(nlogn)
        Arrays.sort(sorted_arr,new Comparator<MeetingRoomNode>(){
            public int compare(MeetingRoomNode m1, MeetingRoomNode m2)
            {
                if(m1.end==m2.end)
                {
                    if(m1.index<m2.index)   return -1;  // m1 comes first
                    else                    return 1;
                }
                else
                {
                    if(m1.end<m2.end)       return -1;  // m1 comes first
                    else                    return 1;
                }
            }
        });
        
        int ans = 1;
        
        // if any meeting is skipped then we have to compare with meeting in
        // progress not skipped
        // Not a consecutive meeting cases
        int last_meet_end = sorted_arr[0].end;
        for(int i=1;i<n;i++)
        {
            if(sorted_arr[i].start>last_meet_end)
            {
                last_meet_end = sorted_arr[i].end;
                ans++;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int N = 6,start[] = {1,3,0,5,8,5},end[] ={2,4,6,7,9,9};
        
        System.out.println(find_max_meetings(start,end,N));

    }

}

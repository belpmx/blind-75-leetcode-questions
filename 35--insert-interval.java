import java.util.ArrayList;
import java.util.List;

class Solution035 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //to store the updated arrays
        List<int []> result = new ArrayList<>();
        int n = intervals.length; //number of the intervals provided
        int i =0;
        int low = newInterval[0];
        int high = newInterval[1];
        //intervals[i][1] will check [x,1] that is the low element on each interval
        while(i<n && intervals[i][1] < low){
            //add the interval to the result that are lower than the low of the new interval
            result.add(intervals[i]);
            i++;
        }
        //merge the intervals that are in range of low and high
        while(i<n && high >= intervals[i][0]){
            //determine the new low and high
            low = Math.min(intervals[i][0],low);
            high = Math.max(intervals[i][1], high);//this high is validated on the while
            i++;
        }
        //re-use the newInterval to store the merged array
        newInterval[0] = low;
        newInterval[1] = high;
        result.add(newInterval);
        //add remaining intervals to result

        while (i < n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[0][]);
    }
}




class Solution35 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        // find out interval on the left of newInterval (non-overlapping)
        while (i < n && intervals[i][1] < newInterval[0]) { 
            result.add(intervals[i]);
            i++;
        }
        // find this interval: [startTime, endTime]
        while (i < n && intervals[i][0] <= newInterval[1]) {
            int startTime = Math.min(intervals[i][0], newInterval[0]);
            int endTime = Math.max(intervals[i][1], newInterval[1]);
            newInterval[0] = startTime;
            newInterval[1] = endTime;
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
} // TC: O(n), SC: O(1)

// intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]

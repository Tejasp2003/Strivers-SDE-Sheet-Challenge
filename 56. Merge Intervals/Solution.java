import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            // No merging needed if there is only one interval or none
            return intervals;
        }
        
        // Sort intervals based on the start value of each interval
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
       
        
        
        for (int[] interval : intervals) {
            int currentStart = interval[0];
            int currentEnd = interval[1];
            
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < currentStart) {
                // If the list is empty or the current interval does not overlap with the previous interval,
                // add the current interval to the list
                mergedIntervals.add(interval);
            } else {
                // If there is an overlap, merge the current interval with the previous interval
                int[] previousInterval = mergedIntervals.get(mergedIntervals.size() - 1);
                previousInterval[1] = Math.max(previousInterval[1], currentEnd);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
    public static void main(String [] args){
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Solution s = new Solution();
        int [][] mergedIntervals = s.merge(intervals);
        for(int i = 0; i < mergedIntervals.length; i++){
            System.out.println(mergedIntervals[i][0] + " " + mergedIntervals[i][1]);
        }
    }
}

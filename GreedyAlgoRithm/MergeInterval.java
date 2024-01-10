class Solution {
    public int[][] merge(int[][] Intervals) {
        Arrays.sort(Intervals, (a, b) -> Integer.compare(a[0], b[0]));// sort on the base of stating point

        ArrayList<int[]> ans = new ArrayList<>();

        for (int[] intervals : Intervals) {
            if (ans.size() == 0) {
                ans.add(intervals);
            } else {
                int preIntervals[] = ans.get(ans.size() - 1);
                if (intervals[0] <= preIntervals[1]) {
                    preIntervals[1] = Math.max(preIntervals[1], intervals[1]);
                } else {
                    ans.add(intervals);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
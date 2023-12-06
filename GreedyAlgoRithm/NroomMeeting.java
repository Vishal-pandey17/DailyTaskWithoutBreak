class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        int meeting[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            meeting[i][0] = i;
            meeting[i][1] = start[i];
            meeting[i][2] = end[i];
        }
        Arrays.sort(meeting, Comparator.comparingDouble(o -> o[2]));

        int max = 1;
        int last = meeting[0][2];
        for (int i = 1; i < n; i++) {
            if (meeting[i][1] > last) {
                max++;
                last = meeting[i][2];
            }
        }
        return max;
    }
}

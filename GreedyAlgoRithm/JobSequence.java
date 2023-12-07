
class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int maxNum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxNum) {
                maxNum = arr[i].deadline;
            }
        }

        int temp[] = new int[maxNum + 1];

        Arrays.fill(temp, -1);

        int countJob = 0;
        int jobProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (temp[j] == -1) {
                    temp[j] = i;
                    countJob++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        int ans[] = new int[2];
        ans[0] = countJob;
        ans[1] = jobProfit;

        return ans;
    }
}

/*
 * class Job {
 * int id, profit, deadline;
 * Job(int x, int y, int z){
 * this.id = x;
 * this.deadline = y;
 * this.profit = z;
 * }
 * }
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1;
        int j = 0;
        int platform = 1;
        while (i < n) {
            if (arr[i] <= dep[j])
                platform++;
            else
                j++;
            i++;
        }
        return platform;
    }

}
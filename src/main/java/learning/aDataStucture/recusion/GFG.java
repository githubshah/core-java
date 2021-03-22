package learning.aDataStucture.recusion;// Java program to find longest subarray with
// sum of elements at-least k. 

class GFG {

    // function to find the length of largest
    // subarray having sum atmost k.
    public static int atMostSum(int arr[], int n,
                                int k) {
        int sum = 0;
        int cnt = 0, maxcnt = 0;

        for (int i = 0; i < n; i++) {

            // If adding current element doesn't
            // cross limit add it to current window
            if ((sum + arr[i]) <= k) {
                sum += arr[i];
                cnt++;
            }
            // Else, remove first element of current
            // window.
            else if (sum != 0) {
                sum = sum - arr[i - cnt] + arr[i];
            }

            // keep track of max length.
            maxcnt = Math.max(cnt, maxcnt);
        }
        return maxcnt;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        //int arr[] = {4, 2, 4, 1, 2}; // 5
        //int arr[] = {0, 3, 1, 4, 1, 3, 0}; //4
        int arr[] = {0, 0, 3, 1, 4, 1, 3, 0, 0}; //4
        int n = arr.length;
        int k = 4;

        System.out.print(atMostSum(arr, n, k));

    }
}
// This code is contributed by Arnav Kr. Mandal. 

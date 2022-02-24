// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            
            int arr[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            for(int i = 0; i < n; i++)
              arr[(int)i] = Integer.parseInt(st[(int)i]);
              
            
            System.out.println(new Solution().maxStep(arr, n));
        }
    }
    
    
}
    
    
// } Driver Code Ends



class Solution
{
    //Function to find maximum number of consecutive steps 
    //to gain an increase in altitude with each step.
    static int maxStep(int A[], int N)
    {
        int maxStep = 0;
        int i = 1;
        
        int steps = 0;
        while(i < A.length){
            if(A[i] > A[i - 1]){
                steps++;
            }
            else{
                if(steps > maxStep){
                    maxStep = steps;
                }
                steps = 0;
            }
            i++;
        }
        
        if(steps > maxStep){
            maxStep = steps;
        }
                
        return maxStep;
    }
    
}
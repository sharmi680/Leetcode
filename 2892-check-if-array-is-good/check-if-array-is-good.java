class Solution{
    public boolean isGood(int[] nums){
        int n=Arrays.stream(nums).max().getAsInt();  
        if(nums.length !=n+1) 
        return false;        

        int[] count=new int[n+1];                  
        for(int num:nums){
            if(num>n) 
            return false;                
            count[num]++;
        }
        for(int i=1;i<n;i++) {
            if(count[i] !=1)
             return false;           
        }
        return count[n]==2;                          
    }
}

class Solution{
    public int[] limitOccurrences(int[] nums, int k){
        ArrayList<Integer> list=new ArrayList<>();
        for(int num : nums){
            int size=list.size();
            if (size<k || list.get(size-k)!=num){
                list.add(num);
            }
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int n: nums) xor ^= n;
        int mask = (xor & (xor - 1)) ^ xor;
        
        int num1 = 0;
        for(int n: nums)
            if((mask & n) == 0)
                num1 ^= n;
        
        return new int[]{num1, xor ^ num1};
    }
}
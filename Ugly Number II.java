 class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            int indexOf2 = 0, indexOf3 = 0, indexOf5 = 0;
            int factorOf2 = 2, factorOf3 = 3, factorOf5 = 5;
            for(int i=1;i<n;i++){
                int min = Math.min(Math.min(factorOf2,factorOf3),factorOf5);
                ugly[i] = min;
                if(factorOf2 == min)
                    factorOf2 = 2*ugly[++indexOf2];
                if(factorOf3 == min)
                    factorOf3 = 3*ugly[++indexOf3];
                if(factorOf5 == min)
                    factorOf5 = 5*ugly[++indexOf5];
            }
            return ugly[n-1];
        }
    }
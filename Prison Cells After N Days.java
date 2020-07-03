class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] result = new int[cells.length];
        N= N%14 == 0?14:N%14;
        int i, length = cells.length-1;
        while(N > 0)
        {
            for(i=1; i<length; i++)
            {
                if(cells[i-1]==cells[i+1])
                    result[i]=1;
                else
                    result[i]=0;
            }
            N--;
            cells=Arrays.copyOf(result, length+1);
        }
        return result;
    }
}
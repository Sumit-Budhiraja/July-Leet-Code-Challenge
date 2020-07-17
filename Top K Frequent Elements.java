class Solution {
	
	public int[] topKFrequent (int[] nums, int k) {
	
		HashMap<Integer, Integer> frequency = new HashMap <>();
		for (int num : nums) {
			frequency.put (num, frequency.getOrDefault (num, 0) + 1);
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue <>((key1, key2) -> frequency.get (key2) - frequency.get (key1));
		queue.addAll (frequency.keySet ());
		
		int[] topKList = new int[k];
		for (int i = 0; i < k; i++) {
			topKList[i] = queue.poll ();
		}
		
		return topKList;
	}
}
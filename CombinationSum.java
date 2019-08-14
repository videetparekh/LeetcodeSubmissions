class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> values = new ArrayList<>();
        combinationSum(values, new ArrayList<Integer>(), candidates, target, 0);
        return values;
    }
    
    private void combinationSum(List<List<Integer>> values, List<Integer> combination, int[] candidates, int target, int start) {
        if(target > 0){
    		for(int i = start; i < candidates.length && target >= candidates[i]; i++){
    			combination.add(candidates[i]);
    			combinationSum(values, combination, candidates, target - candidates[i], i);
    			combination.remove(combination.size() - 1);
    		}
    	}
    	else if(target == 0 ){
    		values.add(new ArrayList<Integer>(combination));
    	}
    }
}
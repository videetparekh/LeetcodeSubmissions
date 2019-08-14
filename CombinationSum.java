class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum = 0;
        List<List<Integer>> values = new ArrayList<>();
        combinationSum(values, new ArrayList<Integer>(), candidates, target, sum);
        return values;
    }
    
    private void combinationSum(List<List<Integer>> values, List<Integer> combination, int[] candidates, int target, int currentSum) {
        for (int i=0;i<candidates.length; i++) {
            if (candidates[i] + currentSum == target) {
                List<Integer> newCombo = new ArrayList<>(combination);
                newCombo.add(candidates[i]);
                Collections.sort(newCombo);
                if(!values.contains(newCombo)) values.add(newCombo);
            }
            else if (candidates[i] < target - currentSum) {
                List<Integer> newCombo = new ArrayList<>(combination);
                newCombo.add(candidates[i]);
                combinationSum(values, newCombo, candidates, target, currentSum+candidates[i]);
            }
        }
        return;
    }
}
class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // Sort numbers. Important steps to avoid duplicates      
        Arrays.sort(nums);
        List<List<Integer>> sumList = new ArrayList<>();
        
        // Loop through numbers, and for each unique number test all the greater numbers in the array for numbers that can complete a three Sum
        for(int i=0;i<nums.length-2;i++) {
            
            // Ignore duplicates, as they will result in duplicate three sums
            if(i == 0 || (i>0 && nums[i] != nums[i-1])) {
                int sum = 0 - nums[i];

                // Test all array values greater than current
                int low = i+1;
                int high = nums.length-1;

                while(low<high) {

                    // If array values match three sum, add to list and skip over duplicate values
                    if (nums[low]+nums[high] == sum) {
                        sumList.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++; high--;
                    } else if (nums[low] + nums[high] > sum) {high--;}
                    else {low++;}
                }   
            }            
        }
        return sumList;
    }
}
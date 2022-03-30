package recursionproblemset4;


public class set4 {

	public static void main(String[] args) {
		System.out.println(groupSum(0, new int[]{2,4,8}, 14));
		
		System.out.println(split53(new int[]{2,4,2}));
		
		System.out.println(splitArray(new int[]{5,2,3}));
	}
	

	public static boolean groupSum(int start, int[] nums, int target) {
		if(target == 0) return true; // if target is 0, no array is needed
        else if(start == nums.length) return false; // array has been fully iterated through, meaning it's done
        else if(groupSum(start+1, nums, target - nums[start])) return true; // if the next recursive number adds it up to target, return true
        return groupSum(start + 1, nums, target); // recursive case continues to iterate through array
	}
	
	//2
	public static boolean split53(int[] nums) {
		return split53helper(0,nums,0,0);
	}
    // I used a helper function because it's not possible without extra inputs to the recursive function
	public static boolean split53helper(int i, int[] arr, int group1Sum, int group2Sum) {
	    if (i == arr.length) 
            return group1Sum == group2Sum; // base case
	    else if (arr[i] % 5 != 0 && split53helper(i+1, arr, group1Sum+arr[i], group2Sum))
            return true;
	    else if (arr[i] % 3 != 0 && split53helper(i+1, arr, group1Sum, group2Sum+arr[i]))
		    return true;
	
	    return false;
	}
		
		
	public static boolean splitArray(int[] nums) {
		return splitArrayHelper(0,nums,0,0);
	}
	public static boolean splitArrayHelper(int i, int[] arr, int group1Sum, int group2Sum) {
		if (i == arr.length) 
			return group1Sum==group2Sum; // base case
		if (splitArrayHelper(i+1, arr, group1Sum+arr[i], group2Sum))
		  	return true;
		  
		else if (splitArrayHelper(i+1, arr, group1Sum, group2Sum+arr[i])) 
		  	return true;
		
		return false;
	}
		
	
}

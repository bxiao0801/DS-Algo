public class Solution{
	public void quicksort(int[] nums,int start,int end){
		if(start>=end){
			return;
		}

		int pivot=nums[end];
		int i=start;
		int j=end;
		while(i<j){
			while(nums[i]<pivot&&i<j){
				i++;
			}
			while(nums[j]>=pivot&&i<j){
				j--;
			}
			if(i<j){
				swap(nums,i,j);
			}
		}

		swap(nums,i,end);
		quicksort(nums,start,i-1);
		quicksort(nums,i+1,end);
	}

	public void swap(int[] nums,int i,int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}

	public static void main(String[] args){
		int[] nums={5,4,3,2,1,1,1,1,1,2,3,4,5,2,1};
		Solution s=new Solution();
		s.quicksort(nums,0,nums.length-1);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}
}

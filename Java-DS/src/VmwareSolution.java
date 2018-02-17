
public class VmwareSolution {

	
	public int summer(int N){
	
		int count = 0;
	    int start = 1, end = (N+1)/2;
	    while (start < end)
	    {
	        int sum = 0;
	        for (int i = start; i <= end; i++)
	        {
	            sum = sum + i;
	            if (sum == N)
	            {
	                count++;
	                break;
	            }
	 
	            if (sum > N)
	                break;
	        }
	        sum = 0;
	        start++;
	    }
		return count;
		
		
	}
	
	
}

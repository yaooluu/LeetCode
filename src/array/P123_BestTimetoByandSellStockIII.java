package array;

public class P123_BestTimetoByandSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(maxProfit2(new int[]{6,1,3,2,4,7}));
		//System.out.println(maxProfit2(new int[]{1,2,1,2,1,1}));
		//System.out.println(maxProfit2(new int[]{3,2,6,5,0,3}));
	}
	
    public static int maxProfit(int[] prices) {
        int maxP = func(prices,0,prices.length);
        
        for(int i=1;i<prices.length-1;i++) {
            int a = func(prices, 0, i+1);
            int b = func(prices, i+1, prices.length);
            if(a + b > maxP) maxP = a + b;
        }
        return maxP;
    }
    
    private static int func(int[] prices, int start, int end) {
        int min = Integer.MAX_VALUE;
        int maxP = 0;
        
        for(int i=start;i<end;i++) {
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] - min > maxP)
                maxP = prices[i] - min;
        }
        return maxP;
    }

    public static int maxProfit2(int[] prices) {
        int maxP = 0;        
        int min = Integer.MAX_VALUE;
        int[] left = new int[prices.length];
        for(int i=0;i<prices.length;i++) {
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] - min > maxP)
                maxP = prices[i] - min;            
            left[i] = maxP;     
        }
        
        int maxR = 0;
        int max = 0;
        int[] right = new int[prices.length];
        for(int i=prices.length-1;i>=0;i--) {
            if(prices[i] > max)
                max = prices[i];
            else if(max - prices[i] > maxR)
                maxR = max - prices[i];           
            right[i] = maxR;
        }
        
        for(int i=0;i<prices.length-1;i++) {
            if(left[i] + right[i+1] > maxP)
                maxP = left[i]+right[i+1];
        }
        
        return maxP;
    }
}

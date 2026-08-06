class StockSpanner {

    class Pair{
        
        int index;
        int price;
        
        Pair(int index,int price){
            this.index=index;
            this.price=price;
        }
    }

    private Stack<Pair> stack;
    int curindex;

    public StockSpanner() {
        stack=new Stack<>();
        curindex=0;
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek().price<=price){
            stack.pop();
        }
        int res=stack.isEmpty()?curindex+1:curindex-stack.peek().index;
        stack.push(new Pair(curindex++,price));
        return res;
    }

    
}


/*
public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int nge[]=funcNGE(arr);
        int n=arr.length;
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(i-nge[i]);
        }
        return result;
    }
    public int[] funcNGE(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        int nge[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            nge[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return nge;
    }
    */
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
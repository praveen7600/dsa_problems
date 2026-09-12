class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev=reverse(n);
        if(rev<n){
            int temp=rev;
            rev=n;
            n=temp;
        }
        System.out.println("Reverse "+rev+" N  "+n);
        int sum=0;
        for(int i=n;i<=rev;i++){
            if(isPrime(i)){
                sum+=i;
            }
        }
        return sum;
    }

    public int reverse(int n){
        int rev=0;
        while(n>0){
            int rem=n%10;
            rev=(rev*10)+rem;
            n/=10;
        }
        return rev;
    }

    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
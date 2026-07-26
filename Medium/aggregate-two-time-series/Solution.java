class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] arr1, int[][] arr2) {
        List<List<Integer>> result=new ArrayList<>();
        int i=0,j=0;
        int n=arr1.length;
        int m=arr2.length;
        while(i<n && j<m){
            int sum=0;
            ArrayList<Integer> innerlist=new ArrayList<>();
            if(arr1[i][0]==arr2[j][0]){
                sum+=arr1[i][1]+arr2[j][1];
                innerlist.add(arr1[i][0]);
                i++;
                j++;
            }
            else if(arr1[i][0]<arr2[j][0]){
                sum+=arr1[i][1]+arr2[j][1];
                innerlist.add(arr1[i][0]);
                i++;
            }
            else{
                sum+=arr1[i][1]+arr2[j][1];
                innerlist.add(arr2[j][0]);
                j++;
            }
            innerlist.add(sum);
            result.add(innerlist);
        }

        while(i<n){
            int sum=0;
            ArrayList<Integer> innerlist=new ArrayList<>();
            innerlist.add(arr1[i][0]);
            sum+=arr1[i][1];
            i++;
            innerlist.add(sum);
            result.add(innerlist);
        }

        while(j<m){
            int sum=0;
            ArrayList<Integer> innerlist=new ArrayList<>();
            innerlist.add(arr2[j][0]);
            sum+=arr2[j][1];
            j++;
            innerlist.add(sum);
            result.add(innerlist);

        }

        return result;
    }
}
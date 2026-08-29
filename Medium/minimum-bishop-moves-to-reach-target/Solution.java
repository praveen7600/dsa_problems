class Solution {
    int n=8;
    public int minBishopMoves(int[] source, int[] target) {
        int sr=source[0]-1;
        int sc=source[1]-1;
        int tr=target[0]-1;
        int tc=target[1]-1;

        if( (sr+sc)%2 !=(tr+tc)%2 ){
            return -1;
        }

        if(Math.abs(sr-tr)==Math.abs(sc-tc)){
            return 1;
        }
        return 2;
    }
}
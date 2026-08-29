class Solution {
    int n=8;
    public int minBishopMoves(int[] source, int[] target) {
        int sr=source[0]-1;
        int sc=source[1]-1;
        int tr=target[0]-1;
        int tc=target[1]-1;

        if((((sr+sc)%2==0) && ((tr+tc)%2!=0)) || (((sr+sc)%2!=0) && ((tr+tc)%2==0)) ){
            return -1;
        }

        if(leftup(sr,sc,tr,tc) || leftbottom(sr,sc,tr,tc) || rightup(sr,sc,tr,tc) || rightbottom(sr,sc,tr,tc)){
            return 1;
        }
        return 2;
    }
    public boolean leftup(int sr,int sc,int tr,int tc){
        while(sr>0 && sc>0){
            sr-=1;
            sc-=1;
            if(sr==tr && sc==tc){
                return true;
            }
        }
        return false;
    }
    public boolean leftbottom(int sr,int sc,int tr,int tc){
        while(sr<n && sc>0){
            sr+=1;
            sc-=1;
            if(sr==tr && sc==tc){
                return true;
            }
        }
        return false;
    }
    public boolean rightup(int sr,int sc,int tr,int tc){
        while(sr>0 && sc<n){
            sr-=1;
            sc+=1;
            if(sr==tr && sc==tc){
                return true;
            }
        }
        return false;
    }
    public boolean rightbottom(int sr,int sc,int tr,int tc){
        while(sr<n && sc<n){
            sr+=1;
            sc+=1;
            if(sr==tr && sc==tc){
                return true;
            }
        }
        return false;
    }
}
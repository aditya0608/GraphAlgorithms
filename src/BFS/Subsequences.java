package BFS;

import java.sql.Array;
import java.util.ArrayList;

public class Subsequences {

    static int A[]={0,1,2};
    static  ArrayList<Integer> temp=new ArrayList<Integer>();

    public static void main(String args[])
    {

        subb(A,0);
    }
    public static void subb(int A[],int idx)
    {
        if(idx==A.length)
        {
            for(Integer ele:temp)
                System.out.print(ele+" ");
            System.out.println();
            return;
        }
        temp.add(A[idx]);

        subb(A,idx+1);

temp.remove(temp.size()-1);
        subb(A,idx+1);
    }
}


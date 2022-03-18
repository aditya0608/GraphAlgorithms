package GraphProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class City {
int B[][]={
        {1, 3},
        {1, 4},
    {3, 2},
        {3, 5}
};
    int A=5;
        public int solve() {
            int MOD=1000000000+7;
            Queue<Integer> queueA=new LinkedList<Integer>();
            Queue<Integer> queueB=new LinkedList<Integer>();
            if(A==1 || A==2)
                return 0;
            ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
            int [] visited=new int[A+1];
            int parent[]=new int[A+1];
            for(int i=0;i<=A;i++)

                list.add(new ArrayList<Integer>());
            for(int array[]:B)
            {
                list.get(array[0]).add(array[1]);
                list.get(array[1]).add(array[0]);
            }
            Queue<Integer> queue=new LinkedList<Integer>();
            queue.add(B[0][0]);
            parent[B[0][0]]=1;
            queueA.add(B[0][0]);
            while(!queue.isEmpty())
            {
                int temp=queue.poll();
                visited[temp]=1;

                for(Integer ele:list.get(temp))
                {
                    if(visited[ele]==0)
                    {
                        queue.add(ele);
                        parent[ele]=(parent[temp]==1?2:1);
                        if(parent[ele]==1)
                        {
                            queueA.add(ele);
                        }
                        else
                        {
                            queueB.add(ele);
                        }
                    }
                }


            }
            return ((queueA.size()*queueB.size())-A+1)%MOD;
        }
        }



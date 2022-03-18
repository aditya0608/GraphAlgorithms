package GraphProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InstituteIBA {

   int A = 59;
    int []B = { 37, 53, 46, 66, 66, 31, 51, 52, 62, 55, 58, 66, 52, 36, 42, 52, 35, 59, 63, 55, 52, 39, 61, 41, 45, 50, 52, 39, 69, 41, 30, 65, 54, 51, 45, 63, 52, 42, 69, 58, 55, 56, 56, 32, 42, 63, 35, 36, 37, 62, 37, 40, 67, 52, 31, 35, 68, 60, 50 };
    int [][]C = {
            {2, 16},
            {2, 50},
            {3, 56},
            {7, 45},
            {8, 13},
            {8, 14},
            {8, 54},
            {9, 58},
            {11, 44},
            {12, 36},
            {15, 22},
            {15, 53},
            {15, 56},
            {16, 40},
            {16, 41},
            {17, 20},
            {20, 30},
            {22, 58},
            {23, 31},
            {25, 45},
            {26, 34},
            {27, 42},
            {29, 45},
            {34, 45},
            {35, 41},
            {36, 57},
            {37, 38},
            {44, 58},
            {47, 51},
            {50, 57},
    };
    int D = 260;
        public int solve() {
            int visited[]=new int[A+1];
            ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
            int count=0;
            for(int i=0;i<=A;i++)
                list.add(new ArrayList<Integer>());

            for(int [] edge:C)
            {
                list.get(edge[0]).add(edge[1]);
                list.get(edge[1]).add(edge[0]);
            }
            for(int i=1;i<=A;i++)
            {
                if(visited[i]==0 && list.get(i).size()>0)
                {
                    int weight=0;
                    Queue<Integer> queue=new LinkedList<Integer>();
                    queue.offer(i);
                    while(!queue.isEmpty())
                    {
                        int temp=queue.poll();
                        visited[temp]=1;
                        weight+=B[temp-1];
                        for(Integer ele:list.get(temp))
                        {
                            if(visited[ele]==0)
                            {
                                queue.offer(ele);

                            }
                        }
                    }
                    if(weight>=D)
                        count++;
                }
            }
            return count;
        }
    }


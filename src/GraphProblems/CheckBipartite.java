package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartite {


    int B[][]={{11, 68},
            {4, 76},
            {29, 78},
            {14, 59},
            {2, 92},
            {17, 81},
            {16, 48},
            {20, 93},
            {71, 93},
            {74, 78},
            {19, 67},
            {11, 48},
            {19, 71},
            {0, 87},
            {39, 75},
            {32, 72},
            {52, 89},
            {1, 95},
            {61, 77},
            {34, 94},
            {48, 66},
            {9, 39},
            {21, 30},
            {1, 68},
            {15, 76},
            {22, 88},
            {64, 94},
            {43, 51},
            {22, 29},
            {10, 76},
            {59, 78},
            {25, 28},
            {92, 94},
            {11, 52},
            {28, 78},
            {27, 90},
            {30, 71},
            {15, 30},
            {14, 78},
            {35, 68},
            {32, 91},
            {10, 46},
            {60, 79},
            {11, 58},
            {0, 16},

    };
    int A=96;
        public int solve() {

            int []visited=new int[A+1];
            Arrays.fill(visited,0);
            ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=A;i++)
                list.add(new ArrayList<Integer>());
            int result=1;
            for(int [] array:B)
            {
                list.get(array[0]).add(array[1]);
                list.get(array[1]).add(array[0]);
            }
            System.out.println(list);
            Queue<Integer> queue=new LinkedList<Integer>();
            for(int i=0;i<=A;i++)
            {
                if(visited[i]!=0)
                    continue;
            queue.offer(i);
            visited[i]=1;
            while(!queue.isEmpty())
            {
                Integer ele=queue.poll();

                for(Integer subs:list.get(ele))
                {
                    if(visited[subs]!=0 )
                    {
                        if(visited[ele]==visited[subs] )
                        {
                            result=0;
                            System.out.println("Reached");
                            queue.clear();
                        }
                    }
                    else {
                       if(visited[ele]==1)
                           visited[subs]=2;
                       else
                           visited[subs]=1;
                        queue.offer(subs);
                        System.out.println( ele +"  "+ subs);

                    }
                }
            }}
            return result;

        }
    }



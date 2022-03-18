package GraphProblems.level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Level {

    static int A = 3;

    static ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2));
    static ArrayList<Integer> C = new ArrayList<>(Arrays.asList(3,1));
    static ArrayList<Integer> D = new ArrayList<>(Arrays.asList(7, 15,27));
    static ArrayList<Integer> E = new ArrayList<>(Arrays.asList(1, 10,11));
    static ArrayList<Integer> F = new ArrayList<>(Arrays.asList(29,6,26));
    public static void main(String args[])
    {
    for(Integer ele: solve())
        System.out.println(ele);
    }
        public static ArrayList<Integer> solve() {
            ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<PairLevel>> levelList=new ArrayList<ArrayList<PairLevel>>();
            ArrayList<Integer> ans=new ArrayList<Integer>();

            int visited[]=new int[A+1];
            int level[]=new int[A+1];
            Arrays.fill(level,-1);
            for(int i=0;i<=A;i++)
            {
                list.add(new ArrayList<Integer>());
                levelList.add(new ArrayList<PairLevel>());
            }
            for(int i=0;i<B.size();i++)
            {
                list.get(B.get(i)).add(C.get(i));
                list.get(C.get(i)).add(B.get(i));
            }
            Queue<Integer> queue=new LinkedList<Integer>();
            queue.offer(1);
            level[1]=0;
            levelList.get(0).add(new PairLevel(1,D.get(0)));

            while(!queue.isEmpty())
            {
                int ele=queue.poll();
                visited[ele]=1;
                for(Integer child:list.get(ele))
                {
                    if(visited[child]!=1)
                    {
                        levelList.get(level[ele]+1).add(new PairLevel(child,D.get(child-1)));
                        if(level[child]==-1)
                        level[child]=level[ele]+1;
                        queue.offer(child);
                    }
                }
            }
            Arrays.sort(level);
            int maxDepth=level[level.length-1];
            int max;
            for(int i=0;i<E.size();i++)
            {
                int currentLevel=E.get(i)%(maxDepth+1);
                int comparator=F.get(i);
                max=Integer.MAX_VALUE;

                for(PairLevel ele:levelList.get(currentLevel))
                {
                    if(ele.weight>comparator )
                    {
                        max=ele.weight;
                    }
                }
                    if (max == Integer.MAX_VALUE)
                        ans.add(-1);
                    else
                    ans.add(max);

            }
            return ans;
        }
    }
    class PairLevel {
        int ele;
        int weight;
        public PairLevel(int ele,int weight)
        {
            this.ele=ele;
            this.weight=weight;
        }
    }


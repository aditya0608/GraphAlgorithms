package BFS;

import Caching.CachingQuestion;
import DFS.DFSRunner;
import DijksrasAlgorithm.DijkstraRunner;
import GraphProblems.*;

import java.util.*;

public class GraphRunner {

    public static int[] visited=new int[20];
    public static ArrayList<ArrayList<Pair>> createArrayList()
    {
        ArrayList<ArrayList<Pair>> nodeList=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<20;i++)
            nodeList.add(new ArrayList<Pair>());
        nodeList.get(1).add(new Pair(1,2));
        nodeList.get(1).add(new Pair(1,5));
        nodeList.get(1).add(new Pair(1,10));

        nodeList.get(2).add(new Pair(2,1));
        nodeList.get(2).add(new Pair(2,6));

        nodeList.get(3).add(new Pair(3,5));

        nodeList.get(5).add(new Pair(5,1));
        nodeList.get(5).add(new Pair(5,3));

        nodeList.get(6).add(new Pair(6,2));

        nodeList.get(10).add(new Pair(10,1));
        return nodeList;
    }
    public static ArrayList<ArrayList<Pair>> createArrayListForDijkstra()
    {
        ArrayList<ArrayList<Pair>> nodeList=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<14;i++)
            nodeList.add(new ArrayList<Pair>());
        nodeList.get(2).add(new Pair(2,3));
        nodeList.get(2).add(new Pair(1,8));

        nodeList.get(3).add(new Pair(9,4));
        nodeList.get(3).add(new Pair(6,6));
        nodeList.get(3).add(new Pair(2,2));


        nodeList.get(4).add(new Pair(2,6));
        nodeList.get(4).add(new Pair(9,3));
        nodeList.get(4).add(new Pair(3,10));

        nodeList.get(6).add(new Pair(6,3));
        nodeList.get(6).add(new Pair(2,4));
        nodeList.get(6).add(new Pair(8,8));
        nodeList.get(6).add(new Pair(5,10));

        nodeList.get(8).add(new Pair(1,2));
        nodeList.get(8).add(new Pair(11,9));
        nodeList.get(8).add(new Pair(2,10));
        nodeList.get(8).add(new Pair(8,6));

        nodeList.get(9).add(new Pair(11,8));
        nodeList.get(9).add(new Pair(8,10));

        nodeList.get(10).add(new Pair(8,9));
        nodeList.get(10).add(new Pair(2,8));
        nodeList.get(10).add(new Pair(5,6));
        nodeList.get(10).add(new Pair(3,4));













        return nodeList;
    }
    public static void main(String args[])
    {


        //printGraph(createArrayList());
        //DFSRunner.printDFS(createArrayList(),1);
        //DijkstraRunner.printDijkstra(createArrayListForDijkstra(),2);
        //new CirclesandPath().solve();
        //System.out.println( new CheckBipartite().solve());
        int A[][]={
                {0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1},
        };
        int B[]={14,7};
        int C[]={14,6};
        //System.out.println(new ShortestPathInAMaze().solve(A,B,C));
        //System.out.println(new CachingQuestion(2));
        //new TopologicalSort().solve();
        //System.out.println(new City().solve());
        //System.out.println(new InstituteIBA().solve());
        //System.out.println(new EdgeMst().solve());
        System.out.println(new Black().black());
    }
    public static void printGraph(ArrayList<ArrayList<Pair>> nodeList)
    {
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(nodeList.get(1).get(0).a);
        System.out.println(queue.peek());
        while(!queue.isEmpty())
        {
            Integer temp=queue.poll();
            visited[temp]=1;
            for(Pair pair:nodeList.get(temp))
            {
                if(visited[pair.b]==0)
                {
                    queue.offer(pair.b);
                    visited[pair.b]=1;
                    System.out.println(pair.b);
                }
            }
        }

    }


}




package DijksrasAlgorithm;

import BFS.Pair;

import java.util.*;

public class DijkstraRunner {

    public static int visited[]=new int[11];
    public static int distance[]=new int[11];

    public static void printDijkstra(ArrayList<ArrayList<Pair>> nodeList,int source)
    {
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source]=0;
        Queue<Pair> queue=new PriorityQueue<Pair>(new CustomComparator());
        queue.offer(new Pair(0,source));

        while(!queue.isEmpty())
        {
            Pair temp= queue.poll();
            int u=temp.b;
            if(visited[u]==1)
                continue;
            visited[u]=1;
            for(Pair pair:nodeList.get(u)) {
                int v = pair.a;
                int w = pair.b;
                if (v+distance[u]<distance[w]) {
                    distance[w]=v+distance[u];
                    queue.offer(new Pair(distance[w],w ));
                }
            }
        }
        for(Integer i:distance)
            System.out.println(i);

    }
}
class CustomComparator implements Comparator<Pair>
{

    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.a-o2.b;
    }
}

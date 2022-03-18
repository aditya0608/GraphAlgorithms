package DFS;

import java.util.ArrayList;
import BFS.Pair;

public class DFSRunner {

public static int visited[]=new int[20];
    public static void printDFS(ArrayList<ArrayList<Pair>> nodeList,int source)
    {
visited[source]=1;
        System.out.println(source);
        for(Pair pair:nodeList.get(source)) {
            if (visited[pair.b] == 0) {
                printDFS(nodeList, pair.b);
            }
        }
    }
}

package GraphProblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSort {
int A=6;
int finalANS[]={};
int B[][]={
        {6, 3},
    {6, 1},
        {5, 1},
            {5, 2},
                {3, 4},
                    {4, 2}
};
        public int[] solve() {

            int degreeCount[]=new int[A+1];
            int sortedArray[]=new int[A+1];
            for(int [] array:B)
            {
                degreeCount[array[1]]+=1;
            }

            Queue<Node> queue=new PriorityQueue<Node>(new CustomComparator());
            for(int i=1;i<degreeCount.length;i++)
            {
                if(degreeCount[i]==0)
                    queue.offer(new Node(i));
            }

            int k=0;
            while(!queue.isEmpty())
            {
                Node temp=queue.poll();
                sortedArray[k]=temp.label;
                k++;
                for(int array[]:B)
                {
                    if(array[0]==temp.label)
                    {
                        degreeCount[array[1]]-=1;
                        if(degreeCount[array[1]]==0)
                            queue.offer(new Node(array[1]));
                    }
                }
            }
for(int ele:degreeCount) {
    if (ele > 0)
        return finalANS;
}
            return sortedArray;

        }
    }
    class Node{
        int label;
        public Node(int label)
        {
            this.label=label;
        }
    }
    class CustomComparator implements Comparator<Node>
    {
        @Override
        public int compare(Node node1,Node node2)
        {
            return node1.label-node2.label;
        }
    }



package GraphProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Black {

    ArrayList<String> A=new ArrayList<String>()

    {
        {
            add("XXX");
            add("XXX");
            add("XXX");
        }
    };
    ArrayList<ArrayList<Integer>> B=new ArrayList<ArrayList<Integer>>()

    {
        {
            add(new ArrayList<Integer>(){
                {
                    add (2);
                    add(4);
                }
                });
            add(new ArrayList<Integer>(){{
                add (2);
                add(6);
            }});

        }
    };

        int sizex=0;
        int sizeY=0;
        int k=0;
        int j=0;
        public int black() {
            B.get(0).set(0,1);
            System.out.println("--->" +""+B.get(0).get(0));
            sizex=A.size();
            sizeY=A.get(0).length();
            int visited[][]=new int[A.size()][A.get(0).length()];
            int dirs[][]={{0,1},{-1,0},{1,0},{0,-1}};
            Queue<PairBlack> queue=new LinkedList<PairBlack>();
            Queue<PairBlack> queueInside=new LinkedList<PairBlack>();
            for(String list:A)
            {

                for(int i=0;i<list.length();i++)
                {
                    if(list.charAt(i)=='X')
                        queue.offer(new PairBlack(j,i));
                }
                j++;
            }

            while(!queue.isEmpty())
            {
                PairBlack temp=queue.poll();
                if(visited[temp.x][temp.y]==1)
                    continue;
                queueInside.offer(new PairBlack(temp.x,temp.y));
                while(!queueInside.isEmpty())
                {
                    PairBlack tempInside=queueInside.poll();
                    visited[tempInside.x][tempInside.y]=1;
                    for(int dir[]:dirs)
                    {
                        int newX=dir[0]+tempInside.x;
                        int newY=dir[1]+tempInside.y;

                        if(isValid(newX,newY))
                        {
                            if( visited[newX][newY]==0 && A.get(newX).charAt(newY)=='X')
                            {
                                visited[newX][newY]=1;
                                queueInside.offer(new PairBlack(newX,newY));
                            }
                        }

                    }
                }
                k++;
            }
            return k;

        }
        public boolean isValid(int x,int y)
        {
            if(x<0 || x>=sizex || y<0 || y>=sizeY)
                return false;
            return true;
        }
    }
    class PairBlack{
        int x;
        int y;
        public PairBlack(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }


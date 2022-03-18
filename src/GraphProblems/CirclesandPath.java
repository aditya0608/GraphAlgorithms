package GraphProblems;

import java.util.Scanner;

public class CirclesandPath {

    public  int A=7;
    public  int B=91;
    public  int R=7;
    public  int X[]={1, 7, 1, 7, 1, 5, 1, 6};
    public  int Y[]={25, 4, 74, 14, 90, 58, 37, 4};
    public  int visited[][]=new int[A+1][B+1];
    static String result="NO";

    public  String solve() {

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                if(checkIfInside(i, j))
                {
                    visited[i][j] = 0;
                }
                else
                    visited[i][j]=1;
            }
        }
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                System.out.print(visited[i][j] +"  ");
            }
            System.out.println();}
        String result=travelPath(visited,0,0);
        System.out.println(result);
        return result;
    }

    private  String travelPath(int[][] visited, int sourceX,int sourceY) {
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        if(sourceX==A && sourceY==B && visited[sourceX ][sourceY ]==1)
            return "YES";
                if(visited[sourceX][sourceY]==1)
                {
                for (int[] dir : dirs) {
                    if (isValid(sourceX + dir[0], sourceY + dir[1])) {
                        if (visited[sourceX + dir[0]][sourceY + dir[1]] == 0)
                            continue;
                        visited[sourceX][sourceY]=0;

                        travelPath(visited, sourceX + dir[0], sourceY + dir[1]);
                    }   }
        }


return "NO";
    }

    private  boolean isValid(int i, int i1) {

        if(i<0 || i1<0 || i>A || i1>B)
            return false;
        return true;
    }

    private  boolean checkIfInside(int i, int j) {

        for(int k=0;k<X.length;k++)
        {
            double distance=Math.sqrt(Math.pow(X[k]-i,2)+Math.pow(Y[k]-j,2));
            System.out.println("distance "+(distance));
            if (distance<=R)
                return true;
        }
        return false;
    }


}

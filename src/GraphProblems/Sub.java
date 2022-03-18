package GraphProblems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Sub {
    static int length=0;
    static int max=-1;
    static int A[]={5,4,2,6,3,5};
    static Set<ArrayList<Integer>> set=new HashSet<ArrayList <Integer>>();
    static  ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> array=new ArrayList<Integer>();
    public static void main(String args[])
    {
        sub(0,array);

        System.out.println(max);
    }

    public static void sub(int k,ArrayList<Integer> array)
    {

        int length=0;
        if(k==A.length) {
            Set<Integer> set=new HashSet<>();
            for(int i=0;i< array.size()-1;i++) {
                if (checkPrime(array.get(i))) {
                    if (array.get(i+1 ) % array.get(i) == 0) {
                        //System.out.print(array.get(i) + " " + array.get(i + 1)+" "+   " ");
                        set.add(array.get(i) );
                        set.add(array.get(i+1) );
                    }
                } else {
                    int ele = array.get(i + 1);
                    if (checkPrime(ele) && ele % array.get(i) == 0) {
                        //System.out.print(array.get(i) + " " + array.get(i + 1)+" "+    " ");
                        set.add(array.get(i) );
                        set.add(array.get(i+1) );
                    }
                }
            }
            //System.out.println(set.size());
            if(set.size()>max)
                max=set.size();
           // System.out.println();
return;
        }
            array.add(A[k]);
        sub(k+1,array);
        if(!array.isEmpty())
        array.remove(array.size()-1);
        sub(k+1,array);

    }

    private static boolean check(int ele) {
        if(checkPrime(ele))
        {
         return true;
        }

        return false;
    }

    private static boolean checkPrime(int ele) {

        for(int i=2;i<ele;i++)
        {
            if(ele%i==0)
                return false;
        }
        return true;
    }
}

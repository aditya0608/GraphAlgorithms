package Caching;

import java.util.LinkedList;
import java.util.Queue;

public class CachingQuestion {


        Queue<Pair> queue;
        Queue<Pair> usage;
        int capacityG;
        public CachingQuestion(int capacity) {
            capacityG=capacity;
            queue=new LinkedList<Pair>();
            usage=new LinkedList<Pair>();
        }
        public int get(int key) {
            for(Pair p:queue)
            {
                if(p.key==key)
                {
                    usage.offer(new Pair(p.key,p.value));
                    return p.value;
                }
            }
            return -1;

        }

        public void set(int key, int value) {

            if(queue.size()<capacityG)
                queue.offer(new Pair(key,value));
            int toBe=-1;
            if(null!=usage)
            {
                for(Pair pair:usage)
                {
                    for(Pair search:queue)
                    {
                        if(pair.key==search.key && pair.value==search.value)
                        {
                            usage.remove(pair.key);
                            toBe=pair.key;
                        }
                    }
                    queue.offer(new Pair(toBe,value));

                }
            }
            else
            {
                queue.remove();
                queue.offer(new Pair(key,value));
            }



        }
    }
    class Pair
    {
        int key;
        int value;
        public Pair(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }


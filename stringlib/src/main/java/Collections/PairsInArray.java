package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by AiYeSus on 11/29/2017.
 * Find pairs that add up to target in array
 */

public class PairsInArray {

    long t0, tCM;
    Map<Integer, Integer> pairMap = new HashMap<>();

    public void useList(int[] iarr, int target) {
        // Put iarr in list of integer
        pairMap.clear();
        tCM = System.currentTimeMillis();
        t0 = System.nanoTime();
        List<Integer> iaList = new ArrayList<Integer>();
        for(int i : iarr ) {
            if ( i <= target ) iaList.add(i);
        }
        // find all possible complements
        Iterator itr = iaList.iterator();
        int k;
        for( int i : iaList ) {
            if ( !pairMap.containsKey(i) && !pairMap.containsValue(i) && iaList.contains(target-i) ) {
                System.out.println(i + ", " + (target-i));
                pairMap.put(i, target-i);
            }
        }
        System.out.println("Time spent : "+(System.nanoTime() - t0)+
                "\n# of pais :"+pairMap.size()+"\ncurrentTimeMillis : "+(System.currentTimeMillis() - tCM));
    }

    public void useListAndSet(int[] iarr, int target) {
        Map<Integer, Integer> iMap = new HashMap<Integer, Integer>();
        // Put iarr in list of integer
        List<Integer> iaList = new ArrayList<Integer>();
        for(int i : iarr ) {
            iaList.add(i);
        }
        // find all possible complements
        for(int i=0; i<=(target/2); i++) {
            if ( iaList.contains(i) && iaList.contains(target-i) ) {
                iMap.put(i, target-i);
            }
        }
        Set<Integer> iSet = iMap.keySet();
        int k;
        Iterator itr = iSet.iterator();
        while( itr.hasNext() ) {
            k = (int)itr.next();
            //        System.out.println(k + ", " + iMap.get(k));
        }
        StringBuilder sbListAndMap = new StringBuilder("sbListAndMap Time : "+(System.nanoTime() - t0));
        tCM = tCM-System.currentTimeMillis();
        System.out.println(sbListAndMap.toString()+"\n--------\n"+tCM);

    }

    public void loopThru(int[] iarr, int target) {
        pairMap.clear();
        t0 = System.nanoTime();
        tCM=System.currentTimeMillis();
        for(int i=0; i<iarr.length; i++)
            for(int j=i; j<iarr.length; j++) {
                if ( (iarr[i] + iarr[j] == target ) ) {
                    System.out.println(iarr[i]+", "+iarr[j]);
                    pairMap.put(iarr[i], iarr[j]);
                }
            }
        System.out.println("Time spent : "+(System.nanoTime() - t0)+"\n# of pais :"+pairMap.size()+
                "\ncurrentTimeMillis :"+(System.currentTimeMillis() - tCM));
    }

    public static void main(String[] args) {
 //       int[] iarr = {1, 2, 3, 5, 7, 8, 4, 0, 6};
        Random rnd = new Random();
        int target = 379, sz=1000;

        int[] iarr = new int[sz];
        for(int k=0; k<sz; k++) {
            iarr[k] = Math.abs(rnd.nextInt() % sz);
        }

        PairsInArray findPairs = new PairsInArray();
        findPairs.useList(iarr, target);
        findPairs.loopThru(iarr, target);
    }
}

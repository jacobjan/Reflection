package com.example;

/**
 * Created by AiYeSus on 12/6/2017.
 */

import java.io.*;
import java.util.*;

public class HackerXDefence {

    static int[][] incM;
    static Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

    public static int findClosetFreq(int incMFreqIdx) {
// build list of (freq - incM[incMFreqIdx][1]) from beginning to 'incMFreqIdx'
        //
        List<Integer> freqRange = new ArrayList<>();
        int freqDiff=0, targetFreq = incM[incMFreqIdx][1] ;
        for ( int i=0; i<incMFreqIdx; i++ ) {
            freqDiff = Math.abs(targetFreq - incM[i][1]);
            if ( freqDiff == 0 ) return 0;
            freqRange.add(freqDiff);
        }
        Collections.sort(freqRange);
//        System.out.println("FreqS :"+freqRange);

        return freqRange.get(0);
    }

    public static InputStream ReadFile2InputStream(String path) throws FileNotFoundException {
       // String json_file = "C:\\Jihshin\\AndroidStudio\\Reflection\\stringlib\\src\\main\\java\\GSON\\mmap.json";
         //   BufferedReader br = new BufferedReader(new FileReader(path));
        return new FileInputStream( path );
    }

    public static void main(String[] args) throws FileNotFoundException {

        String infile = "C:\\Jihshin\\AndroidStudio\\Reflection\\stringlib\\src\\main\\java\\com\\example\\test1.txt";
        Scanner in = new Scanner( ReadFile2InputStream( infile ));     //(System.in);
        int nMSL = in.nextInt();
        int nMneeded = 1, iIncoming=0, timeUnitNeeded=0, shortestFreq=0;
        incM = new int[nMSL][2];
        for(int iMissile=0; iMissile<nMSL; iMissile++) {
            incM[iMissile][0] = in.nextInt();
            incM[iMissile][1] = in.nextInt();
            freqMap.put(incM[iMissile][1], 0);
        }
        while(iIncoming <= nMSL-2) {
            timeUnitNeeded = incM[iIncoming+1][0] - incM[iIncoming][0];
            shortestFreq=findClosetFreq(iIncoming+1);
            if( timeUnitNeeded==0 || shortestFreq > timeUnitNeeded ) {
                System.out.println("Need another missile, cloestFreq:"+shortestFreq+" time unit needed:"+timeUnitNeeded );
                nMneeded++;
            }
            iIncoming++;
        }
        System.out.println(nMneeded);
    }
}
/**
 4
 1 1
 2 2
 3 1
 5 1  Need 1 ( missile to defend incoming missiles )
 ----------
 4
 1 1
 2 3
 3 1
 5 1  Need 2 ( missiles to defend incoming missiles )
 ----

*/
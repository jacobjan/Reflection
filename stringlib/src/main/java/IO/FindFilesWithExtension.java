package IO;

import java.io.File;
import java.io.IOException;

/**
 * Created by AiYeSus on 12/7/2017.
 */

public class FindFilesWithExtension {

    public static void walkdir(File dir) throws IOException {
        String fileExt = ".pdf";
        File[] listFile = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    walkdir(listFile[i]);
                } else {
                    if (listFile[i].getName().endsWith(fileExt)){
                        System.out.println("File exist : " + listFile[i].getCanonicalPath());
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        final String folder = "C:\\bin\\man";
        File dir = new File(folder);
        walkdir( dir );
    }
}

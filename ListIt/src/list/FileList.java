/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author em.es
 */
public class FileList {

    static File dir = new File("C:\\Users\\Dave\\Documents\\List It");

//    static {
//        dir.mkdirs();
//    }
    public static String[] getList() {
        return list();
    }

    static String[] list() {
        FilenameFilter filter = (File dir1, String name) -> name.contains(".txt");
        String[] names = dir.list(filter);
        Arrays.sort(names,
                (String s1,String s2)->{
            long a = new File(dir + "\\" + s1).lastModified();
            long b = new File(dir + "\\" + s2).lastModified();
            return Long.compare(a, b) * -1;
        });
//        for (String name : names) {
//            System.out.println(name);
//        }
        strip(names);
        return names;
    }

    static void strip(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].substring(0, names[i].indexOf("."));
        }
    }

    
}

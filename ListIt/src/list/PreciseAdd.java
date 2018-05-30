/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.List;

/**
 *
 * @author em.es
 */
public class PreciseAdd {

    private final List<String> list;
    private final String item;

    public PreciseAdd(List<String> list, String item) {
        this.list = list;
        this.item = item;
        list.add(place(), item);
    }

    private int place() {
        int a = -1, z = list.size();

//        split list
        while (true) {
            int index = a + (z - a) / 2;

//            compare words
            int test = item.compareToIgnoreCase(list.get(index));

            if (test < 0) {
                z = index;
            } else if (test > 0) {
                a = index;
            } else {
                return index;
            }
            if (z - a == 1) {
                return z;
            }

        }
    }
}

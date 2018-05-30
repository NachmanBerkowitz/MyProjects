/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.ArrayList;

/**
 *
 * @author em.es
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testPreciseAdd();
    }

    public static void testPreciseAdd() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 65; i < 85; i++) {
            list.add(Character.toString((char)i));
        }
//        list.add("a");
        list.remove("H");
//        list.add("d");
        print(list);
        System.out.println("");
        new PreciseAdd(list, "A");
        System.out.println();
        print(list);
    }

    public static void print(ArrayList<String> list) {
        list.forEach((string) -> {
            System.out.println(string);
        });
    }
}

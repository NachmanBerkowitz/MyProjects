/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author em.es
 */
public class Writer {

    private final String dir = "C:\\Users\\Dave\\Documents\\List It";
    private final String item;
    private final String fileName;
    private final File file;
    private ArrayList<String> list = new ArrayList<>();

    private static final Logger LOGGER = Logger.getLogger(Writer.class.getName());

    public Writer(String fileName, String item) {
        this.item = item;
        this.fileName = fileName;
        file = new File(dir + File.separatorChar + fileName + ".txt");

        get();

        if (list.size() > 0) {
            new PreciseAdd(list, item);
        } else {
            list.add(item);
        }

        addNumber();
        write();
    }

    private void write() {
        try (PrintWriter fos = new PrintWriter(new BufferedWriter(new FileWriter((file), true)))) {
            PrintWriter fos2 = new PrintWriter(new BufferedWriter(new FileWriter((file), false)));
            fos2.print("");
            list.forEach((string) -> {
                fos.println(string);
            });
            LOGGER.log(Level.INFO, "''{0}'' was added to list {1}.", new Object[]{item, fileName});
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }

    private void get() {
        try (BufferedReader fis = new BufferedReader(new FileReader(file))) {
            while (fis.ready()) {
//                System.out.println(line);
                list.add(fis.readLine());
            }
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        removeNumber();
    }

    /**
     * removes item number
     */
    private void removeNumber() {
        for (int i = 0; i < list.size(); i++) {

            if ((int) ((list.get(i).charAt(0) - 48) / 10.0 + 1) == 1) {

                char[] digits2 = new char[list.get(i).length()];
                int j = 0;

                while ((int) ((list.get(i).charAt(j) - 48) / 10.0 + 1) == 1) {
                    digits2[j] = list.get(i).charAt(j++);
                }

                String number = String.valueOf(digits2, 0, j) + ". ";
//                System.out.println(number);

                if (list.get(i).startsWith(number)) {
                    list.set(i, list.get(i).replaceFirst(number, ""));
                }
            }
        }
    }

    /**
     * adds item number
     */
    private void addNumber() {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, (i + 1) + ". " + list.get(i));
        }
    }
}

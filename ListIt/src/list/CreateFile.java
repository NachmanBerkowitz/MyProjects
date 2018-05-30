/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author em.es
 */
public class CreateFile {

    private String fileName;
    private final String dir = "C:\\Users\\Dave\\Documents\\List It";
    private static final Logger LOGGER = Logger.getLogger(CreateFile.class.getName());

    public boolean created;

    public CreateFile(String fileName) {
        this.fileName = fileName;

        File file = new File(dir + File.separatorChar + fileName + ".txt");
        try {
            created = file.createNewFile();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

}

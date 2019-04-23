/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentsInfo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thebender
 */
public class ComponentReader {
    
    public static void readGPUs() throws IOException {
        File file = new File ("DataBases/GPUS.txt");
        
        Scanner sc = new Scanner(file).useDelimiter("[$]");
        
        StringTokenizer st = new StringTokenizer(sc.next(), ";");
        
        //System.out.println(sc.next());
    }
    
    public static void main(String argv[]) {
        try {
            ComponentReader.readGPUs();
        } catch (IOException ex) {
            Logger.getLogger(ComponentReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

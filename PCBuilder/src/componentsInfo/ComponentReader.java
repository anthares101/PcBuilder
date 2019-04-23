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
    
    public static GPU[] readGPUs() throws IOException {
        
        GPU[] array = new GPU[5];
        int i = 0;
        
        File file = new File ("DataBases/GPUS.txt");
        
        Scanner sc = new Scanner(file).useDelimiter("[$]");
        
        while(sc.hasNext()) {
            StringTokenizer st = new StringTokenizer(sc.next(), ";");
            GPU gpu = new GPU();

            gpu.setName(st.nextToken());
            gpu.setPrize(Double.parseDouble(st.nextToken()));
            gpu.setHeight(Double.parseDouble(st.nextToken()));
            gpu.setWeight(Double.parseDouble(st.nextToken()));
            //gpu.setLongitude(Double.parseDouble(st.nextToken())); <-- falta
            gpu.setRecommendedPSU(Integer.parseInt(st.nextToken()));
            gpu.setDescription(st.nextToken());
            
            array[i] = gpu;
            i++;
        }
        
        return array;
    }
    
}

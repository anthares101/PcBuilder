/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentsInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author thebender
 */
public class ComponentReader {
    
    public static ArrayList<PcBox> readPcBox() throws FileNotFoundException {
        
        ArrayList<PcBox> array = new ArrayList();
        
        File file = new File ("DataBases/PCBoxes.txt");
        
        Scanner sc = new Scanner(file).useDelimiter("[$]");
        
        while(sc.hasNext()) {
            StringTokenizer st = new StringTokenizer(sc.next(), ";");
            PcBox box = new PcBox();
            
            box.setName(st.nextToken());
            box.setPrize(Double.parseDouble(st.nextToken()));
            
            //lectura de los factores forma
            StringTokenizer aux = new StringTokenizer(st.nextToken(), ",");
            ArrayList<String> factorForms = new ArrayList();
            while(aux.hasMoreTokens()) {
                factorForms.add(aux.nextToken());
            }
            box.setFormFactors(factorForms);
            
            box.setHeight(Double.parseDouble(st.nextToken()));
            box.setWeight(Double.parseDouble(st.nextToken()));
            box.setLongitude(Double.parseDouble(st.nextToken()));
            box.setMaxGPU(Double.parseDouble(st.nextToken()));
            box.setDescription(st.nextToken());
            
            array.add(box);
        }
        
        return array;
    }
    
    public static ArrayList<Motherboard> readMotherboards() throws FileNotFoundException {
        
        ArrayList<Motherboard> array = new ArrayList();
        
        File file = new File ("DataBases/Motherboards.txt");
        
        Scanner sc = new Scanner(file).useDelimiter("[$]");
        
        while(sc.hasNext()) {
            StringTokenizer st = new StringTokenizer(sc.next(), ";");
            Motherboard mb = new Motherboard();
            
            mb.setName(st.nextToken());
            mb.setPrize(Double.parseDouble(st.nextToken()));
            mb.setFormFactor(st.nextToken());
            mb.setSocket(st.nextToken());
            mb.setRamCompatibility(Integer.parseInt(st.nextToken()));
            mb.setDescription(st.nextToken());
            
            array.add(mb);
        }
        
        return array;
    }
    
    public static ArrayList<CPU> readCPUs() throws FileNotFoundException {
        
        ArrayList<CPU> array = new ArrayList();
        
        File file = new File ("DataBases/CPUs.txt");
        
        Scanner sc = new Scanner(file).useDelimiter("[$]");
        
        while(sc.hasNext()) {
            StringTokenizer st = new StringTokenizer(sc.next(), ";");
            CPU cpu = new CPU();
            
            cpu.setName(st.nextToken());
            cpu.setPrize(Double.parseDouble(st.nextToken()));
            cpu.setSocket(st.nextToken());
            cpu.setDescription(st.nextToken());
            
            array.add(cpu);
        }
        
        return array;
    }
        
    public static ArrayList<GPU> readGPUs() throws FileNotFoundException {
        
        ArrayList<GPU> array = new ArrayList();
        
        File file = new File ("DataBases/GPUS.txt");
        
        Scanner sc = new Scanner(file).useDelimiter("[$]");
        
        while(sc.hasNext()) {
            StringTokenizer st = new StringTokenizer(sc.next(), ";");
            GPU gpu = new GPU();

            gpu.setName(st.nextToken());
            gpu.setPrize(Double.parseDouble(st.nextToken()));
            gpu.setWidth(Double.parseDouble(st.nextToken()));
            gpu.setLongitude(Double.parseDouble(st.nextToken()));
            gpu.setRecommendedPSU(Integer.parseInt(st.nextToken()));
            gpu.setDescription(st.nextToken());
            
            array.add(gpu);
        }
        
        return array;
    }
}

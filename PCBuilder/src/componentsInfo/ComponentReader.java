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
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author thebender
 */
public class ComponentReader {
    
    public static ArrayList<PcBox> readPcBox() throws FileNotFoundException {
        
        ArrayList<PcBox> array = new ArrayList();
        
        File file = new File ("DataBases/PCBoxes.txt");
        
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);

        while(sc.hasNext()) {
            
            String token = sc.next();
            
            if(!StringUtils.isBlank(token)) {
                
                StringTokenizer st = new StringTokenizer(token, ";");
                PcBox box = new PcBox();

                box.setName(st.nextToken());
                box.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    box.setRecomended(true);
                }
                else {
                    box.setRecomended(false);
                }

                //lectura de los factores forma
                StringTokenizer aux = new StringTokenizer(st.nextToken(), ",");
                ArrayList<String> factorForms = new ArrayList();
                while(aux.hasMoreTokens()) {
                    factorForms.add(aux.nextToken());
                }
                box.setFormFactors(factorForms);

                box.setHeight(Double.parseDouble(st.nextToken()));
                box.setWidth(Double.parseDouble(st.nextToken()));
                box.setLongitude(Double.parseDouble(st.nextToken()));
                box.setMaxGPU(Double.parseDouble(st.nextToken()));
                box.setDescription(st.nextToken());

                array.add(box);
            }
        }
        
        sc.close();
        
        return array;
    }
    
    public static ArrayList<Motherboard> readMotherboards() throws FileNotFoundException {
        
        ArrayList<Motherboard> array = new ArrayList();
        
        File file = new File ("DataBases/Motherboards.txt");
        
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);

        while(sc.hasNext()) {
            String token = sc.next();
            
            if(!StringUtils.isBlank(token)) {
                StringTokenizer st = new StringTokenizer(token, ";");
                Motherboard mb = new Motherboard();

                mb.setName(st.nextToken());
                mb.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    mb.setRecomended(true);
                }
                else {
                    mb.setRecomended(false);
                }
                mb.setFormFactor(st.nextToken());
                mb.setSocket(st.nextToken());
                mb.setRamCompatibility(Integer.parseInt(st.nextToken()));
                mb.setDescription(st.nextToken());

                array.add(mb);
            }
        }
        
        sc.close();
        
        return array;
    }
    
    public static ArrayList<CPU> readCPUs() throws FileNotFoundException {
        
        ArrayList<CPU> array = new ArrayList();
        
        File file = new File ("DataBases/CPUs.txt");
        
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);
        
        while(sc.hasNext()) {
            
            String token = sc.next();
            
            if(!StringUtils.isBlank(token)) {
                StringTokenizer st = new StringTokenizer(token, ";");
                CPU cpu = new CPU();

                cpu.setName(st.nextToken());
                cpu.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    cpu.setRecomended(true);
                }
                else {
                    cpu.setRecomended(false);
                }
                cpu.setSocket(st.nextToken());
                cpu.setDescription(st.nextToken());

                array.add(cpu);
            }
        }
        
        sc.close();
        
        return array;
    }
        
    public static ArrayList<GPU> readGPUs() throws FileNotFoundException {

        ArrayList<GPU> array = new ArrayList();
        
        File file = new File ("DataBases/GPUs.txt");
       
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);
        
        while(sc.hasNext()) {
            String token = sc.next();
            
            if(!StringUtils.isBlank(token)) {
                StringTokenizer st = new StringTokenizer(token, ";");
                GPU gpu = new GPU();

                gpu.setName(st.nextToken());
                gpu.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    gpu.setRecomended(true);
                }
                else {
                    gpu.setRecomended(false);
                }
                gpu.setWidth(Double.parseDouble(st.nextToken()));
                gpu.setLongitude(Double.parseDouble(st.nextToken()));
                gpu.setRecommendedPSU(Integer.parseInt(st.nextToken()));
                gpu.setDescription(st.nextToken());

                array.add(gpu);
            }
        }
        
        sc.close();
        
        return array;
    }
    
    public static ArrayList<Cooler> readCoolers() throws FileNotFoundException {
        
        ArrayList<Cooler> array = new ArrayList();
        
        File file = new File ("DataBases/Coolers.txt");
        
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);

        while(sc.hasNext()) {
            
            String token = sc.next();
            
            if(!StringUtils.isBlank(token)) {
                StringTokenizer st = new StringTokenizer(token, ";");
                Cooler cooler = new Cooler();

                cooler.setName(st.nextToken());
                cooler.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    cooler.setRecomended(true);
                }
                else {
                    cooler.setRecomended(false);
                }

                //lectura de los sockets compatibles
                StringTokenizer aux = new StringTokenizer(st.nextToken(), ",");
                ArrayList<String> socketList = new ArrayList();
                while(aux.hasMoreTokens()) {
                    socketList.add(aux.nextToken());
                }
                cooler.setSockets(socketList);

                cooler.setHeight(Double.parseDouble(st.nextToken()));
                cooler.setDescription(st.nextToken());
                
                array.add(cooler);
            }
        }
        
        sc.close();
        
        return array;
    }
    
   public static ArrayList<RAM> readRAMs() throws FileNotFoundException {
        
        ArrayList<RAM> array = new ArrayList();
        
        File file = new File ("DataBases/RAMs.txt");
        
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);

        while(sc.hasNext()) {
            String token = sc.next();

            if(!StringUtils.isBlank(token)) {
                StringTokenizer st = new StringTokenizer(token, ";");
                RAM ram = new RAM();
                
                ram.setName(st.nextToken());
                ram.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    ram.setRecomended(true);
                }
                else {
                    ram.setRecomended(false);
                }
                ram.setType(Integer.parseInt(st.nextToken()));
                ram.setDescription(st.nextToken());
                
                array.add(ram);
            }
        }
        
        sc.close();
        
        return array;
    }
   
   public static ArrayList<HardDisk> readDisks() throws FileNotFoundException {
       
        ArrayList<HardDisk> array = new ArrayList();

        File file = new File ("DataBases/HardDisks.txt");
        
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);
        
        while(sc.hasNext()) {
            String token = sc.next();
            
            if(!StringUtils.isBlank(token)) {
                StringTokenizer st = new StringTokenizer(token, ";");
                HardDisk hd = new HardDisk();
                
                hd.setName(st.nextToken());
                hd.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    hd.setRecomended(true);
                }
                else {
                    hd.setRecomended(false);
                }
                
                hd.setDescription(st.nextToken());
                
                array.add(hd);
            }
        }       
       
        sc.close();
        
        return array;
    }
    
    public static ArrayList<PSU> readPSUs() throws FileNotFoundException {
        
        ArrayList<PSU> array = new ArrayList();
        
        File file = new File ("DataBases/PSUs.txt");
        
        Pattern pat = Pattern.compile("([$](\r?)\n)");
        Scanner sc = new Scanner(file).useDelimiter(pat);
        
        while(sc.hasNext()) {
            String token = sc.next();
            
            if(!StringUtils.isBlank(token)) {
                StringTokenizer st = new StringTokenizer(token, ";");
                PSU psu = new PSU();
                
                psu.setName(st.nextToken());
                psu.setPrize(Double.parseDouble(st.nextToken()));
                
                if(st.nextToken().equals("1")) {
                    psu.setRecomended(true);
                }
                else {
                    psu.setRecomended(false);
                }
                psu.setWatts(Integer.parseInt(st.nextToken()));
                psu.setDescription(st.nextToken());
                
                array.add(psu);
            }
        }
        
        sc.close();
        
        return array;
    }
}

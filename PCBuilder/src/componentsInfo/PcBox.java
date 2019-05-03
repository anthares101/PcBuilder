/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentsInfo;

import java.util.ArrayList;

/**
 *
 * @author anthares101
 */
public class PcBox extends PcComponent {
    
    private ArrayList<String> formFactors;
    private double height;
    private double width;
    private double longitude;
    private double maxGPU;
    
    public PcBox() {
        super();
        
        this.setHeight(0);
        this.setLongitude(0);
        this.setWidth(0);
        this.setMaxGPU(0);
    }

    public String getFormFactor(int index) {
        return this.formFactors.get(index);
    }
    
    public int getFormFactorListSize() {
        return this.formFactors.size();
    }
    
    public Boolean isFormFactorsEmpty(){
        return this.formFactors.isEmpty();
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getMaxGPU() {
        return this.maxGPU;
    }

    public void setFormFactors(ArrayList formFactors) {
        this.formFactors = formFactors;
    }
    
    public void addFormFactor(int index, String formFactor){
        this.formFactors.add(index, formFactor);
    }
    
    public void removeFormFactor(int index){
        this.formFactors.remove(index);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setMaxGPU(double maxGPU) {
        this.maxGPU = maxGPU;
    }
    
    public Boolean supportFormFactor(String formFactor){
        int i = 0;
        
        while(i < this.formFactors.size() &&!this.formFactors.get(i).equals(formFactor))
            i++;
        
        return i != this.formFactors.size();
    }
    
}

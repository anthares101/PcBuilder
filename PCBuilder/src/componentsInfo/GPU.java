/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentsInfo;

/**
 *
 * @author anthares101
 */
public class GPU extends PcComponent{
    
    private double height;
    private double longitude;
    private int recommendedPSU;
    
    public GPU() {
        super();
        
        this.setHeight(0);
        this.setLongitude(0);
        this.setRecommendedPSU(0);
    }
    
    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getRecommendedPSU() {
        return recommendedPSU;
    }
    private double weight;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRecommendedPSU(int recommendedPSU) {
        this.recommendedPSU = recommendedPSU;
    }
}

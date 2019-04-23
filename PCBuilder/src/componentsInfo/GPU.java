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
public class GPU extends PcComponent {
    
    private double longitude;
    private double weight;
    private int recommendedPSU;
    
    public GPU() {
        super();
        
        this.setLongitude(0);
        this.setWeight(0);
        this.setRecommendedPSU(0);
    }

    public double getWeight() {
        return this.weight;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getRecommendedPSU() {
        return this.recommendedPSU;
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

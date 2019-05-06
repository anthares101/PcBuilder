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
    
    private double width;
    private double longitude;
    private int recommendedPSU;
    
    public GPU() {
        super();
        
        this.setLongitude(0);
        this.setWidth(0);
        this.setRecommendedPSU(0);
    }

    public double getWidth() {
        return this.width;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getRecommendedPSU() {
        return this.recommendedPSU;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRecommendedPSU(int recommendedPSU) {
        this.recommendedPSU = recommendedPSU;
    }
    
}

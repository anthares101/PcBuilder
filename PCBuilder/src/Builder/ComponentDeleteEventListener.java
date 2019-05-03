/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author anthares101
 */
public interface ComponentDeleteEventListener {
    //Action performed when a PcComponent is deleted from builder, the argument represent the component type
    void onComponentDeleteEvent(int type);
}

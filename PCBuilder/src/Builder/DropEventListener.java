/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.util.ArrayList;

/**
 *
 * @author anthares101
 */
public interface DropEventListener {
    //Action performed when a drop event happen
    void onDropEvent(ArrayList<String> data);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prizm;

import java.util.TreeMap;

/**
 *
 * @author zoi
 */
public class ParaCalculator {
    private final TreeMap<Long, Long> elements = new TreeMap<>();
    
    public void add(long ID, long amount) {
        synchronized (elements) {
            if (elements.containsKey(ID)) {
                long box = elements.get(ID);
                elements.put(ID, box+amount);
            } else {
                elements.put(ID, amount);
            }
        }
    }
    
    public long get(long ID) {
        synchronized (elements) {
            if (!elements.containsKey(ID)) return 0l;
            return elements.remove(ID);
        }
    }
}

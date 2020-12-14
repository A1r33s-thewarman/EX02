/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author rkavi
 */

import java.util.Collection;
import java.util.HashMap;

public class NodeData implements node_data {
    private int pin; //pin with private access midiefier
    HashMap<Integer,node_data> hashmap;
    private String detail;
    private int tag;
    public static int count=0;

    public NodeData(int key) {
        this.hashmap = new HashMap<>();
        this.pin = key;
    }
    public NodeData(node_data n){
        this.pin=n.getKey();
        this.tag=n.getTag();
    }
    public NodeData(){
        this.pin=count++;
        this.hashmap = new HashMap<>();
    }

    public HashMap<Integer, node_data> getMap() {
        return hashmap;
    }

    //return pin id
    @Override
    public int getKey() {
        return this.pin;
    }

    //This method returns a list of all the Neighbor nodes of this node_data
    public Collection<node_data> getNi() {
        if (this.hashmap.values() != null) {
            return this.hashmap.values();
        }
        return null;
    }

    //Return true iff this<==>key is adjacent as a boundary between the keys.
    public boolean hasNi(int key) {
        return this.hashmap.containsKey(key);
    }

    //This method applies the node data(t) to the node data.
    public void addNi(node_data t) {
        if(this.getKey()!=t.getKey()){
            this.hashmap.put(t.getKey(),t);
        }
        this.hashmap.put(t.getKey(),t);
    }

    // remove edges
    public void removeNode(node_data node) {
        this.hashmap.remove(node.getKey());
    }

    //return information
    @Override
    public String getInfo() {
        return detail;
    }

    //make changes to information
    @Override
    public void setInfo(String s) {
        this.detail = s;
    }

    //store temp data
    @Override
    public int getTag() {
        return this.tag;
    }

    //allow to edit tag data
    @Override
    public void setTag(int t) {

        this.tag = t;
    }

    @Override
    public geo_location getLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocation(geo_location p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWeight(double w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
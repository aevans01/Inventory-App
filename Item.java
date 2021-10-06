/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EXAEVAN1
 */
public class Item {

    private int id;
    private String name;
    private String upc;
    private int numInStock;
    private int reorderAmount;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * @param upc the upc to set
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     * @return the numInStock
     */
    public int getNumInStock() {
        return numInStock;
    }

    /**
     * @param numInStock the numInStock to set
     */
    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

    /**
     * @return the reorderAmount
     */
    public int getReorderAmount() {
        return reorderAmount;
    }

    /**
     * @param reorderAmount the reorderAmount to set
     */
    public void setReorderAmount(int reorderAmount) {
        this.reorderAmount = reorderAmount;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Oshin
 */
public class Data {

    private Double limit;
     
     public Data(){
        this.limit=1000.0;
    }
    /**
     * @return the limit
     */
    public Double getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(Double limit) {
        this.limit = limit;
    }
 

}

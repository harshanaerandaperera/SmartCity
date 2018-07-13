/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import Controller.*;
import java.util.UUID;


/**
 * SensorMonitor class contain details of a Sensor Monitor SensorMonitor class
 * contain Sensor Station as an observer
 *
 * @author Oshin
 */
public class SensorMonitor implements Subject, Observer {

    private String sensorMonitorID;
    //interval is the frequency
    private Double interval;
    //isActive is status(active/not active)
    private boolean isActive;
    private Sensor sensor;
    private ArrayList<Observer> Observers;
    private ArrayList<Double> coords;

    private Data reading;

    SetOfTrafficSensors SOTS = SetOfTrafficSensors.getSetOfTrafficSensorsInstance();
    SetOfSensorMonitors SOSM = SetOfSensorMonitors.getSetOfSensorMonitorsInstance();
    SetOFData SOD = SetOFData.getSetOFDataInstance();
    SetOfEmbelishedData SOED = SetOfEmbelishedData.getSetOfEmbelishedDataInstance();
    SetOfBinSensors SOBS = SetOfBinSensors.getSetOfBinSensorsInstance();
    SetOfFloodSensors SOFS = SetOfFloodSensors.getSetOfFloodSensorsInstance();
    SetOfSensors SOS = SetOfSensors.getSetOfSensorsInstance();

    /**
     * Constructor for Sensor Monitor object with status , interval , Sensor
     * Type
     *
     * @param inInterval
     * @param inIsActive
     * @param inSensorType
     */
    public SensorMonitor(String inSensorID, Double inInterval, String inIsActive, String inSensorType) {
        this.sensorMonitorID = UUID.randomUUID().toString();

        this.interval = inInterval;
        if (inIsActive.equals("Active")) {
            this.isActive = true;
        } else {
            this.isActive = false;
        }

        if (inSensorType.equals("Bin Sensor")) {
            this.sensor = new BinSensor(inSensorID);
            SOBS.addBinSensor(new BinSensor(inSensorID));
            SOS.addSensor(sensor);
        } else if (inSensorType.equals("Flood Sensor")) {
            this.sensor = new FloodSensor(inSensorID);
            SOFS.addFloodSensor(new FloodSensor(inSensorID));
            SOS.addSensor(sensor);
        } else {
            this.sensor = new TrafficSensor(inSensorID);
            SOTS.addTrafficSensor(new TrafficSensor(inSensorID));
            SOS.addSensor(sensor);
        }
    }

    public void doTick(Observer observer) {

        System.out.println("take readings------------------------------------------------------------------------------------------------------------");
        shouldTakeReading(observer);
    }

    @Override
    public void registerObserver(Observer obs) {
        getObservers().add(obs);
    }

    @Override
    public void unRegisterObserver(Observer obs) {
        getObservers().remove(obs);
    }

    @Override
    public void Notify() {
    }

    @Override
    public void update(Object ob, Observer observer) {
        if (ob instanceof Clock) {

            this.doTick(observer);
        }
    }

    /**
     * @return the sensorMonitorID
     */
    public String getSensorMonitorID() {
        return sensorMonitorID;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    public void shouldTakeReading(Observer observer) {

        for (int i = 0; i < SOSM.size(); i++) {
            for (int j = 0; j < SOED.size(); j++) {
                if (SOSM.get(i) == observer) {
                    if (SOSM.get(i).getSensor().getSensorId().equals(SOED.get(j).getSensor().getSensorId())) {
                        SOED.get(j).setCount(SOSM.get(i).getSensor().getData());
                    }
                }
            }
        }
//   public EmbelishedData embellishData(Sensor senor){
//        long timeInMills = 10; 
//        ArrayList<Double> coords = getCoords();
//        String id = sensor.getSensorId();
//      //  EmbelishedData embellishedData = new EmbelishedData(reading, timeInMills, coords, id);
//       // return embellishedData;
//    }
//    
    }

    public void calculateDataCount(String sid) {

        for (int i = 0; i < SOD.size(); i++) {
            if (SOD.get(i).getSensorid() == sid) {
                System.out.println("Sensor ID Match -------------------------------------------------------------------------");
            }

        }

    }

    /**
     * @return the sensor
     */
    public Sensor getSensor() {
        return sensor;
    }

    /**
     * @return the interval
     */
    public Double getInterval() {
        return interval;
    }

    /**
     * @return the Observers
     */
    public ArrayList<Observer> getObservers() {
        return Observers;
    }

    /**
     * @return the coords
     */
    public ArrayList<Double> getCoords() {
        return coords;
    }

    /**
     * @param coords the coords to set
     */
    public void setCoords(ArrayList<Double> coords) {
        this.coords = coords;
    }

    /**
     * @return the SOED
     */
    public SetOfEmbelishedData getSOED() {
        return SOED;
    }

}

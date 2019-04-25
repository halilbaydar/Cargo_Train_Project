package Util;
public class Cargo{
    private int id;
    private int loadingStation;
    private int size;
    private int targetStation;
    public Cargo( int id, int loadingStation, int size, int targetStation) {
        super();
        this.id = id;
        this.loadingStation = loadingStation;
        this.size = size;
        this.targetStation = targetStation;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLoadingStation() {
        return loadingStation;
    }
    public void setLoadingStation(int loadingStation) {
        this.loadingStation = loadingStation;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getTargetStation() {
        return targetStation;
    }
    public void setTargetStation(int targetStation) {
        this.targetStation = targetStation;
    }
    public Cargo() {
        this.id=0;
        this.loadingStation=0;
        this.size=0;
        this.targetStation=0;
    }
    @Override
    public String toString() {
        return  this.id + " " + this.loadingStation + " " +  
                   this.targetStation+  " "  + this.size;
    }
}
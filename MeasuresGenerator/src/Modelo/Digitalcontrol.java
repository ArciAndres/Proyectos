package Modelo;
// Generated Feb 4, 2017 9:14:21 PM by Hibernate Tools 4.3.1



/**
 * Digitalcontrol generated by hbm2java
 */
public class Digitalcontrol  implements java.io.Serializable {


     private int id;
     private Meter meter;
     private Boolean state;
     private Integer boardPin;

    public Digitalcontrol() {
    }

	
    public Digitalcontrol(int id) {
        this.id = id;
    }
    public Digitalcontrol(int id, Meter meter, Boolean state, Integer boardPin) {
       this.id = id;
       this.meter = meter;
       this.state = state;
       this.boardPin = boardPin;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Meter getMeter() {
        return this.meter;
    }
    
    public void setMeter(Meter meter) {
        this.meter = meter;
    }
    public Boolean getState() {
        return this.state;
    }
    
    public void setState(Boolean state) {
        this.state = state;
    }
    public Integer getBoardPin() {
        return this.boardPin;
    }
    
    public void setBoardPin(Integer boardPin) {
        this.boardPin = boardPin;
    }




}



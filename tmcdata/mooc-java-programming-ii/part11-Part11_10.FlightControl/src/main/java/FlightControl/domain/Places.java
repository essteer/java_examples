package FlightControl.domain;

public class Places {
    private String ID;
    
    public Places(String ID){
        this.ID = ID;
    }
    
    @Override
    public String toString(){
        return this.ID;
    }
}
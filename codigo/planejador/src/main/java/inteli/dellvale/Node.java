package inteli.dellvale;

import java.math.BigInteger;
import java.util.ArrayList;

public class Node {
    private BigInteger id;
    private String Type;
    private String Description;
    private String Country;
    private double DemandReached;
    private ArrayList<Demand> demand;

    public Node(BigInteger id, String Type, String Description,String Country,ArrayList<Demand> demand){

        this.id= id;
        this.Type = Type;
        this.Description = Description;
        this.Country = Country;
        this.DemandReached = 0;
        this.demand = demand;
    }
    public BigInteger getId(){
        return this.id;
    }
    public String getType(){
        return this.Type;
    }

    public ArrayList<Demand> getDemand() {
        return demand;
    }

    public double getDemandReached() {
        return DemandReached;
    }

    public void incrementDemandReached(double qtd){
        this.DemandReached+=qtd;
    }
    public String getDescription(){
        return this.Description;
    }
    public String getCountry(){
        return this.Country;
    }

}

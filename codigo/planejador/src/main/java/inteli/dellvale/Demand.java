package inteli.dellvale;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Demand {
    private BigInteger idElo;
    private Date data_inicio;
    private BigDecimal qtd;
    private Date data_fim;
    private String product;
    private String demnd_type;


    public Demand(BigInteger idElo,Date data_inicio,Date data_fim, String product,String demnd_type,BigDecimal qtd){
        this.idElo = idElo;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.product = product;
        this.demnd_type = demnd_type;
        this.qtd = qtd;

    }
    public Demand(){
        this.idElo = BigInteger.valueOf(-1);
        this.data_inicio = new Date(0,0,0,0,0);
        this.data_fim = new Date(0,0,0,0,0);;
        this.product = "";
        this.demnd_type = "";
        this.qtd = BigDecimal.valueOf(0);

    }
    public BigInteger getIdElo(){
        return  this.idElo;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public String getProduct() {
        return product;
    }

    public String getDemnd_type() {
        return demnd_type;
    }
}

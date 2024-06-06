//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2024.02.22 at 08:27:36 PM UTC
//


package inteli.xml.sudeste;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}capacidadeVazao" minOccurs="0"/&gt;
 *         &lt;element ref="{}codSubModal" minOccurs="0"/&gt;
 *         &lt;element ref="{}codigoProduto" minOccurs="0"/&gt;
 *         &lt;element ref="{}dataInicioVigencia"/&gt;
 *         &lt;element ref="{}habilitarRestricao"/&gt;
 *         &lt;element ref="{}id" minOccurs="0"/&gt;
 *         &lt;element ref="{}idSubRedeTransporte" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{}textoObservacao"/&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{}idEloCadeiaProducaoDestino"/&gt;
 *             &lt;element ref="{}idEloCadeiaProducaoOrigem"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{}tipoVisaoPrazo"/&gt;
 *         &lt;element ref="{}unidadeQuantidade"/&gt;
 *         &lt;element ref="{}unidadeTempoVazao"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "capacidadeVazao",
    "codSubModal",
    "codigoProduto",
    "dataInicioVigencia",
    "habilitarRestricao",
    "id",
    "idSubRedeTransporte",
    "textoObservacao",
    "idEloCadeiaProducaoDestino",
    "idEloCadeiaProducaoOrigem",
    "tipoVisaoPrazo",
    "unidadeQuantidade",
    "unidadeTempoVazao"
})
@XmlRootElement(name = "variacaoCapacidadeVazaoTrecho")
public class VariacaoCapacidadeVazaoTrecho {

    protected BigDecimal capacidadeVazao;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codSubModal;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String codigoProduto;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInicioVigencia;
    protected boolean habilitarRestricao;
    protected Id id;
    protected BigInteger idSubRedeTransporte;
    protected String textoObservacao;
    protected BigInteger idEloCadeiaProducaoDestino;
    protected BigInteger idEloCadeiaProducaoOrigem;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String tipoVisaoPrazo;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String unidadeQuantidade;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String unidadeTempoVazao;

    /**
     * Gets the value of the capacidadeVazao property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCapacidadeVazao() {
        return capacidadeVazao;
    }

    /**
     * Sets the value of the capacidadeVazao property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCapacidadeVazao(BigDecimal value) {
        this.capacidadeVazao = value;
    }

    /**
     * Gets the value of the codSubModal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodSubModal() {
        return codSubModal;
    }

    /**
     * Sets the value of the codSubModal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodSubModal(String value) {
        this.codSubModal = value;
    }

    /**
     * Gets the value of the codigoProduto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * Sets the value of the codigoProduto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoProduto(String value) {
        this.codigoProduto = value;
    }

    /**
     * Gets the value of the dataInicioVigencia property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    /**
     * Sets the value of the dataInicioVigencia property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDataInicioVigencia(XMLGregorianCalendar value) {
        this.dataInicioVigencia = value;
    }

    /**
     * Gets the value of the habilitarRestricao property.
     *
     */
    public boolean isHabilitarRestricao() {
        return habilitarRestricao;
    }

    /**
     * Sets the value of the habilitarRestricao property.
     *
     */
    public void setHabilitarRestricao(boolean value) {
        this.habilitarRestricao = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link Id }
     *
     */
    public Id getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Id }
     *
     */
    public void setId(Id value) {
        this.id = value;
    }

    /**
     * Gets the value of the idSubRedeTransporte property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdSubRedeTransporte() {
        return idSubRedeTransporte;
    }

    /**
     * Sets the value of the idSubRedeTransporte property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdSubRedeTransporte(BigInteger value) {
        this.idSubRedeTransporte = value;
    }

    /**
     * Gets the value of the textoObservacao property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTextoObservacao() {
        return textoObservacao;
    }

    /**
     * Sets the value of the textoObservacao property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTextoObservacao(String value) {
        this.textoObservacao = value;
    }

    /**
     * Gets the value of the idEloCadeiaProducaoDestino property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdEloCadeiaProducaoDestino() {
        return idEloCadeiaProducaoDestino;
    }

    /**
     * Sets the value of the idEloCadeiaProducaoDestino property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdEloCadeiaProducaoDestino(BigInteger value) {
        this.idEloCadeiaProducaoDestino = value;
    }

    /**
     * Gets the value of the idEloCadeiaProducaoOrigem property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdEloCadeiaProducaoOrigem() {
        return idEloCadeiaProducaoOrigem;
    }

    /**
     * Sets the value of the idEloCadeiaProducaoOrigem property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdEloCadeiaProducaoOrigem(BigInteger value) {
        this.idEloCadeiaProducaoOrigem = value;
    }

    /**
     * Gets the value of the tipoVisaoPrazo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipoVisaoPrazo() {
        return tipoVisaoPrazo;
    }

    /**
     * Sets the value of the tipoVisaoPrazo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipoVisaoPrazo(String value) {
        this.tipoVisaoPrazo = value;
    }

    /**
     * Gets the value of the unidadeQuantidade property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnidadeQuantidade() {
        return unidadeQuantidade;
    }

    /**
     * Sets the value of the unidadeQuantidade property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnidadeQuantidade(String value) {
        this.unidadeQuantidade = value;
    }

    /**
     * Gets the value of the unidadeTempoVazao property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnidadeTempoVazao() {
        return unidadeTempoVazao;
    }

    /**
     * Sets the value of the unidadeTempoVazao property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnidadeTempoVazao(String value) {
        this.unidadeTempoVazao = value;
    }

}
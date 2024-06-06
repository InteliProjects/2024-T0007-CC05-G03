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
 *         &lt;element ref="{}id"/&gt;
 *         &lt;element ref="{}tipoElo"/&gt;
 *         &lt;element ref="{}ativo"/&gt;
 *         &lt;element ref="{}codigoUsinaPelotizacao"/&gt;
 *         &lt;element ref="{}consideraFeed"/&gt;
 *         &lt;element ref="{}descricao"/&gt;
 *         &lt;element ref="{}idEmpresaProprietaria"/&gt;
 *         &lt;element ref="{}indicePercentualProducaoFinos"/&gt;
 *         &lt;element ref="{}minimoObrigado"/&gt;
 *         &lt;element ref="{}percentualVale"/&gt;
 *         &lt;element ref="{}siteProdutivoAPS"/&gt;
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
    "id",
    "tipoElo",
    "ativo",
    "codigoUsinaPelotizacao",
    "consideraFeed",
    "descricao",
    "idEmpresaProprietaria",
    "indicePercentualProducaoFinos",
    "minimoObrigado",
    "percentualVale",
    "siteProdutivoAPS"
})
@XmlRootElement(name = "usinaPelotizacaoAPS")
public class UsinaPelotizacaoAPS {

    @XmlElement(required = true)
    protected Id id;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String tipoElo;
    protected boolean ativo;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String codigoUsinaPelotizacao;
    protected boolean consideraFeed;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected BigInteger idEmpresaProprietaria;
    @XmlElement(required = true)
    protected BigDecimal indicePercentualProducaoFinos;
    @XmlElement(required = true)
    protected BigDecimal minimoObrigado;
    @XmlElement(required = true)
    protected BigDecimal percentualVale;
    @XmlElement(required = true)
    protected SiteProdutivoAPS siteProdutivoAPS;

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
     * Gets the value of the tipoElo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipoElo() {
        return tipoElo;
    }

    /**
     * Sets the value of the tipoElo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipoElo(String value) {
        this.tipoElo = value;
    }

    /**
     * Gets the value of the ativo property.
     *
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Sets the value of the ativo property.
     *
     */
    public void setAtivo(boolean value) {
        this.ativo = value;
    }

    /**
     * Gets the value of the codigoUsinaPelotizacao property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoUsinaPelotizacao() {
        return codigoUsinaPelotizacao;
    }

    /**
     * Sets the value of the codigoUsinaPelotizacao property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoUsinaPelotizacao(String value) {
        this.codigoUsinaPelotizacao = value;
    }

    /**
     * Gets the value of the consideraFeed property.
     *
     */
    public boolean isConsideraFeed() {
        return consideraFeed;
    }

    /**
     * Sets the value of the consideraFeed property.
     *
     */
    public void setConsideraFeed(boolean value) {
        this.consideraFeed = value;
    }

    /**
     * Gets the value of the descricao property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets the value of the descricao property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Gets the value of the idEmpresaProprietaria property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdEmpresaProprietaria() {
        return idEmpresaProprietaria;
    }

    /**
     * Sets the value of the idEmpresaProprietaria property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdEmpresaProprietaria(BigInteger value) {
        this.idEmpresaProprietaria = value;
    }

    /**
     * Gets the value of the indicePercentualProducaoFinos property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIndicePercentualProducaoFinos() {
        return indicePercentualProducaoFinos;
    }

    /**
     * Sets the value of the indicePercentualProducaoFinos property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIndicePercentualProducaoFinos(BigDecimal value) {
        this.indicePercentualProducaoFinos = value;
    }

    /**
     * Gets the value of the minimoObrigado property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMinimoObrigado() {
        return minimoObrigado;
    }

    /**
     * Sets the value of the minimoObrigado property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMinimoObrigado(BigDecimal value) {
        this.minimoObrigado = value;
    }

    /**
     * Gets the value of the percentualVale property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getPercentualVale() {
        return percentualVale;
    }

    /**
     * Sets the value of the percentualVale property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setPercentualVale(BigDecimal value) {
        this.percentualVale = value;
    }

    /**
     * Gets the value of the siteProdutivoAPS property.
     *
     * @return
     *     possible object is
     *     {@link SiteProdutivoAPS }
     *
     */
    public SiteProdutivoAPS getSiteProdutivoAPS() {
        return siteProdutivoAPS;
    }

    /**
     * Sets the value of the siteProdutivoAPS property.
     *
     * @param value
     *     allowed object is
     *     {@link SiteProdutivoAPS }
     *
     */
    public void setSiteProdutivoAPS(SiteProdutivoAPS value) {
        this.siteProdutivoAPS = value;
    }

}
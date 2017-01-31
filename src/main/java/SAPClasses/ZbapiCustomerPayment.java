
package SAPClasses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZbapiCustomerPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZbapiCustomerPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Customer" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="FiscYear" type="{urn:sap-com:document:sap:rfc:functions}numeric4"/>
 *         &lt;element name="AcDocNo" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="PstngDate" type="{urn:sap-com:document:sap:rfc:functions}date"/>
 *         &lt;element name="DocDate" type="{urn:sap-com:document:sap:rfc:functions}date"/>
 *         &lt;element name="EntryDate" type="{urn:sap-com:document:sap:rfc:functions}date"/>
 *         &lt;element name="BusArea" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *         &lt;element name="ValLoccurr" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/>
 *         &lt;element name="ValDoc" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/>
 *         &lt;element name="TaxAmount" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/>
 *         &lt;element name="TaxDoc" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/>
 *         &lt;element name="ItemText" type="{urn:sap-com:document:sap:rfc:functions}char50"/>
 *         &lt;element name="Value" type="{urn:sap-com:document:sap:rfc:functions}curr13.2"/>
 *         &lt;element name="Currency" type="{urn:sap-com:document:sap:rfc:functions}cuky5"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZbapiCustomerPayment", propOrder = {
    "customer",
    "fiscYear",
    "acDocNo",
    "pstngDate",
    "docDate",
    "entryDate",
    "busArea",
    "valLoccurr",
    "valDoc",
    "taxAmount",
    "taxDoc",
    "itemText",
    "value",
    "currency"
})
public class ZbapiCustomerPayment {

    @XmlElement(name = "Customer", required = true)
    protected String customer;
    @XmlElement(name = "FiscYear", required = true)
    protected String fiscYear;
    @XmlElement(name = "AcDocNo", required = true)
    protected String acDocNo;
    @XmlElement(name = "PstngDate", required = true)
    protected String pstngDate;
    @XmlElement(name = "DocDate", required = true)
    protected String docDate;
    @XmlElement(name = "EntryDate", required = true)
    protected String entryDate;
    @XmlElement(name = "BusArea", required = true)
    protected String busArea;
    @XmlElement(name = "ValLoccurr", required = true)
    protected BigDecimal valLoccurr;
    @XmlElement(name = "ValDoc", required = true)
    protected BigDecimal valDoc;
    @XmlElement(name = "TaxAmount", required = true)
    protected BigDecimal taxAmount;
    @XmlElement(name = "TaxDoc", required = true)
    protected BigDecimal taxDoc;
    @XmlElement(name = "ItemText", required = true)
    protected String itemText;
    @XmlElement(name = "Value", required = true)
    protected BigDecimal value;
    @XmlElement(name = "Currency", required = true)
    protected String currency;

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomer(String value) {
        this.customer = value;
    }

    /**
     * Gets the value of the fiscYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiscYear() {
        return fiscYear;
    }

    /**
     * Sets the value of the fiscYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiscYear(String value) {
        this.fiscYear = value;
    }

    /**
     * Gets the value of the acDocNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcDocNo() {
        return acDocNo;
    }

    /**
     * Sets the value of the acDocNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcDocNo(String value) {
        this.acDocNo = value;
    }

    /**
     * Gets the value of the pstngDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPstngDate() {
        return pstngDate;
    }

    /**
     * Sets the value of the pstngDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPstngDate(String value) {
        this.pstngDate = value;
    }

    /**
     * Gets the value of the docDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocDate() {
        return docDate;
    }

    /**
     * Sets the value of the docDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocDate(String value) {
        this.docDate = value;
    }

    /**
     * Gets the value of the entryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * Sets the value of the entryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryDate(String value) {
        this.entryDate = value;
    }

    /**
     * Gets the value of the busArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusArea() {
        return busArea;
    }

    /**
     * Sets the value of the busArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusArea(String value) {
        this.busArea = value;
    }

    /**
     * Gets the value of the valLoccurr property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValLoccurr() {
        return valLoccurr;
    }

    /**
     * Sets the value of the valLoccurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValLoccurr(BigDecimal value) {
        this.valLoccurr = value;
    }

    /**
     * Gets the value of the valDoc property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValDoc() {
        return valDoc;
    }

    /**
     * Sets the value of the valDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValDoc(BigDecimal value) {
        this.valDoc = value;
    }

    /**
     * Gets the value of the taxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the value of the taxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxAmount(BigDecimal value) {
        this.taxAmount = value;
    }

    /**
     * Gets the value of the taxDoc property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxDoc() {
        return taxDoc;
    }

    /**
     * Sets the value of the taxDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxDoc(BigDecimal value) {
        this.taxDoc = value;
    }

    /**
     * Gets the value of the itemText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemText() {
        return itemText;
    }

    /**
     * Sets the value of the itemText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemText(String value) {
        this.itemText = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}

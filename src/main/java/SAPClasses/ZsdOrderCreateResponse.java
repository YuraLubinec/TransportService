
package SAPClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Messtab" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfBdcmsgcoll"/>
 *         &lt;element name="SalesOrder" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="Subrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messtab",
    "salesOrder",
    "subrc"
})
@XmlRootElement(name = "ZsdOrderCreateResponse")
public class ZsdOrderCreateResponse {

    @XmlElement(name = "Messtab", required = true)
    protected TableOfBdcmsgcoll messtab;
    @XmlElement(name = "SalesOrder", required = true)
    protected String salesOrder;
    @XmlElement(name = "Subrc")
    protected int subrc;

    /**
     * Gets the value of the messtab property.
     * 
     * @return
     *     possible object is
     *     {@link TableOfBdcmsgcoll }
     *     
     */
    public TableOfBdcmsgcoll getMesstab() {
        return messtab;
    }

    /**
     * Sets the value of the messtab property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfBdcmsgcoll }
     *     
     */
    public void setMesstab(TableOfBdcmsgcoll value) {
        this.messtab = value;
    }

    /**
     * Gets the value of the salesOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesOrder() {
        return salesOrder;
    }

    /**
     * Sets the value of the salesOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesOrder(String value) {
        this.salesOrder = value;
    }

    /**
     * Gets the value of the subrc property.
     * 
     */
    public int getSubrc() {
        return subrc;
    }

    /**
     * Sets the value of the subrc property.
     * 
     */
    public void setSubrc(int value) {
        this.subrc = value;
    }

}

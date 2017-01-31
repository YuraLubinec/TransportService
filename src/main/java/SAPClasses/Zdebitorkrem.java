
package SAPClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Zdebitorkrem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Zdebitorkrem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Customer" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="Family" type="{urn:sap-com:document:sap:rfc:functions}char25"/>
 *         &lt;element name="Name" type="{urn:sap-com:document:sap:rfc:functions}char25"/>
 *         &lt;element name="Father" type="{urn:sap-com:document:sap:rfc:functions}char40"/>
 *         &lt;element name="Tabno" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="Jobtxt" type="{urn:sap-com:document:sap:rfc:functions}char40"/>
 *         &lt;element name="Orgtxt" type="{urn:sap-com:document:sap:rfc:functions}char40"/>
 *         &lt;element name="TelAts" type="{urn:sap-com:document:sap:rfc:functions}char16"/>
 *         &lt;element name="Email" type="{urn:sap-com:document:sap:rfc:functions}char241"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Zdebitorkrem", propOrder = {
    "customer",
    "family",
    "name",
    "father",
    "tabno",
    "jobtxt",
    "orgtxt",
    "telAts",
    "email"
})
public class Zdebitorkrem {

    @XmlElement(name = "Customer", required = true)
    protected String customer;
    @XmlElement(name = "Family", required = true)
    protected String family;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Father", required = true)
    protected String father;
    @XmlElement(name = "Tabno", required = true)
    protected String tabno;
    @XmlElement(name = "Jobtxt", required = true)
    protected String jobtxt;
    @XmlElement(name = "Orgtxt", required = true)
    protected String orgtxt;
    @XmlElement(name = "TelAts", required = true)
    protected String telAts;
    @XmlElement(name = "Email", required = true)
    protected String email;

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
     * Gets the value of the family property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamily(String value) {
        this.family = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the father property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFather() {
        return father;
    }

    /**
     * Sets the value of the father property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFather(String value) {
        this.father = value;
    }

    /**
     * Gets the value of the tabno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTabno() {
        return tabno;
    }

    /**
     * Sets the value of the tabno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTabno(String value) {
        this.tabno = value;
    }

    /**
     * Gets the value of the jobtxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobtxt() {
        return jobtxt;
    }

    /**
     * Sets the value of the jobtxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobtxt(String value) {
        this.jobtxt = value;
    }

    /**
     * Gets the value of the orgtxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgtxt() {
        return orgtxt;
    }

    /**
     * Sets the value of the orgtxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgtxt(String value) {
        this.orgtxt = value;
    }

    /**
     * Gets the value of the telAts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelAts() {
        return telAts;
    }

    /**
     * Sets the value of the telAts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelAts(String value) {
        this.telAts = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}

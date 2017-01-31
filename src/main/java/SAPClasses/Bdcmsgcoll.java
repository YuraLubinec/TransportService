
package SAPClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Bdcmsgcoll complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bdcmsgcoll">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tcode" type="{urn:sap-com:document:sap:rfc:functions}char20"/>
 *         &lt;element name="Dyname" type="{urn:sap-com:document:sap:rfc:functions}char40"/>
 *         &lt;element name="Dynumb" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *         &lt;element name="Msgtyp" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Msgspra" type="{urn:sap-com:document:sap:rfc:functions}lang"/>
 *         &lt;element name="Msgid" type="{urn:sap-com:document:sap:rfc:functions}char20"/>
 *         &lt;element name="Msgnr" type="{urn:sap-com:document:sap:rfc:functions}char3"/>
 *         &lt;element name="Msgv1" type="{urn:sap-com:document:sap:rfc:functions}char100"/>
 *         &lt;element name="Msgv2" type="{urn:sap-com:document:sap:rfc:functions}char100"/>
 *         &lt;element name="Msgv3" type="{urn:sap-com:document:sap:rfc:functions}char100"/>
 *         &lt;element name="Msgv4" type="{urn:sap-com:document:sap:rfc:functions}char100"/>
 *         &lt;element name="Env" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *         &lt;element name="Fldname" type="{urn:sap-com:document:sap:rfc:functions}char132"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bdcmsgcoll", propOrder = {
    "tcode",
    "dyname",
    "dynumb",
    "msgtyp",
    "msgspra",
    "msgid",
    "msgnr",
    "msgv1",
    "msgv2",
    "msgv3",
    "msgv4",
    "env",
    "fldname"
})
public class Bdcmsgcoll {

    @XmlElement(name = "Tcode", required = true)
    protected String tcode;
    @XmlElement(name = "Dyname", required = true)
    protected String dyname;
    @XmlElement(name = "Dynumb", required = true)
    protected String dynumb;
    @XmlElement(name = "Msgtyp", required = true)
    protected String msgtyp;
    @XmlElement(name = "Msgspra", required = true)
    protected String msgspra;
    @XmlElement(name = "Msgid", required = true)
    protected String msgid;
    @XmlElement(name = "Msgnr", required = true)
    protected String msgnr;
    @XmlElement(name = "Msgv1", required = true)
    protected String msgv1;
    @XmlElement(name = "Msgv2", required = true)
    protected String msgv2;
    @XmlElement(name = "Msgv3", required = true)
    protected String msgv3;
    @XmlElement(name = "Msgv4", required = true)
    protected String msgv4;
    @XmlElement(name = "Env", required = true)
    protected String env;
    @XmlElement(name = "Fldname", required = true)
    protected String fldname;

    /**
     * Gets the value of the tcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcode() {
        return tcode;
    }

    /**
     * Sets the value of the tcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcode(String value) {
        this.tcode = value;
    }

    /**
     * Gets the value of the dyname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDyname() {
        return dyname;
    }

    /**
     * Sets the value of the dyname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDyname(String value) {
        this.dyname = value;
    }

    /**
     * Gets the value of the dynumb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynumb() {
        return dynumb;
    }

    /**
     * Sets the value of the dynumb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynumb(String value) {
        this.dynumb = value;
    }

    /**
     * Gets the value of the msgtyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgtyp() {
        return msgtyp;
    }

    /**
     * Sets the value of the msgtyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgtyp(String value) {
        this.msgtyp = value;
    }

    /**
     * Gets the value of the msgspra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgspra() {
        return msgspra;
    }

    /**
     * Sets the value of the msgspra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgspra(String value) {
        this.msgspra = value;
    }

    /**
     * Gets the value of the msgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgid() {
        return msgid;
    }

    /**
     * Sets the value of the msgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgid(String value) {
        this.msgid = value;
    }

    /**
     * Gets the value of the msgnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgnr() {
        return msgnr;
    }

    /**
     * Sets the value of the msgnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgnr(String value) {
        this.msgnr = value;
    }

    /**
     * Gets the value of the msgv1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgv1() {
        return msgv1;
    }

    /**
     * Sets the value of the msgv1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgv1(String value) {
        this.msgv1 = value;
    }

    /**
     * Gets the value of the msgv2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgv2() {
        return msgv2;
    }

    /**
     * Sets the value of the msgv2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgv2(String value) {
        this.msgv2 = value;
    }

    /**
     * Gets the value of the msgv3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgv3() {
        return msgv3;
    }

    /**
     * Sets the value of the msgv3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgv3(String value) {
        this.msgv3 = value;
    }

    /**
     * Gets the value of the msgv4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgv4() {
        return msgv4;
    }

    /**
     * Sets the value of the msgv4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgv4(String value) {
        this.msgv4 = value;
    }

    /**
     * Gets the value of the env property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnv() {
        return env;
    }

    /**
     * Sets the value of the env property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnv(String value) {
        this.env = value;
    }

    /**
     * Gets the value of the fldname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFldname() {
        return fldname;
    }

    /**
     * Sets the value of the fldname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFldname(String value) {
        this.fldname = value;
    }

}


package SAPClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZpernDebitor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZpernDebitor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tabno" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/>
 *         &lt;element name="Family" type="{urn:sap-com:document:sap:rfc:functions}char25"/>
 *         &lt;element name="Name" type="{urn:sap-com:document:sap:rfc:functions}char25"/>
 *         &lt;element name="Father" type="{urn:sap-com:document:sap:rfc:functions}char40"/>
 *         &lt;element name="Birthdate" type="{urn:sap-com:document:sap:rfc:functions}date"/>
 *         &lt;element name="Job" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/>
 *         &lt;element name="Jobtxt" type="{urn:sap-com:document:sap:rfc:functions}char40"/>
 *         &lt;element name="OrgUnit" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/>
 *         &lt;element name="Orgtxt" type="{urn:sap-com:document:sap:rfc:functions}char40"/>
 *         &lt;element name="TelAts" type="{urn:sap-com:document:sap:rfc:functions}char30"/>
 *         &lt;element name="TelHome" type="{urn:sap-com:document:sap:rfc:functions}char30"/>
 *         &lt;element name="TelMisto" type="{urn:sap-com:document:sap:rfc:functions}char30"/>
 *         &lt;element name="KodAts" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="KodMisto" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="TelMob1" type="{urn:sap-com:document:sap:rfc:functions}char30"/>
 *         &lt;element name="TelMob2" type="{urn:sap-com:document:sap:rfc:functions}char30"/>
 *         &lt;element name="Email" type="{urn:sap-com:document:sap:rfc:functions}char241"/>
 *         &lt;element name="TelFax" type="{urn:sap-com:document:sap:rfc:functions}char30"/>
 *         &lt;element name="Pol" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Customer" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="Bukrs" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *         &lt;element name="Butxt" type="{urn:sap-com:document:sap:rfc:functions}char25"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZpernDebitor", propOrder = {
    "tabno",
    "family",
    "name",
    "father",
    "birthdate",
    "job",
    "jobtxt",
    "orgUnit",
    "orgtxt",
    "telAts",
    "telHome",
    "telMisto",
    "kodAts",
    "kodMisto",
    "telMob1",
    "telMob2",
    "email",
    "telFax",
    "pol",
    "customer",
    "bukrs",
    "butxt"
})
public class ZpernDebitor {

    @XmlElement(name = "Tabno", required = true)
    protected String tabno;
    @XmlElement(name = "Family", required = true)
    protected String family;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Father", required = true)
    protected String father;
    @XmlElement(name = "Birthdate", required = true)
    protected String birthdate;
    @XmlElement(name = "Job", required = true)
    protected String job;
    @XmlElement(name = "Jobtxt", required = true)
    protected String jobtxt;
    @XmlElement(name = "OrgUnit", required = true)
    protected String orgUnit;
    @XmlElement(name = "Orgtxt", required = true)
    protected String orgtxt;
    @XmlElement(name = "TelAts", required = true)
    protected String telAts;
    @XmlElement(name = "TelHome", required = true)
    protected String telHome;
    @XmlElement(name = "TelMisto", required = true)
    protected String telMisto;
    @XmlElement(name = "KodAts", required = true)
    protected String kodAts;
    @XmlElement(name = "KodMisto", required = true)
    protected String kodMisto;
    @XmlElement(name = "TelMob1", required = true)
    protected String telMob1;
    @XmlElement(name = "TelMob2", required = true)
    protected String telMob2;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "TelFax", required = true)
    protected String telFax;
    @XmlElement(name = "Pol", required = true)
    protected String pol;
    @XmlElement(name = "Customer", required = true)
    protected String customer;
    @XmlElement(name = "Bukrs", required = true)
    protected String bukrs;
    @XmlElement(name = "Butxt", required = true)
    protected String butxt;

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
     * Gets the value of the birthdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the value of the birthdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthdate(String value) {
        this.birthdate = value;
    }

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJob(String value) {
        this.job = value;
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
     * Gets the value of the orgUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgUnit() {
        return orgUnit;
    }

    /**
     * Sets the value of the orgUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgUnit(String value) {
        this.orgUnit = value;
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
     * Gets the value of the telHome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelHome() {
        return telHome;
    }

    /**
     * Sets the value of the telHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelHome(String value) {
        this.telHome = value;
    }

    /**
     * Gets the value of the telMisto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelMisto() {
        return telMisto;
    }

    /**
     * Sets the value of the telMisto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelMisto(String value) {
        this.telMisto = value;
    }

    /**
     * Gets the value of the kodAts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodAts() {
        return kodAts;
    }

    /**
     * Sets the value of the kodAts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodAts(String value) {
        this.kodAts = value;
    }

    /**
     * Gets the value of the kodMisto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodMisto() {
        return kodMisto;
    }

    /**
     * Sets the value of the kodMisto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodMisto(String value) {
        this.kodMisto = value;
    }

    /**
     * Gets the value of the telMob1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelMob1() {
        return telMob1;
    }

    /**
     * Sets the value of the telMob1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelMob1(String value) {
        this.telMob1 = value;
    }

    /**
     * Gets the value of the telMob2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelMob2() {
        return telMob2;
    }

    /**
     * Sets the value of the telMob2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelMob2(String value) {
        this.telMob2 = value;
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

    /**
     * Gets the value of the telFax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelFax() {
        return telFax;
    }

    /**
     * Sets the value of the telFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelFax(String value) {
        this.telFax = value;
    }

    /**
     * Gets the value of the pol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPol() {
        return pol;
    }

    /**
     * Sets the value of the pol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPol(String value) {
        this.pol = value;
    }

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
     * Gets the value of the bukrs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBukrs() {
        return bukrs;
    }

    /**
     * Sets the value of the bukrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBukrs(String value) {
        this.bukrs = value;
    }

    /**
     * Gets the value of the butxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getButxt() {
        return butxt;
    }

    /**
     * Sets the value of the butxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setButxt(String value) {
        this.butxt = value;
    }

}

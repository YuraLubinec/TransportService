
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
 *         &lt;element name="CheckCommunities" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/>
 *         &lt;element name="EmployeeId" type="{urn:sap-com:document:sap:rfc:functions}numeric8" minOccurs="0"/>
 *         &lt;element name="FstnameM" type="{urn:sap-com:document:sap:rfc:functions}char25" minOccurs="0"/>
 *         &lt;element name="Job" type="{urn:sap-com:document:sap:rfc:functions}numeric8" minOccurs="0"/>
 *         &lt;element name="Jobtxt" type="{urn:sap-com:document:sap:rfc:functions}char12" minOccurs="0"/>
 *         &lt;element name="LastnameM" type="{urn:sap-com:document:sap:rfc:functions}char25" minOccurs="0"/>
 *         &lt;element name="OrgUnit" type="{urn:sap-com:document:sap:rfc:functions}numeric8" minOccurs="0"/>
 *         &lt;element name="Orgtxt" type="{urn:sap-com:document:sap:rfc:functions}char12" minOccurs="0"/>
 *         &lt;element name="OutTab" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZpernDebitor" minOccurs="0"/>
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
    "checkCommunities",
    "employeeId",
    "fstnameM",
    "job",
    "jobtxt",
    "lastnameM",
    "orgUnit",
    "orgtxt",
    "outTab"
})
@XmlRootElement(name = "ZsearchPerson")
public class ZsearchPerson {

    @XmlElement(name = "CheckCommunities")
    protected String checkCommunities;
    @XmlElement(name = "EmployeeId")
    protected String employeeId;
    @XmlElement(name = "FstnameM")
    protected String fstnameM;
    @XmlElement(name = "Job")
    protected String job;
    @XmlElement(name = "Jobtxt")
    protected String jobtxt;
    @XmlElement(name = "LastnameM")
    protected String lastnameM;
    @XmlElement(name = "OrgUnit")
    protected String orgUnit;
    @XmlElement(name = "Orgtxt")
    protected String orgtxt;
    @XmlElement(name = "OutTab")
    protected TableOfZpernDebitor outTab;

    /**
     * Gets the value of the checkCommunities property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckCommunities() {
        return checkCommunities;
    }

    /**
     * Sets the value of the checkCommunities property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckCommunities(String value) {
        this.checkCommunities = value;
    }

    /**
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeId(String value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the fstnameM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFstnameM() {
        return fstnameM;
    }

    /**
     * Sets the value of the fstnameM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFstnameM(String value) {
        this.fstnameM = value;
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
     * Gets the value of the lastnameM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastnameM() {
        return lastnameM;
    }

    /**
     * Sets the value of the lastnameM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastnameM(String value) {
        this.lastnameM = value;
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
     * Gets the value of the outTab property.
     * 
     * @return
     *     possible object is
     *     {@link TableOfZpernDebitor }
     *     
     */
    public TableOfZpernDebitor getOutTab() {
        return outTab;
    }

    /**
     * Sets the value of the outTab property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZpernDebitor }
     *     
     */
    public void setOutTab(TableOfZpernDebitor value) {
        this.outTab = value;
    }

}

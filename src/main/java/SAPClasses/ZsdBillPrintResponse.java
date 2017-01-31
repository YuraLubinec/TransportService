
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
 *         &lt;element name="PdfBinaryData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="Spoolid" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "pdfBinaryData",
    "spoolid"
})
@XmlRootElement(name = "ZsdBillPrintResponse")
public class ZsdBillPrintResponse {

    @XmlElement(name = "PdfBinaryData", required = true)
    protected byte[] pdfBinaryData;
    @XmlElement(name = "Spoolid")
    protected int spoolid;

    /**
     * Gets the value of the pdfBinaryData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPdfBinaryData() {
        return pdfBinaryData;
    }

    /**
     * Sets the value of the pdfBinaryData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPdfBinaryData(byte[] value) {
        this.pdfBinaryData = value;
    }

    /**
     * Gets the value of the spoolid property.
     * 
     */
    public int getSpoolid() {
        return spoolid;
    }

    /**
     * Sets the value of the spoolid property.
     * 
     */
    public void setSpoolid(int value) {
        this.spoolid = value;
    }

}

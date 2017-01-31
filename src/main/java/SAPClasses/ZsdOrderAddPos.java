
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
 *         &lt;element name="ItemCnt" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="ItemNum" type="{urn:sap-com:document:sap:rfc:functions}char18"/>
 *         &lt;element name="ItemText" type="{urn:sap-com:document:sap:rfc:functions}char40" minOccurs="0"/>
 *         &lt;element name="Messtab" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfBdcmsgcoll" minOccurs="0"/>
 *         &lt;element name="OrderNum" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
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
    "itemCnt",
    "itemNum",
    "itemText",
    "messtab",
    "orderNum"
})
@XmlRootElement(name = "ZsdOrderAddPos")
public class ZsdOrderAddPos {

    @XmlElement(name = "ItemCnt", required = true)
    protected String itemCnt;
    @XmlElement(name = "ItemNum", required = true)
    protected String itemNum;
    @XmlElement(name = "ItemText")
    protected String itemText;
    @XmlElement(name = "Messtab")
    protected TableOfBdcmsgcoll messtab;
    @XmlElement(name = "OrderNum", required = true)
    protected String orderNum;

    /**
     * Gets the value of the itemCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCnt() {
        return itemCnt;
    }

    /**
     * Sets the value of the itemCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCnt(String value) {
        this.itemCnt = value;
    }

    /**
     * Gets the value of the itemNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemNum() {
        return itemNum;
    }

    /**
     * Sets the value of the itemNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemNum(String value) {
        this.itemNum = value;
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
     * Gets the value of the orderNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * Sets the value of the orderNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNum(String value) {
        this.orderNum = value;
    }

}

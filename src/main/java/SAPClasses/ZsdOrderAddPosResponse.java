
package SAPClasses;

import java.math.BigDecimal;
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
 *         &lt;element name="ItemDate" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="ItemSapPrice" type="{urn:sap-com:document:sap:rfc:functions}curr11.2"/>
 *         &lt;element name="Messtab" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfBdcmsgcoll"/>
 *         &lt;element name="OrderItem" type="{urn:sap-com:document:sap:rfc:functions}numeric6"/>
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
    "itemDate",
    "itemSapPrice",
    "messtab",
    "orderItem",
    "salesOrder",
    "subrc"
})
@XmlRootElement(name = "ZsdOrderAddPosResponse")
public class ZsdOrderAddPosResponse {

    @XmlElement(name = "ItemDate", required = true)
    protected String itemDate;
    @XmlElement(name = "ItemSapPrice", required = true)
    protected BigDecimal itemSapPrice;
    @XmlElement(name = "Messtab", required = true)
    protected TableOfBdcmsgcoll messtab;
    @XmlElement(name = "OrderItem", required = true)
    protected String orderItem;
    @XmlElement(name = "SalesOrder", required = true)
    protected String salesOrder;
    @XmlElement(name = "Subrc")
    protected int subrc;

    /**
     * Gets the value of the itemDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDate() {
        return itemDate;
    }

    /**
     * Sets the value of the itemDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDate(String value) {
        this.itemDate = value;
    }

    /**
     * Gets the value of the itemSapPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getItemSapPrice() {
        return itemSapPrice;
    }

    /**
     * Sets the value of the itemSapPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setItemSapPrice(BigDecimal value) {
        this.itemSapPrice = value;
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
     * Gets the value of the orderItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderItem() {
        return orderItem;
    }

    /**
     * Sets the value of the orderItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderItem(String value) {
        this.orderItem = value;
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

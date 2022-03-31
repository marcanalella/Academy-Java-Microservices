
package com.acme.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hello2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hello2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="z" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hello2", propOrder = {
    "x",
    "y",
    "z"
})
public class Hello2 {

    protected String x;
    protected int y;
    protected double z;

    /**
     * Gets the value of the x property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX(String value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     * 
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * Gets the value of the z property.
     * 
     */
    public double getZ() {
        return z;
    }

    /**
     * Sets the value of the z property.
     * 
     */
    public void setZ(double value) {
        this.z = value;
    }

}

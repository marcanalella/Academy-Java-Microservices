
package com.acme.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.acme.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloResponse_QNAME = new QName("http://example.acme.com", "helloResponse");
    private final static QName _Hello2_QNAME = new QName("http://example.acme.com", "hello2");
    private final static QName _Hello_QNAME = new QName("http://example.acme.com", "hello");
    private final static QName _Hello2Response_QNAME = new QName("http://example.acme.com", "hello2Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.acme.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello2 }
     * 
     */
    public Hello2 createHello2() {
        return new Hello2();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Hello2Response }
     * 
     */
    public Hello2Response createHello2Response() {
        return new Hello2Response();
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.acme.com", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.acme.com", name = "hello2")
    public JAXBElement<Hello2> createHello2(Hello2 value) {
        return new JAXBElement<Hello2>(_Hello2_QNAME, Hello2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.acme.com", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.acme.com", name = "hello2Response")
    public JAXBElement<Hello2Response> createHello2Response(Hello2Response value) {
        return new JAXBElement<Hello2Response>(_Hello2Response_QNAME, Hello2Response.class, null, value);
    }

}

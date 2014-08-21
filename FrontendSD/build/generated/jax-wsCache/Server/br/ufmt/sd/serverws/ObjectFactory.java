
package br.ufmt.sd.serverws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufmt.sd.serverws package. 
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

    private final static QName _BuscaArquivoResponse_QNAME = new QName("http://server.sd.ufmt.br/", "buscaArquivoResponse");
    private final static QName _PublicarArquivoResponse_QNAME = new QName("http://server.sd.ufmt.br/", "publicarArquivoResponse");
    private final static QName _GetClientsD_QNAME = new QName("http://server.sd.ufmt.br/", "getClientsD");
    private final static QName _PublicarArquivo_QNAME = new QName("http://server.sd.ufmt.br/", "publicarArquivo");
    private final static QName _GetClientsDResponse_QNAME = new QName("http://server.sd.ufmt.br/", "getClientsDResponse");
    private final static QName _BuscaArquivo_QNAME = new QName("http://server.sd.ufmt.br/", "buscaArquivo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufmt.sd.serverws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PublicarArquivo }
     * 
     */
    public PublicarArquivo createPublicarArquivo() {
        return new PublicarArquivo();
    }

    /**
     * Create an instance of {@link GetClientsDResponse }
     * 
     */
    public GetClientsDResponse createGetClientsDResponse() {
        return new GetClientsDResponse();
    }

    /**
     * Create an instance of {@link BuscaArquivo }
     * 
     */
    public BuscaArquivo createBuscaArquivo() {
        return new BuscaArquivo();
    }

    /**
     * Create an instance of {@link PublicarArquivoResponse }
     * 
     */
    public PublicarArquivoResponse createPublicarArquivoResponse() {
        return new PublicarArquivoResponse();
    }

    /**
     * Create an instance of {@link GetClientsD }
     * 
     */
    public GetClientsD createGetClientsD() {
        return new GetClientsD();
    }

    /**
     * Create an instance of {@link BuscaArquivoResponse }
     * 
     */
    public BuscaArquivoResponse createBuscaArquivoResponse() {
        return new BuscaArquivoResponse();
    }

    /**
     * Create an instance of {@link ClienteD }
     * 
     */
    public ClienteD createClienteD() {
        return new ClienteD();
    }

    /**
     * Create an instance of {@link ItemBuscaNome }
     * 
     */
    public ItemBuscaNome createItemBuscaNome() {
        return new ItemBuscaNome();
    }

    /**
     * Create an instance of {@link DescricaoArquivo }
     * 
     */
    public DescricaoArquivo createDescricaoArquivo() {
        return new DescricaoArquivo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscaArquivoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "buscaArquivoResponse")
    public JAXBElement<BuscaArquivoResponse> createBuscaArquivoResponse(BuscaArquivoResponse value) {
        return new JAXBElement<BuscaArquivoResponse>(_BuscaArquivoResponse_QNAME, BuscaArquivoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicarArquivoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "publicarArquivoResponse")
    public JAXBElement<PublicarArquivoResponse> createPublicarArquivoResponse(PublicarArquivoResponse value) {
        return new JAXBElement<PublicarArquivoResponse>(_PublicarArquivoResponse_QNAME, PublicarArquivoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "getClientsD")
    public JAXBElement<GetClientsD> createGetClientsD(GetClientsD value) {
        return new JAXBElement<GetClientsD>(_GetClientsD_QNAME, GetClientsD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicarArquivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "publicarArquivo")
    public JAXBElement<PublicarArquivo> createPublicarArquivo(PublicarArquivo value) {
        return new JAXBElement<PublicarArquivo>(_PublicarArquivo_QNAME, PublicarArquivo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientsDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "getClientsDResponse")
    public JAXBElement<GetClientsDResponse> createGetClientsDResponse(GetClientsDResponse value) {
        return new JAXBElement<GetClientsDResponse>(_GetClientsDResponse_QNAME, GetClientsDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscaArquivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "buscaArquivo")
    public JAXBElement<BuscaArquivo> createBuscaArquivo(BuscaArquivo value) {
        return new JAXBElement<BuscaArquivo>(_BuscaArquivo_QNAME, BuscaArquivo.class, null, value);
    }

}

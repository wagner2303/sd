
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

    private final static QName _PublicaArquivoResponse_QNAME = new QName("http://server.sd.ufmt.br/", "publicaArquivoResponse");
    private final static QName _BuscaArquivoResponse_QNAME = new QName("http://server.sd.ufmt.br/", "buscaArquivoResponse");
    private final static QName _RemoveArquivoResponse_QNAME = new QName("http://server.sd.ufmt.br/", "removeArquivoResponse");
    private final static QName _PublicaArquivo_QNAME = new QName("http://server.sd.ufmt.br/", "publicaArquivo");
    private final static QName _GetListaClienteDResponse_QNAME = new QName("http://server.sd.ufmt.br/", "getListaClienteDResponse");
    private final static QName _GetListaClienteD_QNAME = new QName("http://server.sd.ufmt.br/", "getListaClienteD");
    private final static QName _BuscaArquivo_QNAME = new QName("http://server.sd.ufmt.br/", "buscaArquivo");
    private final static QName _RemoveArquivo_QNAME = new QName("http://server.sd.ufmt.br/", "removeArquivo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufmt.sd.serverws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetListaClienteD }
     * 
     */
    public GetListaClienteD createGetListaClienteD() {
        return new GetListaClienteD();
    }

    /**
     * Create an instance of {@link RemoveArquivo }
     * 
     */
    public RemoveArquivo createRemoveArquivo() {
        return new RemoveArquivo();
    }

    /**
     * Create an instance of {@link BuscaArquivo }
     * 
     */
    public BuscaArquivo createBuscaArquivo() {
        return new BuscaArquivo();
    }

    /**
     * Create an instance of {@link PublicaArquivo }
     * 
     */
    public PublicaArquivo createPublicaArquivo() {
        return new PublicaArquivo();
    }

    /**
     * Create an instance of {@link GetListaClienteDResponse }
     * 
     */
    public GetListaClienteDResponse createGetListaClienteDResponse() {
        return new GetListaClienteDResponse();
    }

    /**
     * Create an instance of {@link RemoveArquivoResponse }
     * 
     */
    public RemoveArquivoResponse createRemoveArquivoResponse() {
        return new RemoveArquivoResponse();
    }

    /**
     * Create an instance of {@link PublicaArquivoResponse }
     * 
     */
    public PublicaArquivoResponse createPublicaArquivoResponse() {
        return new PublicaArquivoResponse();
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
     * Create an instance of {@link DescricaoArquivo }
     * 
     */
    public DescricaoArquivo createDescricaoArquivo() {
        return new DescricaoArquivo();
    }

    /**
     * Create an instance of {@link ItemBuscaNome }
     * 
     */
    public ItemBuscaNome createItemBuscaNome() {
        return new ItemBuscaNome();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicaArquivoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "publicaArquivoResponse")
    public JAXBElement<PublicaArquivoResponse> createPublicaArquivoResponse(PublicaArquivoResponse value) {
        return new JAXBElement<PublicaArquivoResponse>(_PublicaArquivoResponse_QNAME, PublicaArquivoResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveArquivoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "removeArquivoResponse")
    public JAXBElement<RemoveArquivoResponse> createRemoveArquivoResponse(RemoveArquivoResponse value) {
        return new JAXBElement<RemoveArquivoResponse>(_RemoveArquivoResponse_QNAME, RemoveArquivoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicaArquivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "publicaArquivo")
    public JAXBElement<PublicaArquivo> createPublicaArquivo(PublicaArquivo value) {
        return new JAXBElement<PublicaArquivo>(_PublicaArquivo_QNAME, PublicaArquivo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListaClienteDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "getListaClienteDResponse")
    public JAXBElement<GetListaClienteDResponse> createGetListaClienteDResponse(GetListaClienteDResponse value) {
        return new JAXBElement<GetListaClienteDResponse>(_GetListaClienteDResponse_QNAME, GetListaClienteDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListaClienteD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "getListaClienteD")
    public JAXBElement<GetListaClienteD> createGetListaClienteD(GetListaClienteD value) {
        return new JAXBElement<GetListaClienteD>(_GetListaClienteD_QNAME, GetListaClienteD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscaArquivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "buscaArquivo")
    public JAXBElement<BuscaArquivo> createBuscaArquivo(BuscaArquivo value) {
        return new JAXBElement<BuscaArquivo>(_BuscaArquivo_QNAME, BuscaArquivo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveArquivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.sd.ufmt.br/", name = "removeArquivo")
    public JAXBElement<RemoveArquivo> createRemoveArquivo(RemoveArquivo value) {
        return new JAXBElement<RemoveArquivo>(_RemoveArquivo_QNAME, RemoveArquivo.class, null, value);
    }

}

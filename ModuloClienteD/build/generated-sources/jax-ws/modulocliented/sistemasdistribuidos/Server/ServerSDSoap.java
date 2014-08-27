
package modulocliented.sistemasdistribuidos.Server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServerSDSoap", targetNamespace = "http://server.sd.ufmt.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServerSDSoap {


    /**
     * 
     * @param termo
     * @return
     *     returns modulocliented.sistemasdistribuidos.Server.ArrayOfItemBuscaNome
     */
    @WebMethod(operationName = "BuscaArquivo", action = "http://server.sd.ufmt.br/BuscaArquivo")
    @WebResult(name = "BuscaArquivoResult", targetNamespace = "http://server.sd.ufmt.br/")
    @RequestWrapper(localName = "BuscaArquivo", targetNamespace = "http://server.sd.ufmt.br/", className = "modulocliented.sistemasdistribuidos.Server.BuscaArquivo")
    @ResponseWrapper(localName = "BuscaArquivoResponse", targetNamespace = "http://server.sd.ufmt.br/", className = "modulocliented.sistemasdistribuidos.Server.BuscaArquivoResponse")
    public ArrayOfItemBuscaNome buscaArquivo(
        @WebParam(name = "termo", targetNamespace = "http://server.sd.ufmt.br/")
        String termo);

    /**
     * 
     * @param descricao
     * @return
     *     returns modulocliented.sistemasdistribuidos.Server.ArrayOfClienteD
     */
    @WebMethod(action = "http://server.sd.ufmt.br/getClientesD")
    @WebResult(name = "getClientesDResult", targetNamespace = "http://server.sd.ufmt.br/")
    @RequestWrapper(localName = "getClientesD", targetNamespace = "http://server.sd.ufmt.br/", className = "modulocliented.sistemasdistribuidos.Server.GetClientesD")
    @ResponseWrapper(localName = "getClientesDResponse", targetNamespace = "http://server.sd.ufmt.br/", className = "modulocliented.sistemasdistribuidos.Server.GetClientesDResponse")
    public ArrayOfClienteD getClientesD(
        @WebParam(name = "descricao", targetNamespace = "http://server.sd.ufmt.br/")
        DescricaoArquivo descricao);

    /**
     * 
     * @param arquivo
     * @return
     *     returns boolean
     */
    @WebMethod(action = "http://server.sd.ufmt.br/publicaArquivo")
    @WebResult(name = "publicaArquivoResult", targetNamespace = "http://server.sd.ufmt.br/")
    @RequestWrapper(localName = "publicaArquivo", targetNamespace = "http://server.sd.ufmt.br/", className = "modulocliented.sistemasdistribuidos.Server.PublicaArquivo")
    @ResponseWrapper(localName = "publicaArquivoResponse", targetNamespace = "http://server.sd.ufmt.br/", className = "modulocliented.sistemasdistribuidos.Server.PublicaArquivoResponse")
    public boolean publicaArquivo(
        @WebParam(name = "arquivo", targetNamespace = "http://server.sd.ufmt.br/")
        ItemBuscaNome arquivo);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.server;

import br.ufmt.sd.server.model.ClienteD;
import br.ufmt.sd.server.resources.controller.ItemBuscaNomeJpaController;
import br.ufmt.sd.server.model.DescricaoArquivo;
import br.ufmt.sd.server.model.ItemBuscaNome;
import br.ufmt.sd.server.resources.Cliented;
import br.ufmt.sd.server.resources.controller.DescricaoArquivoJpaController;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author adrian
 */
@WebService(serviceName = "Server")
public class Server {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "buscaArquivo")
    @WebResult(name = "ItemBuscaName")
    public ItemBuscaNome[] buscaArquivo(@WebParam(name = "termo") String termo) {
        ItemBuscaNomeJpaController ijc = new ItemBuscaNomeJpaController();
        List<br.ufmt.sd.server.resources.ItemBuscaNome> arquivos = ijc.getEntityManager().createNamedQuery("ItemBuscaNome.findByNome").setParameter("nome", "%" + termo.toUpperCase() + "%").getResultList();
        ItemBuscaNome[] resultado = null;
        if (!arquivos.isEmpty()) {

            resultado = new ItemBuscaNome[arquivos.size()];
            for (int i = 0; i < arquivos.size(); i++) {
                resultado[i] = new ItemBuscaNome(arquivos.get(i));
            }
        }
        return resultado;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "publicaArquivo")
    public Boolean publicaArquivo(@WebParam(name = "arquivo") ItemBuscaNome arquivo, String endereco) {
        //TODO write your implementation code here:
        return true;
    }
    
    @WebMethod(operationName = "removeArquivo")
    public Boolean removeArquivo(@WebParam(name = "arquivo") DescricaoArquivo descricaoArquivo, String endereco) {
        //TODO write your implementation code here:
        return true;
    }
    

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "getListaClienteD")
    @WebResult(name = "ClienteD")
    public ClienteD[] getListaClienteD(@WebParam(name = "descricaoArquivo") DescricaoArquivo descricaoArquivo) {
        //TODO write your implementation code here:
        DescricaoArquivoJpaController djc = new DescricaoArquivoJpaController();
           ClienteD[] resultado = null;
        if (djc.findDescricaoArquivo(descricaoArquivo.getMd5arquivo()) != null) {
            List<Cliented> clientes = djc.findDescricaoArquivo(descricaoArquivo.getMd5arquivo()).getClientedList();
         
            if (!clientes.isEmpty()) {

                resultado = new ClienteD[clientes.size()];
                for (int i = 0; i < clientes.size(); i++) {
                    resultado[i] = new ClienteD(clientes.get(i));
                }
            }
        }
        return resultado;
    }
}

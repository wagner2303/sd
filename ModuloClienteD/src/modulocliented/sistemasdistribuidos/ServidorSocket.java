package modulocliented.sistemasdistribuidos;

import java.io.File;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import modulocliented.sistemasdistribuidos.clienteD.ClienteD;
import modulocliented.sistemasdistribuidos.clienteD.TabelaDeArquivos;

public class ServidorSocket implements Runnable{
    

    @Override
    public void run() {
        try {
            File arquivoParaEnviar = new File("F:\\zzz\\gato.png");
            String md5 = GeradorHash.geraHash(arquivoParaEnviar);
            TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, arquivoParaEnviar);

            arquivoParaEnviar = new File("F:\\zzz\\milque.jpg");
            md5 = GeradorHash.geraHash(arquivoParaEnviar);
            TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, arquivoParaEnviar);

            arquivoParaEnviar = new File("F:\\zzz\\paramore.jpg");
            md5 = GeradorHash.geraHash(arquivoParaEnviar);
            TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, arquivoParaEnviar);
            
            arquivoParaEnviar = new File("F:\\zzz\\artigo.pdf");
            md5 = GeradorHash.geraHash(arquivoParaEnviar);
            TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, arquivoParaEnviar);
            
            arquivoParaEnviar = new File("F:\\zzz\\Usuario.java");
            md5 = GeradorHash.geraHash(arquivoParaEnviar);
            TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, arquivoParaEnviar);

            ClienteD novoCliente;

            novoCliente = new ClienteD(InetAddress.getLocalHost().getHostAddress(), 10f);
            ExecutorService pool = Executors.newFixedThreadPool(20);
            
            while(true){    
                pool.execute(new ClienteSocket(novoCliente));
//                Thread tc = new Thread(new ClienteSocket(novoCliente));
//                tc.start();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

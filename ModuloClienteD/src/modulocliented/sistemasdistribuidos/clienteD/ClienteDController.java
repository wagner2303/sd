package modulocliented.sistemasdistribuidos.clienteD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modulocliented.sistemasdistribuidos.GeradorHash;

public class ClienteDController {
    
    private ClienteD cliente;

    public ClienteDController(ClienteD cliente) {
        this.cliente = cliente;
    }

    public ClienteD getCliente() {
        return cliente;
    }

    public void setCliente(ClienteD cliente) {
        this.cliente = cliente;
    }
    
    public Socket abrirConexao() throws IOException{
        return cliente.getServerSocket().accept();
    }

    public void enviarParte(File arquivo, Socket socket, int parte) {
        try {
            
            byte[] parteDoArquivo = obterParteDoArquivo(arquivo.getAbsolutePath(), parte);

            OutputStream out = socket.getOutputStream();
            out.write(parteDoArquivo);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void publicarArquivoClienteD(File arquivo) throws FileNotFoundException, NoSuchAlgorithmException {
        //calcular MD5
        String md5Arquivo = GeradorHash.geraHash(arquivo);

        //obter tamanho
        Long tamanho = arquivo.length();

        try {
            //salvar Tabela de arquivos
            TabelaDeArquivos.salvarNovoArquivoNaTabela(md5Arquivo, arquivo);
            
            //criar objeto descrição arquivo
//        DescricaoArquivo novoArquivoParaPublicar = new DescricaoArquivo();
//        novoArquivoParaPublicar.setMd5Arquivo(md5Arquivo);
//        novoArquivoParaPublicar.setTamanho(tamanho);
            
            //enviar dados para o servidor
//        if (publicarArquivo(novoArquivoParaPublicar, arquivo.getName(), "1.1.1.1")) {
//            System.out.println("Publicou!");
//        } else {
//            System.out.println("Não publicou!");
//        }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static byte[] obterParteDoArquivo(String filePath, int position) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(position);
        byte[] bytes = new byte[1024];
        file.read(bytes);
        file.close();
        return bytes;
    }

//    private static Boolean publicarArquivo(sistemasdistribuidos.serverws.DescricaoArquivo descricaoArquivo, java.lang.String nomeArquivo, java.lang.String enderecoMaquina) {
//        sistemasdistribuidos.serverws.Server_Service service = new sistemasdistribuidos.serverws.Server_Service();
//        sistemasdistribuidos.serverws.Server port = service.getServerPort();
//        return port.publicarArquivo(descricaoArquivo, nomeArquivo, enderecoMaquina);
//    }

}

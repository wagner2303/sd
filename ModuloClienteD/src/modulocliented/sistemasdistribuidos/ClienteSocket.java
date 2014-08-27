package modulocliented.sistemasdistribuidos;

import java.io.File;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modulocliented.sistemasdistribuidos.clienteD.ClienteD;
import modulocliented.sistemasdistribuidos.clienteD.ClienteDController;
import modulocliented.sistemasdistribuidos.clienteD.TabelaDeArquivos;

public class ClienteSocket implements Runnable {

    public ClienteSocket(ClienteD novoCliente) {
        try {
            ClienteDController ctlCliente = new ClienteDController(novoCliente);
            Socket socket = ctlCliente.abrirConexao();
            
            Scanner entrada = new Scanner(socket.getInputStream());

            if (entrada.hasNextLine()) {
                String md5Arquivo = entrada.nextLine();
                File arquivo = TabelaDeArquivos.buscarArquivo(md5Arquivo);
                if (arquivo != null) {
                    if (entrada.hasNextLine()) {
                        int parte = Integer.valueOf(entrada.nextLine());
                        ctlCliente.enviarParte(arquivo, socket, parte * 1024);
                    } else {
                        entrada.close();
                    }
                } else {
                    entrada.close();
                }
            } else {
                entrada.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

    }

}

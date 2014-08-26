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

            System.out.println("CONEXÃO ABERTA!");

            while (true) {
                Scanner entrada = new Scanner(socket.getInputStream());

                if (entrada.hasNextLine()) {
                    String md5Arquivo = entrada.nextLine();
                    System.out.println("Obtive esse md5: " + md5Arquivo);
                    File arquivo = TabelaDeArquivos.buscarArquivo(md5Arquivo);
                    if (arquivo != null) {
                        System.out.println("Tenho o arquivo: " + arquivo.getPath());
                        if (entrada.hasNextLine()) {
                            int parte = Integer.valueOf(entrada.nextLine());
                            System.out.println("Vou enviar a parte " + parte);
                            ctlCliente.enviarParte(arquivo, socket, parte * 1024);
                            System.out.println("PARTE ENVIADA!!!!\n\n");
                        } else {
                            System.out.println("DEU ERRO 2");
                            entrada.close();
                        }
                    } else {
                        System.out.println("NÃO TENHO O ARQUIVO");
                        entrada.close();
                    }
                } else {
                    System.out.println("Fim da conexao \n\n");
                    entrada.close();
                    socket = ctlCliente.abrirConexao();
                    System.out.println("CONEXÃO ABERTA!");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

    }

}

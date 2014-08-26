package modulocliented.sistemasdistribuidos.clienteD;

import java.io.IOException;
import java.net.ServerSocket;

public class ClienteD {

    private String endereco;
    private Float velocidadeConexao;
    private ServerSocket serverSocket;

    public ClienteD(String endereco, Float velocidadeConexao) throws IOException {
        serverSocket = new ServerSocket(5678);
        System.out.println("Escutando a porta 5678");
        this.endereco = endereco;
        this.velocidadeConexao = velocidadeConexao;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Float getVelocidadeConexao() {
        return velocidadeConexao;
    }

    public void setVelocidadeConexao(Float velocidadeConexao) {
        this.velocidadeConexao = velocidadeConexao;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

}

package modulocliented.sistemasdistribuidos.clienteD;

import java.io.File;
import java.io.Serializable;

public class ElementoTabela implements Serializable{
    
    private static final long serialVersionUID = -4199321605429811402L;

    private File arquivo;
    private String md5Arquivo;

    public ElementoTabela(File arquivo, String md5Arquivo) {
        this.arquivo = arquivo;
        this.md5Arquivo = md5Arquivo;
    }

    public String getNomeArquivo() {
        return arquivo.getName();
    }

    public String getTamanhoArquivo() {
        return String.valueOf(arquivo.length());
    }

    public String getMd5Arquivo() {
        return md5Arquivo;
    }

    public void setMd5Arquivo(String md5Arquivo) {
        this.md5Arquivo = md5Arquivo;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

}

package modulocliented.sistemasdistribuidos.clienteD;

public class ElementoTabela {

    private String nomeArquivo;
    private String tamanhoArquivo;
    private String md5Arquivo;

    public ElementoTabela(String nomeArquivo, String tamanhoArquivo, String md5Arquivo) {
        this.nomeArquivo = nomeArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
        this.md5Arquivo = md5Arquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(String tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getMd5Arquivo() {
        return md5Arquivo;
    }

    public void setMd5Arquivo(String md5Arquivo) {
        this.md5Arquivo = md5Arquivo;
    }

}

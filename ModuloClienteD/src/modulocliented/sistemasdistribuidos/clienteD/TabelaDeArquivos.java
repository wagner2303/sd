package modulocliented.sistemasdistribuidos.clienteD;

import java.io.File;
import java.util.HashMap;

public class TabelaDeArquivos {

    public static HashMap<String, File> arquivos;

    public static File buscarArquivo(String md5Arquivo) {
        return arquivos.get(md5Arquivo);
    }

    public static void removerArquivo(String md5Arquivo) {
        arquivos.remove(md5Arquivo);
    }
    
    public static void salvarNovoArquivoNaTabela(String md5Arquivo, File arquivo) throws Exception {
        if(arquivos.containsKey(md5Arquivo)){
            throw new Exception("Este arquivo já foi publicado!");
        }else{
            arquivos.put(md5Arquivo, arquivo);
        }
    }

    static {
        arquivos = new HashMap<>();
    }
}

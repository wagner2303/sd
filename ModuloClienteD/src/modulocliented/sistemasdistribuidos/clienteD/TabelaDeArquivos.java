package modulocliented.sistemasdistribuidos.clienteD;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class TabelaDeArquivos {

    public static HashMap<String, File> arquivos;
    public static ArrayList<ElementoTabela> elementosTabela;

    public static File buscarArquivo(String md5Arquivo) {
        return arquivos.get(md5Arquivo);
    }

    public static void removerArquivo(String md5Arquivo) {
        File f = arquivos.remove(md5Arquivo);
        for (ElementoTabela e : elementosTabela) {
            if (e.getNomeArquivo().equalsIgnoreCase(f.getName())) {
                elementosTabela.remove(e);
            }
        }
    }

    public static void salvarNovoArquivoNaTabela(String md5Arquivo, File arquivo) throws Exception {
        if(arquivos.containsKey(md5Arquivo)){
            throw new Exception("Este arquivo já foi publicado!");
        }else{
            arquivos.put(md5Arquivo, arquivo);
            elementosTabela.add(new ElementoTabela(arquivo.getName(), String.valueOf(arquivo.length()), md5Arquivo));
        }
    }

    static {
        arquivos = new HashMap<>();
        elementosTabela = new ArrayList<>();
    }
}

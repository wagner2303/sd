/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.frontendsd;

import br.ufmt.sd.frontendsd.model.ItemTabelaArquivos;
import br.ufmt.sd.serverws.ClienteD;
import br.ufmt.sd.serverws.DescricaoArquivo;
import br.ufmt.sd.serverws.ItemBuscaNome;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 *
 * @author baby
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox vBoxBottonBusca;
    @FXML
    private TextField txtBusca;
    @FXML
    private TableView tableListaArquivos;
    private ArrayList<Thread> threads = new ArrayList<Thread>();

    @FXML
    protected void handleButtonPesquisarAction(ActionEvent event) {
        // TODO Pesquisar no servidor a lista de arquivos
        List<ItemBuscaNome> listaArquivos;
        // Searching...
        listaArquivos = buscaArquivo(txtBusca.getText());

        ArrayList<ItemTabelaArquivos> arrayList = new ArrayList<>();
        for (ItemBuscaNome itemBuscaNome : listaArquivos) {
            arrayList.add(new ItemTabelaArquivos(itemBuscaNome));
        }
        final ObservableList<ItemTabelaArquivos> observableList = FXCollections.observableArrayList(arrayList);

        // Mostrar a lista de arquivos na tabela
        tableListaArquivos.setItems(observableList);
    }

//    @FXML
//    private Label label;
//    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println(cumprimenta("Baby", 20));
//        label.setText("Hello World!");
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOe
    }

    @FXML
    private void handleButtonBaixar(ActionEvent event) {

        ItemTabelaArquivos item = (ItemTabelaArquivos) tableListaArquivos.getSelectionModel().getSelectedItem();
        if (item != null) {
            DescricaoArquivo descricaoArquivo = new DescricaoArquivo();
            descricaoArquivo.setMd5Arquivo(item.getMd5Arquivo());
            descricaoArquivo.setTamanho(item.getTamanho());
            ArrayList<ClienteD> clienteDs = new ArrayList<>();
            for (ClienteD clienteD : getClientsD(descricaoArquivo)) {
                clienteDs.add(clienteD);
            }

            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                threads.add(new Thread(new DownloaderArquivo(
                        file,
                        descricaoArquivo,
                        item.getNomeArquivo(),
                        clienteDs
                )));
                threads.get(threads.size() - 1).start();
            }else{
                System.out.println("Nenhum arquivo");
            }
        }
    }

    private static java.util.List<br.ufmt.sd.serverws.ItemBuscaNome> buscaArquivo(java.lang.String termo) {
        List<ItemBuscaNome> itensBuscaNomes = new ArrayList<>();

        for (int i = 1; i < 20; i++) {
            ItemBuscaNome itemBuscaNome = new ItemBuscaNome();
            DescricaoArquivo da = new DescricaoArquivo();
            da.setTamanho(new Long(97323l));
            da.setMd5Arquivo("ff2081b61b114cd356465823a6cb16d3");
            itemBuscaNome.setDescricaoArquivo(da);
            itemBuscaNome.setNomeArquivo("Paramore " + i);

            itensBuscaNomes.add(itemBuscaNome);
        }
        for (int i = 1; i < 20; i++) {
            ItemBuscaNome itemBuscaNome = new ItemBuscaNome();
            DescricaoArquivo da = new DescricaoArquivo();
            da.setTamanho(new Long(2639100l));
            da.setMd5Arquivo("29a404dbcdb4ea326224ab6acee878de");
            itemBuscaNome.setDescricaoArquivo(da);
            itemBuscaNome.setNomeArquivo("Milque " + i);

            itensBuscaNomes.add(itemBuscaNome);
        }

        return itensBuscaNomes;
//        br.ufmt.sd.serverws.Server_Service service = new br.ufmt.sd.serverws.Server_Service();
//        br.ufmt.sd.serverws.Server port = service.getServerPort();
//        return port.buscaArquivo(termo);
    }

    private static java.util.List<br.ufmt.sd.serverws.ClienteD> getClientsD(br.ufmt.sd.serverws.DescricaoArquivo descricao) {
        List<ClienteD> clienteDs = new ArrayList<>();
        ClienteD clienteD = new ClienteD();
        clienteD.setEndereco("192.168.2.9");
        clienteD.setVelocidadeConexao(Float.parseFloat("10000"));

        clienteDs.add(clienteD);
        return clienteDs;
//        br.ufmt.sd.serverws.Server_Service service = new br.ufmt.sd.serverws.Server_Service();
//        br.ufmt.sd.serverws.Server port = service.getServerPort();
//        return port.getClientsD(descricao);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.sd.frontendsd;

import br.ufmt.sd.frontendsd.model.ItemTabelaArquivos;
import br.ufmt.sd.serverws.DescricaoArquivo;
import br.ufmt.sd.serverws.ItemBuscaNome;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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

        tableListaArquivos.setRowFactory(new Callback<TableView<ItemTabelaArquivos>, TableRow<ItemTabelaArquivos>>() {

            @Override
            public TableRow<ItemTabelaArquivos> call(TableView<ItemTabelaArquivos> p) {
                final TableRow<ItemTabelaArquivos> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        showBottonPaneBusca(row.getItem());
                    }
                });

                return row;
            }
        });
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
        // TODO
    }

    private void showBottonPaneBusca(ItemTabelaArquivos ita) {
     
        HBox hBox = new HBox();
        
        Button btnOk = new Button("Baixar");
        hBox.getChildren().addAll(btnOk);
        vBoxBottonBusca.getChildren().add(hBox);
    }

    private static java.util.List<br.ufmt.sd.serverws.ItemBuscaNome> buscaArquivo(java.lang.String termo) {
        List<ItemBuscaNome> itensBuscaNomes = new ArrayList<>();

        for (int i = 1; i < 40; i++) {
            ItemBuscaNome itemBuscaNome = new ItemBuscaNome();
            DescricaoArquivo da = new DescricaoArquivo();
            da.setTamanho(Long.valueOf(1000000000));
            da.setMd5Arquivo("600996da6a7c25fd2b6614fac2aa440e");
            itemBuscaNome.setDescricaoArquivo(da);
            itemBuscaNome.setNomeArquivo("Xuxa só para baixinhos " + i);

            itensBuscaNomes.add(itemBuscaNome);
        }

        return itensBuscaNomes;
//        br.ufmt.sd.serverws.Server_Service service = new br.ufmt.sd.serverws.Server_Service();
//        br.ufmt.sd.serverws.Server port = service.getServerPort();
//        return port.buscaArquivo(termo);
    }

    private static java.util.List<br.ufmt.sd.serverws.ClienteD> getClientsD(br.ufmt.sd.serverws.DescricaoArquivo descricao) {
        br.ufmt.sd.serverws.Server_Service service = new br.ufmt.sd.serverws.Server_Service();
        br.ufmt.sd.serverws.Server port = service.getServerPort();
        return port.getClientsD(descricao);
    }

}

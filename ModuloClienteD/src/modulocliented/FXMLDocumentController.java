package modulocliented;

import com.sun.javafx.collections.ObservableListWrapper;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import modulocliented.sistemasdistribuidos.GeradorHash;
import modulocliented.sistemasdistribuidos.ServidorSocket;
import modulocliented.sistemasdistribuidos.clienteD.ElementoTabela;
import modulocliented.sistemasdistribuidos.clienteD.TabelaDeArquivos;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnProcurar, btnPublicar, btnVerArquivos;
    @FXML
    private Label lblInfoArquivo, lblQtdeEnvios;
    @FXML
    private TableView<ElementoTabela> tblArquivos;
    @FXML
    private MenuItem mnuInformacoes, mnuSair;

    private File file;
    private ArrayList<ElementoTabela> listaDeArquivosPublicados;

    @FXML
    private void btnProcurarAction(ActionEvent event) {
        lblInfoArquivo.setText("");
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            lblInfoArquivo.setTextFill(Color.BLACK);
            lblInfoArquivo.setText("");
            lblInfoArquivo.setText(file.getAbsolutePath());
            btnPublicar.setDisable(false);
        }
    }

    @FXML
    private void btnPublicarAction(ActionEvent event) {
        if (file != null) {
            try {
                btnPublicar.setDisable(true);
                lblInfoArquivo.setText("Aguarde...");
                String md5 = GeradorHash.geraHash(file);

//                DescricaoArquivo descricao = new DescricaoArquivo();
//                descricao.setMd5Arquivo(md5);
//                descricao.setTamanho(file.length());
//
//                ItemBuscaNome item = new ItemBuscaNome();
//                item.setDescricaoArquivo(descricao);
//                item.setNome(file.getName());
//                
//                if (publicaArquivo(item, md5)) {
//                    lblInfoArquivo.setTextFill(Color.GREEN);
//                    lblInfoArquivo.setText("Arquivo \"" + file.getName() + "\" publicado! ");
//                    TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, file);
//                    atualizarListaArquivos();
//                    tblArquivos.setItems(new ObservableListWrapper<ElementoTabela>(listaDeArquivosPublicados));
//                } else {
//                    lblInfoArquivo.setText("Não foi possível publicar o arquivo \"" + file.getName() + "\"!");
//                }
                lblInfoArquivo.setTextFill(Color.GREEN);
                lblInfoArquivo.setText("Arquivo \"" + file.getName() + "\" publicado! ");
                TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, file);
                atualizarListaArquivos();
                tblArquivos.setItems(new ObservableListWrapper<ElementoTabela>(listaDeArquivosPublicados));

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                lblInfoArquivo.setTextFill(Color.BLACK);
                lblInfoArquivo.setText("");
                Dialog.showErrorDialog(ex.getMessage());
            }
        }
    }

    @FXML
    private void btnVerArquivosAction(ActionEvent event) {
        atualizarListaArquivos();
        tblArquivos.setItems(new ObservableListWrapper<ElementoTabela>(listaDeArquivosPublicados));
    }

    @FXML
    private void mnuSairAction(ActionEvent event) throws Throwable {
        salvarArquivos();
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void mnuInformacoesAction(ActionEvent event) {
        Dialog.showInfoDialog("Criado por Sydy Technology Ltda.");
    }

    @FXML
    private void mnuRemoverAction(ActionEvent event) {
        ElementoTabela elementoSelecionado = tblArquivos.getSelectionModel().getSelectedItem();
        if (elementoSelecionado == null) {
            Dialog.showErrorDialog("Clique primeiro num arquivo da lista, depois clique em Remover!");
        } else {
            TabelaDeArquivos.removerArquivo(elementoSelecionado.getMd5Arquivo());
            Dialog.showMessageDialog("Arquivo removido com sucesso!");
            atualizarListaArquivos();
            tblArquivos.setItems(new ObservableListWrapper<ElementoTabela>(listaDeArquivosPublicados));
        }
    }

    private void atualizarListaArquivos() {
        Set<String> listaDeMd5 = TabelaDeArquivos.arquivos.keySet();
        listaDeArquivosPublicados = new ArrayList<ElementoTabela>();
        for (String chave : listaDeMd5) {
            File arquivo = TabelaDeArquivos.buscarArquivo(chave);
            if (arquivo != null) {
                ElementoTabela arquivoPublicado = new ElementoTabela(arquivo, chave);
                listaDeArquivosPublicados.add(arquivoPublicado);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizarListaArquivos();
        Thread thread = new Thread(new ServidorSocket());
        thread.start();
    }

    public static void salvarArquivos() {
        FileOutputStream manipulador = null;
        ObjectOutputStream objetoManipulador = null;
        try {
            File arquivoGravacao = new File("arquivos.cad");
            manipulador = new FileOutputStream(arquivoGravacao);
            objetoManipulador = new ObjectOutputStream(manipulador);

            Set<String> listaDeMd5 = TabelaDeArquivos.arquivos.keySet();
            File arquivo;
            ElementoTabela arquivoPublicado;

            for (String chave : listaDeMd5) {
                arquivo = TabelaDeArquivos.buscarArquivo(chave);
                if (arquivo != null) {
                    arquivoPublicado = new ElementoTabela(arquivo, chave);
                    objetoManipulador.writeObject(arquivoPublicado);
                }
            }

            TabelaDeArquivos.arquivos.clear();
            objetoManipulador.close();
            manipulador.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarArquivos() {
        FileInputStream manipulador = null;
        ObjectInputStream objetoManipulador = null;
        try {
            File clienteCAD = new File("arquivos.cad");
            manipulador = new FileInputStream(clienteCAD);
            objetoManipulador = new ObjectInputStream(manipulador);
            ElementoTabela elemento;
            while (true) {
                try {
                    elemento = (ElementoTabela) objetoManipulador.readObject();
                    TabelaDeArquivos.salvarNovoArquivoNaTabela(elemento.getMd5Arquivo(), elemento.getArquivo());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            objetoManipulador.close();
            manipulador.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

//    @FXML
//    private void Action(ActionEvent event) {
//        
//    }
}

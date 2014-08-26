package modulocliented;

import com.sun.javafx.collections.ObservableListWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import modulocliented.sistemasdistribuidos.GeradorHash;
import modulocliented.sistemasdistribuidos.clienteD.ElementoTabela;
import modulocliented.sistemasdistribuidos.clienteD.TabelaDeArquivos;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnProcurar, btnPublicar;
    @FXML
    private Label lblDescricaoArquivo;
    @FXML
    private TableView<ElementoTabela> tblArquivos;
    @FXML
    private MenuItem mnuInformacoes, mnuSair;
    

    private File file;

    @FXML
    private void btnProcurarAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            lblDescricaoArquivo.setText("");
            lblDescricaoArquivo.setText(file.getAbsolutePath());
            btnPublicar.setDisable(false);
        }
    }

    @FXML
    private void btnPublicarAction(ActionEvent event) {
        if (file != null) {
            btnPublicar.setDisable(true);
            lblDescricaoArquivo.setText("Procurar Arquivo");
            try {
                String md5 = GeradorHash.geraHash(file);
                TabelaDeArquivos.salvarNovoArquivoNaTabela(md5, file);
                tblArquivos.setItems(new ObservableListWrapper<ElementoTabela>(TabelaDeArquivos.elementosTabela));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex){
                Dialog.showErrorDialog(ex.getMessage());
            }
        }
    }
    
    @FXML
    private void btnVerArquivosAction(ActionEvent event) {
        tblArquivos.setItems(new ObservableListWrapper<ElementoTabela>(TabelaDeArquivos.elementosTabela));
    }
    
    @FXML
    private void mnuSairAction(ActionEvent event) throws Throwable {
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void mnuInformacoesAction(ActionEvent event) {
        Dialog.showInfoDialog("Criado por Sydy Technology Ltda.");
    }

    @FXML
    private void initialize() {
        System.out.println("AQUI");
        tblArquivos.setItems(new ObservableListWrapper<ElementoTabela>(TabelaDeArquivos.elementosTabela));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
//    @FXML
//    private void Action(ActionEvent event) {
//        
//    }

}

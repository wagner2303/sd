package modulocliented;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modulocliented.sistemasdistribuidos.ServidorSocket;

public class ModuloClienteD extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Módulo para enviar arquivos");
        stage.getIcons().add(new Image("sydylogo.png"));

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        
        
        Thread thread = new Thread(new ServidorSocket());
        thread.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

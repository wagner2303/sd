package modulocliented;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class Dialog {

    public static void showMessageDialog(String msg) {
        final Stage dialogStage = new Stage(StageStyle.UTILITY);

        dialogStage.setTitle("ATENÇÃO");
        Button btnOK = new Button("OK");
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                dialogStage.close();
            }
        });

        dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text(msg),
                        HBoxBuilder.create().
                        children(btnOK).
                        spacing(10).
                        alignment(Pos.CENTER).build()).
                alignment(Pos.CENTER).padding(new Insets(10)).
                spacing(10).build()));
        dialogStage.show();
    }
    
    public static void showErrorDialog(String msg) {
        final Stage dialogStage = new Stage(StageStyle.UTILITY);

        dialogStage.setTitle("ERRO!");
        Button btnOK = new Button("OK");
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                dialogStage.close();
            }
        });

        dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text(msg),
                        HBoxBuilder.create().
                        children(btnOK).
                        spacing(10).
                        alignment(Pos.CENTER).build()).
                alignment(Pos.CENTER).padding(new Insets(10)).
                spacing(10).build()));
        dialogStage.show();
    }
    
    public static void showInfoDialog(String msg) {
        final Stage dialogStage = new Stage(StageStyle.UTILITY);

        dialogStage.setTitle("Informações!");
        Button btnOK = new Button("OK");
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                dialogStage.close();
            }
        });
       
        dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text(msg),
                        HBoxBuilder.create().
                        children(btnOK).
                        spacing(10).
                        alignment(Pos.CENTER).build()).
                alignment(Pos.CENTER).padding(new Insets(30)).
                spacing(10).build()));
        dialogStage.show();
    }

    public void showConfirmDialog(String msg) {
        final Stage dialogStage = new Stage(StageStyle.UTILITY);
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        Button btnSim = new Button("Sim");
        Button btnNao = new Button("Não");

        dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text(msg),
                        HBoxBuilder.create().
                        children(btnSim, btnNao).alignment(Pos.CENTER).
                        spacing(10).build()).
                alignment(Pos.CENTER).padding(new Insets(10)).
                spacing(10).build()));
        dialogStage.show();

        btnSim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                dialogStage.close();
                btnSim_OnAction(evt);
            }
        });

        btnNao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                dialogStage.close();
                btnNao_OnAction(evt);
            }
        });
    }

    public abstract void btnSim_OnAction(ActionEvent evt);

    public abstract void btnNao_OnAction(ActionEvent evt);

}

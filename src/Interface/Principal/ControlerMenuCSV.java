package Interface.Principal;

import Interface.Other.ChangeMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

/**
 * Created by chawki on 08/04/2017.
 */
public class ControlerMenuCSV {


    @FXML
    private Button parcourir;
    @FXML
    private TextField path;

    private static String path2;


    @FXML
    private void buttonParcouri() {
        final FileChooser dialog = new FileChooser();
        dialog.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Fichiers csv", "*.csv"));
        final File file = dialog.showOpenDialog(parcourir.getScene().getWindow());
        if (file != null) {
            path.setText(file.getPath());
            path2 = path.getText();
        }
    }


    @FXML
    private void suivant(ActionEvent event) throws IOException {

        ChangeMenu.afficheMenuChoixAlgo(event);

    }


    public static String getPath2() {
        return path2;
    }

    public static void setPath2(String path2) {
        ControlerMenuCSV.path2 = path2;
    }
}

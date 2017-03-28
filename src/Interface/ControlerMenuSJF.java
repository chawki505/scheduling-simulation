package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.io.IOException;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuSJF {


    @FXML
    //button calculer dans le menu sjf
    private void calculerSJF(ActionEvent event) throws IOException {
        ChangeMenu.afficheMenuResultat(event);
    }
}

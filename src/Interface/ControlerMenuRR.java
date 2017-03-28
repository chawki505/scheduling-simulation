package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;



import java.io.IOException;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuRR {


    @FXML
    //button calculer dans le menu RR
    private void calculerRR(ActionEvent event) throws IOException {
        ChangeMenu.afficheMenuResultat(event);
    }
}

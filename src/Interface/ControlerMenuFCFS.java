package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Created by chawki on 27/03/2017.
 */
public class ControlerMenuFCFS {

    @FXML
    //button calculer dans le menu fcfs
    private void calculerFCFS(ActionEvent event) throws Exception {
        ChangeMenu.afficheMenuResultat(event);

    }


}

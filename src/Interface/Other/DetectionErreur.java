package Interface.Other;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by chawki on 06/04/2017.
 */
public class DetectionErreur {


    private static Stage dialogStage;

    //methode pour verifier la saisi correcte  else elle affiche une boite de dialogue de message d'erreur
    public static boolean isInputValid(TextField label, String choix) {
        String errorMessage = "";

        if (label.getText() == null || label.getText().length() == 0) {
            if (choix.equals("Arrive"))
                errorMessage += "vous n'avez pas saisi le temp d'arrive!\n";
            if (choix.equals("CPUtime"))
                errorMessage += "vous n'avez pas saisi le cpu time!\n";
            if (choix.equals("Priority"))
                errorMessage += "vous n'avez pas saisi la priority!\n";
            if (choix.equals("Quantum"))
                errorMessage += "vous n'avez pas saisi le quantum!\n";
        } else {
            // try to parse the input into an int.
            try {
                Integer.parseInt(label.getText());
            } catch (NumberFormatException e) {
                if (choix.equals("arrive"))
                    errorMessage += "votre temp d'arrive n'est pas un nombre correcte !\n";
                if (choix.equals("CPUtime"))
                    errorMessage += "votre cpu time n'est pas un nombre correcte !\n";
                if (choix.equals("Priority"))
                    errorMessage += "votre priority n'est pas un nombre correcte !\n";
                if (choix.equals("Quantum"))
                    errorMessage += "votre quantum n'est pas un nombre correcte !\n";

            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }


    public static void errorFichierCSV() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(dialogStage);
        alert.setTitle("Invalid csv");
        alert.setHeaderText("Please correct valid csv");
        alert.setContentText("switch manuel mode ");
        alert.showAndWait();
    }
}

package ensisa.birds;

import ensisa.birds.model.Bird;
import ensisa.birds.model.BirdRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    // data
    public Bird currentBird;
    private BirdRepository repository;


    // components
    @FXML
    private Label commonNameLabel;
    @FXML
    private Label latinNameLabel;

    public MainController() {
        repository = new BirdRepository();
        repository.load();

        currentBird = repository.birds.get(0);
    }

    public void initialize() {
        commonNameLabel.textProperty().bind(currentBird.commonNameProperty());
        latinNameLabel.textProperty().bind(currentBird.latinNameProperty());
    }
}

package ensisa.birds;

import ensisa.birds.model.Bird;
import ensisa.birds.model.BirdRepository;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MainController {
    // data
    private final ObjectProperty<Bird> currentBird;
    private BirdRepository repository;


    // components
    @FXML
    private Label commonNameLabel;
    @FXML
    private Label latinNameLabel;
    @FXML
    private Label familyLabel;
    @FXML
    private Label genusLabel;
    @FXML
    private Label specieLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private ImageView birdImageView;
    @FXML
    private ListView<Bird> birdListView;
    @FXML
    private VBox birdView;


    public MainController() {
        repository = new BirdRepository();
        repository.load();

        currentBird = new SimpleObjectProperty<>(repository.birds.get(0));
    }

    public void bind(Bird bird) {
        commonNameLabel.textProperty().bind(bird.commonNameProperty());
        latinNameLabel.textProperty().bind(bird.latinNameProperty());
        familyLabel.textProperty().bind(bird.familyProperty());
        genusLabel.textProperty().bind(bird.genusProperty());
        specieLabel.textProperty().bind(bird.specieProperty());
        descriptionLabel.textProperty().bind(bird.descriptionProperty());
        birdImageView.imageProperty().bind(bird.imageProperty());
    }

    public void initialize() {
        birdListView.setCellFactory(new BirdCellFactory());
        birdListView.setItems(repository.birds);
        currentBirdProperty().bind(birdListView.getSelectionModel().selectedItemProperty());
        currentBirdProperty().addListener((o, oldValue, newValue) -> {
            if (oldValue != null) {
                bind(newValue);
            }
        });
        birdView.visibleProperty().bind(currentBirdProperty().isNotNull());
    }

    private Bird getCurrentBird() {
        return currentBird.get();
    }

    public void setCurrentBird(Bird currentBird) {
        this.currentBird.set(currentBird);
    }

    public ObjectProperty<Bird> currentBirdProperty() {
        return currentBird;
    }
}

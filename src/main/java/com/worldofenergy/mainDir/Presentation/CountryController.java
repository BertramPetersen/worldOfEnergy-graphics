package com.worldofenergy.mainDir.Presentation;

import com.worldofenergy.mainDir.*;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CountryController implements Initializable{

    private DataService game;
    private Room room;
    private Stage stage;
    @FXML
    private Label coins;
    @FXML
    private Label sunPot;
    @FXML
    private Label hydroPot;
    @FXML
    private Label windPot;
    @FXML
    private Label geoPot;
    @FXML
    private Label wAmount;
    @FXML
    private Label hAmount;
    @FXML
    private Label sAmount;
    @FXML
    private Label gAmount;
    @FXML
    private ImageView bg;
    @FXML
    private Pane greenPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ButtonBar bar;

    public CountryController(DataService game){
        this.game = game;
        this.room = game.getCurrentRoom();
    }

    class Position {
        private int x,y;
        private EnergySource energySource;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public EnergySource getEnergySource() {
            return energySource;
        }

        public Position(int x, int y, EnergySource energySource){
            this.x = x;
            this.y = y;
            this.energySource = energySource;
        }
    }

    private static final Map<String, List<Position>> positions = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = "/com/worldofenergy/mainDir/Presentation/CountryBackgrounds/" + room.getName()+".png";
        URL bgPath = getClass().getResource(path);
        if(bgPath != null){
            bg.setImage(new Image(bgPath.toString()));
        }
        setPot(room);
        setBuilt(room);
        coins.setText(""+game.getCoins()+" Coins");
        if (!positions.isEmpty()){
            if (positions.get(room.getName()) != null){
                positions.get(room.getName())
                        .forEach((position) -> drawCircle2(position.getX(), position.getY(), position.getEnergySource()));
            }
        }
        anime();
    }
    
    private void anime(){
        FadeTransition fade = new FadeTransition(Duration.millis(200), bar);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setCycleCount(1);
        fade.play();
    }

    private void setBuilt(Room room) {
        int[] built = game.getBuiltEnergy();
        wAmount.setText(""+built[0]);
        hAmount.setText(""+built[1]);
        sAmount.setText(""+built[2]);
        gAmount.setText(""+built[3]);
    }

    private void setPot(Room room){
        windPot.setText("Wind: "+room.getWindPot());
        hydroPot.setText("Hydro: "+room.getWaterPot());
        geoPot.setText("Geo: "+room.getGeoPot());
        sunPot.setText("Sun: "+room.getSunPot());
    }

    public void exitCountry(ActionEvent e) throws IOException {
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        game.setCurrentRoom("AIRPORT");
        HelloApplication.showMainView(game, stage);

    }

    public void buildEnergySource(ActionEvent e){
        Button btn = (Button)e.getSource();
        String energyType = btn.getText();
        EnergySource eType = game.stringToEnergySource(energyType);
        boolean construct = game.construct(energyType);
        if(construct){
            setBuilt(game.getCurrentRoom());
            coins.setText(""+game.getCoins()+" Coins");
            drawCircle(eType);
        }
        else if (!room.ValidateFunds(eType)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient funds");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough funds for construction of "+energyType);
            alert.showAndWait();



        }
    }
    public void drawCircle2(int x, int y, EnergySource energySource) {
        int r = 5;
        Circle circle;
        circle = new Circle(x, y, r, energySource.getColorStrokePair().getKey());
        circle.setStroke(energySource.getColorStrokePair().getValue());
        greenPane.getChildren().add(circle);
    }
    private static final float MIN_BLUE_HUE = 0.5f; // CYAN
    private static final float MAX_BLUE_HUE = 0.88f; // MAGENTA

    // This method should work, but it doens't :)
   /* private boolean isBlueAtPixel(int x, int y){
        PixelReader pixelReader = bg.getImage().getPixelReader();
        Color color = pixelReader.getColor(x, y);
        System.out.println("TISHUE: "+color.getHue());
        if (color.getHue() / 360 >= MIN_BLUE_HUE && color.getHue() / 360 <= MAX_BLUE_HUE) {
            return true;
        } else return false;
    }

    */
    public void drawCircle(EnergySource energySource) {
        Random rand = new Random();
        int x = (rand.nextInt((int)greenPane.getWidth()) + 1 );
        int y = (rand.nextInt((int) greenPane.getHeight()) + 1);
        int r = 5;
        // isBlueAtPixel(x, y);
        Position position = new Position(x, y, energySource);
        positions.compute(room.getName(), (roomName, possiblePos) -> {
            if (possiblePos == null){
                return new ArrayList<>(){{
                    add(position);
                }};
            }
            possiblePos.add(position);
            return possiblePos;
        });

        Circle circle;
        circle = new Circle(x, y, r, energySource.getColorStrokePair().getKey());
        circle.setStroke(energySource.getColorStrokePair().getValue());
        greenPane.getChildren().add(circle);
    }
    public void setHelpButton(ActionEvent e) throws IOException {
        Stage stage1 = new Stage();
        TilePane tilePane = new TilePane();

        Label label = new Label("\n \nTo build " +
                "energy sources, go to one of the areas on he map.\n" +
                "Press the button 'Windmill' or one of the four energy sources you want to build.\n" +
                "You will then be able to build as many sources you want, and see how many different \n" +
                "sources you have built. \n \nClose this window to continue the game.\n");
        Popup popup = new Popup();
        popup.setAutoHide(true);
        popup.getContent().add(label);

        Scene scene = new Scene(tilePane, 550, 130);
        stage1.setScene(scene);
        if (!popup.isShowing()) {
            stage1.show();
            popup.show(stage1);
        }
    }
}
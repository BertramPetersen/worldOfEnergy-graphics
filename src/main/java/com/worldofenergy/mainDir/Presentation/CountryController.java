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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CountryController implements Initializable {

    private final DataService game;
    private final Room room;
    private Stage stage;

    private final String windmill = "m29.8353 2.5327 c.1987-.1953.6171-.4847.8847-.4847.5495 0 .6745.3754.6826.6826v.0034.0027.0013.0013.0007c0 0 0 0 0 .0007.0054.3721.3093.6724.6826.6724.3748 0 .6793-.3018.6827-.6759.0082-.3147.1337-.6895.6827-.6895.2676 0 .6861.2894.8827.4827.267.267.6984.267.9653 0s.267-.6984 0-.9653c-.0901-.0901-.9093-.8827-1.848-.8827-.598 0-1.0445.1938-1.3653.4799-.3209-.2861-.7673-.4799-1.3653-.4799-.9386 0-1.7579.7926-1.848.8827-.2662.2655-.2655.6956-.0007.9625.2644.2669.6965.2683.9642.0048zm3.9662 8.4207c-.1153-.0205-.2328-.0307-.3509-.0307-1.1291 0-2.048.9189-2.048 2.048s.9189 2.048 2.048 2.048h5.4614c1.1291 0 2.048-.9189 2.048-2.048s-.9189-2.048-2.048-2.048c-.1181 0-.2355.0102-.3509.0307-.471-.8485-1.3674-1.3961-2.3798-1.3961-1.0124.0001-1.9088.5475-2.3798 1.3961zm1.0541 1.0261c.1441-.6219.6895-1.0568 1.3257-1.0568.6362 0 1.1817.4349 1.3257 1.0568.0498.2164.2021.3953.4083.4786.2055.0833.4396.0622.6267-.0587.4444-.2861 1.0526.0641 1.0526.5714 0 .3762-.3065.6827-.6827.6827h-5.4614c-.3762 0-.6827-.3065-.6827-.6827 0-.3762.3065-.6827.6827-.6827.1311 0 .2553.0375.37.1113.187.1208.4205.142.6267.0587.2061-.0833.3583-.2622.4081-.4786zm-21.8849-3.7874h3.4134c.3768 0 .6826-.3059.6826-.6826 0-.3768-.3058-.6826-.6826-.6826h-3.4133c-.3762 0-.6827-.3065-.6827-.6826 0-.5072.609-.8581 1.0526-.5713.187.1208.4206.1426.6267.0587.2061-.0833.3584-.2622.4083-.4786.1441-.6219.6895-1.0568 1.3257-1.0568.2485 0 .4908.0676.7017.1959.3223.1946.7421.0929.938-.2294.1953-.3229.0929-.7427-.2294-.938-.4246-.2574-.9121-.3939-1.4104-.3939-1.0124 0-1.9087.5475-2.3797 1.3961-.1153-.0205-.2328-.0307-.3509-.0307-1.1291 0-2.048.9189-2.048 2.048s.9188 2.0479 2.0479 2.0479zm27.3067 31.4027h-10.9227c-.3768 0-.6826.3058-.6826.6827s.3058.6827.6826.6827h10.9226c.3768 0 .6827-.3058.6827-.6827s-.3058-.6827-.6825-.6827zm-13.6533 0h-1.3653c-.3768 0-.6826.3058-.6826.6827s.3058.6827.6826.6827h1.3653c.3768 0 .6826-.3058.6826-.6827s-.3058-.6827-.6826-.6827zm-16.384 0h-9.5573c-.3768 0-.6826.3058-.6826.6827s.3059.6827.6826.6827h9.5573c.3768 0 .6827-.3058.6827-.6827s-.3058-.6827-.6827-.6827zm-2.1736-13.9947c.3577 0 .7106-.0949.9939-.2587l11.4197-5.888 11.3917 5.8729c.3113.1789.6649.2737 1.0226.2737.7298 0 1.4104-.3919 1.7749-1.024.5639-.9782.228-2.233-.7216-2.7812l-10.8094-6.9455-.6103-12.8013c0-1.1291-.9189-2.048-2.048-2.048s-2.048.9189-2.0473 2.0159l-.6109 12.8334-10.7814 6.9291c-.9776.5646-1.3134 1.8193-.7489 2.7976.3646.6315 1.0452 1.024 1.7749 1.024zm-.3155-2.6563 11.105-7.1359c.1857-.1195.3017-.3215.3127-.5421l.6288-13.2178c0-.3761.3065-.6826.6826-.6826.3761 0 .6826.3065.6834.7147l.6281 13.1857c.011.2205.127.4225.3127.5421l11.133 7.1523c.3256.1884.4376.6069.2499.9332-.1823.3147-.5577.4635-.9612.2348l-11.733-6.0497c-.0976-.0505-.2055-.0757-.3127-.0757s-.2151.0253-.3127.0757l-11.7609 6.0648c-.3188.1843-.7503.0649-.9325-.2498-.1884-.3263-.0765-.7448.2771-.9496zm12.7495-5.8771c.3775 0 .6826-.3058.6826-.6826 0-.3768-.3051-.6827-.6826-.6827h-.0068c-.3768 0-.6793.3059-.6793.6827 0 .3768.3093.6826.6861.6826zm2.7081 23.154c-.6724-8.0691-.6806-18.2736-.6806-18.3754 0-.3768-.3058-.6826-.6826-.6826-.3768 0-.6826.3058-.6826.6826 0 .0997.0075 9.7539.626 17.7493h-2.6167c.6179-7.9954.6254-17.6497.6254-17.7493 0-.3768-.3058-.6826-.6826-.6826s-.6826.3058-.6826.6826c0 .0989-.0075 9.7873-.6301 17.7493h-4.8312c-.3768 0-.6827.3058-.6827.6827s.3058.6827.6827.6827h9.5572c.0191 0 .0375-.0007.0567-.0021.0375-.0035.0682-.0219.1031-.03.045-.0116.0894-.0184.1304-.0382.0396-.0184.0724-.0464.1078-.0724.0348-.0259.0709-.0485.1011-.0812.0294-.0321.0491-.0703.0724-.1072.0232-.0375.0478-.0717.0635-.1133.0157-.0423.0191-.0874.0267-.1331.0062-.0355.0212-.0676.0212-.1051 0-.0102-.0054-.0184-.0054-.028-.0008-.0101.0039-.0183.0033-.0286z";
    private final String hydro    = "M70.5 27C67.9 28.9 66.2 32 66 35.4V35.6C65.8 40.3 65.3 43.3 63.7 44.6H69.5C70.5 41.7 70.8 38.4 70.9 35.9V35.6C71.1 32.5 73.5 30.2 75.8 30.2 75.4 28.6 75.1 27 74.6 25.7 73.4 25.5 72 25.9 70.5 27ZM59.8 47.1H59.2 56.7 39.3V52H44.2V61.9 64.4H41.7V66.9H24.4C11.5 66.9 9.8 74 9.6 76.3 9.6 76.5 9.6 76.6 9.6 76.9V81.8 84.3H7.1V89.2H21.9V84.3H19.4V81C19.4 81 19.4 76.9 24.3 76.9H41.6V79.4H44.1L46.6 81.9V82.4 124H64V81.8L66.5 79.3V52.1H69V47.2H68 59.8V47.1ZM110.3 79.5C108.8 78.2 107 76.7 105.1 75.1L104.5 74.6C90.7 62.4 90.7 62.4 84.8 35L83.6 29.6C80.3 14.6 75.1 5.3 67.9 1.7 65.6.5 61.9-0 60.1-0 55.2-0 52.1 2.5 52.1 6.7 52.1 9.8 54.6 12.3 57.7 12.3S63.4 9.8 63.4 6.7C63.4 6.3 63.4 6 63.2 5.6 64 5.7 64.8 6 65.6 6.5 69.6 8.4 75 14.2 78.5 30.8L79.7 36.2C85.8 64.8 86 65.3 101.1 78.5L101.7 79C103.6 80.7 105.4 82.2 107.1 83.6 114.4 89.5 118.3 92.9 121.7 104.7 122.1 105.9 123.1 106.6 124.2 106.6 124.4 106.6 124.7 106.6 124.9 106.5 126.4 106.1 127.1 104.7 126.7 103.3 122.8 89.8 117.9 85.7 110.3 79.5ZM35 126.5 35 135.8 75.3 135.8 75.3 126.5ZM55 46 55 14.8 59 14.8 59 46Z";
    private final String solar    = "m76.3141 38.266-1.8321-4.8856h-22.4729l1.751 15.0588h15.5033c5.2523 0 8.8963-5.2567 7.0507-10.1731zm-73.9965-4.8856-1.8319 4.8856c-1.8458 4.917 1.7991 10.1733 7.0507 10.1733h15.5032l1.7509-15.0588h-22.473zm16.5128-30.1176c-3.1209-.0002-5.9541 1.9632-7.0506 4.8855l-1.9326 5.1537h17.2782l1.1673-10.0392h-9.4623zm46.1897 4.8853c-1.0965-2.9224-3.9297-4.8857-7.0508-4.8857h-9.4623l1.1671 10.0392h17.2784l-1.9325-5.1535zm-18.0637 25.2321-17.1127 0-1.7512 15.0589 20.6151 0zm-1.7508-15.0588-13.6112 0-1.1673 10.0392 15.9458 0zm23.6295 0-18.5768 0 1.1671 10.0392 21.1743 0zm-25.3807-15.0588-10.1087 0-1.1676 10.0392 12.4438 0zm-35.4896 15.0588-3.7647 10.0392 21.1745 0 1.1671-10.0392zm48.4638 50.1962h-10.3023l-1.506-15.0588h-12.4404l-1.506 15.0588h-10.3025c-1.3855 0-2.5098 1.1234-2.5098 2.5098s1.1242 2.5098 2.5098 2.5098h36.0572c1.3856 0 2.5098-1.1234 2.5098-2.5098 0-1.3864-1.1243-2.5098-2.5098-2.5098z";
    final         String geo      = "m83.2037 0h-16.6149l-2.9378 35.4008-22.7011-11.9421v10.7712l-20.475-10.7712v10.7712l-20.475-10.7712v63.8413h87.3v-37.9395l-4.0963-49.3605zm-11.6446 5.4h6.6742l3.269 39.3919-12.6596-6.6598 2.7164-32.7321zm-66.1592 54.5353h40.9876v9.3647h-40.9876v-9.3647zm65.7 21.9647h-8.5124v-21.9647h8.5124v21.9647zm10.8 0h-5.4v-27.3647h-19.3124v27.3647h-51.7876v-7.2h46.3876v-20.1647h-46.3876v-22.1342l20.475 10.7712v-10.7712l20.475 10.7712v-10.7712l35.55 18.7016v30.7973z";

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
    private ButtonBar bar;

    public CountryController(DataService game){
        this.game = game;
        this.room = game.getCurrentRoom();
    }

    public static final Map<String, List<Position>> positions = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = "/com/worldofenergy/mainDir/Presentation/CountryBackgrounds/" + room.getName() + ".png";
        URL bgPath = getClass().getResource(path);
        if (bgPath != null) {
            bg.setImage(new Image(bgPath.toString()));
        }
        setPot(room);
        setBuilt(room);
        coins.setText("" + game.getCoins() + " Coins");
        if (!positions.isEmpty()) {
            if (positions.get(room.getName()) != null) {
                positions.get(room.getName())
                        .forEach((position) -> redrawCircle(position.getX(), position.getY(), position.getEnergySource()));
            }
        }
        anime();
    }

    private void anime() {
        FadeTransition fade = new FadeTransition(Duration.millis(200), bar);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setCycleCount(1);
        fade.play();
    }


    private void setBuilt(Room room) {
        int[] built = game.getBuiltEnergy();
        wAmount.setText("" + built[0]);
        hAmount.setText("" + built[1]);
        sAmount.setText("" + built[2]);
        gAmount.setText("" + built[3]);
    }

    private void setPot(Room room) {
        windPot.setText("Wind: " + room.getWindPot());
        hydroPot.setText("Hydro: " + room.getWaterPot());
        geoPot.setText("Geo: " + room.getGeoPot());
        sunPot.setText("Sun: " + room.getSunPot());
    }

    public void exitCountry(ActionEvent e) throws IOException {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        game.setCurrentRoom("AIRPORT");

        HelloApplication.showMainView(game, stage);

    }

    public void buildEnergySource(ActionEvent e) {
        Button btn = (Button) e.getSource();
        String energyType = btn.getId();
        EnergySource eType = game.stringToEnergySource(energyType);
        boolean construct = game.construct(energyType);
        if (construct) {
            setBuilt(game.getCurrentRoom());
            coins.setText("" + game.getCoins() + " Coins");
            drawCircle(eType);
        } else if (!room.ValidateFunds(eType)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient funds");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough funds for construction of " + energyType);
            alert.showAndWait();
        }
    }

    /**
     * Redraws all shapes when reentering a country with built energysources
     * @param x The saved x coordinate
     * @param y The saved x coordinate
     * @param energySource The type EnergySource the shape represents
     */
    public void redrawCircle(int x, int y, EnergySource energySource) {
        Button shape = new Button();
        shape.setLayoutX(x);
        shape.setLayoutY(y);
        if (energySource.getName().equalsIgnoreCase("windmill")){

            shape.setStyle("-fx-shape: \""+ windmill  + "\"; -fx-scale-x: 1; -fx-scale-y: 1");
        } else if (energySource.getName().equalsIgnoreCase("solar panel")){
            shape.setStyle("-fx-shape: \""+ solar  + "\"; -fx-scale-x: 1; -fx-scale-y: 1");
        } else if (energySource.getName().contains("Hydro")){
            shape.setStyle("-fx-shape: \""+ hydro  + "\"; -fx-scale-x: 1; -fx-scale-y: 1.5");
        } else{
            shape.setStyle("-fx-shape: \""+ geo  + "\"; -fx-scale-x: 1; -fx-scale-y: 1.5");
        }
        greenPane.getChildren().add(shape);
    }

    private static final float MIN_BLUE_HUE = 0.5f; // CYAN
    private static final float MAX_BLUE_HUE = 0.88f; // MAGENTA

    // This method should work, but it doesn't :)
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
        int x = (rand.nextInt((int) greenPane.getWidth()) + 1);
        int y = (rand.nextInt((int) greenPane.getHeight()) + 1);
        int r = 5;
        // isBlueAtPixel(x, y);
        Position position = new Position(x, y, energySource);
        positions.compute(room.getName(), (roomName, possiblePos) -> {
            if (possiblePos == null) {
                return new ArrayList<>() {{
                    add(position);
                }};
            }
            possiblePos.add(position);
            return possiblePos;
        });

        Button shape = new Button();
        shape.setLayoutX(x);
        shape.setLayoutY(y);
        if (energySource.getName().equalsIgnoreCase("windmill")){
            shape.setStyle("-fx-shape: \""+ windmill  + "\"; -fx-scale-x: 1; -fx-scale-y: 1");
        } else if (energySource.getName().equalsIgnoreCase("solar panel")){
            shape.setStyle("-fx-shape: \""+ solar  + "\"; -fx-scale-x: 1; -fx-scale-y: 1");
        } else if (energySource.getName().contains("Hydro")){
            shape.setStyle("-fx-shape: \""+ hydro  + "\"; -fx-scale-x: 1; -fx-scale-y: 1");
        } else if (energySource.getName().contains("Geo")){
            shape.setStyle("-fx-shape: \""+ geo  + "\"; -fx-scale-x: 1; -fx-scale-y: 1");
        }
        greenPane.getChildren().add(shape);
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
        popup.getContent().add(label);

        Scene scene = new Scene(tilePane, 550, 130);
        stage1.setScene(scene);
        if (!popup.isShowing()) {
            stage1.show();
            popup.show(stage1);
        }
    }
}
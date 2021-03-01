import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class App extends Application {

    ExcelProcessor excelProcessor = new ExcelProcessor();
    Utils utils = new Utils();

    byte count = 1;
    @Override
    public void start(Stage stage){
//        Canvas canvas = new Canvas(300, 400);
//        GraphicsContext context = canvas.getGraphicsContext2D();
//        drowShepes(context);
//
//        Group group = new Group();
//        group.getChildren().add(canvas);
        stage.setTitle("Application");

        Button submitBtn = new Button();
        submitBtn.setText("Submit");
        Button closeBtn = new Button();
        closeBtn.setText("Close");

        TextField nameField = new TextField();
        TextField ageField = new TextField();
        nameField.setPrefColumnCount(7);
        ageField.setPrefColumnCount(7);

        nameField.setAlignment(Pos.CENTER);
        ageField.setAlignment(Pos.CENTER);

        Pane root = new Pane();

        Label labelName = new Label("no text");
        Label labelAge = new Label("no text");
        Label labelBeforeName = new Label("Name value");
        Label labelBeforeAge = new Label("Age value");

        nameField.setOnAction(actionEvent -> {
        });

        ageField.setOnAction(actionEvent -> {
        });

        submitBtn.setOnAction(actionEvent -> {
            excelProcessor.fillCell(utils.isValidInput(ageField.getText()));
            labelAge.setText(utils.getExceptionName());
            excelProcessor.fillCell(nameField.getText());
            labelName.setText("OK");
            if (utils.getExceptionName().equals("OK")){
                excelProcessor.writeFile();
                count++;
                excelProcessor.createRow(count);
            }
            utils.setExceptionName("OK");
        });

        closeBtn.setOnAction(actionEvent -> excelProcessor.close());

        labelName.setLayoutX(220);
        labelName.setLayoutY(50);
        labelBeforeName.setLayoutX(25);
        labelBeforeName.setLayoutY(50);

        labelAge.setLayoutX(220);
        labelAge.setLayoutY(100);
        labelBeforeAge.setLayoutX(25);
        labelBeforeAge.setLayoutY(100);

        nameField.setLayoutX(100);
        nameField.setLayoutY(50);
        ageField.setLayoutX(100);
        ageField.setLayoutY(100);

        submitBtn.setLayoutX(125);
        submitBtn.setLayoutY(250);

        submitBtn.setMinHeight(25);
        submitBtn.setMinWidth(50);
        submitBtn.setVisible(true);
        submitBtn.setDefaultButton(true);

        ///
        closeBtn.setLayoutX(125);
        closeBtn.setLayoutY(350);

        closeBtn.setMinHeight(25);
        closeBtn.setMinWidth(50);
        closeBtn.setVisible(true);
        closeBtn.setDefaultButton(true);
        ///

        root.getChildren().add(nameField);
        root.getChildren().add(labelBeforeName);
        root.getChildren().add(labelName);
        root.getChildren().add(ageField);
        root.getChildren().add(labelBeforeAge);
        root.getChildren().add(labelAge);
        root.getChildren().add(submitBtn);
        root.getChildren().add(closeBtn);

        Scene scene = new Scene(root,300,400);
        stage.setScene(scene);
        stage.show();
    }
    private void drowShepes(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillOval(10, 60,30,30);
    }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}

package xyz.brandonirizarry.demogame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import xyz.brandonirizarry.movesquare.game.Game;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main extends Application {
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLUMNS = 5;
    private static final double SQUARE_UNIT = 100.0;
    private static final double BOARD_HEIGHT = NUM_ROWS * SQUARE_UNIT;
    private static final double BOARD_WIDTH = NUM_COLUMNS * SQUARE_UNIT;

    private static final Game game = new Game(NUM_ROWS, NUM_COLUMNS);
    private static final Queue<KeyCode> keyPresses = new ArrayDeque<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Demo frontend/backend architecture");

        var canvas = new Canvas(BOARD_WIDTH, BOARD_HEIGHT);
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> Main.keyPresses.add(e.getCode()));

        var graphicsContext = canvas.getGraphicsContext2D();

        // This will run the 'update' method 60 times per second
        // "sixty frames per second"
        var loop = new Timeline(
                new KeyFrame(Duration.millis(1000.0/60), e -> update(graphicsContext, Main.keyPresses.poll()))
        );

        loop.setCycleCount(Animation.INDEFINITE);
        loop.play();

        var pane = new StackPane();
        pane.getChildren().add(canvas);
        var scene = new Scene(pane, BOARD_WIDTH, BOARD_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void update(GraphicsContext graphicsContext, KeyCode keyPress) {
        graphicsContext.clearRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        var gameState = Main.game.export();


        for (var rowIndex = 0; rowIndex < NUM_ROWS; rowIndex++ ) {
            for (var columnIndex = 0; columnIndex < NUM_COLUMNS; columnIndex++) {
                switch (gameState[rowIndex][columnIndex]) {
                    case Player -> drawBasicShape(graphicsContext, rowIndex, columnIndex);
                    case Empty -> { }
                }
            }
        }

        // Necessary, because the 'ordinal()' method on KeyCode enum is invoked
        // to perform the switch expression coming up.
        if (keyPress == null) return;

        // Let's check up on our keypresses.
        switch (keyPress) {
            case KeyCode.W -> game.moveNorth();
            case KeyCode.A -> game.moveWest();
            case KeyCode.S -> game.moveSouth();
            case KeyCode.D -> game.moveEast();
            default -> { }
        }
    }

    private void drawBasicShape(GraphicsContext graphicsContext, int rowIndex, int columnIndex) {
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(columnIndex *  SQUARE_UNIT, rowIndex * SQUARE_UNIT, SQUARE_UNIT, SQUARE_UNIT);
    }
}

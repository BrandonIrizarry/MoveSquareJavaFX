module xyz.brandonirizarry.demoGame {
    requires xyz.brandonirizarry.moveSquareBackend;
    requires javafx.graphics;

    opens xyz.brandonirizarry.demogame to javafx.fxml;
    exports xyz.brandonirizarry.demogame;
}

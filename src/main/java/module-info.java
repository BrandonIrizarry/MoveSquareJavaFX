module xyz.brandonirizarry.moveSquareJavaFX {
    requires xyz.brandonirizarry.moveSquareBackend;
    requires javafx.graphics;

    opens xyz.brandonirizarry.movesquarejavafx to javafx.fxml;
    exports xyz.brandonirizarry.movesquarejavafx;
}

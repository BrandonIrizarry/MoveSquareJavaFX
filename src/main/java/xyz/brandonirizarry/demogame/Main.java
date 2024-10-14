package xyz.brandonirizarry.demogame;

import xyz.brandonirizarry.moveSquare.Game;

public class Main {
    public static void main(String[] args) {
        var game = new Game("yowser");

        System.out.println(game.name());
        System.out.println("I was right!");
    }
}

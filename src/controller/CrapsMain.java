/*
 * TCSS 305 Autumn 2022
 * Assignment 5
 */
package controller;

import view.CrapsGUI;

/**
 * Entry point to enter the Game of Craps program.
 *
 * @author Rainie Chi
 * @version 9 Dec 2022
 */
public class CrapsMain {
    /**
     * Main method to enter the program.
     * @param args args
     */
    public static void main(final String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new CrapsGUI();
        });
    }
}

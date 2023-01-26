/*
 * TCSS 305 Autumn 2022
 * Assignment 5
 */
package view;

import model.CrapsModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.awt.event.KeyEvent.*;

/**
 * Craps GUI class that sets up the GUI and listeners.
 */
public class CrapsGUI extends JFrame {
    /**
     * A ToolKit.
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    /**
     * The Dimension of the screen.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    /**
     * Size of text fields.
     */
    private static final Dimension FIELD_SIZE = new Dimension(80, 20);
    /**
     * Sad dog icon.
     */
    private final ImageIcon SAD_ICON = new ImageIcon("saddog.PNG");
    /**
     * Happy dog icon.
     */
    private final ImageIcon HAPPY_ICON = new ImageIcon("happydog.PNG");
    /**
     * Crying dog icon.
     */
    private final ImageIcon CRY_ICON = new ImageIcon("cryingdog.png");
    /**
     * Pending dice icon.
     */
    private final ImageIcon PENDING_ICON = new ImageIcon("pending.PNG");
    /**
     * Dice 1 icon.
     */
    private final ImageIcon ONE_ICON = new ImageIcon("one.PNG");
    /**
     * Dice 2 icon.
     */
    private final ImageIcon TWO_ICON = new ImageIcon("two.png");
    /**
     * Dice 3 icon.
     */
    private final ImageIcon THREE_ICON = new ImageIcon("three.PNG");
    /**
     * Dice 4 icon.
     */
    private final ImageIcon FOUR_ICON = new ImageIcon("four.png");
    /**
     * Dice 5 icon.
     */
    private final ImageIcon FIVE_ICON = new ImageIcon("five.PNG");
    /**
     * Dice 6 icon.
     */
    private final ImageIcon SIX_ICON = new ImageIcon("six.png");

    /**
     * Craps Model object.
     */
    private final CrapsModel myCraps;
    /**
     * The roll button.
     */
    private final JButton myRollButton;
    /**
     * The play again button to start another round.
     */
    private final JButton myPlayAgainButton;
    /**
     * Set Bank button that sets bank balance.
     */
    private final JButton mySetBankButton;
    /**
     * Add 5 button that adds 5 to bet.
     */
    private final JButton myAdd5Button;
    /**
     * Add 10 button that adds 10 to bet.
     */
    private final JButton myAdd10Button;
    /**
     * Add 20 button that adds 20 to bet.
     */
    private final JButton myAdd20Button;
    /**
     * Add 50 button that adds 50 to bet.
     */
    private final JButton myAdd50Button;
    /**
     * Add 100 button that adds 100 to bet.
     */
    private final JButton myAdd100Button;
    /**
     * Text field showing value of dice 1.
     */
    private final JTextField myDice1Field;
    /**
     * Text field showing value of dice 2.
     */
    private final JTextField myDice2Field;
    /**
     * Text field showing value of total.
     */
    private final JTextField myTotalField;
    /**
     * Text field showing value of the point.
     */
    private final JTextField myPointField;
    /**
     * Text field showing player's win total.
     */
    private final JTextField myPlayerField;
    /**
     * Text field showing house's win total.
     */
    private final JTextField myHouseField;
    /**
     * Text field showing value of bank balance.
     */
    private final JTextField myBankField;
    /**
     * Text field showing value of bet.
     */
    private final JTextField myBetField;
    /**
     * Text field showing result of current game.
     */
    private final JLabel myResultLabel;
    /**
     * Label showing icon of dice 1.
     */
    private final JLabel myDiceIcon1;
    /**
     * Label showing icon of dice 2.
     */
    private final JLabel myDiceIcon2;
    /**
     * Start Menu Item that starts the game.
     */
    private final JMenuItem myStartMenuItem;
    /**
     * Reset Menu Item that resets the game.
     */
    private final JMenuItem myResetMenuItem;
    /**
     * Exit Menu Item that exits the game.
     */
    private final JMenuItem myExitMenuItem;
    /**
     * About Menu Item that shows info of the game.
     */
    private final JMenuItem myAboutMenuItem;
    /**
     * Rules Menu Item that shows the rules.
     */
    private final JMenuItem myRulesMenuItem;

    /**
     * Constructor for Craps GUI.
     */
    public CrapsGUI() {
        super("Game of Craps");
        myRollButton =
                new JButton("<html><body>Roll The Dice!<br>(Alt + R)</body></html>");
        myPlayAgainButton =
                new JButton("<html><body>Play Again<br>(Alt + A)</body></html>");
        mySetBankButton = new JButton("Set Bank");
        myAdd5Button = new JButton("+$5");
        myAdd10Button = new JButton("+$10");
        myAdd20Button = new JButton("+$20");
        myAdd50Button = new JButton("+$50");
        myAdd100Button = new JButton("+$100");
        myDice1Field = new JTextField();
        myDice2Field = new JTextField();
        myTotalField = new JTextField();
        myPointField = new JTextField();
        myPlayerField = new JTextField();
        myHouseField = new JTextField();
        myBankField = new JTextField();
        myBetField = new JTextField();
        myResultLabel = new JLabel();
        myStartMenuItem = new JMenuItem("Start");
        myResetMenuItem = new JMenuItem("Reset");
        myExitMenuItem = new JMenuItem("Exit");
        myAboutMenuItem = new JMenuItem("About");
        myRulesMenuItem = new JMenuItem("Rules");
        myRollButton.setMnemonic(VK_R);
        myPlayAgainButton.setMnemonic(VK_A);
        myDiceIcon1 = new JLabel();
        myDiceIcon2 = new JLabel();

        setSize(700, 400);
        //center of the screen
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2,
                SCREEN_SIZE.height / 2 - getHeight() / 2);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener();
        myCraps = new CrapsModel();
        guiSetup();
        initMenuBar();
        menuItemListeners();
        addListeners();
        startingPoint();
    }

    /**
     * Sets up the GUI components.
     */
    private void guiSetup() {
        final Container mainContainer = getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(leftPanel(), BorderLayout.CENTER);
        mainContainer.add(rightPanel(), BorderLayout.EAST);

    }

    /**
     * Sets up the left panel, which holds the roll panel and bottom panel.
     *
     * @return the left panel
     */
    private JPanel leftPanel() {
        final JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(rollPanel(), BorderLayout.CENTER);
        leftPanel.add(bottomPanel(), BorderLayout.SOUTH);
        return leftPanel;
    }

    /**
     * Sets up the roll panel.
     *
     * @return the roll panel
     */
    private JPanel rollPanel() {
        final JPanel rollPanel = new JPanel();
        rollPanel.setLayout(new BoxLayout(rollPanel, BoxLayout.PAGE_AXIS));
        final JPanel resultLabelPanel = new JPanel(new FlowLayout());
        final JPanel buttonPanel = new JPanel(new FlowLayout());
        final JPanel dicePanel = new JPanel(new FlowLayout());
        final JPanel totalPanel = new JPanel(new FlowLayout());
        final JPanel pointPanel = new JPanel(new FlowLayout());

        //button to roll the dice
        myRollButton.setPreferredSize(new Dimension(150, 60));

        final JLabel totalLabel = new JLabel("Total:  ");
        final JLabel pointLabel = new JLabel("Point:  ");

        myDice1Field.setPreferredSize(FIELD_SIZE);
        myDice2Field.setPreferredSize(FIELD_SIZE);
        myTotalField.setPreferredSize(FIELD_SIZE);
        myPointField.setPreferredSize(FIELD_SIZE);
        myDice1Field.setEditable(false);
        myDice2Field.setEditable(false);
        myTotalField.setEditable(false);
        myPointField.setEditable(false);
        resultLabelPanel.add(myResultLabel);
        buttonPanel.add(myRollButton);
        dicePanel.add(myDiceIcon1);
        dicePanel.add(myDiceIcon2);
        totalPanel.add(totalLabel);
        totalPanel.add(myTotalField);
        pointPanel.add(pointLabel);
        pointPanel.add(myPointField);

        rollPanel.add(resultLabelPanel);
        rollPanel.add(pointPanel);
        rollPanel.add(buttonPanel);
        rollPanel.add(dicePanel);
        rollPanel.add(totalPanel);
        rollPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        return rollPanel;
    }

    /**
     * Sets up the bottom panel, which contains the play again panel and win totals panel.
     *
     * @return the bottom panel
     */
    private JPanel bottomPanel() {
        final JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        final JPanel playAgainPanel = new JPanel();
        final JPanel winTotalsPanel = new JPanel();
        winTotalsPanel.setLayout(new BoxLayout(winTotalsPanel, BoxLayout.PAGE_AXIS));
        final JPanel playerPanel = new JPanel(new FlowLayout());
        final JPanel housePanel = new JPanel(new FlowLayout());

        final JLabel playerLabel = new JLabel("Player: ");
        final JLabel houseLabel = new JLabel("House: ");

        myPlayerField.setPreferredSize(FIELD_SIZE);
        myPlayerField.setEditable(false);
        myHouseField.setPreferredSize(FIELD_SIZE);
        myHouseField.setEditable(false);

        playerPanel.add(playerLabel);
        playerPanel.add(myPlayerField);
        housePanel.add(houseLabel);
        housePanel.add(myHouseField);

        winTotalsPanel.add(playerPanel);
        winTotalsPanel.add(housePanel);
        winTotalsPanel.setBorder(BorderFactory.createTitledBorder("Win Totals"));

        myPlayAgainButton.setPreferredSize(new Dimension(80, 50));
        playAgainPanel.add(myPlayAgainButton);

        bottomPanel.add(playAgainPanel, BorderLayout.WEST);
        bottomPanel.add(winTotalsPanel, BorderLayout.CENTER);
        return bottomPanel;
    }

    /**
     * Sets up the right panel, which contains the bank panel and bet panel.
     *
     * @return the right panel.
     */
    private JPanel rightPanel() {
        final JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(bankPanel(), BorderLayout.NORTH);
        rightPanel.add(betPanel(), BorderLayout.CENTER);
        return rightPanel;
    }

    /**
     * Sets up the bank panel.
     *
     * @return the bank panel
     */
    private JPanel bankPanel() {
        final JPanel bankPanel = new JPanel();
        bankPanel.setLayout(new BoxLayout(bankPanel, BoxLayout.PAGE_AXIS));
        final JPanel bankFieldPanel = new JPanel(new FlowLayout());
        final JPanel buttonPanel = new JPanel(new FlowLayout());
        final JLabel dollarSign = new JLabel("$");

        myBankField.setPreferredSize(FIELD_SIZE);
        bankFieldPanel.add(dollarSign);
        bankFieldPanel.add(myBankField);
        buttonPanel.add(mySetBankButton);

        bankPanel.setBorder(BorderFactory.createTitledBorder("BANK"));
        bankPanel.add(bankFieldPanel);
        bankPanel.add(buttonPanel);
        return bankPanel;
    }

    /**
     * Sets up the bet panel.
     *
     * @return the bet panel
     */
    private JPanel betPanel() {
        final JPanel betPanel = new JPanel();
        betPanel.setLayout(new BoxLayout(betPanel, BoxLayout.PAGE_AXIS));
        betPanel.setBorder(BorderFactory.createTitledBorder("BET"));
        final JPanel betFieldPanel = new JPanel(new FlowLayout());
        final JPanel buttonPanel1 = new JPanel(new FlowLayout());
        final JPanel buttonPanel2 = new JPanel(new FlowLayout());
        final JPanel buttonPanel3 = new JPanel(new FlowLayout());
        final JPanel buttonPanel4 = new JPanel(new FlowLayout());
        final JPanel buttonPanel5 = new JPanel(new FlowLayout());
        final JLabel dollarSign = new JLabel("$");

        buttonPanel1.add(myAdd5Button);
        buttonPanel2.add(myAdd10Button);
        buttonPanel3.add(myAdd20Button);
        buttonPanel4.add(myAdd50Button);
        buttonPanel5.add(myAdd100Button);

        myBetField.setPreferredSize(FIELD_SIZE);
        betFieldPanel.add(dollarSign);
        betFieldPanel.add(myBetField);
        betPanel.add(betFieldPanel);
        betPanel.add(buttonPanel1);
        betPanel.add(buttonPanel2);
        betPanel.add(buttonPanel3);
        betPanel.add(buttonPanel4);
        betPanel.add(buttonPanel5);
        return betPanel;
    }

    /**
     * Sets up the menu bar and shortcuts for menu items.
     */
    private void initMenuBar() {
        final JMenuBar mb = new JMenuBar();
        final JMenu game = new JMenu("Game");
        final JMenu help = new JMenu("Help");
        mb.add(game);
        mb.add(help);
        myStartMenuItem.setAccelerator(KeyStroke.getKeyStroke('1', KeyEvent.CTRL_DOWN_MASK));
        myExitMenuItem.setAccelerator(KeyStroke.getKeyStroke('3', KeyEvent.CTRL_DOWN_MASK));
        myResetMenuItem.setAccelerator(KeyStroke.getKeyStroke('2', KeyEvent.CTRL_DOWN_MASK));
        myAboutMenuItem.setAccelerator(KeyStroke.getKeyStroke('4', KeyEvent.CTRL_DOWN_MASK));
        myRulesMenuItem.setAccelerator(KeyStroke.getKeyStroke('5', KeyEvent.CTRL_DOWN_MASK));
        game.add(myStartMenuItem);
        game.add(myResetMenuItem);
        game.add(myExitMenuItem);
        help.add(myAboutMenuItem);
        help.add(myRulesMenuItem);
        setJMenuBar(mb);
    }

    /**
     * Creates the JOptionPane to confirm exit.
     */
    private void closingJOptionPane() {
        final int result = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit?",
                "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, CRY_ICON);
        if (result == JOptionPane.YES_NO_OPTION) {
            dispose();
        }
    }

    /**
     * Prompts the JOptionPane to confirm exit when user exits.
     */
    private void addWindowListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent theWe) {
                closingJOptionPane();
            }
        });
    }

    /**
     * Adds listeners to menu items.
     */
    private void menuItemListeners() {
        final String rules = """
                The first roll:
                - If the sum is 7 or 11 on the first throw you win.
                - If the sum is 2, 3 or 12 you lose, the house wins.
                - If the sum is 4, 5, 6, 8, 9, or 10, that sum becomes the 'point'.
                   Continue rolling given the point
                   Now you must roll the 'point' total before rolling a 7 in order to win.
                   If you roll a 7 you lose (the 'house' wins).""";
        //Start MenuItem Listener
        myStartMenuItem.addActionListener(theEvent -> gameOn());

        //Reset MenuItem Listener
        myResetMenuItem.addActionListener(theEvent -> {
            myCraps.resetGame();
            startingPoint();
        });
        //Exit MenuItem Listener
        myExitMenuItem.addActionListener(theEvent -> closingJOptionPane());

        //About MenuItem Listener
        myAboutMenuItem.addActionListener(theEvent ->
                JOptionPane.showMessageDialog(null,
                        "Creator: Rainie\nVersion: 1.0\nMade with Java 19",
                        "About", JOptionPane.INFORMATION_MESSAGE, HAPPY_ICON));

        //Rules MenuItem Listener
        myRulesMenuItem.addActionListener(theEvent ->
                JOptionPane.showMessageDialog(null, rules,
                        "Rules", JOptionPane.INFORMATION_MESSAGE, HAPPY_ICON));
    }

    /**
     * Adds listeners to components.
     */
    public void addListeners() {
        //add bet buttons listeners
        myAdd5Button.addActionListener(theEvent -> betButtonSetup(5));
        myAdd10Button.addActionListener(theEvent -> betButtonSetup(10));
        myAdd20Button.addActionListener(theEvent -> betButtonSetup(20));
        myAdd50Button.addActionListener(theEvent -> betButtonSetup(50));
        myAdd100Button.addActionListener(theEvent -> betButtonSetup(100));

        //Roll Button listener
        myRollButton.addActionListener(theEvent -> {
            final int bet = myCraps.getMyBet();
            final int sum = rollDice();
            if (myCraps.getMyInitialRoll()) {
                if (sum == 7 || sum == 11) {
                    playerWon(bet);
                } else if (sum == 2 || sum == 3 || sum == 12) {
                    playerLost(bet);
                } else {
                    myPointField.setText(String.valueOf(sum));
                    myCraps.setMyPoint(sum);
                    myCraps.setMyInitialRoll(false);
                }
            } else {
                if (sum == 7) {
                    playerLost(bet);
                } else if (sum == myCraps.getMyPoint()) {
                    playerWon(bet);
                }
            }
        });

        //Play Again Button Listener
        myPlayAgainButton.addActionListener(theEvent -> gameOn());

        //Set Bank Button Listener
        mySetBankButton.addActionListener(theEvent -> {
            final String enteredValue = myBankField.getText();
            //checks if the entered value is valid before setting the balance
            if (!isPositiveInteger(enteredValue)) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a positive integer value that is greater than 0",
                        "Set Your Bank", JOptionPane.INFORMATION_MESSAGE, SAD_ICON);
            } else {
                final int bankValue = Integer.parseInt(enteredValue);
                myStartMenuItem.setEnabled(true);
                myCraps.setMyBalance(bankValue);
                myBankField.setEditable(false);
                mySetBankButton.setEnabled(false);
                enableBet(true);
            }
        });
    }

    /**
     * Helper method to roll the dice and sets up components accordingly.
     * @return Sum of the dice
     */
    private int rollDice() {
        myCraps.rollDice();
        int dice1 = myCraps.getMyDice1();
        int dice2 = myCraps.getMyDice2();
        myDice1Field.setText(String.valueOf(myCraps.getMyDice1()));
        myDice2Field.setText(String.valueOf(myCraps.getMyDice2()));
        myTotalField.setText(String.valueOf(myCraps.getMyDiceSum()));
        changeDiceImage(dice1, myDiceIcon1);
        changeDiceImage(dice2, myDiceIcon2);
        return myCraps.getMyDiceSum();
    }

    /**
     * Helper method that changes the dice icon to its current value.
     * @param theValue the value of the dice
     * @param theLabel the label that shows the icon
     */
    private void changeDiceImage(final int theValue, final JLabel theLabel) {
        if (theValue == 1) {
            theLabel.setIcon(ONE_ICON);
        }
        if (theValue == 2) {
            theLabel.setIcon(TWO_ICON);
        }
        if (theValue == 3) {
            theLabel.setIcon(THREE_ICON);
        }
        if (theValue == 4) {
            theLabel.setIcon(FOUR_ICON);
        }
        if (theValue == 5) {
            theLabel.setIcon(FIVE_ICON);
        }
        if (theValue == 6) {
            theLabel.setIcon(SIX_ICON);
        }
    }

    /**
     * Helper method to change the dice image to pending.
     */
    private void pendingDiceImage() {
        myDiceIcon1.setIcon(PENDING_ICON);
        myDiceIcon2.setIcon(PENDING_ICON);
    }

    /**
     * Helper method to set components when player wins.
     * @param theBet value of the bet
     */
    private void playerWon(final int theBet) {
        myResultLabel.setText("You Won!");
        myCraps.setMyInitialRoll(true);
        myCraps.setMyBalance(theBet * 2);
        myCraps.addMyWinsCount();
        myPlayerField.setText(String.valueOf(myCraps.getMyWinsCount()));
        myBankField.setText(String.valueOf(myCraps.getMyBalance()));
        gamePause();
    }

    /**
     * Helper method to set components when player loses.
     * @param theBet value of the bet
     */
    private void playerLost(final int theBet) {
        myResultLabel.setText("You Lost!");
        myCraps.setMyInitialRoll(true);
        myCraps.addMyHouseWinsCount();
        myHouseField.setText(String.valueOf(myCraps.getMyHouseWinsCount()));
        myCraps.setMyBalance(-theBet);
        myBankField.setText(String.valueOf(myCraps.getMyBalance()));
        if (myCraps.getMyBalance() < 1) {
            JOptionPane.showMessageDialog(null,
                    "Out of money! Game Over :(",
                    "Game Over", JOptionPane.INFORMATION_MESSAGE, CRY_ICON);
            myCraps.resetGame();
            startingPoint();
        } else {
            gamePause();
        }
    }

    /**
     * Helper method that sets components to game pause status in between rounds.
     */
    private void gamePause() {
        myRollButton.setEnabled(false);
        enableBet(true);
        myBetField.setText("");
        myPlayAgainButton.setEnabled(true);
    }

    /**
     * Helper method that sets components to starting point status
     * when program first starts or reset.
     */
    private void startingPoint() {
        pendingDiceImage();
        myPointField.setText("");
        myDice1Field.setText("");
        myDice2Field.setText("");
        myTotalField.setText("");
        myBankField.setText("");
        myBetField.setText("");
        myResultLabel.setText("");
        myHouseField.setText("0");
        myPlayerField.setText("0");
        myBankField.setEditable(true);
        mySetBankButton.setEnabled(true);
        myRollButton.setEnabled(false);
        myPlayAgainButton.setEnabled(false);
        enableBet(false);
        myStartMenuItem.setEnabled(false);
        myResetMenuItem.setEnabled(false);
    }

    /**
     * Helper method that enables/disables bet buttons and bet text field.
     *
     * @param theValue whether bet components are enabled
     */
    private void enableBet(final boolean theValue) {
        myBetField.setEditable(theValue);
        myAdd5Button.setEnabled(theValue);
        myAdd10Button.setEnabled(theValue);
        myAdd20Button.setEnabled(theValue);
        myAdd50Button.setEnabled(theValue);
        myAdd100Button.setEnabled(theValue);
    }

    /**
     * Helper method to determine if input String can be parsed into an integer.
     *
     * @param theString input String
     * @return whether the String can be parsed into an int
     */
    private boolean isPositiveInteger(final String theString) {
        try {
            final int num = Integer.parseInt(theString);
            if (num < 1) {
                return false;
            }
        } catch (final NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Helper method to set up listener for the bet buttons.
     *
     * @param theValue the bet value
     */
    private void betButtonSetup(final int theValue) {
        final String enteredBetValue = myBetField.getText();
        if (isPositiveInteger(enteredBetValue)) {
            final int betValue = Integer.parseInt(enteredBetValue);
            myBetField.setText(String.valueOf(betValue + theValue));
        } else {
            myBetField.setText(String.valueOf(theValue));
        }
    }

    /**
     * Creates JOptionPane that asks player to enter valid bet value.
     */
    private void invalidBetOptionPane() {
        JOptionPane.showMessageDialog(null,
                "Please enter a integer bet value that is greater than 0",
                "Bet", JOptionPane.INFORMATION_MESSAGE, SAD_ICON);
    }

    /**
     * Creates JOptionPane that tells player balance is insufficient.
     */
    private void insufficientBalancePane() {
        JOptionPane.showMessageDialog(null,
                "Insufficient Balance", "Uh-oh!", JOptionPane.INFORMATION_MESSAGE, SAD_ICON);
    }

    /**
     * Helper method that checks if bet is valid, if so, starts a round.
     */
    private void gameOn() {
        final String enteredBetValue = myBetField.getText();
        if (!isPositiveInteger(enteredBetValue)) {
            invalidBetOptionPane();
        } else {
            final int betValue = Integer.parseInt(enteredBetValue);
            if (betValue > myCraps.getMyBalance()) {
                insufficientBalancePane();
            } else {
                myResetMenuItem.setEnabled(true);
                myStartMenuItem.setEnabled(false);
                pendingDiceImage();
                myResultLabel.setText("");
                myPointField.setText("");
                myTotalField.setText("");
                myDice1Field.setText("");
                myDice2Field.setText("");
                myCraps.setMyBet(betValue);
                myRollButton.setEnabled(true);
                enableBet(false);
                myPlayAgainButton.setEnabled(false);
            }
        }
    }
}
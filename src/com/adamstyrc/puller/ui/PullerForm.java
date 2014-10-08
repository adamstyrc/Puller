package com.adamstyrc.puller.ui;

import javax.swing.*;

public class PullerForm {
    private JPanel rootPanel;
    private JTextField destinationText;
    private JButton destinationPathButton;
    private JButton pullDataButton;
    private JTextArea outputLog;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JButton getPullDataButton() {
        return pullDataButton;
    }

    public JTextField getDestinationText() {
        return destinationText;
    }

    public JButton getDestinationPathButton() {
        return destinationPathButton;
    }

    public JTextArea getOutputLog() {
        return outputLog;
    }
}

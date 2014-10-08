package com.adamstyrc.puller.ui;

import javax.swing.*;

public class PullerForm {
    private JPanel rootPanel;
    private JTextField sourceText;
    private JButton button;
    private JTextField destinationText;
    private JButton destinationPathButton;

//    public static void main(String[] args) {
//        final JFrame frame = new JFrame("PullerForm");
//        final PullerForm pullerForm = new PullerForm();
//        frame.setContentPane(pullerForm.rootPanel);
//
//        pullerForm.getDestinationPathButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser fc = new JFileChooser();
//                fc.setAcceptAllFileFilterUsed(false);
//                fc.setMultiSelectionEnabled(false);
//
//                int returnValue = fc.showOpenDialog(frame);
//
//                if (returnValue == JFileChooser.APPROVE_OPTION) {
//                    File selectedFile = fc.getSelectedFile();
//                    pullerForm.getDestinationText().setText(selectedFile.getAbsolutePath());
//                }
//            }
//        });
//
//
////        fc.dir
////        fc.setFileFilter(new FileNameExtensionFilter("apk", "apk"));
////        frame
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getSourceText() {
        return sourceText;
    }

    public JButton getButton() {
        return button;
    }

    public JTextField getDestinationText() {
        return destinationText;
    }

    public JButton getDestinationPathButton() {
        return destinationPathButton;
    }
}

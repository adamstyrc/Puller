package com.adamstyrc.puller;

import com.adamstyrc.puller.ui.PullerForm;
import com.adamstyrc.puller.util.AdbCommandExecutor;
import com.adamstyrc.puller.util.AppDataDownloader;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PullerToolWindow {

    public static final String TOOL_WINDOW_ID = "Puller";

    private static final ImageIcon pomodoroIcon = new ImageIcon(PullerToolWindow.class.getResource("/resources/pomodoro-icon.png"));

    private final AdbCommandExecutor mCommandExecutor = new AdbCommandExecutor();

    public PullerToolWindow() {
        ProjectManager.getInstance().addProjectManagerListener(new ProjectManagerListener() {
            @Override
            public void projectOpened(Project project) {
                registerWindowFor(project);
            }

            @Override
            public boolean canCloseProject(Project project) {
                return false;
            }

            @Override
            public void projectClosed(Project project) {
                unregisterWindowFrom(project);
            }

            @Override
            public void projectClosing(Project project) {

            }
        });
    }

    public void registerWindowFor(Project project) {
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
        if (toolWindowManager.getToolWindow(TOOL_WINDOW_ID) != null) {
            return;
        }

//        PomodoroComponent pomodoroComponent = ApplicationManager.getApplication().getComponent(PomodoroComponent.class);
//        PomodoroPresenter presenter = new PomodoroPresenter(pomodoroComponent.getModel());

        ToolWindow myToolWindow = toolWindowManager.registerToolWindow(TOOL_WINDOW_ID, false, ToolWindowAnchor.BOTTOM);
        myToolWindow.setIcon(pomodoroIcon);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        final PullerForm pullerForm = new PullerForm();
        Content content = contentFactory.createContent(pullerForm.getRootPanel(), "settings", false);
        myToolWindow.getContentManager().addContent(content);

        final JTextField destinationText = pullerForm.getDestinationText();
        destinationText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSettings(destinationText);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSettings(destinationText);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSettings(destinationText);
            }
        });
        pullerForm.getDestinationText().setText("/Users/adamstyrc/Desktop/");

        pullerForm.getPullDataButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dstPath = pullerForm.getDestinationText().getText();
                if (isProperDestinationDirPath(dstPath)) {
                    AppDataDownloader downloader = new AppDataDownloader();
                    downloader.download();
                }
            }
        });

        pullerForm.getDestinationPathButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose directory to store data");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                String currentDirPath = pullerForm.getDestinationText().getText();
                if (isProperDestinationDirPath(currentDirPath)) {
                    File currentDir = new File(currentDirPath);
                    fileChooser.setCurrentDirectory(currentDir);
                }
//                fileChooser.setCurrentDirectory(new java.io.File("."));
//                fileChooser.set

                int returnValue = fileChooser.showOpenDialog(pullerForm.getRootPanel());
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    pullerForm.getDestinationText().setText(selectedFile.getAbsolutePath());
                }
            }
        });
    }

    private void updateSettings(JTextField destinationText) {
        String text = destinationText.getText();
        PullerSettings.getInstance().setDestinationDirPath(text);
    }

    public void unregisterWindowFrom(Project project) {
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
        if (toolWindowManager.getToolWindow(TOOL_WINDOW_ID) != null) {
            toolWindowManager.unregisterToolWindow(TOOL_WINDOW_ID);
        }
    }

    private boolean isProperDestinationDirPath(String dirPath) {
        File currentDir = new File(dirPath);
        return currentDir.isDirectory();
    }

}

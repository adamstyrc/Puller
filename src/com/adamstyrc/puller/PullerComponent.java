package com.adamstyrc.puller;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class PullerComponent implements ApplicationComponent {

    public PullerComponent() {
    }

    public void initComponent() {
        PullerToolWindow pullerToolWindow = new PullerToolWindow();
//        pullerToolWindow.registerWindowFor();
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "com.adamstyrc.puller.PullerComponent";
    }
}

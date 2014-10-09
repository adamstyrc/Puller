package com.adamstyrc.puller;

import com.intellij.openapi.components.ServiceManager;

public class PullerSettings {

    private static PullerSettings sInstance;
    private String mDestinationDirPath;

    private PullerSettings(String destinationDirPath) {
        mDestinationDirPath = destinationDirPath;
    }

    public static synchronized PullerSettings getInstance() {
//        return ServiceManager.getService(PullerSettings.class);
        if (sInstance == null) {
            sInstance = new PullerSettings("/Users/adamstyrc/Desktop/");
        }
        return sInstance;
    }

    public String getDestinationDirPath() {
        return mDestinationDirPath;
    }

    public void setDestinationDirPath(String destinationDirPath) {
        mDestinationDirPath = destinationDirPath;
    }
}

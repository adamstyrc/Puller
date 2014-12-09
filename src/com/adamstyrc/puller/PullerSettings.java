package com.adamstyrc.puller;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@State(name = "PullerSettings", storages = {@Storage(id = "other", file = "$APP_CONFIG$/pomodoro.settings.xml")})
public class PullerSettings implements PersistentStateComponent<PullerSettings> {

    private static PullerSettings sInstance;
    public String mDestinationDirPath;
    public String mAdbPath;

    private PullerSettings() {
    }

    public static synchronized PullerSettings getInstance() {
        if (sInstance == null) {
            sInstance = new PullerSettings();
        }
        return sInstance;
    }

    @Override
    public PullerSettings getState() {
        return this;
    }

    @Override
    public void loadState(PullerSettings pullerSettings) {
        XmlSerializerUtil.copyBean(pullerSettings, this);
    }

    public String getDestinationDirPath() {
        return mDestinationDirPath;
    }

    public void setDestinationDirPath(String destinationDirPath) {
        mDestinationDirPath = destinationDirPath;
    }

    public void setAdbPath(String adbPath) {
        mAdbPath = adbPath;
    }

    public String getAdbPath() {
        return mAdbPath;
    }
}

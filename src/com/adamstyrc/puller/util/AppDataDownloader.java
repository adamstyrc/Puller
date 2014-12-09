package com.adamstyrc.puller.util;

import com.adamstyrc.puller.PullerSettings;

public class AppDataDownloader {

    private static final String ANDROID_DATA_CACHE_PATH = "/sdcard/pullerCache/";

    public void download() {
        PullerSettings pullerSettings = PullerSettings.getInstance();
        String destinationPath = pullerSettings.getDestinationDirPath();

        AdbCommandExecutor commandExecutor = new AdbCommandExecutor("/Users/adamstyrc/utils/");
        commandExecutor.createCacheDir();
        commandExecutor.pullData(ANDROID_DATA_CACHE_PATH, destinationPath);
        commandExecutor.removeCacheDir(ANDROID_DATA_CACHE_PATH);
    }
}

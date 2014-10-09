package com.adamstyrc.puller.util;

import com.adamstyrc.puller.PullerSettings;

public class AppDataDownloader {

    private static final String ANDROID_DATA_CACHE_PATH = "/sdcard/pullerCache/";

    public void download() {
        String destinationPath = PullerSettings.getInstance().getDestinationDirPath();

        AdbCommandExecutor commandExecutor = new AdbCommandExecutor();
        commandExecutor.createCacheDir();
        commandExecutor.pullData(ANDROID_DATA_CACHE_PATH, destinationPath);
        commandExecutor.removeCacheDir(ANDROID_DATA_CACHE_PATH);
    }
}

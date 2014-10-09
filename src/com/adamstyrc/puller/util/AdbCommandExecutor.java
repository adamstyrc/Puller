package com.adamstyrc.puller.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdbCommandExecutor {

    public void pullData(String srcFilePath, String dstFilePath) {
        String command = "adb pull " + srcFilePath + " " + dstFilePath;
        executeCommand(command);
    }

    public void createCacheDir() {
        String command = "adb shell am broadcast -a pl.adamstyrc.puller.intent.DEBUG --es sms_body \"test from adb\"";
        executeCommand(command);
    }

    public void removeCacheDir(String filePath) {
        String command = "adb shell rm -r " + filePath;
        executeCommand(command);
    }

    public String executeCommand(String command) {
        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}

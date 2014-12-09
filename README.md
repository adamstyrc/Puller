Puller
======

IntelliJ Plugin which enables you quick download your Android applications internal data files. 

======

1. Add puller-android-1.0.jar to your Android project dependencies.
2. Register broadcast receiver component in AndroidManifest.xml:
```
<receiver
    android:name="com.adamstyrc.puller.debugutils.PullerReceiver"
    android:enabled="true"
    android:exported="true" >
    <intent-filter>
        <action android:name="pl.adamstyrc.puller.intent.DEBUG"></action>
    </intent-filter>
</receiver>
```
3. Open Puller tab in IntelliJ/Android Studio and pull the data. The data will be downloaded to selected path on your desktop disc.

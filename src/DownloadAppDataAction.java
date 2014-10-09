import com.adamstyrc.puller.util.AppDataDownloader;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class DownloadAppDataAction extends AnAction {
    public void actionPerformed(AnActionEvent e) {
        AppDataDownloader downloader = new AppDataDownloader();
        downloader.download();
    }
}

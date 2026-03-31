//2. Реализуйте интерфейс “Task” для скачивания указанного файла из
//интернета. Ссылку на файл можно взять произвольную. При вызове
//метода start() начните скачивание, а при вызове метода stop() прекратите.
//Если скачивание не завершено, то необходимо очистить занятые ресурсы.
//Для выполнения задания рекомендуется использовать классы
//“java.io.BufferedInputStream” и “java.io.FileOutputStream”.

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload implements Task {
    private static final String DOWNLOAD_URL = "https://www.cs.mcgill.ca/~akroit/math/compsci/Cormen%20Introduction%20to%20Algorithms.pdf";
    private Thread downloadThread;

    public void downloadFile(String fileUrl, String savePath)
            throws MalformedURLException, URISyntaxException {

        URL url = new URI(fileUrl).toURL();
        try (BufferedInputStream bis = new BufferedInputStream(url.openStream());
             FileOutputStream fos = new FileOutputStream(savePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer, 0, 1024)) != -1) {
                if (Thread.currentThread().isInterrupted()) {
                    fos.close();
                    bis.close();
                    Files.delete(Paths.get(savePath));
                    break;
                }
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start() {
        downloadThread = new Thread(() -> {
            try {
                downloadFile(DOWNLOAD_URL, "savedFile.pdf");
            } catch (MalformedURLException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finish downloading");
            downloadThread.interrupt();
        });
        System.out.println("Start downloading");
        downloadThread.start();
    }

    @Override
    public void stop() {
        System.out.println("Stop downloading");
        downloadThread.interrupt();
    }
}

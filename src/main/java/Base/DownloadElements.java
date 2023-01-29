package Base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadElements {
    URL websiteUrl;
    ReadableByteChannel rbc;
    FileOutputStream outputStream;
    public void downloadFileFromUrl(String url) throws IOException {
        websiteUrl=new URL(url);
        rbc= Channels.newChannel(websiteUrl.openStream());
        outputStream=new FileOutputStream("download.html");
        outputStream.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
        closeFile();
    }
    public void closeFile() throws IOException {
        outputStream.close();
        rbc.close();
    }

//    public static void main(String[] args) throws IOException {
//
//        DownloadElements downloadElements=new DownloadElements();
//        downloadElements.downloadFileFromUrl("https://www.google.co.in");
//    }
}

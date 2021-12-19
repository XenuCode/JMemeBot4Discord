import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.*;

public class MemeController {
    private String memeDirectory="";

    public void setMemeDirectory(String memeDirectory) {
        this.memeDirectory = memeDirectory;
    }

    List<String> memes=new ArrayList<>();
    private int lastnumber=919129312;
    public MemeController(String memeDirectory)
    {
        this.memeDirectory =memeDirectory;
        loadListOfFilesToCashe();

    }

    public String getRandomMeme(){
        if(memes==null){
            loadListOfFilesToCashe();
        }
       return memes.get(pseudoRandomNonReapeatableNumber());

    }
    private int pseudoRandomNonReapeatableNumber(){
        int number;
        while (true){
            System.out.println(memes.size());
            number = new Random().nextInt(memes.size());
            if(lastnumber!=number)
            {
                lastnumber=number;
                return number;
            }
        }

    }
    private void loadListOfFilesToCashe(){
        File directoryPath = new File(memeDirectory);
        //List of all files and directories
        System.out.println("loading to cache");
        //if(directoryPath.list()!=null){
            System.out.println("loaded");
            memes.addAll(Arrays.asList((directoryPath.list())));
        //}

    }

    public void refreshCashe() {
        loadListOfFilesToCashe();
    }
    public void addMeme(String url) throws IOException {
        //ReadableByteChannel readChannel = Channels.newChannel(new URL(url).openStream());
        UUID uuid=UUID.randomUUID();

        downloadFile(url,memeDirectory+"/"+ uuid + url.substring(url.lastIndexOf(".")));
        //FileOutputStream fileOS = new FileOutputStream(memeDirectory+"/"+ uuid + url.substring(url.lastIndexOf(".")));
        //FileChannel writeChannel = fileOS.getChannel();
        //writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
        memes.add(memeDirectory+"/"+ uuid);
    }
    private void downloadFile(String downloadURL,String destinationURL){
        ReadableByteChannel readableChannelForHttpResponseBody = null;
        FileChannel fileChannelForDownloadedFile = null;

        try {
            // Define server endpoint
            URL robotsUrl = new URL(downloadURL);
            HttpURLConnection urlConnection = (HttpURLConnection) robotsUrl.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Memebot by Xenu");
            // Get a readable channel from url connection
            readableChannelForHttpResponseBody = Channels.newChannel(urlConnection.getInputStream());

            // Create the file channel to save file
            FileOutputStream fosForDownloadedFile = new FileOutputStream(destinationURL);
            fileChannelForDownloadedFile = fosForDownloadedFile.getChannel();

            // Save the body of the HTTP response to local file
            fileChannelForDownloadedFile.transferFrom(readableChannelForHttpResponseBody, 0, Long.MAX_VALUE);

        } catch (IOException ioException) {
            System.out.println("IOException occurred while contacting server.");
        } finally {

            if (readableChannelForHttpResponseBody != null) {

                try {
                    readableChannelForHttpResponseBody.close();
                } catch (IOException ioe) {
                    System.out.println("Error while closing response body channel");
                }
            }

            if (fileChannelForDownloadedFile != null) {

                try {
                    fileChannelForDownloadedFile.close();
                } catch (IOException ioe) {
                    System.out.println("Error while closing file channel for downloaded file");
                }
            }

        }
    }
}

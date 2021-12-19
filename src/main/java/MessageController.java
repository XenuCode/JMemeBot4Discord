import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.*;
import java.io.File;
import java.io.IOException;

public class MessageController extends ListenerAdapter {

    private MemeController memeController;
    private SettingsData settingsData;
    public MessageController(SettingsData settingsData,MemeController memeController) {
        this.memeController=memeController;
        this.settingsData=settingsData;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if(!event.getAuthor().isBot()){
            System.out.println("ITS not BOT");
            switch (event.getMessage().getContentRaw()){
                case "!addmeme":
                {
                    addMeme(event);
                }break;
                case "!help":
                {
                    help(event);
                }break;
                case "!meme":
                {
                    sendMeme(event);
                }
                break;
            }
        }
        else {
            System.out.println("BOOOOOOOT");
        }


    }
    void sendMeme(MessageReceivedEvent event){
        MessageChannel channel= event.getChannel();
        String meme = new String(memeController.getRandomMeme());
        channel.sendMessage("Here yo go, meme for you").addFile(new File(settingsData.getMemePath()+"/"+meme)).queue();
        System.out.println("Sending response");
    }
    void help(MessageReceivedEvent event){
        MessageChannel channel= event.getChannel();
        channel.sendMessage("Commands are the following: \n" +
                "```!meme      : gives you a random meme \n" +
                "!addmeme   : adds a new meme to our collection (it can't be NSFW + you need to attach a file)\n" +
                "!help      : shows all commands``` \n" +
                "*Xenu*").queue();
    }
    void addMeme(MessageReceivedEvent event){
        MessageChannel channel= event.getChannel();
        String imageUrl = null;
        float val = 0;
        try
        {
            imageUrl = event.getMessage().getAttachments().get(0).getUrl();
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"url\": \""+ imageUrl +"\"}");
            Request request = new Request.Builder()
                    .url("https://nsfw-image-classification1.p.rapidapi.com/img/nsfw")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("x-rapidapi-host", "nsfw-image-classification1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", settingsData.getKey())
                    .build();

        String response = client.newCall(request).execute().body().string();
        response= response.substring(response.indexOf(":")+2,response.lastIndexOf("}"));
        val = Float.parseFloat(response);

        }catch (Exception e){
            e.printStackTrace();
            channel.sendMessage("Your meme could not be processed").queue();
        }
        if(val<0.6){

            channel.sendMessage("Meme accepted, thanks for contribution").queue();
            try {
                memeController.addMeme(imageUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println(val);
            channel.sendMessage("Hye hey Hye no NSFW content there or you will get banned").queue();
        }
    }
}

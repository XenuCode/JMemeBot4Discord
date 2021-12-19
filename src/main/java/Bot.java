import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class Bot{
    SettingsData settingsData;
    public Bot(SettingsData settingsData){
        this.settingsData = settingsData;
    }
    MemeController memeController;

    public void start(){
        memeController= new MemeController(settingsData.getMemePath());
        //memeController.setMemeDirectory(settingsData.getMemePath());
        System.out.println("memepath = "+settingsData.getMemePath());


        System.out.println("LESSAGO");
        try {
        JDA jda = JDABuilder.createDefault(settingsData.getBotToken()).setActivity(Activity.watching("memes")).build();
            SettingsController settingsController = new SettingsController();
            settingsController.loadSettings();
            jda.addEventListener(new MessageController(settingsController.getSettingsData(),memeController));
    } catch (
    LoginException e) {
        e.printStackTrace();
    }
}
}

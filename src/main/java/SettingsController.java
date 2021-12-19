import java.io.*;

public class SettingsController {
private SettingsData settingsData = new SettingsData();
public SettingsController(){

}
public void loadSettings(){
    try {
        File f = new File("settings.txt");
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        settingsData.setBotToken(bufferedReader.readLine());
        settingsData.setMemePath(bufferedReader.readLine());
        settingsData.setNsfwThreshold(Float.parseFloat(bufferedReader.readLine()));
        settingsData.setKey(bufferedReader.readLine());
    }
    catch (Exception e)
    {
        System.out.println("create file settings.txt with token, meme, nsfw detection thresshold and RAPID api (https://rapidapi.com/inferdo/api/nsfw-image-classification1/) key path in each line respectively example :");
        System.out.println("ADAkaskas-dfsd.sdfajsdjaskdasdsjka <discord bot token");
        System.out.println("/home/xenu/memes <path to memes");
        System.out.println("0.65 <threshold");
        System.out.println("ad0asd912jjk101l23 <rapidapi key");
    }
}

    public SettingsData getSettingsData() {
        return settingsData;
    }
}

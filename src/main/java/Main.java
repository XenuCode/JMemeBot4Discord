import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) {
        SettingsController settingsController = new SettingsController();
        settingsController.loadSettings();
        Bot bot = new Bot(settingsController.getSettingsData());
        System.out.println(settingsController.getSettingsData().getMemePath());
        bot.start();
    }
}
public class SettingsData {
    private String memePath,botToken,key;
    private float nsfwThreshold;



    public String getMemePath() {
        return memePath;
    }

    public void setMemePath(String memePath) {
        this.memePath = memePath;
    }

    public String getBotToken() {
        return botToken;
    }

    public float getNsfwThreshold() {
        return nsfwThreshold;
    }

    public void setNsfwThreshold(float nsfwThreshold) {
        this.nsfwThreshold = nsfwThreshold;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}


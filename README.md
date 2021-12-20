
# JMemeBot4Discord

### Simple and lightweight MemeBot for discord made completely in Java !

#### Simply add bot to your server by clicking [this link](https://discord.com/oauth2/authorize?client_id=918819630913568789&scope=bot&permissions=517544069184)

### How to Deploy
There is no official windows and MacOS support !

####
- Download `JMemeBot4Discord.jar` into your final destination
- Install the latest `java 8`
    - Arch based distros: `sudo pacman -S jre8-openjdk`
    - Ubuntu based distros: `sudo apt install openjdk-8-jre`
    - Windows `install java 8 like a normie from oracle or something`

#### Gather data
- Get discord bot token
- Set up a folder where memes will be located
- Get RAPID-API [nsfw classification ](https://rapidapi.com/inferdo/api/nsfw-image-classification1/) token
- Fine tune sensitivity for NSFW content filtration using this api (values from 0.0 to 1.0)

#### Enter gathered data into config file
1. Create File named settings.txt in the same directory as `JMemeBot4Discord.jar`
2. Open file and input data in this order without any spaces tabs in form shown below (do NOT write <some comment> inside of file)

``` 
aSJdaskdjak48Jii9aklsdAi.gdfg4A43.d-dskoASK458GNUIA84ha <this is bot token>
/home/user/memebot/memes                                <this is memepath use / dashes for folder separation>
0.65                                                    <this is NSFW content filtration value>
238r3iu4h2hzsl84jifhuyg76rgdj4u6uz                      <this is NSFW classification api key > 
```

3. Save file and run `JMemeBot4Discord.jar` with `java -jar JMemeBot4Discord.jar`

## How to Use

- `!meme` shows you random meme
- `!addmeme` lets you add meme (you need to attach image or gif to it)
- `!help` writes helpful information

## License

[MIT](https://choosealicense.com/licenses/mit/)


## Acknowledgements

- #### This bot uses the best java discord api library: [JDA]( https://github.com/DV8FromTheWorld/JDA) 


# JMemeBot4Discord

### Simple and lightweight MemeBot for discord made completly in java !
### How to use
Threre is no official windows and MacOS support !

####
- Download `memebot.jar` into your final destination
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
1. Create File named settings.txt in the same directory as `memebot.jar`
2. Open file and input data in this order wihtout any spaces tabs in form shown below (do NOT write <some comment> inside of file)


``` aSJdaskdjak48Jii9aklsdAi.gdfg4A43.d-dskoASK458GNUIA84ha <this is bot token>
/home/user/memebot/memes                                <this is memepath use / dashes for folder separation>
0.65                                                    <this is NSFW content filtration value>
238r3iu4h2hzsl84jifhuyg76rgdj4u6uz                      <this is NSFW classification api key > 
```

3. Save file and run `memebot.jar` with `java -jar memebot.jar`

## License

[MIT](https://choosealicense.com/licenses/mit/)


## Acknowledgements

- #### This bot uses the best java discord api library: [JDA]( https://github.com/DV8FromTheWorld/JDA) 

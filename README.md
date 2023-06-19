# LazyBot

**LazyBot** is an actively developing Open Source framework, which is designed to:
- Lower the entry level into telegram bot development;
- Give development of telegram bots a certain shape;
- Introduce standards for creating telegram bots in Java environment.

These goals are achieved by the fact that when creating telegram bots using the LazyBot framework:
- You no longer need to learn the Telegram Bot API;
- To describe your bot's functionality you use an xml file whose structure must correspond to bot.xsd;
- Has specific extension points with which you can add functionality to suit your needs without breaking the original structure.

### Additional repositories:
- The [java-telegram-bot-api](https://github.com/pengrad/java-telegram-bot-api) is used to get data from telegram.
- [JaxpToObjects](https://github.com/Rillde/JaxpToObjects) is used to map xml elements to Java classes.

## Download
[JAR on release page](https://github.com/Rillde/LazyBot/releases)

## Example of a simple bot  
In this simple example, let's create a bot that will be able to respond to certain commands sent to it by the user via simple text messages, menus and still be able to return to the past responses of the bot.

### bom.xml:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Bot token="123" xmlns="http://lazybot.ru"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://lazybot.ru bom.xsd">
    <Replies after="/start">
        <Reply>
            <Message>
                <Text>Hello world!</Text>
            </Message>
        </Reply>
        <Reply>
            <Menu>
                <Text>This is a sample menu</Text>
                <ButtonsArray>
                    <Button>
                        <ButtonLabel>Button1</ButtonLabel>
                        <Callback>butt1</Callback>
                    </Button>
                </ButtonsArray>
            </Menu>
        </Reply>
    </Replies>
    <Replies after="butt1">
        <Reply>
            <Menu>
                <Text>You pressed "Button1"</Text>
                <ButtonsArray>
                    <BackButton>
                        <ButtonLabel>Back</ButtonLabel>
                        <Count>1</Count>
                    </BackButton>
                </ButtonsArray>
            </Menu>
        </Reply>
    </Replies>
</Bot>
```
### Java Bot application:
```java
// Create a new LazyBot object
LazyBotTG botTG = new LazyBotTG(inputStream);
// or
LazyBotTG botTG = new LazyBotTG("filePath");

// Running the bot
botTG.start();

// Basically, you don't have to do anything else.
// It's easy enough :)
```
As you can see, we were able to create a simple telegram bot using a couple of lines in an xml file and in our Java application. You may think that even this is already too much, but let's look at the things that we managed to avoid thanks to the use of the LazyBot framework:
- Open and start studying the Telegram Bot API documentation;
- Go into the implementation of [java-telegram-bot-api](https://github.com/pengrad/java-telegram-bot-api);
- Think over the architecture of our code in such a way that in the future it will be easily changeable;
- Refactor the structure of the code that we managed to create, but realized that it would not suit us in the future.  
  
However, in the future we can add/change a couple of lines in our xml file and at the same time add new functionality for the bot or completely change it.

## [Documentation](https://github.com/Rillde/LazyBot/wiki)

## License
Apache-2.0
# LazyBot
LazyBot is a framework for writing telegram bots.
All you need to do is describe the bot structure with an xml file and __bom.xsd__ xml schema connected to it and integrate LazyBot into your project.

### Additional repositories:
- The [java-telegram-bot-api](https://github.com/pengrad/java-telegram-bot-api) is used to get data from telegram.
- [JaxpToObjects](https://github.com/Rillde/JaxpToObjects) is used to map xml elements to Java classes.

### Features:
- Telegram bot is created using an xml file.
- No knowledge of the telegram bot api required.
- It is possible to save incoming messages.
- Easy to extend.

## Download
[JAR on release page](https://github.com/Rillde/LazyBot/releases)

## Example of a simple bot:

### bom.xml:
```xml
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
                    <ButtonLabel>Зарегистрироваться на фестиваль</ButtonLabel>
                    <Callback>StartReg</Callback>
                </Button>
                <BackButton>
                    <ButtonLabel>Back</ButtonLabel>
                    <Count>3</Count>
                </BackButton>
            </ButtonsArray>
        </Menu>
    </Reply>
</Replies>
```

### Java:
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

## [Documentation](https://github.com/Rillde/LazyBot/wiki)

## License
Apache-2.0
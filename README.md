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
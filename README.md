# ft-pix4d-demo

This test factory based on Serenity BDD and it is for a demo purpose for Pix4d

## Project Copy from

https://github.com/serenity-bdd/serenity-cucumber-starter

## Docker

To run Chrome use
```
docker-compose up -d
```

To connect to the VNC. The password is `secret`.
```
vnc://127.0.0.1
```

To stop docker
```
docker-compose down
```

### More info
More info on how to build latest version and other browser check this link
```
https://github.com/SeleniumHQ/docker-selenium
```

## Run test
Before running ensure to have the chrome docker up.

### Use Gradle

Open a command window and run:
```
gradle test
```
This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(CucumberWithSerenity.class)` annotation on the `CucumberTestSuite`
class tells JUnit to kick off Cucumber.

### Clean build
Open a command window and run:
```
gradle clean test
```

### Run specific tags
Update in 'build.gradle' the test section. Assuming we want to run only `@OnDemandTest` tag:

```
test {
    //..
    systemProperty 'cucumber.options' ,  '-t @OnDemandTest'

}
```
Also you can find predefined gradle task that run specific tags. Example 
* `gradle clean smokeTest` runs tag `@FTSmokeTest`

## Screen sizing
To set the screen sizing during the test and also the size of the screenshot taken, you could update the size in `serenity.preperties` file
```
serenity.browser.width=1440
serenity.browser.height=1200
```

## Serenity Documentation
For the full documentation of Serentiy BDD framework check the link
```
http://thucydides.info/docs/serenity-staging/
https://github.com/serenity-bdd/serenity-demos/tree/master/cucumber-webtests
```

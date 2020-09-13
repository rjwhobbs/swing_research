# swingy
Swingy , project from the 42 project curriculum.

To build you will need maven, https://maven.apache.org/install.html

Build: `$ mvn clean package`

run: `$ java -jar target/swing.jar <option>`

Options are either `console` or `gui`.

This project was built and tested on macOS using JDK14 and a potato running linux with JDK8

You may get this error `Exception in thread "main" java.awt.AWTError: Assistive Technology not found` 
on linux. This is due to using OpenJDK headless.

run `$ sudo dpkg -l | grep openjdk` to confirm you are using a headless version of java

remove `$ sudo apt-get remove openjdk-8-jre-headless`

and install `sudo apt-get install openjdk-8-jre`

Thanks to this post https://askubuntu.com/questions/695560/assistive-technology-not-found-awterror

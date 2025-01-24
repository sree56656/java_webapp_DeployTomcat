Purpose: The project is a simple web application that allows users to say hello
to each other. The application has a simple user interface with a
tag that displays the greeting message. The application also has a
tag that allows users to enter their name and a button that sends the
name to the server. The server then responds with a greeting
message that is displayed on the page.

Steps:
1. setup the tomcat env variable as CATALINA_HOME then add %CATALINA_HOME%/bin in PATH variable.
2. javac -cp "%CATALINA_HOME%\lib\servlet-api.jar" -d ../webapp/WEB-INF/classes com/example/HelloServlet.java - to compile the code
3. jar -cvf webapp.war -C ../webapp . - to build the code it generates webapp.jar file in current dir
4. copy webapp.war to tomcat webapps directory
5. start tomcat using startup.bat from tomcat/bin path
6. http://localhost:8080/webapp - to view the application


folder structure:

MyWebApp/
├── src/
│   ├── main/
│       ├── java/
│           └── com/
│               └── example/
│                   └── HelloServlet.java
│       ├── webapp/
│           ├── WEB-INF/
│               └── web.xml
│           └── index.jsp


problems faced:
1. C:\apache-tomcat-10.1.34\bin>startup.bat
The JAVA_HOME environment variable is not defined correctly.
JAVA_HOME=C:\Users\Sree\.jdks\openjdk-18.0.1.1\bin
NB: JAVA_HOME should point to a JDK not a JRE. 
Sol'n : it solves with setting up the java env variable properly.

2. java>javac -d ../../webapp/WEB-INF/classes com/example/HelloServlet.java
com\example\HelloServlet.java:4: error: package javax.servlet does not exist
import javax.servlet.ServletException;
                    ^
com\example\HelloServlet.java:5: error: package javax.servlet.annotation does not exist
import javax.servlet.annotation.WebServlet;
                               ^
com\example\HelloServlet.java:6: error: package javax.servlet.http does not exist
import javax.servlet.http.HttpServlet;

Sol'n: 
modify below code into \webapp\src\main\java\com\example\HelloServlet.java

package com.example;

import java.io.IOException;
import jakarta.servlet.ServletException; // Change here
import jakarta.servlet.annotation.WebServlet; // Change here
import jakarta.servlet.http.HttpServlet; // Change here
import jakarta.servlet.http.HttpServletRequest; // Change here
import jakarta.servlet.http.HttpServletResponse; // Change here

3. java.lang.IllegalStateException: Error starting child at org.apache.catalina.core.ContainerBase.addChildInternal(ContainerBase.java:602) at

sol'n:

It is because of conflict at web.xml and HelloServlet.java.
in web.xml, modifying hello to helloworld like below will resolve the issue.
<servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/helloWorld</url-pattern>
    </servlet-mapping>
**Project setup**

**Prerequisites:**
-Install IntelliJ
-Install Java (get for e.g. JDK 11) *it was used OpenJDK-11 
-Add Java to path - Windows (JAVA_HOME=path\to\your\jdk\jdk-11)
-Install maven (e.g. 3.6.3)
-Add maven to path: (MAVEN_HOME=path\to\your\maven_dir\apache-maven-3.6.3)
		    (M2_HOME=path\to\your\maven_dir\apache-maven-3.6.3)
-Add next values to path variable: ;%M2_HOME%\bin; and ;%JAVA_HOME%\bin;
-Use git to clone repository
-Download ChromeDriver, unzip it and place it to SeleniumProject\src\test\java\Utils
-Add ChromeDriver to path variable (;path\to\SeleniumProject\src\test\Utils;) 
-Open project with IntelliJ 
-Update ChromeDriver path in ..\Utils\InitiateDriver with path to your ChromeDriver (do not forget .exe at the end of path if you are using Win)
(example of path "path\to\project\\SeleniumProject\\src\\test\\java\\Utils\\chromedriver.exe")

You can run all tests by running RegressionSuite.xml file or run them one by one from java class files (ProductTest and RegistrationTest)

For running headlessly, uncomment line 18 (`options.addArguments("headless");`) in file ..\Utils\InitiateDriver 
After that, open terminal, navigate to project dir (cd SeleniumProject) and type `mvn test`
RegressionSuite.xml will be run by default
Report can be found at SeleniumProject\target\emailable-report
package properties;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser");
        System.out.println(browser); // null
    }

    @Test
    void systemProperties1Test() {
        System.setProperty("browser", "chrome"); // System - некое внутреннее хранилище ключ значение. Это для того, чтобы забрать значение переменной извне. В тестах это лучше не использовать.
        String browser = System.getProperty("browser");

        System.out.println(browser);
    }

    @Test
    void systemProperties2Test() {
        String browser = System.getProperty("browser", "mozilla"); // def - a default value. Если в selenide не передать браузер, он по дефолту возьмет хром. В данном случае у нас по дефолту будет moziila.

        System.out.println(browser);
    }

    @Test
    void systemProperties3Test() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "mozilla"); // def - a default value. Если в selenide не передать браузер, он по дефолту возьмет хром. В данном случае у нас по дефолту будет moziila.

        System.out.println(browser);
    }

    @Test
    @Tag("jenkinsProperties")
    void systemProperties4Test() {
        String browser = System.getProperty("browser", "mozilla");

        System.out.println(browser);

//        gradle jenkins_properties -Dbrowser=chrome
    }

    @Test
    @Tag("hello")
    void systemProperties5Test() {
        String name = System.getProperty("name", "default student");
        String message = format("Hello, %s!", name);

        System.out.println(message);

        // gradle hello_test -Dname="Loh Cvetochnii"

    }
}

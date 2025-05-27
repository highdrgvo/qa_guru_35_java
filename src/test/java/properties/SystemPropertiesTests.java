package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser");
        System.out.println(browser); // null
    }

    @Test
    @Tag("jenkinsProperties")
    void systemProperties1Test() {
        System.setProperty("browser", "chrome"); // System - некое внутреннее хранилище ключ значение. Это для того, чтобы забрать значение переменной извне. В тестах это лучше не использовать.
        String browser = System.getProperty("browser");

        System.out.println(browser);
    }

    @Test
    @Tag("jenkinsProperties")
    void systemProperties2Test() {
        String browser = System.getProperty("browser", "mozilla"); // def - a default value. Если в selenide не передать браузер, он по дефолту возьмет хром. В данном случае у нас по дефолту будет moziila.

        System.out.println(browser);
    }

    @Test
    @Tag("jenkinsProperties")
    void systemProperties3Test() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "mozilla"); // def - a default value. Если в selenide не передать браузер, он по дефолту возьмет хром. В данном случае у нас по дефолту будет moziila.

        System.out.println(browser);
    }
}

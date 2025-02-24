package org.luis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        // SeleniumFirstScript();
        GoogleTest();
    }

    static final String OK_COOKIES = "L2AGLb";

    static void GoogleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.es/");

        String title = driver.getTitle();
        System.out.println(title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement aceptarTodo = driver.findElement(By.id(OK_COOKIES));
        aceptarTodo.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement iniciarSesion = driver.findElement(By.className("gb_Ua gb_zd gb_qd gb_hd"));

        /*
        <a class="gb_Ua gb_zd gb_qd gb_hd" aria-label="Iniciar sesión" href="https://accounts.google.com/ServiceLogin?hl=es&amp;passive=true&amp;continue=https://www.google.es/&amp;ec=futura_ctr_og_so_72776761_p" target="_top"><span class="gb_Td">Iniciar sesión</span></a>
         */
        iniciarSesion.click();

        System.out.println(driver.getTitle());

        driver.quit();
    }

    static void SetupDriver(String url) {

    }

    static void SeleniumFirstScript() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        System.out.println("Title test: " + title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));



        textBox.sendKeys("42 42 42 42");
        submitButton.click();

        String newTitle = driver.getTitle();
        System.out.println("New title test: " + newTitle);

    }
}
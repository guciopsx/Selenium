import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
    }

    private WebDriver browser = new FirefoxDriver();

    private static String QUALIFICATIONS_LACK = "Brak kwalifikacji";
    private static String JUNIOR = "Junior";
    private static String GNOME = "Skrzat";
    private static String YOUNGSTER = "Mlodzik";
    private static String ADULT = "Dorosly";
    private static String SENIOR = "Senior";
    private static String ERROR = "Blad danych";

    private static String NAME = "Imię";
    private static String SURENAME = "Nazwisko";

    private String date(int age) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy ");
        LocalDateTime now = LocalDateTime.now();
        now = now.minusYears(age);
        now = now.minusMonths(6);
        return dtf.format(now);
    }


    @Before
    public void runBrowser() {
        browser.get("https://lamp.ii.us.edu.pl/~mtdyd/zawody/");
    }

    @After
    public void closeBrowser() {
        browser.close();
    }

    @Test
    public void test01() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(9));
        clickSubmit();

        assertEquals(QUALIFICATIONS_LACK, getMessage());
    }

    @Test
    public void test02() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(10));
        getParentCheck().click();
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(GNOME, getMessage());
    }

    @Test
    public void test03() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(11));
        getParentCheck().click();
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(GNOME, getMessage());
    }

    @Test
    public void test04() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(12));
        getParentCheck().click();
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(YOUNGSTER, getMessage());
    }

    @Test
    public void test05() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(13));
        getParentCheck().click();
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(YOUNGSTER, getMessage());
    }

    @Test
    public void test06() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(14));
        getParentCheck().click();
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(JUNIOR, getMessage());
    }

    @Test
    public void test07() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(17));
        getParentCheck().click();
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(JUNIOR, getMessage());
    }

    @Test
    public void test08() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(18));
        clickSubmit();

        assertEquals(ADULT, getMessage());
    }

    @Test
    public void test09() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(64));
        clickSubmit();

        assertEquals(ADULT, getMessage());
    }

    @Test
    public void test10() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(65));
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(SENIOR, getMessage());
    }

    @Test
    public void test11() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(15));
        getParentCheck().click();
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(JUNIOR, getMessage());
    }

    @Test
    public void test12() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(15));
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(ERROR, getMessage());
    }

    @Test
    public void test13() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(15));
        getParentCheck().click();
        clickSubmit();

        assertEquals(ERROR, getMessage());
    }

    @Test
    public void test14() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(70));
        getDoctorCheck().click();
        clickSubmit();

        assertEquals(SENIOR, getMessage());
    }

    @Test
    public void test15() {
        getName().sendKeys(NAME);
        getSurname().sendKeys(SURENAME);
        getBrithDate().sendKeys(date(70));
        clickSubmit();

        assertEquals(ERROR, getMessage());
    }

    private WebElement getName() {
        return browser.findElement(By.id("inputEmail3"));
    }

    private WebElement getSurname() {
        return browser.findElement(By.id("inputPassword3"));
    }

    private WebElement getBrithDate() {
        return browser.findElement(By.id("dataU"));
    }

    private WebElement getParentCheck() {
        return browser.findElement(By.id("rodzice"));
    }

    private WebElement getDoctorCheck() {
        return browser.findElement(By.id("lekarz"));
    }

    private String getMessage() {
        browser.switchTo().alert().dismiss();
        String dialogText = browser.switchTo().alert().getText();
        browser.switchTo().alert().dismiss();
        return dialogText;
    }

    private void clickSubmit() {
        browser.findElement(By.cssSelector("button")).click();
    }
}


package org.example.pageClasses;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.utilities.Util;

public class HomePage extends BasePage {
    public WebDriver driver;
    public String translationBtn = "id=>translation-btn";
    public String litePackageID = "id=>name-lite";
    public String classicPackageID = "id=>name-classic";
    public String premiumPackageID = "id=>name-premium";
    public String countryIcon = "id=>country";
    public String country_ae = "id=>ae";
    public String country_td = "id=>td";
    public String country_iq = "id=>iq";
    public String litePriceID = "xpath=>//*[@id=\"currency-lite\"]/b";
    public String classicPriceID = "xpath=>//*[@id=\"currency-classic\"]/b";
    public String premiumPriceID = "xpath=>//*[@id=\"currency-premium\"]/b";
    public String liteCurrencyID = "xpath=>//*[@id=\"currency-lite\"]/i";
    public String classicCurrencyID = "xpath=>//*[@id=\"currency-classic\"]/i";
    public String premiumCurrencyID = "xpath=>//*[@id=\"currency-premium\"]/i";
    boolean isLitePriceCorrect;
    boolean isClassicPriceCorrect;
    boolean isPremiumPriceCorrect;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void changeLanguageToEnglish() {
        elementClick(translationBtn, "Click Translate");
    }

    private void changeCountry(String locator, String info) {
        elementClick(countryIcon, "Country Icon");
        elementClick(locator, info);
    }

    private void verifyPackageType() {
        String litePackage = getText(litePackageID, "first package");
        Util.verifyTextMatch(litePackage, "LITE");

        String classicPackage = getText(classicPackageID, "second package");
        Util.verifyTextMatch(classicPackage, "CLASSIC");

        String premiumPackage = getText(premiumPackageID, "third package");
        Util.verifyTextMatch(premiumPackage, "PREMIUM");
    }

    private void verifyPackageCurrency() {
        String liteCurrency = getText(liteCurrencyID, "get Lite currency");
        Util.verifyTextContains(liteCurrency, "USD");

        String classicCurrency = getText(classicCurrencyID, "get Classic currency");
        Util.verifyTextContains(classicCurrency, "USD");

        String premiumCurrency = getText(premiumCurrencyID, "get Premium currency");
        Util.verifyTextContains(premiumCurrency, "USD");
    }

    public boolean validateUAESubPackages() {
        changeCountry(country_ae, "Choose UAE Country");

        //Validate Subscription Packages Types
        verifyPackageType();

        //Validate Subscription Packages Price
        String litePrice = getText(litePriceID, "get Lite Price");
        isLitePriceCorrect = Util.verifyTextContains(litePrice, "5.4");

        String classicPrice = getText(classicPriceID, "get Classic Price");
        isClassicPriceCorrect = Util.verifyTextContains(classicPrice, "10.9");

        String premiumPrice = getText(premiumPriceID, "get premium Price");
        isPremiumPriceCorrect = Util.verifyTextContains(premiumPrice, "16.3");

        //Validate Subscription Packages Currency
        verifyPackageCurrency();

        if (isLitePriceCorrect && isClassicPriceCorrect && isPremiumPriceCorrect) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateChadSubPackages() {
        changeCountry(country_td, "Choose Chad Country");

        //Validate Subscription Packages Types
        verifyPackageType();

        //Validate Subscription Packages Price
        String litePrice = getText(litePriceID, "get Lite Price");
        isLitePriceCorrect = Util.verifyTextContains(litePrice, "2.4");

        String classicPrice = getText(classicPriceID, "get Classic Price");
        isClassicPriceCorrect = Util.verifyTextContains(classicPrice, "4.8");

        String premiumPrice = getText(premiumPriceID, "get premium Price");
        isPremiumPriceCorrect = Util.verifyTextContains(premiumPrice, "7.2");

        //Validate Subscription Packages Currency
        verifyPackageCurrency();

        if (isLitePriceCorrect && isClassicPriceCorrect && isPremiumPriceCorrect) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateIraqSubPackages() {
        changeCountry(country_iq, "Choose Chad Country");

        //Validate Subscription Packages Types
        verifyPackageType();

        //Validate Subscription Packages Price
        String litePrice = getText(litePriceID, "get Lite Price");
        isLitePriceCorrect = Util.verifyTextContains(litePrice, "2.4");

        String classicPrice = getText(classicPriceID, "get Classic Price");
        isClassicPriceCorrect = Util.verifyTextContains(classicPrice, "4.1");

        String premiumPrice = getText(premiumPriceID, "get premium Price");
        isPremiumPriceCorrect = Util.verifyTextContains(premiumPrice, "6.2");

        //Validate Subscription Packages Currency
        verifyPackageCurrency();

        if (isLitePriceCorrect && isClassicPriceCorrect && isPremiumPriceCorrect) {
            return true;
        } else {
            return false;
        }
    }
}

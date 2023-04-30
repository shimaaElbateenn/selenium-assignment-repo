package testClasses;

import base.BaseTest;
import base.CheckPoint;
import org.example.pageClasses.HomePage;
import org.testng.annotations.Test;


public class PackageTests extends BaseTest {
    @Test
    public void verifyPackageDetails() {
        HomePage homePage = new HomePage(driver);
        homePage.changeLanguageToEnglish();

        boolean UAEResults = homePage.validateUAESubPackages();
        CheckPoint.mark("test-01", UAEResults, "UAE Verify");

        boolean ChadResults = homePage.validateChadSubPackages();
        CheckPoint.mark("test-01", ChadResults, "Chad Verify");

        boolean IraqResults = homePage.validateIraqSubPackages();
        CheckPoint.markFinal("test-01", IraqResults, "Iraq Verify");
    }

}

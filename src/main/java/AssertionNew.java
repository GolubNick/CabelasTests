import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import java.io.File;

import static org.testng.internal.EclipseInterface.*;

@Listeners({ScreenShooter.class})
public class AssertionNew extends Assert{
    public static  double stepNumber = 0.0;

    public void logBusiness(double stepNumber, String message){
        this.stepNumber = stepNumber;
        Reporter.log("<p><font color=\"000000\" style=\"background-color:#C0C0C0\">" + stepNumber + ") " + message + "</font></p>");
    }

    public static void assertTrue(boolean condition, String message) {
        stepNumber += 0.1;
        String step = String.valueOf(stepNumber).split("00")[0];
        String pathFile = takeScreenShot(message.replace(" ",""));
        if(condition) {
            Reporter.log("<p><font color=\"FFFFFF\" style=\"background-color:#228B22\">"
                    +format(Boolean.valueOf(condition), Boolean.TRUE, message, step)+"</font></p>");
            Reporter.log("<p><font color=\"000000\" style=\"background-color:#C0C0C0\">"
                    +"<a href=\"" + pathFile + "\">" + "Screenshot: " + message + "</a></font></p>");

        }
        else {
            Reporter.log("<p><font color=\"000000\" style=\"background-color:#C0C0C0\">"
                    +"<a href=\"" + pathFile + "\">" + "Screenshot: " + message + "</a></font></p>");
            Reporter.log("<p><font color=\"FFFFFF\" style=\"background-color:#FF0000\">"
                    + format(Boolean.valueOf(condition), Boolean.TRUE, message, step) + "</font></p>");
        }
    }

    static String format(Object actual, Object expected, String message, String step) {
        String formatted = "";
        if (null != message) {
            formatted = step + ") " + message + "<br> ";
        }

        return formatted + "Expected: " + expected + CLOSING_CHARACTER +
                "<br>Actual: " + OPENING_CHARACTER + actual + ASSERT_RIGHT + "<br>";
    }

    private static String takeScreenShot(String nameFile){
        File scrFile = null;
//        String pathFile = "D:\\workspace\\provectus\\test-output\\html\\" + nameFile + System.currentTimeMillis() / 1000L + ".png";
        try {
            scrFile = Screenshots.takeScreenShotAsFile();
//            FileUtils.copyFile(scrFile, new File(pathFile));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(scrFile.getAbsolutePath());
        return scrFile.getAbsolutePath();
    }
}

package org.demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.URL;

import static org.openqa.selenium.By.*;

public class SmartTVTest {

    public AndroidDriver driver;
    /*
    Implement a new class called Secret.java with the following:

package org.demo;
public class Secret extends Credentials {
    Secret() {
        this.setUsername("[BrowserStack User]");
        this.setAccess_key("[BrowseStack Access Key]");
    }
}
    It will be called by the Credentials constructor.
    It should be included in the .gitignore and not be pushed to a repo.
     */
    public Secret secret = new Secret();

    @BeforeMethod(alwaysRun=true)
    public void setUp() throws Exception {

        MutableCapabilities caps = new UiAutomator2Options();
        caps.setCapability("build", "Smart TV Test");
        //caps.setCapability("deviceName", "Amazon Fire TV Stick 4K");
        //caps.setCapability("osVersion", "7.1");
        caps.setCapability("deviceName", "Nvidia Shield TV Pro 2019");
        caps.setCapability("osVersion", "11.0" );
        caps.setCapability("developerName", "Kenton");
        caps.setCapability("appium:browserstack.dedicatedDevice", true);
        caps.setCapability("app", "bs://60900b07f2a370ebb40da7293ad873c4e96a2f97");

        driver = new AndroidDriver(new URL("https://" +
                secret.getUsername() + ":" + secret.getAccess_key() +
                "@hub.browserstack.com/wd/hub"), caps);

    }

    @Test (enabled = false)
    public void testLB() throws Exception {
        Thread.sleep(7000);
        driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(7000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.amazon.tv.leanbacklauncher:id/list\").instance(1)")).click();
        Thread.sleep(7000);
        driver.findElement(AppiumBy.id("com.amazon.tv.leanbacklauncher:id/banner_icon")).click();
        Thread.sleep(7000);
        Assert.assertTrue(true);
    }
    @Test(enabled = true)
    public void testKenton() throws Exception {
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_CENTER));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_LEFT));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_LEFT));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_RIGHT));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_RIGHT));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_RIGHT));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_RIGHT));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_CENTER));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_RIGHT));

        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_CENTER));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_CENTER));
        Thread.sleep(10000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.MEDIA_PLAY_PAUSE));

        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void testSmartTv() throws Exception {
        String videoName = "";
        String focusedVideoName = "";

        boolean isFrameLayout = true;

        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_DOWN));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_RIGHT));


        if(isFrameLayout) {
            videoName = driver.findElement(xpath("//android.widget.FrameLayout[@focused='true']"))
                    .getAttribute("content-desc");
            System.out.println("Selected Video Name: " + videoName);
        }

        driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_CENTER));
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.MEDIA_PLAY_PAUSE));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.MEDIA_PLAY_PAUSE));
        Thread.sleep(8000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.MEDIA_REWIND));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));

        if(isFrameLayout) {
            focusedVideoName = driver.findElement(xpath("//android.widget.FrameLayout[@focused='true']"))
                    .getAttribute("content-desc");

            if (focusedVideoName.equals(videoName)) {
                System.out.println("Video played - Test passed");
            } else {
                System.out.println("Video could not be played - Test failed");
            }
            Assert.assertEquals(focusedVideoName, videoName);
        } else {
            Assert.assertTrue(!isFrameLayout);
        }
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}

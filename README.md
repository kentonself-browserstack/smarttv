## SmartTV demo
This demo script runs a demo of a SmartTV app in BrowserStack

To Run:

1. Pull this Repo
2. Create a class in src/test/org/demo called Secret.java that contains

       package org.demo;
       public class Secret extends Credentials {
           Secret() {
              this.setUsername("[BrowserStack User]");
              this.setAccess_key("[BrowseStack Access Key]");
           }
       }

(Replace the strings above with user credentials)

3. Upload the Leakback.apk
4. Change the app url in SmartTVTest.java
5. Run mvn test
6. See the results in BrowserStack AppAutomate



   

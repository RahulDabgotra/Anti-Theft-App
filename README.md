# Anti-Theft-App
## Lost phone recovery android app using SIM's IMSI number 
Anti-Theft App is a project which helps us to trace smartphones. It consists of an Android client application that will automatically send SMS when the SIM card is changed.

![Initial App Setup](https://user-images.githubusercontent.com/43419632/143008413-9c58db6f-c8a8-4b7f-aaf9-e0ef5d9dfd94.png)

- Once our application is installed onto a mobile phone and an alternate number is fed into the software (ATA). The owner’s SIM card gets registered in the database which is hosted in the cloud.
- Whenever the phone is rebooted, ATA is invoked in stealth mode and verifies whether the SIM card present in the mobile phone is of the owner. If the SIM belongs to the owner (registered in the database), the software doesn’t do any activity. 
- But, if SIM has been changed and that SIM is not registered in the database then, ATA sends a message to the alternate mobile number (friends/relatives number which has been saved while installing the application) in stealth mode and starts listening for incoming SMS messages.
- If the phone gets formatted, it can log in through web browsers to access the camera, gallery and GPS.

![Runs in background ](https://user-images.githubusercontent.com/43419632/143008527-fd7b1868-55fc-491b-af17-be2b40be3694.png)

**Possible Feature:**
1. User Login (For Setting up the Application)
    - Create Account/Registers User
    - Login/Authentication
    - Add Users Details
        - Alternate Mobile Number
    - Change Alternate Mobile Number
    - Change Password

2. Runs in the background 
    - Checks for if the SIM changes or the Phone gets rebooted
        - Sends SMS to Alternate Mobile Number with details
    - If the phone gets formatted
        - Login through a web browser to access
            - Camera
            - Gallery
            - GPS

**Markup:**
![Markup](https://user-images.githubusercontent.com/43419632/143008532-aff50aca-1152-4223-9e5b-2fbbada167ae.png)

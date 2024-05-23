package com.hasanalmunawr.ImplemetationSpringBootEmailSender.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmailUtil {


//    String HTML
    public static String getMessageEmail(String username, String activation_code, String confirmationUrl) {
        String message = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Account Activation</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        margin: 0;
                        padding: 0;
                        background-color: #f4f4f4;
                    }
                    .container {
                        max-width: 600px;
                        margin: 10px auto;
                        padding: 20px;
                        background-color: #fff;
                        border-radius: 5px;
                        box-shadow: 0 0 10px rgba(0,0,0,0.1);
                    }
                    .activation-code {
                        font-size: 36px;
                        text-align: center;
                        margin-bottom: 20px;
                    }
                    .activation-link {
                        display: block;
                        text-align: center;
                        margin-top: 20px;
                    }
                    .activation-link a {
                        display: inline-block;
                        padding: 10px 20px;
                        background-color: #007bff;
                        color: #fff;
                        text-decoration: none;
                        border-radius: 5px;
                    }
                </style>
            </head>
            <body>
            <div class="container">
                <h1>Account Activation</h1>
                <p class="greeting">Hello  %username </p>
                <p>Thank you for signing up! Please use the following activation code to activate your account:</p>
                <div class="activation-code"> %activation_code </div>
                <div class="activation-link">
                    <a href= %confirmationUrl target="_blank">Activate your account</a>
                </div>
            </div>
            </body>
            </html>
            """.replace("%username", username).replace("%activation_code", activation_code).replace("%confirmationUrl", activation_code);

        return message;
    }


//    PATH HTML
    public static String emailMessage(String username, String activationCode, String confirmationUrl) {
        try {
            // Assuming pathToHtmlFile is the path to your HTML file
            Path pathToHtmlFile = Path.of("src/main/resources/templates/activate_account.html");
            // Read the contents of the HTML file into a String
            String htmlContent = Files.readString(pathToHtmlFile);

            // Perform string manipulation to replace variables
//            String username = "John Doe"; // Example username
//            String activationCode = "123456"; // Example activation code

            // Replace variables with actual values in the HTML content
            htmlContent = htmlContent.replace("${username}", username);
            htmlContent = htmlContent.replace("${activation_code}", activationCode);
            htmlContent = htmlContent.replace("${confirmationUrl}", confirmationUrl);


            // Print the modified HTML content
//            System.out.println(htmlContent);
            return htmlContent;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}

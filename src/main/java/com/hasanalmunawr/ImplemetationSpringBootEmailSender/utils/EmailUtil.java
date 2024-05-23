package com.hasanalmunawr.ImplemetationSpringBootEmailSender.utils;

public class EmailUtil {


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



}

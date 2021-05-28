import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class Master {

    public static void main(String[] args) throws Exception {
        long currentHour = (System.currentTimeMillis() / 3600000) * 3600000;
        System.out.println(currentHour);
        currentHour = (System.currentTimeMillis() / 3600_000L) * 3600_000L;
        System.out.println(currentHour);
        System.setProperty("http.agent", "Chrome");
        boolean hasNotFound = true;
        while (hasNotFound) {
            //https://in.bookmyshow.com/buytickets/master-madurai/movie-madu-ET00110368-MT/20210113
            // https://in.bookmyshow.com/buytickets/aayirathil-oruvan-madurai/movie-madu-ET00002304-MT/20210109
            URL url = new URL("https://in.bookmyshow.com/buytickets/aayirathil-oruvan-madurai/movie-madu-ET00002304-MT/20210109");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line, totalLine = "";
            while ((line = in.readLine()) != null) {
                totalLine += line;
            }
            in.close();

            System.out.println(totalLine);

            if (totalLine.toLowerCase().contains("gopuram") || totalLine.toLowerCase().contains("vetri")) {
                hasNotFound = false;
                System.out.println("skven");
            }

        }




        String to = "page-skven@amazon.com";

        // Sender's email ID needs to be mentioned
        String from = "venkateswaranskv@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println(mex);
        }

    }
}

package fluent_design;

public class Main {
    public static void main(String[] args) {
        /*
            There are two code smells in Mailer_BeanStyle code,
            repeated use of mailerBeanStyle reference and unclear object
            lifetime.
        */
        Mailer_BeanStyle mailerBeanStyle = new Mailer_BeanStyle();
        mailerBeanStyle.setFrom("abc@gmail.com");
        mailerBeanStyle.setTo("def@gmail.com");
        mailerBeanStyle.setSubject("Fake Mail");
        mailerBeanStyle.setBody("It Sucks...!");
        mailerBeanStyle.send();

        /*
            Using MailBuilder we can remove the first code smell,
            which is repeated use of reference, but MailBuilder
            Object lifetime is still unclear, someone can store the
            MailBuilder object in a reference and use it even after
            it's work is done. so to remove this code smell, we use
            lambda expression and loan design pattern
        */
        new MailBuilder()
            .setFrom("abc@gmail.com")
            .setTo("def@gmail.com")
            .setSubject("Dummy Subject")
            .setBody("Mail To Send")
            .send();


        //loan design pattern..!
        MailerFluent.send(mailerFluent ->
                mailerFluent.from("example@gmail.com")
                        .to("anotherexample@gmail.com")
                        .subject("buildNotification")
                        .body("... TEXT ..."));

        MailerFluent.send(mailerFluent ->
                mailerFluent.from("manu@gmail.com")
                        .to("asd@gmail.com")
                        .subject("buildNotification dummy")
                        .body("... EXT ..."));


    }
}

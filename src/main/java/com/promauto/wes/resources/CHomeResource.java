package com.promauto.wes.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Belyaev Alexei (lebllex) on 29.11.18.
 */
@Controller
@RequestMapping("/home")
public class CHomeResource {
    @GetMapping
    public String emitHelloHome(){
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <title>WesOutputView</title>\n" +
                "  <link rel=\"stylesheet\"  href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
                "</head>\n" +
                "<body ng-app=\"cms\">\n" +
                "  <H1>Home page</H1>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}

package jonash.group.packageone;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringBootMainApplicationStarterClass.class)
class SpringBootMainApplicationStarterClassTests {

    @Autowired
    HttpClients httpClient;

    @Autowired
    Parser parser;

    @Test
    void getHTMLPageContentWithApacheHTTPClient() {
        String html = httpClient.getSomeInfoFromWebsiteUsingApacheHTTPClient("https://example.com/");
        Assert.isTrue(html.contains("<") && html.contains(">"), "Client fetches no html in unit test");
    }

    @Test
    void parseExample(){
        String content = Utilities.readFile("./src/main/resources/example-website.txt");
        String parsedContent = parser.parseHTMLPage(content);
        Assert.isTrue(parsedContent.equals("<h1>Example Domain</h1>"),"parsing error");
    }

    @Test
    void downloadPageAndParseString(){
        String html = httpClient.getSomeInfoFromWebsiteUsingApacheHTTPClient("https://example.com/");
        String parsedContent = parser.parseHTMLPage(html);
        Assert.isTrue(parsedContent.equals("<h1>Example Domain</h1>"),"parsing error");
    }

    @Test
    @Ignore
    //used for manual executions of tasks here in IDE, e.g. download pages for testing
    void executeAnyMethod(){
        HttpClients httpClients = new HttpClients();
        String content = httpClients.getSomeInfoFromWebsiteUsingApacheHTTPClient("https://example.com/");
        Utilities.writeContentToFileToResourceFolder(content, "example-website.txt");
    }

}

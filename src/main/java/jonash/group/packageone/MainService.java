package jonash.group.packageone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainService {

    @Autowired
    HttpClients httpClients;

    @Autowired
    Parser parser;

    public String downloadPageAndParseString(String url){
        String content = httpClients.getSomeInfoFromWebsiteUsingApacheHTTPClient(url);
        return parser.parseHTMLPage(content);
    }
}
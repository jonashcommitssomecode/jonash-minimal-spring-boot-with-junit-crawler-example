package jonash.group.packageone;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Parser {

    //using regex, cause jsoup doesn't seem to work on dirty html
    String parseHTMLPage(String html) {
        try {
            String regex     = "<body>.*</body>";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(html);
            String firstMatching = null;
            while (m.find()) {
                firstMatching = m.group();
            }
            String regex2 = "<h1>.*</h1>";
            Pattern p2 = Pattern.compile(regex2);
            Matcher m2 = null;
            if (firstMatching != null) {
                m2 = p2.matcher(firstMatching);
            }
            String secondMatchedPart = null;
            if (m2 != null) {
                while (m2.find()) {
                    secondMatchedPart = m2.group();
                }
            }
            return secondMatchedPart;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

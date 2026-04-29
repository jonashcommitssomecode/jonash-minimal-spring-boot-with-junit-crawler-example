package jonash.group.packageone;

import jonash.group.packagetwo.SomeAutowiredClassInAnotherPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class MainController {

    @Autowired
    MainService mainService;

    @Autowired
    SomeAutowiredClassInAnotherPackage someAutowiredClassInAnotherPackage;

    @GetMapping("/")
    public String downloadPageAndParseString() {
        someAutowiredClassInAnotherPackage.someMethod();
        return mainService.downloadPageAndParseString("https://example.com/");
    }

}
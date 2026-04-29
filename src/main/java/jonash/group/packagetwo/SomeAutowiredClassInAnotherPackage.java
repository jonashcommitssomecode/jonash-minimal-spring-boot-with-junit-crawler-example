package jonash.group.packagetwo;

import org.springframework.stereotype.Component;

@Component
public class SomeAutowiredClassInAnotherPackage{

    public void someMethod(){
        System.out.println("Print something");
    }

}
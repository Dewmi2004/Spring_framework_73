package lk.ijse.been;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Boy {
    @Qualifier("girl")// transfer the qualifier to Autowire- set what type of  component should use
    @Autowired() //Add Dependency Injection
    Agreement agreement;// loose couple-use interface to use object

    public Boy() {
        System.out.println("boy object created");
    }
    public void ChatWithBoy() {
        agreement.Chat();
    }
}


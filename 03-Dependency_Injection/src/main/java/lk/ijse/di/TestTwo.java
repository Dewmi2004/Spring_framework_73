package lk.ijse.di;

import org.springframework.stereotype.Component;

@Component
public class TestTwo implements DI {

    @Override
    public void chat() {
        System.out.println("Test One Chat");
    }
}

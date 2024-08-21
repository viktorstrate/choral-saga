package saga.choreographies.example;

import java.util.Optional;
import saga.choreographies.Serviceable;

public class OrderService@A implements Serviceable@A<String, String> {
    public OrderService() {}

    public Optional@A<String> execute(String@A req) {
        return Optional@A.<String>of(req + " -> ordered"@A);
    }

    public void compensate() {
        System@A.out.println("Cancel order!"@A);
    }
}

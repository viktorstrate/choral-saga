package saga.choreographies.example;

import java.util.Optional;
import saga.choreographies.Serviceable;

public class DeliveryService@A implements Serviceable@A<String, String> {
    public DeliveryService() {}

    public Optional@A<String> execute(String@A req) {
        return Optional@A.<String>of(req + " -> delivered"@A);
    }

    public void compensate() {
        System@A.out.println("Cancel delivery!"@A);
    }
}

package saga.choreographies.example;

import java.util.Optional;
import saga.choreographies.Serviceable;

public class RestaurantService@A implements Serviceable@A<String, String> {
    public RestaurantService() {}

    public Optional@A<String> execute(String@A req) {
        return Optional@A.<String>of(req + " -> cooked"@A);
    }

    public void compensate() {
        System@A.out.println("Stop preparing dish!"@A);
    }
}

package saga.choreographies.example;

import java.util.Optional;
import saga.choreographies.Serviceable;
import saga.choreographies.Link;
import saga.choreographies.Choice;

public class Saga@(Orchestrator, Order, Restaurant, Delivery) {
    private Link@(Orchestrator, Order)<String, String> linkOrder;
    private Link@(Orchestrator, Restaurant)<String, String> linkRestaurant;
    private Link@(Orchestrator, Delivery)<String, String> linkDelivery;

    public Saga(
        Link@(Orchestrator, Order)<String, String> linkOrder,
        Link@(Orchestrator, Restaurant)<String, String> linkRestaurant,
        Link@(Orchestrator, Delivery)<String, String> linkDelivery) {
            this.linkOrder = linkOrder;
            this.linkRestaurant = linkRestaurant;
            this.linkDelivery = linkDelivery;
    }

    public void start(String@Orchestrator request) {
        Optional@Orchestrator<String> order = linkOrder.execute(request);

        if (order.isEmpty()) {
            linkOrder.ch.<Choice>select(Choice@Orchestrator.SUCCESS);
            linkRestaurant.ch.<Choice>select(Choice@Orchestrator.SUCCESS);
            linkDelivery.ch.<Choice>select(Choice@Orchestrator.SUCCESS);

            prepareMeal("Test"@Orchestrator);
        } else {
            linkOrder.ch.<Choice>select(Choice@Orchestrator.FAIL);
            linkRestaurant.ch.<Choice>select(Choice@Orchestrator.FAIL);
            linkDelivery.ch.<Choice>select(Choice@Orchestrator.FAIL);
        }

        System@Order.out.println("Order service done"@Order);
        System@Restaurant.out.println("Restaurant service done"@Restaurant);
        System@Delivery.out.println("Delivery service done"@Delivery);
        System@Orchestrator.out.println("Orchestrator done"@Orchestrator);
    }

    private void prepareMeal(String@Orchestrator order) {
        System@Orchestrator.out.println(order);
    }
}

package saga;

import java.util.List;
import java.util.Optional;

import choral.channels.BiChannel_A;
import choral.runtime.LocalChannel.LocalChannel_A;
import choral.runtime.Media.MessageQueue;
import saga.choreographies.Link_Orchestrator;
import saga.choreographies.Link_Service;
import saga.choreographies.example.Saga_Delivery;
import saga.choreographies.example.Saga_Orchestrator;
import saga.choreographies.example.Saga_Order;
import saga.choreographies.example.Saga_Restaurant;
import saga.choreographies.example.DeliveryService;
import saga.choreographies.example.OrderService;
import saga.choreographies.example.RestaurantService;

public class Main {
    public static void main(String[] args) {
        LinkChannel orderChannel = new LinkChannel();
        Link_Orchestrator<String, String> linkOOrd = new Link_Orchestrator<>(orderChannel.channelA());
        Link_Service<String, String> linkOrdO = new Link_Service<>(orderChannel.channelB(), new OrderService());
        Saga_Order orderService = new Saga_Order(linkOrdO);

        LinkChannel restaurantChannel = new LinkChannel();
        Link_Orchestrator<String, String> linkOR = new Link_Orchestrator<>(restaurantChannel.channelA());
        Link_Service<String, String> linkRO = new Link_Service<>(restaurantChannel.channelB(), new RestaurantService());
        Saga_Restaurant restaurantService = new Saga_Restaurant(linkOrdO);

        LinkChannel deliveryChannel = new LinkChannel();
        Link_Orchestrator<String, String> linkOD = new Link_Orchestrator<>(deliveryChannel.channelA());
        Link_Service<String, String> linkDO = new Link_Service<>(deliveryChannel.channelB(), new DeliveryService());
        Saga_Delivery deliveryService = new Saga_Delivery(linkDO);

        Saga_Orchestrator orchestratorService = new Saga_Orchestrator(linkOOrd, linkOR, linkOD);

        List.<Runnable>of(
                () -> orchestratorService.start("pizza"),
                () -> orderService.start(),
                () -> restaurantService.start(),
                () -> deliveryService.start())
                .parallelStream()
                .forEach(Runnable::run);
    }
}
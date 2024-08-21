package saga.choreographies;

import java.util.Optional;
import choral.channels.BiChannel;

public class Link@(Orchestrator, Service)<Req@X, Res@Y> {
    public BiChannel@(Orchestrator, Service)<Req, Optional<Res>> ch;
    private Serviceable@Service<Req, Res> service;

    public Link(BiChannel@(Orchestrator, Service)<Req, Optional<Res>> ch, Serviceable@Service<Req, Res> service) {
        this.ch = ch;
        this.service = service;
    }

    public Optional@Orchestrator<Res> execute(Req@Orchestrator req) {
        Req@Service serviceRequest = ch.<Req>com(req);
        Optional@Service<Res> serviceResult = service.execute(serviceRequest);
        Optional@Orchestrator<Res> result = ch.<Optional<Res>>com(serviceResult);
        
        return result;
    }

    // It looks like @SelectionMethod is only supported for interfaces
    /*@SelectionMethod 
    public < T@X extends Enum@X< T > > T@Service select( T@Orchestrator m ) {
        return ch.<T>select(m);
    }*/
}
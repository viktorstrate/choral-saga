package saga.choreographies;

import java.util.Optional;

public interface Serviceable@(A)<Req@X, Res@Y> {
    Optional@A<Res> execute(Req@A req);
    void compensate();
}

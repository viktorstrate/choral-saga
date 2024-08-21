package saga;

import java.util.Optional;

import choral.channels.BiChannel_A;
import choral.channels.BiChannel_B;
import choral.lang.Unit;
import choral.runtime.Media.MessageQueue;

public class LinkChannel<In, Out> {
    private MessageQueue queueA, queueB;

    public LinkChannel() {
        queueA = new MessageQueue();
        queueB = new MessageQueue();
    }

    public ChannelA channelA() {
        return new ChannelA();
    }

    public ChannelB channelB() {
        return new ChannelB();
    }

    public class ChannelA implements BiChannel_A<String, Optional<String>> {

        @Override
        public <S extends String> Unit com(S m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'com'");
        }

        @Override
        public <T extends Enum<T>> Unit select(T m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'select'");
        }

        @Override
        public <S extends Optional<String>> S com(Unit m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'com'");
        }

        @Override
        public <S extends Optional<String>> S com() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'com'");
        }

        @Override
        public <T extends Enum<T>> T select(Unit m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'select'");
        }

        @Override
        public <T extends Enum<T>> T select() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'select'");
        }

    }

    public class ChannelB implements BiChannel_B<String, Optional<String>> {

        @Override
        public <S extends String> S com(Unit m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'com'");
        }

        @Override
        public <S extends String> S com() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'com'");
        }

        @Override
        public <T extends Enum<T>> T select(Unit m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'select'");
        }

        @Override
        public <T extends Enum<T>> T select() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'select'");
        }

        @Override
        public <S extends Optional<String>> Unit com(S m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'com'");
        }

        @Override
        public <T extends Enum<T>> Unit select(T m) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'select'");
        }
    }
}

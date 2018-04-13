package demo.reader;

public class RepeatableReader<T extends RepeatableReader.Responsive, S> extends Reader<T> {

    RepeatableReader(Class<T> clazz) {
        super(clazz);
    }

    public T read(String urlBody) {
        T answer;
        do {
            answer = super.read(urlBody);
        } while (answer.response() == null);
        return answer;
    }

    public interface Responsive<S> {

        S response();
    }
}

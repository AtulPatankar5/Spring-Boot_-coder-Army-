package in.strikes.crudSpringBootDemo.exception;

public class ResourceNotException extends RuntimeException {

    public ResourceNotException(String message) {
        super(message);
    }
}

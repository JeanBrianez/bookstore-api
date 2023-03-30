package api.bookstore.integ;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthorControllerTests.class,
        BookControllerTests.class,
        CostumerControllerTests.class,
        OrderControllerTests.class,
        OrderItemControllerTests.class,
        PublisherControllerTests.class
})
public class AllIntegTests {
}

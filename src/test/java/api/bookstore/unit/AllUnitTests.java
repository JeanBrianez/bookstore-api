package api.bookstore.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthorServiceTests.class,
        BookServiceTests.class,
        CostumerServiceTests.class,
        OrderServiceTests.class,
        OrderItemServiceTests.class,
        PublisherServiceTests.class
})
public class AllUnitTests {
}

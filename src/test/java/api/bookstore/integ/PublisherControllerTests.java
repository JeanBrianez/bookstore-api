package api.bookstore.integ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherControllerTests {

    @Test
    public void testSanity() {
        int a = 1;
        assertEquals(a,1);
    }
}

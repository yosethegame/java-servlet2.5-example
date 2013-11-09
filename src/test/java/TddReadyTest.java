import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TddReadyTest {

    @Test
    public void jUnitWorks() {
        assertThat( 1 + 1, equalTo( 2 ));
    }
}

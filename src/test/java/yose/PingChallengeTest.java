package yose;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import org.junit.Before;
import org.junit.Test;
import utils.FeatureDescription;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PingChallengeTest extends FeatureDescription {

    private WebClient client = new WebClient();
    private WebResponse response;

    @Before
    public void openPage() throws IOException {
        Page page = client.getPage( "http://localhost:8080/ping" );
        response = page.getWebResponse();
    }

    @Test
    public void pingAnswers() throws IOException {
        assertThat( response.getStatusCode(), equalTo( 200 ));
    }

    @Test
    public void pingAnswersJson() throws IOException {
        assertThat( response.getContentType(), equalTo( "application/json" ));
    }

    @Test
    public void pingAnswersTheValueExpectedByTheGame() {
        assertThat( response.getContentAsString(), equalTo( "{\"alive\":true}" ));
    }
}

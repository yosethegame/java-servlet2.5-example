package utils;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertNotNull;
import static utils.FileReaderHelper.contentOfFile;

public class FeatureDescription {

    ServletWrapper server;

    @Before
    public void
    startClean() throws Exception {
        String webXml = contentOfFile( "src/main/webapp/WEB-INF/web.xml" );
        assertNotNull("make sure src/main/webapp/WEB-INF/web.xml exists", webXml);

        server = new ServletWrapper( 8080, webXml );
        server.start();
    }

    @After
    public void
    stopServer() throws Exception {
        server.stop();
    }
}

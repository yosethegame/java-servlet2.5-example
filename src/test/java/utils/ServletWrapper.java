package utils;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import static utils.ServletMappingExtractor.*;

public class ServletWrapper {

    Server server;

    public ServletWrapper(int port, String webXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        org.mortbay.log.Log.setLog( null );
        server = new Server(port);
        Context root = new Context(server,"/",Context.SESSIONS);
        root.addServlet( new ServletHolder( servletInstanceIn(webXml) ), servletMappingIn(webXml) );
    }

    public void start() throws Exception {
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }
}

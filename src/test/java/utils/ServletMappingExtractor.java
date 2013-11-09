package utils;

import javax.servlet.http.HttpServlet;

public class ServletMappingExtractor {

    public static String servletNameIn(String content) {
        return extractContentOfTag( "servlet-name", in( content ) );
    }

    public static String servletMappingIn(String content) {
        return extractContentOfTag( "url-pattern", in( content ) );
    }

    public static String servletClassIn(String content) {
        return extractContentOfTag( "servlet-class", in( content ) );
    }

    public static HttpServlet servletInstanceIn(String content) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (HttpServlet) Class.forName( servletClassIn( content ) ).newInstance();
    }

    public static String in(String content) {
        return content;
    }

    public static String extractContentOfTag(String tag, String content) {
        int openingTagIndex = content.indexOf( "<" + tag + ">" );
        int closingTagIndex = content.indexOf( "</" + tag + ">" );
        return content.substring( openingTagIndex + tag.length() + 2, closingTagIndex );
    }
}

package de.netpagegermany.liferay.objectstaglib;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A class for loading objects from request to pageContext.
 * 
 * @author Denis Wirries
 * @since 0.1
 */
public class LoadObjectsTag extends TagSupport {

    private static final long serialVersionUID = 2522701324045836532L;

    private static Log log = LogFactory.getLog(LoadObjectsTag.class);

    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        @SuppressWarnings("unchecked")
        Enumeration<String> e = request.getAttributeNames();
        while (e.hasMoreElements()) {
            String attribute = e.nextElement();

            log.trace("Request-Attribut found: " + attribute);
            if (pageContext.getAttribute(attribute) == null) {
                log.trace("PageContext no contains attribut - copy attribut to pageContext");
                pageContext.setAttribute(attribute, request.getAttribute(attribute));
            }
        }

        return SKIP_BODY;
    }

}

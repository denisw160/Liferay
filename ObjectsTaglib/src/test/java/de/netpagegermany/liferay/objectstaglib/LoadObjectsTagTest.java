package de.netpagegermany.liferay.objectstaglib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.el.ExpressionEvaluator;
import javax.servlet.jsp.el.VariableResolver;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Test for {@link LoadObjectsTag}.
 * 
 * @author Denis Wirries
 */
public class LoadObjectsTagTest {

    @Test
    public void testDoStartTag() throws Exception {
        PageContext pageContext = new TestPageContext();
        pageContext.setAttribute("Test4", "ValueExits");

        HttpServletRequest request = new TestServletRequest();
        request.setAttribute("Test1", "Test-Value1");
        request.setAttribute("Test2", "Test-Value2");
        request.setAttribute("Test3", "Test-Value3");
        request.setAttribute("Test4", "Test-Value4");

        pageContext.initialize(null, request, null, null, false, 0, false);

        LoadObjectsTag tag = new LoadObjectsTag();
        tag.setPageContext(pageContext);

        Assert.assertNull(pageContext.getAttribute("Test1"));
        Assert.assertEquals(pageContext.getAttribute("Test4"), "ValueExits");

        tag.doStartTag();

        Assert.assertEquals(pageContext.getAttribute("Test1"), "Test-Value1");
        Assert.assertEquals(pageContext.getAttribute("Test2"), "Test-Value2");
        Assert.assertEquals(pageContext.getAttribute("Test3"), "Test-Value3");
        Assert.assertEquals(pageContext.getAttribute("Test4"), "ValueExits");
    }

    private class TestPageContext extends PageContext {

        private ServletRequest request;

        private final Map<String, Object> attributes = new HashMap<String, Object>();

        @Override
        public void initialize(Servlet servlet, ServletRequest request, ServletResponse response, String errorPageURL, boolean needsSession,
                int bufferSize, boolean autoFlush) throws IOException, IllegalStateException, IllegalArgumentException {
            this.request = request;
        }

        @Override
        public void release() {
        }

        @Override
        public HttpSession getSession() {
            return null;
        }

        @Override
        public Object getPage() {
            return null;
        }

        @Override
        public ServletRequest getRequest() {
            return request;
        }

        @Override
        public ServletResponse getResponse() {
            return null;
        }

        @Override
        public Exception getException() {
            return null;
        }

        @Override
        public ServletConfig getServletConfig() {
            return null;
        }

        @Override
        public ServletContext getServletContext() {
            return null;
        }

        @Override
        public void forward(String relativeUrlPath) throws ServletException, IOException {
        }

        @Override
        public void include(String relativeUrlPath) throws ServletException, IOException {
        }

        @Override
        public void include(String relativeUrlPath, boolean flush) throws ServletException, IOException {
        }

        @Override
        public void handlePageException(Exception e) throws ServletException, IOException {
        }

        @Override
        public void handlePageException(Throwable t) throws ServletException, IOException {
        }

        @Override
        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }

        @Override
        public void setAttribute(String name, Object value, int scope) {
        }

        @Override
        public Object getAttribute(String name) {
            if (!attributes.containsKey(name))
                return null;

            return attributes.get(name);
        }

        @Override
        public Object getAttribute(String name, int scope) {
            return null;
        }

        @Override
        public Object findAttribute(String name) {
            return null;
        }

        @Override
        public void removeAttribute(String name) {
        }

        @Override
        public void removeAttribute(String name, int scope) {
        }

        @Override
        public int getAttributesScope(String name) {
            return 0;
        }

        @Override
        public Enumeration getAttributeNamesInScope(int scope) {
            return null;
        }

        @Override
        public JspWriter getOut() {
            return null;
        }

        @Override
        public ExpressionEvaluator getExpressionEvaluator() {
            return null;
        }

        @Override
        public VariableResolver getVariableResolver() {
            return null;
        }
    }

    private class TestServletRequest implements HttpServletRequest {

        private final Map<String, Object> attributes = new HashMap<String, Object>();

        public Object getAttribute(String name) {
            if (!attributes.containsKey(name))
                return null;

            return attributes.get(name);
        }

        public Enumeration getAttributeNames() {
            return new Vector(attributes.keySet()).elements();
        }

        public String getCharacterEncoding() {
            return null;
        }

        public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
        }

        public int getContentLength() {
            return 0;
        }

        public String getContentType() {
            return null;
        }

        public ServletInputStream getInputStream() throws IOException {
            return null;
        }

        public String getParameter(String name) {
            return null;
        }

        public Enumeration getParameterNames() {
            return null;
        }

        public String[] getParameterValues(String name) {
            return null;
        }

        public Map getParameterMap() {
            return null;
        }

        public String getProtocol() {
            return null;
        }

        public String getScheme() {
            return null;
        }

        public String getServerName() {
            return null;
        }

        public int getServerPort() {
            return 0;
        }

        public BufferedReader getReader() throws IOException {
            return null;
        }

        public String getRemoteAddr() {
            return null;
        }

        public String getRemoteHost() {
            return null;
        }

        public void setAttribute(String name, Object o) {
            attributes.put(name, o);
        }

        public void removeAttribute(String name) {
        }

        public Locale getLocale() {
            return null;
        }

        public Enumeration getLocales() {
            return null;
        }

        public boolean isSecure() {
            return false;
        }

        public RequestDispatcher getRequestDispatcher(String path) {
            return null;
        }

        public String getRealPath(String path) {
            return null;
        }

        public int getRemotePort() {
            return 0;
        }

        public String getLocalName() {
            return null;
        }

        public String getLocalAddr() {
            return null;
        }

        public int getLocalPort() {
            return 0;
        }

        public String getAuthType() {
            return null;
        }

        public Cookie[] getCookies() {
            return null;
        }

        public long getDateHeader(String name) {
            return 0;
        }

        public String getHeader(String name) {
            return null;
        }

        public Enumeration getHeaders(String name) {
            return null;
        }

        public Enumeration getHeaderNames() {
            return null;
        }

        public int getIntHeader(String name) {
            return 0;
        }

        public String getMethod() {
            return null;
        }

        public String getPathInfo() {
            return null;
        }

        public String getPathTranslated() {
            return null;
        }

        public String getContextPath() {
            return null;
        }

        public String getQueryString() {
            return null;
        }

        public String getRemoteUser() {
            return null;
        }

        public boolean isUserInRole(String role) {
            return false;
        }

        public Principal getUserPrincipal() {
            return null;
        }

        public String getRequestedSessionId() {
            return null;
        }

        public String getRequestURI() {
            return null;
        }

        public StringBuffer getRequestURL() {
            return null;
        }

        public String getServletPath() {
            return null;
        }

        public HttpSession getSession(boolean create) {
            return null;
        }

        public HttpSession getSession() {
            return null;
        }

        public boolean isRequestedSessionIdValid() {
            return false;
        }

        public boolean isRequestedSessionIdFromCookie() {
            return false;
        }

        public boolean isRequestedSessionIdFromURL() {
            return false;
        }

        public boolean isRequestedSessionIdFromUrl() {
            return false;
        }

    }

}

package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
        filterName = "EncodingWrapeerFilter"
)
public class EncodingWrapeerFilter implements Filter {
    private String encoding;

    public EncodingWrapeerFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setContentType("text/html;charset=" + this.encoding);
        String requestURI = httpRequest.getRequestURI();
        if (!requestURI.contains("favicon.ico")) {
            if (httpRequest.getMethod().equals("GET")) {
                EncodingWrapeerFilter.EncodingWraperRequst wraper = new EncodingWrapeerFilter.EncodingWraperRequst(httpRequest, this.encoding);
                chain.doFilter(wraper, httpResponse);
            } else {
                httpRequest.setCharacterEncoding(this.encoding);
                System.out.print("get");
                chain.doFilter(httpRequest, httpResponse);
            }

        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.print(this.encoding);
    }

    private class EncodingWraperRequst extends HttpServletRequestWrapper {
        private HttpServletRequest request;
        private String encoding;

        public EncodingWraperRequst(HttpServletRequest request, String encoding) {
            super(request);
            this.request = request;
            this.encoding = encoding;
        }

        public String getParameter(String name) {
            String value = "";
            System.out.print("重写后的getparmeter");

            try {
                value = new String(this.request.getParameter(name).getBytes("ISO-8859-1"), this.encoding);
            } catch (UnsupportedEncodingException var4) {
                var4.printStackTrace();
            }

            return value;
        }
    }
}
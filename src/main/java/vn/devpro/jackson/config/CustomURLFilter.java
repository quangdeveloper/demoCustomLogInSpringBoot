package vn.devpro.jackson.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

@Slf4j
public class CustomURLFilter implements Filter {

    public static final String REQUEST_ID = "request_id";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(" \nDo filter in custom filter is run\n");
        String requestId = UUID.randomUUID().toString();
        servletRequest.setAttribute(REQUEST_ID, requestId);
        logRequest((HttpServletRequest) servletRequest, requestId);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void logRequest(HttpServletRequest request, String requestId) {

        System.out.println(" \n logging request in custom filter run \n");
        if (request != null) {
            StringBuilder data = new StringBuilder();
            data.append("\nLOGGING REQUEST-------------Filter----------------------\n")
                    .append("[REQUEST-ID]: ").append(requestId).append("\n")
                    .append("[PATH]: ").append(request.getRequestURI()).append("\n")
                    .append("[QUERIES]: ").append(request.getQueryString()).append("\n")
                    .append("[HEADERS]: ").append("\n");

            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
                data.append("---").append(key).append(" : ").append(value).append("\n");
            }
            data.append("LOGGING REQUEST-----------------------------------\n");
            log.info(data.toString());
        }

    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
package com.RainManages.servlet;

import javax.servlet.*;
import java.io.IOException;

public class EncodeFilter implements Filter {
    private String encode = null;

    @Override
    public void destroy() {
        encode = null;
    }

    // 对所有页面设置字符集
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encode);
            response.setCharacterEncoding(encode);

        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encode = filterConfig.getInitParameter("encode");
        if (this.encode == null) {
            this.encode = encode;
        }
    }

}

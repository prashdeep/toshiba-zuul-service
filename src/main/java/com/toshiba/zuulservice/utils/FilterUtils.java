package com.toshiba.zuulservice.utils;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class FilterUtils {

    public static final String CORRELATION_ID = "correlation-id";


    public String getCorrelationId(){
        RequestContext ctx = RequestContext.getCurrentContext();

        if (ctx.getRequest().getHeader(CORRELATION_ID) !=null) {
            return ctx.getRequest().getHeader(CORRELATION_ID);
        }
        else{
            return  ctx.getZuulRequestHeaders().get(CORRELATION_ID);
        }
    }

    public void setCorrelationId(String correlationId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(CORRELATION_ID, correlationId);
    }

}
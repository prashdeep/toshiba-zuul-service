package com.toshiba.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.toshiba.zuulservice.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ZuulPreFilter extends ZuulFilter {

    @Autowired
    private FilterUtils filterUtils;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        if(filterUtils.getCorrelationId() == null){
            filterUtils.setCorrelationId(UUID.randomUUID().toString());
        }
        System.out.println("Pre filter is run with corelation ID:  "+filterUtils.getCorrelationId());
        return null;
    }
}
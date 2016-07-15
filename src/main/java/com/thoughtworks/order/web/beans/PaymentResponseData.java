package com.thoughtworks.order.web.beans;

import com.thoughtworks.order.domain.Payment;
import com.thoughtworks.order.infrastructure.records.Record;
import com.thoughtworks.order.web.jersey.Routes;

import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.Map;

public class PaymentResponseData implements Record{
    private Payment payment;
    private UriInfo paymentUrl;

    public PaymentResponseData(Payment payment, UriInfo paymentUrl) {
        this.payment = payment;
        this.paymentUrl = paymentUrl;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        String paymentPath = paymentUrl.getPath();
        return new HashMap<String, Object>() {{
            put("order_uri", paymentPath.substring(0, paymentPath.length()-"/payment".length()));
            put("uri", paymentPath);
            put("pay_type", payment.getType());
            put("amount", payment.getAmount());
            put("created_at", payment.getPayAt());
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }




}

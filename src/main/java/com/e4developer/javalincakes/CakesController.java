package com.e4developer.javalincakes;

import io.javalin.http.Context;

import java.util.Arrays;

public final class CakesController {

    private CakesController() {
    }

    static String[] availableCakes = {"carrot cake", "chocolate cake", "cheesecake"};

    public static void getAllCakes(Context ctx) {
        ctx.json(availableCakes);
        ctx.result(
                "Port: " + ctx.port() + "\n" +
                "protocol: " + ctx.protocol() + "\n" +
                "method: " + ctx.method() + "\n" +
                "isMultipartFormData: " + ctx.isMultipartFormData() + "\n" +
                "isMultipart: " + ctx.isMultipart() + "\n" +
                "ip: " + ctx.ip() + "\n" +
                "host: " + ctx.host() + "\n" +
                "headerMap: " + ctx.headerMap() + "\n" +
                "cookieMap: " + ctx.cookieMap() + "\n" +
                "contentType: " + ctx.contentType() + "\n" +
                "contentLength: " + ctx.contentLength() + "\n" +
                "attributeMap: " + ctx.attributeMap() + "\n" +
                "basicAuthCredentials: " + ctx.basicAuthCredentials() + "\n" +
                "pathParamMap: " + ctx.pathParamMap() + "\n" +
                "bodyAsBytes: " + Arrays.toString(ctx.bodyAsBytes()) + "\n" +
                "body: " + ctx.body() + "\n"
                        );
    }


    public static void getSpecialCake(Context ctx) {
        for (String cake : availableCakes) {
            if (cake.contains(ctx.pathParam("special"))) {
                ctx.result(cake);
                return;
            }
        }
        ctx.result("No Cake :(");
    }
}

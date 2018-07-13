package com.study.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class CallInterceptor implements Interceptor{

	@Override
	public Response intercept(Chain chain) throws IOException {
		System.out.println(chain.request().url());
		return chain.proceed(chain.request());
	}

}

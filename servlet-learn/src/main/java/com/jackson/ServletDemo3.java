package com.jackson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求方式
        System.out.println(req.getMethod());

        //2. 获取虚拟目录
        System.out.println(req.getContextPath());

        //3. 获取URL
        System.out.println(req.getRequestURL());

        //4. 获取URI
        System.out.println(req.getRequestURI());

        //5. 获取请求参数
        System.out.println(req.getQueryString());

        //6. 获取请求头
        System.out.println(req.getHeader("User-Agent"));

        //get中文乱码
        String username = req.getParameter("username");
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        String s = new String(bytes, StandardCharsets.UTF_8);

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post，请求体
        BufferedReader bufferedReader = req.getReader();
        String line;
        while ((line = bufferedReader.readLine())!= null) {
            System.out.println(line);
        }
        // 请求结束流会随着req的销毁而销毁
    }
}

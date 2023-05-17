/*
 * @Descripttion: 
 * @version: 
 * @@Company: DCIT-SH
 * @Author: 宸
 * @Date: 2023-03-14 16:29:40
 * @LastEditors: 宸
 * @LastEditTime: 2023-03-14 16:29:54
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charaset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>");
        writer.print("Hello CSDN, I'm byr from VScode.");
        writer.print("<br>");
        writer.print("你好CSDN，我是用VScode的北邮人。");
        writer.print("</h1>");
        req.setAttribute("HelloServlet", writer);
    }
}

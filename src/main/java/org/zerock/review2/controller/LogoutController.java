package org.zerock.review2.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
@Log4j2
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {
        log.info("log out.........................");

        HttpSession session = req.getSession();

        session.removeAttribute("loginInfo");
        session.invalidate(); //세션을 없애고 세션에 속해있는 모든값 삭제

        resp.sendRedirect("/");

    }

}

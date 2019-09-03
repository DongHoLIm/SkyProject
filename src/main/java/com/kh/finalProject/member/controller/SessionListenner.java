package com.kh.finalProject.member.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.finalProject.member.controller.MemberController;
import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.service.MemberService;
import com.kh.finalProject.member.model.service.MemberServiceImpl;
import com.kh.finalProject.member.model.vo.Member;

@WebListener
public class SessionListenner implements HttpSessionListener {
	
	public SessionListenner() {

	}

	public void sessionCreated(HttpSessionEvent se) {

	}
	
	public void sessionDestroyed(HttpSessionEvent se) {	
		Member loginUser =(Member) se.getSession().getAttribute("loginUser");
		MemberService ms = new MemberServiceImpl();
		ms.sessionLogOut(loginUser);
	}
}

package com.kh.finalProject.common;

import javax.servlet.http.HttpServletRequest;

import com.kh.finalProject.member.model.vo.Member;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mailController {
	
	public int sendEmail(Member findMemberId,HttpServletRequest request,int status){
		String userId = findMemberId.getMemberId();
		String userPwd = findMemberId.getMemberPwd();
		String userEmail = findMemberId.getEmail();
		int result = 0;
		 String host     = "smtp.naver.com";
		  final String user   = "limdh93";
		  final String password  = "luck0826";

		  String to     = userEmail;

		  
		  // Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", host);
		  props.put("mail.smtp.auth", "true");

		  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(user, password);
		   }
		  });

		  // Compose the message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(user));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		   // Subject
		   if(status==0) {
			   message.setSubject("OO대학교 아이디 찾은 결과 입니다.");
		   }else {
			   message.setSubject("OO대학교 새로운 비밀번호입니다.");
		   }
		   
		   
		   // Text
		   if(status == 0) {
			   message.setText("귀하의 해당아이디는 "+userId+"입니다.");
		   }else {
			   message.setText("귀하의 새로운 비밀번호는  "+userPwd+"입니다.");
		   }
		  

		   // send the message
		   Transport.send(message);		 
		   	result = 1;	  
		  } catch (MessagingException e) {
			  
			  result=0;
		  }		
		  return result;	
	}
}

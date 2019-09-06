package com.kh.finalProject.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class SendModie {
	@RequestMapping("sendMessage.ac")
	public ModelAndView sendMessage(ModelAndView mv,HttpServletRequest request) {
		String charsetType = "UTF-8";

		String sms_url = "";
		sms_url = "https://sslsms.cafe24.com/sms_sender.php";
		String user_id ="ksjp1117";
		String secure="90608f1b049410403bf2ba5d0c55fda6";
		String msg=request.getParameter("msg");
		String sphone1="010";
		String sphone2="6384";
		String sphone3="2055";
		String rphone = request.getParameter("phoneNumber");
		
		

		String[] host_info = sms_url.split("/");
		String host = host_info[2];
		String path = "/" + host_info[3];
		int port = 80;
		String arrKey[]
				= new String[] {"user_id","secure","msg", "rphone","sphone1","sphone2","sphone3"};
		String valKey[]= new String[arrKey.length] ;
		valKey[0] = user_id;
		valKey[1] = secure;
		valKey[2] = msg;
		valKey[3] = rphone;
		valKey[4] = sphone1;
		valKey[5] = sphone2;
		valKey[6] = sphone3;

		String boundary = "";
		Random rnd = new Random();
		String rndKey = Integer.toString(rnd.nextInt(32000));
		

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytData = rndKey.getBytes();
			md.update(bytData);
			byte[] digest = md.digest();
			for(int i =0;i<digest.length;i++)
			{
				boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
			}
			boundary = "---------------------"+boundary.substring(0,11);

			// 본문 생성
			String data = "";
			String index = "";
			String value = "";
			for (int i=0;i<arrKey.length; i++)
			{
				index =  arrKey[i];
				value = valKey[i];
				data +="--"+boundary+"\r\n";
				data += "Content-Disposition: form-data; name=\""+index+"\"\r\n";
				data += "\r\n"+value+"\r\n";
				data +="--"+boundary+"\r\n";
			}
			InetAddress addr = InetAddress.getByName(host);
			Socket socket = new Socket(host, port);
			// 헤더 전송
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetType));
			wr.write("POST "+path+" HTTP/1.0\r\n");
			wr.write("Content-Length: "+data.length()+"\r\n");
			wr.write("Content-type: multipart/form-data, boundary="+boundary+"\r\n");
			wr.write("\r\n");

			// 데이터 전송
			wr.write(data);
			wr.flush();

			// 결과값 얻기
			BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(),charsetType));
			String line;
			String alert = "";
			ArrayList tmpArr = new ArrayList();
			while ((line = rd.readLine()) != null) {
				tmpArr.add(line);
			}
			wr.close();
			rd.close();
			String tmpMsg = (String)tmpArr.get(tmpArr.size()-1);
			String[] rMsg = tmpMsg.split(",");
			String Result= rMsg[0]; //발송결과
			String Count= ""; //잔여건수
			if(rMsg.length>1) {Count= rMsg[1]; }

			//발송결과 알림
			if(Result.equals("success")) {
				alert = "성공적으로 발송하였습니다.";
				alert += " 잔여건수는 "+ Count+"건 입니다.";
			}
			else if(Result.equals("reserved")) {
				alert = "성공적으로 예약되었습니다";
				alert += " 잔여건수는 "+ Count+"건 입니다.";
			}
			else if(Result.equals("3205")) {
				alert = "잘못된 번호형식입니다.";
			}
			else {
				alert = "[Error]"+Result;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	mv.setViewName("JsonView");		
		
	return mv;
}
}

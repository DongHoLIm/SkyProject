package com.kh.finalProject.reply.model.service;

import com.kh.finalProject.reply.model.exception.ReplyInsertException;
import com.kh.finalProject.reply.model.vo.Reply;

public interface ReplyService {

	int insertFreeBoardRP(Reply rp) throws ReplyInsertException;
	
}

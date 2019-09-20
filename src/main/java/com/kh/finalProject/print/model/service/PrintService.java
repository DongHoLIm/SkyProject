package com.kh.finalProject.print.model.service;

import java.util.ArrayList;

import com.kh.finalProject.print.model.exception.PrintException;
import com.kh.finalProject.print.model.vo.Print;

public interface PrintService {

	ArrayList<Print> printCheck(String studentNo) throws PrintException;

}

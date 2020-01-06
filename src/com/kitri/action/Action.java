package com.kitri.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
		
}

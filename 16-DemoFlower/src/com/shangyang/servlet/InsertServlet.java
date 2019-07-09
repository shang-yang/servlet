package com.shangyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shangyang.pojo.Flower;
import com.shangyang.service.FlowerService;
import com.shangyang.service.impl.FlowerServiceImpl;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FlowerService flowerService = new FlowerServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String production = req.getParameter("production");
		Flower flower = new Flower();
		flower.setName(name);
		flower.setPrice(Double.parseDouble(price));
		flower.setProduction(production);
		int index = flowerService.add(flower);
		if (index > 0)
				// 防止表单重复提交
				resp.sendRedirect("show");
//			req.getRequestDispatcher("show").forward(req, resp);
		else
				// 防止表单重复提交
				resp.sendRedirect("add.jsp");
//			req.getRequestDispatcher("add.jsp").forward(req, resp);
	}

}

package com.shangyang.servlet;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class NumServlet
 */

public class NumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	// 覆写init初始化方法，将数据读取到ServletContext对象中
	@Override
	public void init() throws ServletException {
		// 获取文件中的计数器数据
			// 获取文件路径
			String path = this.getServletContext().getRealPath("/num/num.txt");
			// 声明流对象
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(path);
				br = new BufferedReader(fr);
				String num = br.readLine();
				System.out.println(num);
				this.getServletContext().setAttribute("num", Integer.parseInt(num));
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	
	
	//覆写销毁方法，存储计数器到文件
	@Override
		public void destroy() {
			// 获取网页计数器
			int num = (int) this.getServletContext().getAttribute("num");
			System.out.println(num);
			// 获取文件路径
			String path = this.getServletContext().getRealPath("/num/num.txt");
			// 声明流对象
			BufferedWriter bw = null;
			FileWriter fw = null;
			try {
				fw = new FileWriter(path);
				bw = new BufferedWriter(fw);
				bw.write(num + "");
				bw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

}

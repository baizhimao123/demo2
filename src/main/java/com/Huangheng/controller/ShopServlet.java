package com.Huangheng.controller;

import com.Huangheng.dao.ProductDao;
import com.Huangheng.model.Category;
import com.Huangheng.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList= null;
        try {
            categoryList = category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ProductDao productDao=new ProductDao();
            List<Product>   productList=null;
            if (request.getParameter("categoryId")==null){
            productList=productDao.findAll(con);
            }else {
                int categoryId=Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(categoryId,con);
            }
            request.setAttribute("productList",productList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String path="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

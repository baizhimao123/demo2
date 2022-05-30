package com.Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "calServlet", value = "/cal")
public class CalServlet extends HttpServlet {

    public int Add(int firstVal,int secondVal){
        return firstVal+secondVal;
    }
    public int Subtract(int firstVal,int secondVal){
        return firstVal-secondVal;
    }
    public int Multiply(int firstVal,int secondVal){
        return firstVal*secondVal;
    }

    public double Divide(int firstVal,int secondVal){
        return firstVal/secondVal;
    }
    public int ComputeLength(int firstVal,int secondVal){
        return 0;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstVal=Integer.parseInt(request.getParameter("firstVal"));
        int secondVal=Integer.parseInt(request.getParameter("secondVal"));
        String name=request.getParameter("name");
        String length=request.getParameter("length");
        String result=request.getParameter("result");

        String add=request.getParameter("add");
        String subtract=request.getParameter("subtract");
        String multiply=request.getParameter("multiply");
        String divide=request.getParameter("divide");
        String computeLength=request.getParameter("computeLength");
        if (add.equals("Add") && name.equals("+")){
            Add(firstVal,secondVal);
        }else if (subtract.equals("Subtract") && name.equals("-")){
            Subtract(firstVal,secondVal);
        }else if (multiply.equals("Multiply") && name.equals("*")){
            Multiply(firstVal,secondVal);
        }else if (divide.equals("Divide") && name.equals("/")){
            Divide(firstVal,secondVal);
        }else if (computeLength.equals("ComputeLength")){
            ComputeLength(firstVal,secondVal);
        }

        response.sendRedirect("/lab3/cal.jsp");
    }
}

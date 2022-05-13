package com.Huangheng.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean active;

    public Category(int categoryId, String categoryName, String description, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public Category() {

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException {

        List<Category> list=new ArrayList<Category>();
        try {
            String sql="select * from Category";
            PreparedStatement pt=con.prepareStatement(sql);
            ResultSet rs=pt.executeQuery();
            while (rs.next()){
                Category category=new Category();
                category.setCategoryId(rs.getInt("CategoryId"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setDescription(rs.getString("Description"));
                category.setActive(rs.getBoolean("Active"));
                list.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static String findByCategoryId(Connection con,int categoryId){
        String categoryName=null;
        try {
            String sql="select CategoryName from Category where CategoryId=?";
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setInt(1,categoryId);
            ResultSet rs=pt.executeQuery();
            while (rs.next()){
                categoryName=rs.getString("CategoryName");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryName;
    }
}

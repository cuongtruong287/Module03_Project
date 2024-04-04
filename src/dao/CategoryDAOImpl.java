package dao;

import entity.Category;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO{
    @Override
    public List<Category> getAllCategory() {
        // mo ket noi DB
        Connection connection = ConnectionDB.openConnection();
        List<Category> categories = new ArrayList<>();
        // thuc hien truy van cau lenh SQL thong qua
        try {
            // thuc hien cau lenh sql thogn qua preparedStatement
            PreparedStatement statement = connection.prepareStatement("select * from categories");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setCategoryStatus(resultSet.getBoolean("category_status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            {
                ConnectionDB.closeConnection(connection);
            }
        }
        return categories;
    }

    @Override
    public boolean addCagegory(Category category) {
        Connection connection = ConnectionDB.openConnection();
        try {
            String sql = "INSERT INTO categories(category_name, category_status) VALUE (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,category.getCategoryName());
            statement.setBoolean(2,category.getCategoryStatus());
            int check = statement.executeUpdate();
            if (check > 0){
                return  true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Category findByID(int id) {
        Connection connection = ConnectionDB.openConnection();
        Category category = new Category();
        try {
            String sql = "select * from categories where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return null;
            }
            while (resultSet.next()){
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setCategoryStatus(resultSet.getBoolean("Category_status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return category;
    }

    @Override
    public boolean updateCategory(Category category) {
        Connection connection = ConnectionDB.openConnection();
        try {
            String sql = "update categories set category_name = ?, category_status = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getCategoryName());
            statement.setBoolean(2,category.getCategoryStatus());
            statement.setInt(3,category.getCategoryId());
            int check = statement.executeUpdate();
            if (check > 0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void deleteCategory(int id) {
        Connection connection = ConnectionDB.openConnection();
        Category category = new Category();
        try {
            String sql = "delete from categories where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public List<Category> searchByName(String keyword) {
        // mo ket noi DB
        Connection connection = ConnectionDB.openConnection();
        List<Category> categories = new ArrayList<>();
        // thuc hien truy van cau lenh SQL thong qua
        try {
            // thuc hien cau lenh sql thogn qua preparedStatement
            String sql = "select * from categories where category_name like ? limit 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setCategoryStatus(resultSet.getBoolean("category_status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            {
                ConnectionDB.closeConnection(connection);
            }
        }
        return categories;
    }
}

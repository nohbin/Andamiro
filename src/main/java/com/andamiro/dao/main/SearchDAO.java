package com.andamiro.dao.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andamiro.dto.search.SearchVO;
import com.andamiro.utill.DBManager;

public class SearchDAO {
    private static SearchDAO instance = new SearchDAO();

    private SearchDAO() {
    }

    public static SearchDAO getInstance() {
        return instance;
    }

    public ArrayList<SearchVO> searchResult(String query) {
        ArrayList<SearchVO> searchResults = new ArrayList<>();
        String sql = "SELECT recipename, userid FROM search_table WHERE recipename LIKE ? OR userid LIKE ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + query + "%");
            pstmt.setString(2, "%" + query + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String recipename = rs.getString("recipename");
                String userid = rs.getString("userid");
                SearchVO searchVO = new SearchVO();
                searchResults.add(searchVO);
                System.out.println(searchVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           DBManager.close(conn, pstmt, rs);
        }

        return searchResults;
    }
}


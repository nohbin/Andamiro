package com.andamiro.dao.main;
//package com.andamiro.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.andamiro.dto.main.MainSearchVO;
//import com.andamiro.utill.DBManager;
//
//public class MainSearchDAO {
//    private MainSearchDAO() {
//    }
//
//    private static MainSearchDAO instance = new MainSearchDAO();
//
//    public static MainSearchDAO getInstance() {
//        return instance;
//    }
//
//    public List<MainSearchVO> searchRecipe(String recipename) {
//    	String sql = "SELECT * FROM andamirorecipe WHERE recipename LIKE ?";
//    	List<MainSearchVO> list = new ArrayList<MainSearchVO>();
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//      
//        try {
//            conn = DBManager.getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "%" + recipename + "%");
//            rs = pstmt.executeQuery();
//            System.out.println("성공"+conn);
//            System.out.println("rs"+rs);
//            System.out.println("list"+list);
//            System.out.println("recipename1"+recipename);
//            while (rs.next()) {
//                MainSearchVO mainSearchVO = new MainSearchVO();
//                mainSearchVO.setRecipename(rs.getString("recipename"));
//                list.add(mainSearchVO);
//                System.out.println("리스트는" + list);
//                System.out.println("recipename2"+recipename);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBManager.close(conn, pstmt, rs);
//        }
//
//        return list;
//    }
//}



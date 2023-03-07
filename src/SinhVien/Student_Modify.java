package SinhVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Student_Modify {
	public static List<SinhVien> showAll() {
		List<SinhVien> dssv = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection("jbbc:mysql://localhost:3306/Student", "root", "");
			String sql = "select* from Student";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				SinhVien std = new SinhVien(rs.getInt("ID"), rs.getString("fullName"), rs.getString("gender"),
						rs.getString("email"), rs.getString("phoneNumber"), rs.getInt("age"));
				dssv.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dssv;
	}

	public static void insert(SinhVien sv) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306:/Student", "root", "");
			String sql = "inser into SinhVien(ID,fullName,gender,email,phoneNumber,age) values(?,?,?,?,?,?)";
			st = con.prepareCall(sql);
			st.setLong(1, sv.getID());
			st.setString(2, sv.getFullName());
			st.setString(3, sv.getGender());
			st.setString(4, sv.getEmail());
			st.setString(5, sv.getPhoneNumber());
			st.setLong(6, sv.getAge());
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void update(SinhVien sv) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql:/localhost:3306:/Student", "root", "");
			String sql = "update SinhVien set fullName=?,gender=?,email=?,phoneNumber=?,age=? where id=?";
			ps = con.prepareCall(sql);
			ps.setString(1, sv.getFullName());
			ps.setString(2, sv.getGender());
			ps.setString(3, sv.getEmail());
			ps.setString(4, sv.getPhoneNumber());
			ps.setLong(5, sv.getAge());
			ps.setLong(6, sv.getID());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql:/localhost:3306:/Student", "root", "");
			String sql = "delete from Student where id =?";
			ps.setLong(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static List<SinhVien> findStudentByFullname(String fullName) {
		List<SinhVien> dssv = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DriverManager.getConnection("jbbc:mysql://localhost:3306/Student", "root", "");
			String sql = "select* from Student where like fullName ?";
			st =  con.prepareStatement(sql);
			st.setString(1,"%"+ fullName+"%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				SinhVien std = new SinhVien(rs.getInt("ID"), rs.getString("fullName"), rs.getString("gender"),
						rs.getString("email"), rs.getString("phoneNumber"), rs.getInt("age"));
				dssv.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dssv;
	}
}

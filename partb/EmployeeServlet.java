import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String idParam = request.getParameter("id");

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "yourpassword");
            st = con.createStatement();

            if(idParam != null && !idParam.isEmpty()) {
                rs = st.executeQuery("SELECT * FROM employee WHERE id=" + idParam);
            } else {
                rs = st.executeQuery("SELECT * FROM employee");
            }

            out.println("<h2>Employee Records</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Designation</th><th>Salary</th></tr>");
            while(rs.next()) {
                out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+
                            "</td><td>"+rs.getString(3)+"</td><td>"+rs.getDouble(4)+"</td></tr>");
            }
            out.println("</table>");

        } catch(Exception e) {
            e.printStackTrace(out);
        } finally {
            try { if(rs!=null) rs.close(); if(st!=null) st.close(); if(con!=null) con.close(); } catch(Exception e){}
        }
    }
}

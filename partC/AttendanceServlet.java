import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "yourpassword");

            PreparedStatement ps = con.prepareStatement("INSERT INTO attendance(student_name, roll_no, status) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, roll);
            ps.setString(3, status);

            int i = ps.executeUpdate();
            if(i > 0) {
                out.println("<h3>Attendance submitted successfully!</h3>");
            } else {
                out.println("<h3>Failed to submit attendance.</h3>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}

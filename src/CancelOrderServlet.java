import com.order.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class CancelOrderServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String orderName = req.getParameter("orderName");

            if (orderName.isEmpty()) {
                resp.getWriter().print("Ordername is empty");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("CancelOrder.html");
                requestDispatcher.include(req, resp);
            }

            DataBaseConnection dataBaseConnection = new DataBaseConnection(orderName);
            Connection connection = dataBaseConnection.createConnection();
            ResultSet resultSet=dataBaseConnection.getOrder(connection);
            try{
                resp.getWriter().print("Order name  : " + resultSet.getString("orderName"));
                resp.getWriter().print("TechChicken  : " + resultSet.getString("TechChicken"));
                resp.getWriter().print("Chilli Chicken  : " + resultSet.getString("chilliChicken"));
                resp.getWriter().print("Veg Biryani  : " + resultSet.getString("vegBiryani"));

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("CancelOrder.html");
                requestDispatcher.include(req, resp);

            }catch (SQLException e){
                e.printStackTrace();
            }
        }


    }





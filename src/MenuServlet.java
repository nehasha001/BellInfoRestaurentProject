
import com.order.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

    public class MenuServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String techChicken = req.getParameter("techChicken");
            String chilliChicken = req.getParameter("chilliChicken");
            String vegBiryani = req.getParameter("vegBiryani");
            String orderName = req.getParameter("orderName");

            if (orderName.isEmpty()) {
                resp.getWriter().print("Don't forget order name");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.html");
                requestDispatcher.include(req, resp);
            }else if (techChicken.isEmpty() &&
                    chilliChicken.isEmpty() &&
                    vegBiryani.isEmpty()) {
                resp.getWriter().print("Choose at least one item");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.html");
                requestDispatcher.include(req, resp);
            }

            if (techChicken.isEmpty()) techChicken = "0";
            if (chilliChicken.isEmpty()) chilliChicken = "0";
            if (vegBiryani.isEmpty()) vegBiryani = "0";

            DataBaseConnection dataBaseConnection = new DataBaseConnection(orderName, techChicken, chilliChicken, vegBiryani);
            Connection connection = dataBaseConnection.createConnection();
            dataBaseConnection.setOrder(connection);

            resp.getWriter().print("Order placed!!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Home.html");
            requestDispatcher.include(req, resp);


        }
    }



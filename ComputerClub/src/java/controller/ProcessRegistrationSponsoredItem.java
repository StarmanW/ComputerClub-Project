package controller;

import dataAccess.CollaboratorDA;
import dataAccess.ItemDA;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessRegistrationSponsoredItem", urlPatterns = {"/ProcessRegistrationSponsoredItem"})
public class ProcessRegistrationSponsoredItem extends HttpServlet {

    //DAs declaration
    CollaboratorDA collaboratorDA;
    ItemDA itemDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Retrieve all values from request
        String itemName = request.getParameter("itemName");
        String collabName = request.getParameter("collabName");
        int itemType = Integer.parseInt(request.getParameter("itemType"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (itemName.isEmpty() || collabName.isEmpty()) {
            response.sendRedirect("registerSponsoredItem.jsp?empty");
        } else {

            collaboratorDA = new CollaboratorDA();
            itemDA = new ItemDA();
            ArrayList<Item> itemList = itemDA.selectAllItem();

            try {
                //Creating Item object for INSERT operation
                Item item = new Item(String.format("IT%04d", (itemList.size() + 1)), collaboratorDA.selectRecord(collabName), itemType, itemName, quantity);

                //Perform INSERT on member details
                int successInsert = itemDA.createRecord(item);
                switch (successInsert) {
                    case 1:
                        response.sendRedirect("registerSponsoredItem.jsp?success");
                        break;
                    case -1:
                        response.sendRedirect("registerSponsoredItem.jsp?duplicated");
                        break;
                    case 0:
                        response.sendRedirect("registerSponsoredItem.jsp?error");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

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
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?empty");
        } else {
            try {
                Item item = null;
                collaboratorDA = new CollaboratorDA();
                itemDA = new ItemDA();
                ArrayList<Item> itemList = itemDA.selectAllItem();

                if (!itemList.isEmpty()) {
                    int lastID = Integer.parseInt(itemList.get(itemList.size() - 1).getItemID().substring(2, 6));
                    //Creating Item object for INSERT operation
                    item = new Item(String.format("IT%04d", (itemList.size() + 1)), collaboratorDA.selectRecord(collabName), itemType, itemName, quantity);
                } else {
                    item = new Item(String.format("IT%04d", 1), collaboratorDA.selectRecord(collabName), itemType, itemName, quantity);
                }

                //Perform INSERT on member details
                int successInsert = itemDA.createRecord(item);
                switch (successInsert) {
                    case 1:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?success");
                        break;
                    case -1:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?duplicated");
                        break;
                    case 0:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?error");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

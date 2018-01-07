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
@WebServlet(name = "ProcessUpdateSponsoredItem", urlPatterns = {"/ProcessUpdateSponsoredItem"})
public class ProcessUpdateSponsoredItem extends HttpServlet {

    //DAs declaration
    CollaboratorDA collaboratorDA;
    ItemDA itemDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Retrieve all values from request
        String itemID = (String) request.getSession().getAttribute("itemID");
        String itemName = request.getParameter("itemName");
        String collabName = request.getParameter("collabName");
        int itemType = Integer.parseInt(request.getParameter("itemType"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        //Validate values - if empty, redirect back to page
        if (itemName.isEmpty() || collabName.isEmpty()) {
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?empty");
        } else {
            try {
                //Creating collaboratorDA and itemDA object for UPDATE operation
                //Get the list of item for size check
                //Creating a new Item object for UPDATE operation
                collaboratorDA = new CollaboratorDA();
                itemDA = new ItemDA();
                ArrayList<Item> itemList = itemDA.selectAllItem();
                Item item = new Item(itemID, collaboratorDA.selectRecord(collabName), itemType, itemName, quantity);

                //Perform UPDATE operation on new item details
                int successUpdate = itemDA.updateRecord(item);
                switch (successUpdate) {
                    case 1:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?itemID=" + itemID + "&success");
                        break;
                    case 0:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?itemID=" + itemID + "&error");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

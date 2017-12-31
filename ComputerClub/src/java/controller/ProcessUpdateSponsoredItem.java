/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    CollaboratorDA collaboratorDA;
    ItemDA itemDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String itemID = (String) request.getSession().getAttribute("itemID");
        String itemName = request.getParameter("itemName");
        String collabName = request.getParameter("collabName");
        int itemType = Integer.parseInt(request.getParameter("itemType"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (itemName.isEmpty() || collabName.isEmpty()) {
            response.sendRedirect("registerSponsoredItem.jsp?empty");
        }

        try {
            collaboratorDA = new CollaboratorDA();
            itemDA = new ItemDA();
            ArrayList<Item> itemList = itemDA.selectAllItem();
            Item item = new Item(itemID, collaboratorDA.selectRecord(collabName), itemType, itemName, quantity);

            int successInsert = itemDA.updateRecord(item);
            switch (successInsert) {
                case 1:
                    response.sendRedirect("updateSponsoredItem.jsp?itemID=" + itemID + "&success");
                    break;
                case 0:
                    response.sendRedirect("updateSponsoredItem.jsp?itemID=" + itemID + "&error");
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

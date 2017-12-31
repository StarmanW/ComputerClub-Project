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
import javax.servlet.http.HttpSession;
import model.Item;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessDeleteSponsoredItem", urlPatterns = {"/ProcessDeleteSponsoredItem"})
public class ProcessDeleteSponsoredItem extends HttpServlet {

    ItemDA itemDA;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Get member object from session
        Item item = (Item) request.getSession().getAttribute("itemToDelete");
        HttpSession session = request.getSession();
        
        try {
            itemDA = new ItemDA();
            int successDelete = itemDA.deleteRecord(item.getItemID());
            switch (successDelete) {
                case 1:     //Display deletion status
                    response.sendRedirect("deleteSponsoredItemStatus.jsp?success");
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
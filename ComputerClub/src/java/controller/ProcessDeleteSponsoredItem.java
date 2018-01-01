package controller;

import dataAccess.ItemDA;
import java.io.IOException;
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

    //DA declaration
    ItemDA itemDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //If memberToDelete attribute is empty, redirect back to deleteMember.jsp?studID=
        if (request.getSession().getAttribute("itemToDelete") == null) {
            response.sendRedirect("deleteSponsoredItem.jsp?itemID=");
        } else {
            //Get member object from session
            Item item = (Item) request.getSession().getAttribute("itemToDelete");
            HttpSession session = request.getSession();

            try {
                //Creating ItemDA for DELETE operation
                itemDA = new ItemDA();

                //Perform DELETE operation on selected itemID
                int successDelete = itemDA.deleteRecord(item.getItemID());
                switch (successDelete) {
                    case 1:     //Display deletion status
                        response.sendRedirect("deleteSponsoredItemStatus.jsp?success");
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                session.setAttribute("errorMsg", ex.getMessage());
                response.sendRedirect("deleteSponsoredItemStatus.jsp?error");
                ex.printStackTrace();
            }
        }
    }
}

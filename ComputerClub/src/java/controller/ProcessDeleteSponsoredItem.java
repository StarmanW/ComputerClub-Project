package controller;

import dataAccess.EventItemDA;
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
    EventItemDA eventItemDA;

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
                eventItemDA = new EventItemDA();

                //Perform DELETE operation on selected itemID
                boolean successDeleteEI = eventItemDA.deleteRecordByItemID(item.getItemID());
                int successDelete = itemDA.deleteRecord(item.getItemID());

                if (successDeleteEI && successDelete == 1) {
                    response.sendRedirect("deleteSponsoredItemStatus.jsp?success");
                }
            } catch (Exception ex) {
                session.setAttribute("errorMsg", ex.getMessage());
                response.sendRedirect("deleteSponsoredItemStatus.jsp?error");
                ex.printStackTrace();
            }
        }
    }
}

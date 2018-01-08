package controller;

import dataAccess.CollaboratorDA;
import dataAccess.EventCollaboratorDA;
import dataAccess.EventItemDA;
import dataAccess.ItemDA;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Collaborator;

/**
 *
 * @author Samuel Wong Kim Foong
 */
@WebServlet(name = "ProcessDeleteCollaborator", urlPatterns = {"/ProcessDeleteCollaborator"})
public class ProcessDeleteCollaborator extends HttpServlet {

    //DA declaration
    CollaboratorDA collaboratorDA;
    EventCollaboratorDA eventCollaboratorDA;
    EventItemDA eventItemDA;
    ItemDA itemDA;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //If memberToDelete attribute is empty, redirect back to deleteMember.jsp?studID=
        if (request.getSession().getAttribute("collaboratorToDelete") == null) {
            response.sendRedirect("deleteCollaborator.jsp?collabID=");
        } else {
            //Get member object from session
            Collaborator collaborator = (Collaborator) request.getSession().getAttribute("collaboratorToDelete");
            HttpSession session = request.getSession();

            try {
                //Perform member DELETE operation
                collaboratorDA = new CollaboratorDA();
                eventCollaboratorDA = new EventCollaboratorDA();
                itemDA = new ItemDA();
                eventItemDA = new EventItemDA();
                
                boolean successDeleteEventItem = eventItemDA.deleteRecordByItemID(itemDA.selectRecordByCollabID(collaborator.getCollabID()).getItemID());
                boolean successDeleteItem = itemDA.deleteRecordByCollabID(collaborator.getCollabID());
                boolean successDeleteEC = eventCollaboratorDA.deleteRecordByCollaboratorID(collaborator.getCollabID());
                int successDelete = collaboratorDA.deleteRecord(collaborator.getCollabID());
                
                if (successDelete == 1 && successDeleteEC && successDeleteItem && successDeleteEventItem) {
                    response.sendRedirect("deleteCollaboratorStatus.jsp?success");
                }
            } catch (Exception ex) {
                session.setAttribute("errorMsg", ex.getMessage());
                response.sendRedirect("deleteCollaboratorStatus.jsp?error");
                ex.printStackTrace();
            }
        }
    }
}

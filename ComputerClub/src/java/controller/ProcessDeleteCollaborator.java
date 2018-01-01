package controller;

import dataAccess.CollaboratorDA;
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
 * @author StarmanW
 */
@WebServlet(name = "ProcessDeleteCollaborator", urlPatterns = {"/ProcessDeleteCollaborator"})
public class ProcessDeleteCollaborator extends HttpServlet {

    //DA declaration
    CollaboratorDA collaboratorDA;

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
                int successDelete = collaboratorDA.deleteRecord(collaborator.getCollabID());
                switch (successDelete) {
                    case 1:     //Display deletion status
                        response.sendRedirect("deleteCollaboratorStatus.jsp?success");
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                session.setAttribute("errorMsg", ex.getMessage());
                response.sendRedirect("deleteCollaboratorStatus.jsp?error");
                ex.printStackTrace();
            }
        }
    }
}

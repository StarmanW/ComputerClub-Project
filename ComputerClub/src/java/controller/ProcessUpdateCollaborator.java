package controller;

import dataAccess.CollaboratorDA;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Collaborator;

/**
 *
 * @author Samuel Wong Kim Foong
 */
@WebServlet(name = "ProcessUpdateCollaborator", urlPatterns = {"/ProcessUpdateCollaborator"})
public class ProcessUpdateCollaborator extends HttpServlet {

    //DA declaration
    CollaboratorDA collaboratorDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get all parameters value from request
        String collabID = (String) request.getSession().getAttribute("collabID");
        String collabName = request.getParameter("collabName");
        int collabType = Integer.parseInt(request.getParameter("collabType"));
        String collabContact = request.getParameter("collabContact");
        String collabEmail = request.getParameter("collabEmail");
        String additionalNotes = request.getParameter("additionalNotes");

        //Redirect back to registerCollaborator page with parameter ?empty
        //To display empty fields error message
        if (collabName.isEmpty() || collabContact.isEmpty() || collabEmail.isEmpty()) {
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?empty");
        } else {
            try {
                collaboratorDA = new CollaboratorDA();

                //Creating new collaborator object
                Collaborator collaborator = new Collaborator(collabID, collabName, collabType, collabContact, collabEmail, additionalNotes);

                //Perform UPDATE operation on collaborator object
                int successUpdate = collaboratorDA.updateRecord(collaborator);
                switch (successUpdate) {
                    case 1:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?collabID=" + collabID + "&success");
                        break;
                    default:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?collabID=" + collabID + "&error");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

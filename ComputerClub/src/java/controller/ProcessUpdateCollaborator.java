package controller;

import dataAccess.CollaboratorDA;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Collaborator;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessUpdateCollaborator", urlPatterns = {"/ProcessUpdateCollaborator"})
public class ProcessUpdateCollaborator extends HttpServlet {

    CollaboratorDA collaboratorDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get all parameters value
        String collabID = (String) request.getSession().getAttribute("collabID");
        String collabName = request.getParameter("collabName");
        int collabType = Integer.parseInt(request.getParameter("collabType"));
        String collabContact = request.getParameter("collabContact");
        String collabEmail = request.getParameter("collabEmail");
        String additionalNotes = request.getParameter("additionalNotes");

        //Redirect back to registerCollaborator page with parameter ?empty
        //To display empty fields error message
        if (collabName.isEmpty() || collabContact.isEmpty() || collabEmail.isEmpty()) {
            response.sendRedirect("updateCollaborator.jsp?empty");
        }

        try {
            collaboratorDA = new CollaboratorDA();
            ArrayList<Collaborator> collabList = collaboratorDA.selectAllCollaboratorList();
            
            //Creating new collaborator object
            Collaborator collaborator = new Collaborator(String.format(collabID, (collabList.size() + 1)), collabName, collabType, collabContact, collabEmail, additionalNotes);

            int successUpdate = collaboratorDA.updateRecord(collaborator);
            switch (successUpdate) {
                case 1:
                    response.sendRedirect("updateCollaborator.jsp?collabID=" + collabID + "&success");
                    break;
                default:
                    response.sendRedirect("updateCollaborator.jsp?collabID=" + collabID + "&error");
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
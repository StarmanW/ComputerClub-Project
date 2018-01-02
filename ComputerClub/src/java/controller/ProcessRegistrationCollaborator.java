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
@WebServlet(name = "ProcessRegistrationCollaborator", urlPatterns = {"/ProcessRegistrationCollaborator"})
public class ProcessRegistrationCollaborator extends HttpServlet {

    //DA declaration
    CollaboratorDA collaboratorDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get all parameters value from request
        String collabName = request.getParameter("collabName");
        int collabType = Integer.parseInt(request.getParameter("collabType"));
        String collabContact = request.getParameter("collabContact");
        String collabEmail = request.getParameter("collabEmail");
        String additionalNotes = request.getParameter("additionalNotes");

        //Redirect back to registerCollaborator page with parameter ?empty
        //To display empty fields error message
        if (collabName.isEmpty() || collabContact.isEmpty() || collabEmail.isEmpty()) {
            response.sendRedirect("registerCollaborator.jsp?empty");
        } else {
            try {
                Collaborator collaborator = null;
                collaboratorDA = new CollaboratorDA();
                ArrayList<Collaborator> collabList = collaboratorDA.selectAllCollaboratorList();

                //Validate if there is collaborator records in database
                if (!collabList.isEmpty()) {
                    int lastID = Integer.parseInt(collabList.get(collabList.size() - 1).getCollabID().substring(1, 5));
                    //Creating new collaborator object
                    collaborator = new Collaborator(String.format("C%04d", (lastID + 1)), collabName, collabType, collabContact, collabEmail, additionalNotes);
                } else {
                    collaborator = new Collaborator(String.format("C%04d", 1), collabName, collabType, collabContact, collabEmail, additionalNotes);
                }
                
                //Perform INSERT operation on collaborator object
                int successInsert = collaboratorDA.createRecord(collaborator);
                switch (successInsert) {
                    case 1:
                        response.sendRedirect("registerCollaborator.jsp?success");
                        break;
                    case -1:
                        response.sendRedirect("registerCollaborator.jsp?duplicated");
                        break;
                    case 0:
                        response.sendRedirect("registerCollaborator.jsp?error");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

package controller;

import dataAccess.MemberDA;
import dataAccess.ProgrammeDA;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Member;
import model.Name;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessRegistrationMember", urlPatterns = {"/ProcessRegistrationMember"})
public class ProcessRegistrationMember extends HttpServlet {

    //DAs declaration
    MemberDA memberDA;
    ProgrammeDA programmeDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        programmeDA = new ProgrammeDA();

        //Retrieve all the values from request
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String icNum = request.getParameter("icNum");
        String memID = request.getParameter("memID");
        String contactNo = request.getParameter("contactNo");
        String email = request.getParameter("email");
        String progID = request.getParameter("progID");
        String academicYear = request.getParameter("academicYear");
        char gender = request.getParameter("gender").charAt(0);
        boolean memFeeStats = Boolean.parseBoolean(request.getParameter("memFeeStats"));
        int position = Integer.parseInt(request.getParameter("position"));

        if (fName.isEmpty() || lName.isEmpty() || icNum.isEmpty() || memID.isEmpty() || contactNo.isEmpty() || email.isEmpty() || progID.isEmpty() || academicYear.isEmpty()
                || String.valueOf(gender).isEmpty()) {
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?empty");
        } else {
            try {
                //Creating memberDA and member object 
                Member member = new Member(memID, programmeDA.selectProgramme(progID),
                        new Name(fName, lName), email, contactNo, icNum,
                        icNum, gender, memFeeStats, position, academicYear);
                memberDA = new MemberDA();
                
                //Perform INSERT operation and validate insert operation
                int successInsert = memberDA.createRecord(member);
                switch (successInsert) {
                    case 1:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?success");
                        break;
                    case -1:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?duplicated");
                        break;
                    default:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?error");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

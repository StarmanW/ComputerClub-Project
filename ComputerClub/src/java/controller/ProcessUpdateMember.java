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
@WebServlet(name = "ProcessUpdateMember", urlPatterns = {"/ProcessUpdateMember"})
public class ProcessUpdateMember extends HttpServlet {

    //DAs declaration
    MemberDA memberDA;
    ProgrammeDA programmeDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Retrieve all values from request
        String studIDOriginal = (String) request.getSession().getAttribute("studIDOriginal");
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

        //Empty fields verification
        if (fName.isEmpty() || lName.isEmpty() || icNum.isEmpty() || memID.isEmpty() || contactNo.isEmpty() || email.isEmpty() || progID.isEmpty() || academicYear.isEmpty()
                || String.valueOf(gender).isEmpty()) {
            response.sendRedirect(request.getSession().getAttribute("requestURL") + "?empty");
        } else {
            try {
                //Creating programmeDA and memberDA object for UPDATE operation
                programmeDA = new ProgrammeDA();
                memberDA = new MemberDA();

                //Creating member object
                Member member = new Member(memID, programmeDA.selectProgramme(progID),
                        new Name(fName, lName), email, contactNo, icNum,
                        icNum, gender, memFeeStats, position, academicYear);

                //Perform UPDATE on member details
                int successUpdate = memberDA.updateRecord(member, studIDOriginal);
                switch (successUpdate) {
                    case 1:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?studID=" + member.getStudID() + "&success");
                        break;
                    default:
                        response.sendRedirect(request.getSession().getAttribute("requestURL") + "?studID=" + member.getStudID() + "&error");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

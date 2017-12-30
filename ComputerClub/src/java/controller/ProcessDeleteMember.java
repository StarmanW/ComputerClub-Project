package controller;

import dataAccess.MemberDA;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Member;

/**
 *
 * @author StarmanW
 */
@WebServlet(name = "ProcessDeleteMember", urlPatterns = {"/ProcessDeleteMember"})
public class ProcessDeleteMember extends HttpServlet {

    //Data Access declaration
    MemberDA memberDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Get member object from session
        Member member = (Member) request.getSession().getAttribute("memberToDelete");
        HttpSession session = request.getSession();

        try {
            //Execute member deletion
            memberDA = new MemberDA();
            int successInsert = memberDA.deleteRecord(member);
            switch (successInsert) {
                case 1:     //Display deletion status
                    response.sendRedirect("deleteMemberStatus.jsp?success");
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            session.setAttribute("errorMsg", ex.getMessage());
            response.sendRedirect("deleteMemberStatus.jsp?error");
            ex.printStackTrace();
        }
    }
}

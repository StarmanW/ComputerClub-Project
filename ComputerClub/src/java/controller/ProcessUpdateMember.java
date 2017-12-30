/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dataAccess.MemberDA;
import dataAccess.ProgrammeDA;
import java.io.IOException;
import java.io.PrintWriter;
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

    MemberDA memberDA;
    ProgrammeDA programmeDA;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        programmeDA = new ProgrammeDA();
        
        String studIDOriginal = String.valueOf(request.getSession().getAttribute("studIDOriginal"));
        
        //Retrieve all the values
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
            response.sendRedirect("updateMember.jsp?empty");
        }
        
        //Creating a new temporary member object for update
        Member member = new Member(memID, programmeDA.selectProgramme(progID),
                new Name(fName, lName), email, contactNo, icNum,
                icNum, gender, memFeeStats, position, academicYear);

        //Perform update on member detail
        try {
            memberDA = new MemberDA();
            int successInsert = memberDA.updateRecord(member, studIDOriginal);
            switch (successInsert) {
                case 1:
                    response.sendRedirect("updateMember.jsp?studID=" + member.getStudID() + "&success");
                    break;
                default:
                    response.sendRedirect("updateMember.jsp?studID=" + member.getStudID() + "&error");
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

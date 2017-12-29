package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class registerMember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      dataAccess.ProgrammeDA programme = null;
      synchronized (application) {
        programme = (dataAccess.ProgrammeDA) _jspx_page_context.getAttribute("programme", PageContext.APPLICATION_SCOPE);
        if (programme == null){
          programme = new dataAccess.ProgrammeDA();
          _jspx_page_context.setAttribute("programme", programme, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- Site made with Mobirise Website Builder v4.5.2, https://mobirise.com -->\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"generator\" content=\"Mobirise v4.5.2, mobirise.com\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"assets/images/logo-1-3508x2480.jpg\" type=\"image/x-icon\">\r\n");
      out.write("    <meta name=\"description\" content=\"Website Creator Description\">\r\n");
      out.write("    <title>Register Member</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/web/assets/mobirise-icons/mobirise-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/web/assets/mobirise-icons-bold/mobirise-icons-bold.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/tether/tether.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap-grid.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap-reboot.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/socicon/css/styles.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/dropdown/css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/theme/css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/mobirise/css/mbr-additional.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/mobirise/css/mbr-additional.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/registerMember.css\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <section class=\"menu cid-qDNS0J8sKR\" once=\"menu\" id=\"menu1-k\" data-rv-view=\"2425\">\r\n");
      out.write("        <nav class=\"navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm\">\r\n");
      out.write("            <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <div class=\"hamburger\">\r\n");
      out.write("                    <span></span>\r\n");
      out.write("                    <span></span>\r\n");
      out.write("                    <span></span>\r\n");
      out.write("                    <span></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"menu-logo\">\r\n");
      out.write("                <div class=\"navbar-brand\">\r\n");
      out.write("                    <span class=\"navbar-logo\">\r\n");
      out.write("                    <a href=\"homepage.jsp\">\r\n");
      out.write("                         <img src=\"assets/images/logo-1-3508x2480.jpg\" title=\"\" media-simple=\"true\" style=\"height: 4.5rem;\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                </span>\r\n");
      out.write("                    <span class=\"navbar-caption-wrap\"><a class=\"navbar-caption text-white display-4\" href=\"homepage.jsp\">\r\n");
      out.write("                        COMPUTER CLUB</a></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                <ul class=\"navbar-nav nav-dropdown\" data-app-modern-menu=\"true\">\r\n");
      out.write("                    <li class=\"nav-item dropdown open\"><a class=\"nav-link link text-white dropdown-toggle display-4\" aria-expanded=\"true\" data-toggle=\"dropdown-submenu\">REGISTER</a>\r\n");
      out.write("                        <div class=\"dropdown-menu\"><a class=\"text-white dropdown-item display-4\" href=\"registerMember.jsp\" aria-expanded=\"false\">MEMBER</a><a class=\"text-white dropdown-item display-4\" href=\"registerEvent.jsp\" aria-expanded=\"false\">EVENT</a><a class=\"text-white dropdown-item display-4\" href=\"registerCollaborator.jsp\" aria-expanded=\"false\">COLLABORATOR</a></div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item dropdown\"><a class=\"nav-link link dropdown-toggle text-white display-4\" data-toggle=\"dropdown-submenu\" aria-expanded=\"false\">MANAGE</a>\r\n");
      out.write("                        <div class=\"dropdown-menu\"><a class=\"dropdown-item text-white display-4\" href=\"memberList.jsp\">MEMBERS</a><a class=\"dropdown-item text-white display-4\" href=\"eventList.jsp\">EVENTS</a><a class=\"dropdown-item text-white display-4\" href=\"collaboratorList.jsp\">COLLABORATORS</a></div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div class=\"navbar-buttons mbr-section-btn\"><a class=\"btn btn-sm btn-primary display-4\" href=\"index.jsp\"><span class=\"mbrib-lock mbr-iconfont mbr-iconfont-btn\"></span>\r\n");
      out.write("                    \r\n");
      out.write("                    LOGOUT</a></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </section>\r\n");
      out.write("    <section class=\"cid-qECj4TnJzd mbr-fullscreen mbr-parallax-background\" id=\"header2-14\" data-rv-view=\"3093\">\r\n");
      out.write("        <div class=\"container align-center\">\r\n");
      out.write("            <br />\r\n");
      out.write("            <br />\r\n");
      out.write("            <div class=\"form-container\">\r\n");
      out.write("                <h1 class=\"well\">Register New Member</h1>\r\n");
      out.write("                <hr style=\"border-top:1px solid gray;\" />\r\n");
      out.write("                <div class=\"col-lg-12 well\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <form>\r\n");
      out.write("                            <p style=\"color:red; float: left;\">\"*\" Required fields</p>\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <p style=\"color:red\">Please ensure all the fields are not left blank</p>\r\n");
      out.write("                            <div class=\"col-sm-12\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>First Name</label>\r\n");
      out.write("                                        <input type=\"text\" placeholder=\"John\" class=\"form-control\" pattern=\"[A-Za-z\\-@ ]{2,}\" title=\"Alphabetic, @ and - symbols only. E.g. - John\" required=\"required\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Last Name</label>\r\n");
      out.write("                                        <input type=\"text\" placeholder=\"Doe\" class=\"form-control\" pattern=\"[A-Za-z\\-@ ]{2,}\" title=\"Alphabetic, @ and - symbols only. E.g. - Smith\" required=\"required\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>IC Number</label>\r\n");
      out.write("                                        <input type=\"text\" placeholder=\"981213125523\" class=\"form-control\" pattern=\"\\d{12}\" title=\"Numeric only. E.g. 985564127789\" required=\"required\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Member ID</label>\r\n");
      out.write("                                        <input type=\"text\" placeholder=\"16SMD00990\" class=\"form-control\" pattern=\"^\\d{2}[A-Z]{3}\\d{5}$\" title=\"E.g. 16SMD00990\" required=\"required\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Contact Number</label>\r\n");
      out.write("                                        <input type=\"text\" placeholder=\"0195421325\" class=\"form-control\" pattern=\"([0-9]|[0-9\\-]){3,20}\" title=\"Numeric and '-' symbols only. E.g. 014-8897875\" required=\"required\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Email</label>\r\n");
      out.write("                                        <input type=\"email\" placeholder=\"email@hotmail.com\" class=\"form-control\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$\" title=\"E.g. - cisco@business.co.uk\" required=\"required\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Programme Code</label>\r\n");
      out.write("                                        <select name=\"\" class=\"form-control\" required=\"required\">\r\n");
      out.write("                                            <option disabled selected value>Select programme code</option>\r\n");
      out.write("                                            ");

                                                ArrayList<model.Programme> progList = programme.retrieveAllProgrammes();
                                                for (int i = 0; i < progList.size(); i++) {
                                            
      out.write("\r\n");
      out.write("                                            <option value=\"");
      out.print(progList.get(i).getProgCode());
      out.write('"');
      out.write('>');
      out.print(progList.get(i).getProgCode());
      out.write("</option>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Academic Year</label>\r\n");
      out.write("                                        <select name=\"\" class=\"form-control\" required=\"required\">\r\n");
      out.write("                                            <option disabled selected value>Select academic year</option>\r\n");
      out.write("                                            <option value=\"2016/2017\">2016/2017</option>\r\n");
      out.write("                                            <option value=\"2017/2018\">2017/2018</option>\r\n");
      out.write("                                            <option value=\"2018/2019\">2018/2019</option>\r\n");
      out.write("                                            <option value=\"2019/2020\">2019/2020</option>\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Gender:</label>\r\n");
      out.write("                                        <br/>\r\n");
      out.write("                                        <input type=\"radio\" name=\"gender\" value=\"2\" required=\"required\"> Male &nbsp;\r\n");
      out.write("                                        <input type=\"radio\" name=\"gender\" value=\"1\"> Female\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6 form-group\">\r\n");
      out.write("                                        <label><span style=\"color:red;\">*</span>Membership Fee Status:</label>\r\n");
      out.write("                                        <br/>\r\n");
      out.write("                                        <input type=\"radio\" name=\"memFeeStats\" value=\"2\" required=\"required\"> Pending &nbsp;\r\n");
      out.write("                                        <input type=\"radio\" name=\"memFeeStats\" value=\"1\"> Paid\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\" style=\"margin:auto\">\r\n");
      out.write("                                    <label><span style=\"color:red;\">*</span>Position</label>\r\n");
      out.write("                                    <select name=\"\" class=\"form-control\" required=\"required\">\r\n");
      out.write("                                        <option disabled selected value>Select member position</option>\r\n");
      out.write("                                        <option value=\"5\">President</option>\r\n");
      out.write("                                        <option value=\"4\">Vice President</option>\r\n");
      out.write("                                        <option value=\"3\">Secretary</option>\r\n");
      out.write("                                        <option value=\"2\">Treasurer</option>\r\n");
      out.write("                                        <option value=\"1\">Member</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <div class=\"submit-button\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-lg btn-info\">Submit</button>\r\n");
      out.write("                                <button type=\"reset\" class=\"btn btn-lg btn-info\">Reset</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.container -->\r\n");
      out.write("        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\r\n");
      out.write("        <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>\r\n");
      out.write("        <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>\r\n");
      out.write("    </section>\r\n");
      out.write("    <section class=\"cid-qECiDnaZnD\" id=\"footer1-12\" data-rv-view=\"11590\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"media-container-row content text-white\">\r\n");
      out.write("                <div class=\"col-12 col-md-3\">\r\n");
      out.write("                    <div class=\"media-wrap\">\r\n");
      out.write("                        <a href=\"homepage.jsp\"><img src=\"assets/images/logo-2-3508x2480.jpg\" alt=\"Mobirise\" title=\"\" media-simple=\"true\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12 col-md-3 mbr-fonts-style display-7\">\r\n");
      out.write("                    <h5 class=\"pb-3\">\r\n");
      out.write("                    Address\r\n");
      out.write("                </h5>\r\n");
      out.write("                    <p class=\"mbr-text\">Lot 1, Ground Floor,\r\n");
      out.write("                        <br>Pusat Dagangan Donggongon,\r\n");
      out.write("                        <br>Jalan Sapau,\r\n");
      out.write("                        <br>89500 Donggongon,\r\n");
      out.write("                        <br>Penampang, Sabah</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12 col-md-3 mbr-fonts-style display-7\">\r\n");
      out.write("                    <h5 class=\"pb-3\">\r\n");
      out.write("                    Contacts\r\n");
      out.write("                </h5>\r\n");
      out.write("                    <p class=\"mbr-text\">\r\n");
      out.write("                        Email: sabah@tarc.edu.my\r\n");
      out.write("                        <br>Phone: (6)088-718481, 718482\r\n");
      out.write("                        <br>Fax: (6)088-718486\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12 col-md-3 mbr-fonts-style display-7\">\r\n");
      out.write("                    <h5 class=\"pb-3\">\r\n");
      out.write("                    Links\r\n");
      out.write("                </h5>\r\n");
      out.write("                    <p class=\"mbr-text\"><a href=\"http://www.tarc.edu.my/\" target=\"_blank\" class=\"text-primary\">TAR UC</a>\r\n");
      out.write("                        <br><a href=\"http://www.tarc.edu.my/sabah/index.jsp\" class=\"text-primary\" target=\"_blank\">TAR UC Sabah</a>\r\n");
      out.write("                        <br><a class=\"text-primary\" href=\"https://www.facebook.com/tarucsabah/\" target=\"_blank\">TAR UC Sabah Facebook</a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-lower\">\r\n");
      out.write("                <div class=\"media-container-row\">\r\n");
      out.write("                    <div class=\"col-sm-12\">\r\n");
      out.write("                        <hr>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"media-container-row mbr-white\">\r\n");
      out.write("                    <div class=\"col-sm-6 copyright\">\r\n");
      out.write("                        <p class=\"mbr-text mbr-fonts-style display-7\">\r\n");
      out.write("                            Â© Copyright 2017 TAR UC Computer Club - All Rights Reserved\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <script src=\"assets/web/assets/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/popper/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/tether/tether.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/touchswipe/jquery.touch-swipe.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/parallax/jarallax.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/smoothscroll/smooth-scroll.js\"></script>\r\n");
      out.write("    <script src=\"assets/dropdown/js/script.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/theme/js/script.js\"></script>\r\n");
      out.write("    <div id=\"scrollToTop\" class=\"scrollToTop mbr-arrow-up\"><a style=\"text-align: center;\"><i></i></a></div>\r\n");
      out.write("    <!-- Back to top -->\r\n");
      out.write("    <script>\r\n");
      out.write("    if (($(window).height() + 100) < $(document).height()) { $('#top-link-block').removeClass('hidden').affix({ offset: { top: 100 } }); }\r\n");
      out.write("    </script>\r\n");
      out.write("    <style>\r\n");
      out.write("    #top-link-block>.btn {\r\n");
      out.write("        font-size: 1.5em!important;\r\n");
      out.write("        opacity: 0.4!important;\r\n");
      out.write("        padding: 10px 20px!important\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #top-link-block.affix-top {\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        bottom: -82px;\r\n");
      out.write("        right: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #top-link-block.affix {\r\n");
      out.write("        position: fixed;\r\n");
      out.write("        bottom: 18px;\r\n");
      out.write("        right: 10px;\r\n");
      out.write("        z-index: 999;\r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

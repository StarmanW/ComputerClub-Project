package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- Site made with Mobirise Website Builder v4.5.2, https://mobirise.com -->\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"generator\" content=\"Mobirise v4.5.2, mobirise.com\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1\">\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/images/logo-1-3508x2480.jpg\" type=\"image/x-icon\">\r\n");
      out.write("        <meta name=\"description\" content=\"Main login page\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/web/assets/mobirise-icons/mobirise-icons.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/web/assets/mobirise-icons-bold/mobirise-icons-bold.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/tether/tether.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap-grid.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap-reboot.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/socicon/css/styles.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/dropdown/css/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/theme/css/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/mobirise/css/mbr-additional.css\" type=\"text/css\">\r\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/login.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"1019239783298-2ulfldbfduachc7dhp3qgcd39obhih4j.apps.googleusercontent.com\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <section class=\"menu cid-qDNS0J8sKR\" once=\"menu\" id=\"menu1-k\" data-rv-view=\"2425\">\r\n");
      out.write("            <nav class=\"navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm\">\r\n");
      out.write("                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                    <div class=\"hamburger\">\r\n");
      out.write("                        <span></span>\r\n");
      out.write("                        <span></span>\r\n");
      out.write("                        <span></span>\r\n");
      out.write("                        <span></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </button>\r\n");
      out.write("                <div class=\"menu-logo\">\r\n");
      out.write("                    <div class=\"navbar-brand\">\r\n");
      out.write("                        <span class=\"navbar-logo\">\r\n");
      out.write("                            <a href=\"index.jsp\">\r\n");
      out.write("                                <img src=\"assets/images/logo-1-3508x2480.jpg\" title=\"\" media-simple=\"true\" style=\"height: 4.5rem;\">\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <span class=\"navbar-caption-wrap\"><a class=\"navbar-caption text-white display-4\" href=\"index.jsp\">\r\n");
      out.write("                                COMPUTER CLUB</a></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </section>\r\n");
      out.write("        <section class=\"engine\"><a href=\"https://mobirise.co\">Mobirise</a></section>\r\n");
      out.write("        <section class=\"header8 cid-qEC5OqO45Z mbr-fullscreen mbr-parallax-background\" id=\"header8-p\" data-rv-view=\"11520\">\r\n");
      out.write("            <div class=\"mbr-overlay\" style=\"opacity: 0.2; background-color: rgb(0, 0, 0);\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"login-box animated fadeInUp\">\r\n");
      out.write("                    <div class=\"box-header\">\r\n");
      out.write("                        <h2 id=\"login_header\">Log In</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <label for=\"username\">Username</label>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <input type=\"text\" id=\"username\">\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <label for=\"password\">Password</label>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <input type=\"password\" id=\"password\">\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <button type=\"submit\">Login</button>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <div class=\"g-signin2\" data-onsuccess=\"onSignIn\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("    </section>\r\n");
      out.write("    <section class=\"cid-qBqEf2LrJD\" id=\"footer1-4\" data-rv-view=\"11523\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"media-container-row content text-white\">\r\n");
      out.write("                <div class=\"col-12 col-md-3\">\r\n");
      out.write("                    <div class=\"media-wrap\">\r\n");
      out.write("                        <a href=\"index.jsp\"><img src=\"assets/images/logo-2-3508x2480.jpg\" alt=\"Mobirise\" title=\"\" media-simple=\"true\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12 col-md-3 mbr-fonts-style display-7\">\r\n");
      out.write("                    <h5 class=\"pb-3\">\r\n");
      out.write("                        Address\r\n");
      out.write("                    </h5>\r\n");
      out.write("                    <p class=\"mbr-text\">Lot 1, Ground Floor,\r\n");
      out.write("                        <br>Pusat Dagangan Donggongon,\r\n");
      out.write("                        <br>Jalan Sapau,\r\n");
      out.write("                        <br>89500 Donggongon,\r\n");
      out.write("                        <br>Penampang, Sabah</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12 col-md-3 mbr-fonts-style display-7\">\r\n");
      out.write("                    <h5 class=\"pb-3\">\r\n");
      out.write("                        Contacts\r\n");
      out.write("                    </h5>\r\n");
      out.write("                    <p class=\"mbr-text\">\r\n");
      out.write("                        Email: sabah@tarc.edu.my\r\n");
      out.write("                        <br>Phone: (6)088-718481, 718482\r\n");
      out.write("                        <br>Fax: (6)088-718486\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12 col-md-3 mbr-fonts-style display-7\">\r\n");
      out.write("                    <h5 class=\"pb-3\">\r\n");
      out.write("                        Links\r\n");
      out.write("                    </h5>\r\n");
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
      out.write("    <script src=\"assets/playervimeo/vimeo_player.js\"></script>\r\n");
      out.write("    <script src=\"assets/parallax/jarallax.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/smoothscroll/smooth-scroll.js\"></script>\r\n");
      out.write("    <script src=\"assets/dropdown/js/script.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/theme/js/script.js\"></script>\r\n");
      out.write("    <div id=\"scrollToTop\" class=\"scrollToTop mbr-arrow-up\"><a style=\"text-align: center;\"><i></i></a></div>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        function onSignIn(googleUser) {\r\n");
      out.write("            var profile = googleUser.getBasicProfile();\r\n");
      out.write("            console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.\r\n");
      out.write("            console.log('Name: ' + profile.getName());\r\n");
      out.write("            console.log('Image URL: ' + profile.getImageUrl());\r\n");
      out.write("            console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Back to top -->\r\n");
      out.write("    <script>\r\n");
      out.write("        if (($(window).height() + 100) < $(document).height()) {\r\n");
      out.write("            $('#top-link-block').removeClass('hidden').affix({offset: {top: 100}});\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    <style>\r\n");
      out.write("        #top-link-block>.btn {\r\n");
      out.write("            font-size: 1.5em!important;\r\n");
      out.write("            opacity: 0.4!important;\r\n");
      out.write("            padding: 10px 20px!important\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #top-link-block.affix-top {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            bottom: -82px;\r\n");
      out.write("            right: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #top-link-block.affix {\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            bottom: 18px;\r\n");
      out.write("            right: 10px;\r\n");
      out.write("            z-index: 999;\r\n");
      out.write("        }\r\n");
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

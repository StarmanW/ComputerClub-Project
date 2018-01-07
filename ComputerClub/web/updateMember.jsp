<%@page import="model.Member"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="programmeDA" class="dataAccess.ProgrammeDA" scope="application"></jsp:useBean>
<jsp:useBean id="memberDA" class="dataAccess.MemberDA" scope="application"></jsp:useBean>
<%
    session = request.getSession();
    session.setAttribute("requestURL", request.getRequestURL().toString());
    session.setAttribute("studIDOriginal", request.getParameter("studID"));
    Member member = memberDA.selectRecord(request.getParameter("studID"));
%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="generator" content="Mobirise v4.5.2, mobirise.com">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <link rel="shortcut icon" href="assets/images/title bar logo.jpg" type="image/x-icon">
        <meta name="description" content="Website Creator Description">
        <title>Update Member</title>
        <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
        <link rel="stylesheet" href="assets/web/assets/mobirise-icons-bold/mobirise-icons-bold.css">
        <link rel="stylesheet" href="assets/tether/tether.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="assets/socicon/css/styles.css">
        <link rel="stylesheet" href="assets/dropdown/css/style.css">
        <link rel="stylesheet" href="assets/theme/css/style.css">
        <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
        <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
        <link rel="stylesheet" href="assets/css/registerMember.css" type="text/css">
    </head>
    <body>
        <section class="menu cid-qDNS0J8sKR" once="menu" id="menu1-k" data-rv-view="2425">
            <nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <div class="hamburger">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </button>
                <div class="menu-logo">
                    <div class="navbar-brand">
                        <span class="navbar-logo">
                            <a href="homepage.jsp">
                                <img src="assets/images/logo-1-3508x2480.jpg" title="" media-simple="true" style="height: 4.5rem;">
                            </a>
                        </span>
                        <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="homepage.jsp">
                                COMPUTER CLUB</a></span>
                    </div>
                </div>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
                        <li class="nav-item dropdown open"><a class="nav-link link text-white dropdown-toggle display-4" aria-expanded="true" data-toggle="dropdown-submenu">REGISTER</a>
                            <div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="registerMember.jsp" aria-expanded="false">MEMBER</a><a class="text-white dropdown-item display-4" href="registerEvent.jsp" aria-expanded="false">EVENT</a></div>
                        </li>
                        <li class="nav-item dropdown"><a class="nav-link link dropdown-toggle text-white display-4" data-toggle="dropdown-submenu" aria-expanded="false">MANAGE</a>
                            <div class="dropdown-menu"><a class="dropdown-item text-white display-4" href="memberList.jsp">MEMBERS</a><a class="dropdown-item text-white display-4" href="eventList.jsp">EVENTS</a><a class="dropdown-item text-white display-4" href="collaboratorList.jsp">COLLABORATORS</a><a class="dropdown-item text-white display-4" href="sponsoredItemList.jsp">SPONSORED ITEMS</a></div>
                        </li>
                    </ul>
                    <div class="navbar-buttons mbr-section-btn"><a class="btn btn-sm btn-primary display-4" href="index.jsp"><span class="mbrib-lock mbr-iconfont mbr-iconfont-btn"></span>

                            LOGOUT</a></div>
                </div>
            </nav>
        </section>
        <section class="cid-qECj4TnJzd mbr-fullscreen mbr-parallax-background" id="header2-14" data-rv-view="3093">
            <div class="container align-center">
                <br />
                <br />
                <div class="form-container">
                    <h1 class="well">Update Member <%=member.getStudID()%> Details</h1>
                    <hr style="border-top:1px solid gray;" />
                    <div class="col-lg-12 well">
                        <div class="row">
                            <form method="post" action="ProcessUpdateMember">
                                <p style="color:red; float: left;">"*" Required fields</p>
                                <br />
                                <br />
                                <% if (request.getParameter("empty") != null) {%>
                                <p style="color:red">Please ensure all the fields are not left blank</p>
                                <%}%>
                                <div class="col-sm-12">
                                    <div class="row">
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>First Name</label>
                                            <input type="text" name="fName" placeholder="John" class="form-control" value="<%=member.getStudName().getFirstName()%>" pattern="[A-Za-z\-@ ]{2,}" title="Alphabetic, @ and - symbols only. E.g. - John" required="required">
                                        </div>
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Last Name</label>
                                            <input type="text" name="lName" placeholder="Doe" class="form-control" value="<%=member.getStudName().getLastName()%>" pattern="[A-Za-z\-@ ]{2,}" title="Alphabetic, @ and - symbols only. E.g. - Smith" required="required">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>IC Number</label>
                                            <input type="text" name="icNum" placeholder="981213125523" class="form-control" value="<%=member.getIc()%>" pattern="\d{12}" title="Numeric only. E.g. 985564127789" required="required">
                                        </div>
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Member ID</label>
                                            <input type="text" name="memID" placeholder="16SMD00990" class="form-control" value="<%=member.getStudID()%>" pattern="^\d{2}[A-Z]{3}\d{5}$" title="E.g. 16SMD00990" required="required">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Contact Number</label>
                                            <input type="text" name="contactNo" placeholder="0195421325" class="form-control" value="<%=member.getStudContact()%>" pattern="([0-9]|[0-9\-]){3,20}" title="Numeric and '-' symbols only. E.g. 014-8897875" required="required">
                                        </div>
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Email</label>
                                            <input type="email" name="email" placeholder="email@hotmail.com" class="form-control" value="<%=member.getStudEmail()%>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="E.g. - cisco@business.co.uk" required="required">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Programme ID</label>
                                            <select name="progID" class="form-control" required="required">
                                                <option disabled selected value>Select programme ID</option>
                                                <%
                                                    ArrayList<model.Programme> progList = programmeDA.selectAllProgrammesList();
                                                    String progID = member.getProgramme().getProgID();
                                                    for (int i = 0; i < progList.size(); i++) {
                                                        if (progID.equals(progList.get(i).getProgID())) {
                                                %>
                                                <option value="<%=progList.get(i).getProgID()%>" selected="selected"><%=progList.get(i).getProgID()%></option>
                                                <%} else {%>
                                                <option value="<%=progList.get(i).getProgID()%>"><%=progList.get(i).getProgID()%></option>
                                                <% }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Academic Year</label>
                                            <select name="academicYear" class="form-control" required="required">
                                                <option disabled selected value>Select academic year</option>
                                                <%
                                                    java.time.LocalDateTime time = java.time.LocalDateTime.now();
                                                    int year = time.getYear();
                                                    String acadYear = null;
                                                    for (int i = 0; i < 5; i++) {
                                                        if (i == 0) {
                                                            acadYear = (year - 2) + "/" + (year - 1);
                                                %>
                                                <option value="<%=year - 2%>/<%=year - 1%>" <%if (member.getAcademicYear().equals(acadYear)) { %> selected="selected" <%}%>><%=year - 2%>/<%=year - 1%></option>
                                                <%} else if (i == 1) {
                                                    acadYear = (year - 1) + "/" + (year);
                                                %>
                                                <option value="<%=year - 1%>/<%=year%>" <%if (member.getAcademicYear().equals(acadYear)) { %> selected="selected" <%}%>><%=year - 1%>/<%=year%></option>
                                                <%} else if (i == 2) {
                                                    acadYear = (year) + "/" + (year + 1);
                                                %>
                                                <option value="<%=year%>/<%=year + 1%>" <%if (member.getAcademicYear().equals(acadYear)) { %> selected="selected" <%}%>><%=year%>/<%=year + 1%></option>
                                                <%} else {
                                                    acadYear = (year + i - 2) + "/" + (year + i - 1);
                                                %>
                                                <option value="<%=year + i - 2%>/<%=year + i - 1%>" <%if (member.getAcademicYear().equals(acadYear)) { %> selected="selected" <%}%>><%=year + i - 2%>/<%=year + i - 1%></option>
                                                <%      }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Gender:</label>
                                            <br/>
                                            <input type="radio" name="gender" value="M" <%if (member.getGender() == 'M') {%> checked="checked" <%}%> required="required"> Male &nbsp;
                                            <input type="radio" name="gender" value="F" <%if (member.getGender() == 'F') {%> checked="checked" <%}%>> Female
                                        </div>
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Membership Fee Status:</label>
                                            <br/>
                                            <input type="radio" name="memFeeStats" <%if (!member.isMembershipFeeStatus()) {%>checked="checked" <%}%> value="false" required="required"> Pending &nbsp;
                                            <input type="radio" name="memFeeStats" <%if (member.isMembershipFeeStatus()) {%>checked="checked" <%}%> value="true"> Paid
                                        </div>
                                    </div>
                                    <div class="row" style="margin:auto">
                                        <label><span style="color:red;">*</span>Position</label>
                                        <select name="position" class="form-control" required="required">
                                            <option disabled selected value>Select member position</option>
                                            <option value="5" <%if (member.getPosition() == 5) {%> selected="selected" <%}%> >President</option>
                                            <option value="4" <%if (member.getPosition() == 4) {%> selected="selected" <%}%> >Vice President</option>
                                            <option value="3" <%if (member.getPosition() == 3) {%> selected="selected" <%}%> >Secretary</option>
                                            <option value="2" <%if (member.getPosition() == 2) {%> selected="selected" <%}%> >Treasurer</option>
                                            <option value="1" <%if (member.getPosition() == 1) {%> selected="selected" <%}%> >Member</option>
                                        </select>
                                    </div>
                                </div>
                                <br />
                                <div class="submit-button">
                                    <button type="submit" class="btn btn-lg btn-info">Update</button>
                                    <a href="memberList.jsp"><button type="button" class="btn btn-lg btn-info">Back</button></a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container -->
            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
            <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
            <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
        </section>
        <section class="cid-qECiDnaZnD" id="footer1-12" data-rv-view="11590">
            <div class="container">
                <div class="media-container-row content text-white">
                    <div class="col-12 col-md-3">
                        <div class="media-wrap">
                            <a href="homepage.jsp"><img src="assets/images/logo-2-3508x2480.jpg" alt="Mobirise" title="" media-simple="true"></a>
                        </div>
                    </div>
                    <div class="col-12 col-md-3 mbr-fonts-style display-7">
                        <h5 class="pb-3">
                            Address
                        </h5>
                        <p class="mbr-text">Lot 1, Ground Floor,
                            <br>Pusat Dagangan Donggongon,
                            <br>Jalan Sapau,
                            <br>89500 Donggongon,
                            <br>Penampang, Sabah</p>
                    </div>
                    <div class="col-12 col-md-3 mbr-fonts-style display-7">
                        <h5 class="pb-3">
                            Contacts
                        </h5>
                        <p class="mbr-text">
                            Email: sabah@tarc.edu.my
                            <br>Phone: (6)088-718481, 718482
                            <br>Fax: (6)088-718486
                        </p>
                    </div>
                    <div class="col-12 col-md-3 mbr-fonts-style display-7">
                        <h5 class="pb-3">
                            Links
                        </h5>
                        <p class="mbr-text"><a href="http://www.tarc.edu.my/" target="_blank" class="text-primary">TAR UC</a>
                            <br><a href="http://www.tarc.edu.my/sabah/index.jsp" class="text-primary" target="_blank">TAR UC Sabah</a>
                            <br><a class="text-primary" href="https://www.facebook.com/tarucsabah/" target="_blank">TAR UC Sabah Facebook</a></p>
                    </div>
                </div>
                <div class="footer-lower">
                    <div class="media-container-row">
                        <div class="col-sm-12">
                            <hr>
                        </div>
                    </div>
                    <div class="media-container-row mbr-white">
                        <div class="col-sm-6 copyright">
                            <p class="mbr-text mbr-fonts-style display-7">
                                © Copyright 2017 TAR UC Computer Club - All Rights Reserved
                            </p>
                        </div>
                        <div class="col-md-6">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="assets/web/assets/jquery/jquery.min.js"></script>
        <script src="assets/popper/popper.min.js"></script>
        <script src="assets/tether/tether.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
        <script src="assets/parallax/jarallax.min.js"></script>
        <script src="assets/smoothscroll/smooth-scroll.js"></script>
        <script src="assets/dropdown/js/script.min.js"></script>
        <script src="assets/theme/js/script.js"></script>
        <div id="scrollToTop" class="scrollToTop mbr-arrow-up"><a style="text-align: center;"><i></i></a></div>
        <!-- Back to top -->
        <script>
            if (($(window).height() + 100) < $(document).height()) {
                $('#top-link-block').removeClass('hidden').affix({offset: {top: 100}});
            }
        </script>
        <script>
            var urlParams = new URLSearchParams(window.location.search);
            if (urlParams.has('success')) {
                window.alert("Member details successfully updated!");
            } else if (urlParams.has('error')) {
                window.alert("Oh no! An error has occured, please contact the system administrator.");
            }
        </script>
        <style>
            #top-link-block>.btn {
                font-size: 1.5em!important;
                opacity: 0.4!important;
                padding: 10px 20px!important
            }

            #top-link-block.affix-top {
                position: absolute;
                bottom: -82px;
                right: 10px;
            }

            #top-link-block.affix {
                position: fixed;
                bottom: 18px;
                right: 10px;
                z-index: 999;
            }
        </style>
    </body>

</html>
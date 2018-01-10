<!-- 
--
--@author Samuel Wong Kim Foong 
--
--
--> 

<%@page import="model.Event"%>
<%@page import="model.Item"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="itemDA" class="dataAccess.ItemDA" scope="application"></jsp:useBean>
<%
    session = request.getSession();
    if (request.getParameter("eName") != null) {
        if (!request.getParameter("eName").isEmpty() && !request.getParameter("eType").isEmpty() && !request.getParameter("eDate").isEmpty() && !request.getParameter("eStartTime").isEmpty() && !request.getParameter("eEndTime").isEmpty() && !request.getParameter("eLocation").isEmpty()) {
            Event tempEvent = new Event("TMP001", request.getParameter("eName"), Integer.parseInt(request.getParameter("eType")), request.getParameter("eDate"), request.getParameter("eStartTime"), request.getParameter("eEndTime"), request.getParameter("eLocation"));
            session.setAttribute("tempEvent", tempEvent);
        }
    }
    String[] itemIDList = (String[]) session.getAttribute("itemIDList");
    session.setAttribute("requestURL", request.getRequestURL().toString());
%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="generator" content="Mobirise v4.5.2, mobirise.com">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <link rel="shortcut icon" href="assets/images/title bar logo.jpg" type="image/x-icon">
        <meta name="description" content="Sponsored Item List">
        <title>Sponsored Item List for <%=request.getParameter("eventID")%></title>
        <link rel="stylesheet" href="assets/web/assets/mobirise-icons-bold/mobirise-icons-bold.css">
        <link rel="stylesheet" href="assets/tether/tether.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="assets/socicon/css/styles.css">
        <link rel="stylesheet" href="assets/dropdown/css/style.css">
        <link rel="stylesheet" href="assets/datatables/data-tables.bootstrap4.min.css">
        <link rel="stylesheet" href="assets/theme/css/style.css">
        <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
        <link rel="stylesheet" href="assets/css/editDeleteBtn.css" type="text/css">
        <link rel="stylesheet" href="assets/css/lists.css" type="text/css">
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
        <section class="engine"><a href="https://mobirise.co/n">bootstrap modal popup</a></section>
        <section class="section-table cid-qFp8UAA2m0 mbr-parallax-background" id="table1-1f" data-rv-view="1776">
            <div class="mbr-overlay" style="opacity: 0.4; background-color: rgb(35, 35, 35);">
            </div>
            <div class="container container-table">
                <h2 class="mbr-section-title mbr-fonts-style align-center pb-3 display-1"><br><strong>Sponsored Item List</strong><strong><br></strong></h2>
                <form method="POST" action="ProcessRegistrationEventItem">
                    <div class="table-backpanel">
                        <div class="table-wrapper">
                            <div class="container">
                                <div class="row search">
                                    <div class="col-md-6"></div>
                                    <div class="col-md-6">
                                        <div class="dataTables_filter">
                                            <label class="searchInfo mbr-fonts-style display-7">Search:</label>
                                            <input class="form-control input-sm" disabled="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="container scroll">
                                <table class="table isSearch" cellspacing="0">
                                    <thead>
                                        <tr class="table-heads" style="border-bottom-style:solid">
                                            <th class="head-item mbr-fonts-style display-7" colspan="7">
                                                <div style="text-align: center;">
                                                    <a href="registerSponsoredItem.jsp"><img src="assets/images/plus-square.svg" width="30px" /><span class="addNewRecordTxt">&nbsp;Add New Sponsored Item</span></a>
                                                </div>
                                            </th>
                                        </tr>
                                        <tr class="table-heads ">
                                            <th class="head-item mbr-fonts-style display-7">Item ID</th>
                                            <th class="head-item mbr-fonts-style display-7">Item Name</th>
                                            <th class="head-item mbr-fonts-style display-7">Sponsored By</th>
                                            <th class="head-item mbr-fonts-style display-7">Item Quantity</th>
                                            <th class="head-item mbr-fonts-style display-7">Item Type</th>
                                            <th class="head-item mbr-fonts-style display-7"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<Item> itemList = itemDA.selectAllItem();
                                            for (int i = 0; i < itemList.size(); i++) {
                                                boolean checkboxPrinted = false;
                                        %>
                                        <tr>

                                            <td class="body-item mbr-fonts-style display-7"><%=itemList.get(i).getItemID()%></td>
                                            <td class="body-item mbr-fonts-style display-7"><%=itemList.get(i).getItemName()%></td>
                                            <td class="body-item mbr-fonts-style display-7"><%=itemList.get(i).getCollaborator().getCollabName()%></td>
                                            <td class="body-item mbr-fonts-style display-7"><%=itemList.get(i).getQuantity()%></td>
                                            <td class="body-item mbr-fonts-style display-7"><%=itemList.get(i).getItemTypeString()%></td>
                                            <%
                                                if (itemIDList != null) {
                                                    for (int j = 0; j < itemIDList.length; j++) {
                                                        if (itemIDList[j].equals(itemList.get(i).getItemID())) {
                                            %>
                                            <td class="body-item mbr-fonts-style display-7"><input type="checkbox" name="itemID" checked value="<%=itemList.get(i).getItemID()%>" /></td>
                                                <%  checkboxPrinted = true;
                                                                break;
                                                            }
                                                        }
                                                    } %>
                                                <% if (!checkboxPrinted) {%>
                                            <td class="body-item mbr-fonts-style display-7"><input type="checkbox" name="itemID" value="<%=itemList.get(i).getItemID()%>" /></td>
                                        </tr>
                                        <%}
                                            }%>
                                    </tbody>
                                </table>
                            </div>
                            <div class="container table-info-container">
                                <div class="row info">
                                    <div class="col-md-6">
                                        <div class="dataTables_info mbr-fonts-style display-7">
                                            <span class="infoBefore">Showing</span>
                                            <span class="inactive infoRows"></span>
                                            <span class="infoAfter">entries</span>
                                            <span class="infoFilteredBefore">(filtered from</span>
                                            <span class="inactive infoRows"></span>
                                            <span class="infoFilteredAfter">total entries)</span>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin:auto; width:280px;">
                            <a href=""><button type="submit" class="btn btn-sm btn-primary" >Submit</button></a>
                            <a href="registerEvent.jsp"><button type="button" class="btn btn-sm btn-primary">Back</button></a>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <section class="cid-qEChLCCjpO" id="footer1-10" data-rv-view="555">
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
        <script src="assets/dropdown/js/script.min.js"></script>
        <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
        <script src="assets/datatables/jquery.data-tables.min.js"></script>
        <script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
        <script src="assets/smoothscroll/smooth-scroll.js"></script>
        <script src="assets/theme/js/script.js"></script>
        <div id="scrollToTop" class="scrollToTop mbr-arrow-up"><a style="text-align: center;"><i></i></a></div>
        <!-- Back to top -->
        <script>
            if (($(window).height() + 100) < $(document).height()) {
                $('#top-link-block').removeClass('hidden').affix({offset: {top: 100}});
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
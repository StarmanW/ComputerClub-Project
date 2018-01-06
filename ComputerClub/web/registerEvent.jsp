<%session = request.getSession();%>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="generator" content="Mobirise v4.5.2, mobirise.com">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <link rel="shortcut icon" href="assets/images/title bar logo.png" type="image/x-icon">
        <meta name="description" content="Website Creator Description">
        <title>Register Event</title>
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
        <section class="cid-qEH6htC0aL mbr-fullscreen mbr-parallax-background" id="header2-19" data-rv-view="3101">
            <div class="container align-center">
                <br />
                <br />
                <div class="form-container">
                    <h1 class="well">Register New Event</h1>

                    <hr style="border-top:1px solid gray;" />
                    <div class="col-lg-12 well" style="margin:auto; width:90%">
                        <div class="row">
                            <form action="ProcessRegistrationEvent" method="POST">
                                <p style="color:red; float: left;">"*" Required fields</p>
                                <br />
                                <br />
                                <div class="col-sm-12">
                                    <div class="row">
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Event Name</label>
                                            <input type="text" name="eventName" placeholder="Capture The Flag" class="form-control" pattern="[0-9A-Za-z\-@ ]{2,}" title="Alphanumeric, @ and - symbols only. E.g. - Dota Competition 1v1" required="required">
                                        </div>
                                        <div class="col-sm-6 form-group">
                                            <label><span style="color:red;">*</span>Event Date</label>
                                            <input type="date" name="eDate" class="form-control" required="required">
                                        </div>
                                    </div>
                                    <br/>
                                    <div class="row">
                                        <div class="col-sm-6 form-group">
                                            <div class="row" style="margin:auto">
                                                <label><span style="color:red;">*</span>Event Time: &nbsp;</label>
                                                <br/>
                                                <div style="display: block;">
                                                    <input type="time" name="eventStartTime" value="" required="required"><br/>to<br/>
                                                    <input type="time" name="eventEndTime" value="" required="required">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 form-group">
                                        <label><span style="color:red;">*</span>Event Location</label>
                                        <input type="text" name="eventLocation" placeholder="Lot 1-1" class="form-control" required="required">
                                        </div>
                                    </div>
                                    <br/>
                                    <div class="row" style="margin:auto">
                                        <label><span style="color:red;">*</span>Event Category</label>
                                        <select name="eventType" class="form-control" required="required">
                                            <option disabled selected value>Select an event category</option>
                                            <option value="5">Competitions</option>
                                            <option value="4">Educational Visit/Trips</option>
                                            <option value="3">Workshops/Talks</option>
                                            <option value="2">Event Exhibitions</option>
                                            <option value="1">Others</option>
                                        </select>
                                    </div>
                                    <br/>
                                    <div class="form-group" style="margin:auto">
                                        <a href="eventCollaboratorList.jsp"><button type="button" class="btn btn-sm btn-primary">Add/Modify Collaborators</button></a>
                                    </div>
                                    <div class="form-group" style="margin:auto">
                                        <a href="eventSponsoredItemList.jsp"><button type="button" class="btn btn-sm btn-primary">Add/Modify Sponsored Items</button></a>
                                    </div>
                                    <div class="form-group" style="margin:auto">
                                        <a href="eventMemberList.jsp"><button type="button" class="btn btn-sm btn-primary">Add/Modify Participants</button></a>
                                    </div>
                                </div>
                                <br />
                                <div class="form-group" style="margin-left:8%">
                                    <button type="submit" class="btn btn-lg btn-info">Submit</button>
                                    <button type="reset" class="btn btn-lg btn-info">Reset</button>
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
                window.alert("New Event successfully added!");
            } else if (urlParams.has('duplicated')) {
                window.alert("Duplicated records found, please ensure the new event record does not exist in the event list.");
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
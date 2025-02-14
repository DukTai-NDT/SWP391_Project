<%-- 
    Document   : displayProduct
    Created on : Feb 10, 2025, 9:35:21 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.MedicalProducts, entity.Categories" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>Doctris - Doctor Appointment Booking System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Premium Bootstrap 4 Landing Page Template" />
        <meta name="keywords" content="Appointment, Booking, System, Dashboard, Health" />
        <meta name="author" content="Shreethemes" />
        <meta name="email" content="support@shreethemes.in" />
        <meta name="website" content="https://shreethemes.in" />
        <meta name="Version" content="v1.2.0" />
        <!-- favicon -->
        <link rel="shortcut icon" href="images/favicon.ico.png">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Icons -->
        <link href="css/materialdesignicons.min.css" rel="stylesheet" type="text/css" />
        <link href="css/remixicon.css" rel="stylesheet" type="text/css" />
        <link href="https://unicons.iconscout.com/release/v3.0.6/css/line.css"  rel="stylesheet">
        <!-- SLIDER -->
        <link rel="stylesheet" href="css/tiny-slider.css"/>

        <style>
            .shop-image {
                width: 100%;  /* Đảm bảo khung chứa hình ảnh chiếm toàn bộ chiều rộng */
                height: 200px; /* Đồng bộ chiều cao của tất cả ảnh */
                overflow: hidden; /* Ẩn phần dư thừa nếu có */
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .shop-image img {
                width: 100%; /* Đảm bảo ảnh lấp đầy container */
                height: 200px; /* Cố định chiều cao */
                object-fit: cover; /* Cắt ảnh sao cho phù hợp mà không bị méo */


            }
            .img-container {
                    width: 100%;
                    height: 200px; /* Điều chỉnh chiều cao mong muốn */
                    overflow: hidden;
            }

            .img-container img {
                    width: 100%;
                    height: 100%;
                    object-fit: cover;
                    object-position: center;
                    display: block;
                    border-radius: 8px; /* Bo góc nhẹ cho ảnh */
            }
        </style>
        <!-- Css -->
        <link href="css/style.min.css" rel="stylesheet" type="text/css" id="theme-opt" />


    </head>


    <% Vector<MedicalProducts> data = (Vector<MedicalProducts>)request.getAttribute("data");%>
    <% Vector<Categories> dataCat = (Vector<Categories>)request.getAttribute("dataCat");%>

    <body>
        <!-- Loader -->
        <div id="preloader">
            <div id="status">
                <div class="spinner">
                    <div class="double-bounce1"></div>
                    <div class="double-bounce2"></div>
                </div>
            </div>
        </div>
        <!-- Loader -->

        <!-- Navbar STart -->
        <header id="topnav" class="navigation sticky">
            <div class="container">
                <!-- Logo container-->
                <div>
                    <a class="logo" href="HomePageURL">
                        <span class="logo-light-mode">
                            <img src="images/logo-dark.png" class="l-dark" height="24" alt="">
                            <img src="images/logo-light.png" class="l-light" height="24" alt="">
                        </span>
                        <img src="images/logo-light.png" height="24" class="logo-dark-mode" alt="">
                    </a>
                </div>
                <!-- End Logo container-->

                <!-- Start Mobile Toggle -->
                <div class="menu-extras">
                    <div class="menu-item">
                        <!-- Mobile menu toggle-->
                        <a class="navbar-toggle" id="isToggle" onclick="toggleMenu()">
                            <div class="lines">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                        </a>
                        <!-- End mobile menu toggle-->
                    </div>
                </div>
                <!-- End Mobile Toggle -->

                <!-- Start Dropdown -->
                <ul class="dropdowns list-inline mb-0">
                    <li class="list-inline-item mb-0">
                        <a href="javascript:void(0)" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                            <div class="btn btn-icon btn-pills btn-primary"><i data-feather="settings" class="fea icon-sm"></i></div>
                        </a>
                    </li>

                    <li class="list-inline-item mb-0 ms-1">
                        <a href="javascript:void(0)" class="btn btn-icon btn-pills btn-primary" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTop" aria-controls="offcanvasTop">
                            <i class="uil uil-search"></i>
                        </a>
                    </li>

                    <li class="list-inline-item mb-0 ms-1">
                        <div class="dropdown dropdown-primary">
                            <button type="button" class="btn btn-pills btn-soft-primary dropdown-toggle p-0" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="images/doctors/01.jpg" class="avatar avatar-ex-small rounded-circle" alt=""></button>
                            <div class="dropdown-menu dd-menu dropdown-menu-end bg-white shadow border-0 mt-3 py-3" style="min-width: 200px;">
                                <a class="dropdown-item d-flex align-items-center text-dark" href="doctor-profile.html">
                                    <img src="images/doctors/01.jpg" class="avatar avatar-md-sm rounded-circle border shadow" alt="">
                                    <div class="flex-1 ms-2">
                                        <span class="d-block mb-1">Calvin Carlo</span>
                                        <small class="text-muted">Orthopedic</small>
                                    </div>
                                </a>
                                <a class="dropdown-item text-dark" href="doctor-dashboard.html"><span class="mb-0 d-inline-block me-1"><i class="uil uil-dashboard align-middle h6"></i></span> Dashboard</a>
                                <a class="dropdown-item text-dark" href="doctor-profile-setting.html"><span class="mb-0 d-inline-block me-1"><i class="uil uil-setting align-middle h6"></i></span> Profile Settings</a>
                                <div class="dropdown-divider border-top"></div>
                                <a class="dropdown-item text-dark" href="login.html"><span class="mb-0 d-inline-block me-1"><i class="uil uil-sign-out-alt align-middle h6"></i></span> Logout</a>
                            </div>
                        </div>
                    </li>
                </ul>
                <!-- Start Dropdown -->

                <div id="navigation">
                    <!-- Navigation Menu-->   
                    <ul class="navigation-menu nav-left nav-light">
                        <li class="has-submenu parent-menu-item">
                            <a href="javascript:void(0)">Home</a><span class="menu-arrow"></span>
                            <ul class="submenu">
                                <li><a href="index.html" class="sub-menu-item">Index One</a></li>
                                <li><a href="index-two.html" class="sub-menu-item">Index Two</a></li>
                                <li><a href="index-three.html" class="sub-menu-item">Index Three</a></li>
                            </ul>
                        </li>

                        <li class="has-submenu parent-parent-menu-item">
                            <a href="javascript:void(0)">Doctors</a><span class="menu-arrow"></span>
                            <ul class="submenu">
                                <li class="has-submenu parent-menu-item">
                                    <a href="javascript:void(0)" class="menu-item"> Dashboard </a><span class="submenu-arrow"></span>
                                    <ul class="submenu">
                                        <li><a href="doctor-dashboard.html" class="sub-menu-item">Dashboard</a></li>
                                        <li><a href="doctor-appointment.html" class="sub-menu-item">Appointment</a></li>
                                        <li><a href="patient-list.html" class="sub-menu-item">Patients</a></li>
                                        <li><a href="doctor-schedule.html" class="sub-menu-item">Schedule Timing</a></li>
                                        <li><a href="invoices.html" class="sub-menu-item">Invoices</a></li>
                                        <li><a href="patient-review.html" class="sub-menu-item">Reviews</a></li>
                                        <li><a href="doctor-messages.html" class="sub-menu-item">Messages</a></li>
                                        <li><a href="doctor-profile.html" class="sub-menu-item">Profile</a></li>
                                        <li><a href="doctor-profile-setting.html" class="sub-menu-item">Profile Settings</a></li>
                                        <li><a href="doctor-chat.html" class="sub-menu-item">Chat</a></li>
                                        <li><a href="login.html" class="sub-menu-item">Login</a></li>
                                        <li><a href="signup.html" class="sub-menu-item">Sign Up</a></li>
                                        <li><a href="forgot-password.html" class="sub-menu-item">Forgot Password</a></li>
                                    </ul>
                                </li>
                                <li><a href="doctor-team-one.html" class="sub-menu-item">Doctors One</a></li>
                                <li><a href="doctor-team-two.html" class="sub-menu-item">Doctors Two</a></li>
                                <li><a href="doctor-team-three.html" class="sub-menu-item">Doctors Three</a></li>
                            </ul>
                        </li>

                        <li class="has-submenu parent-menu-item">
                            <a href="javascript:void(0)">Patients</a><span class="menu-arrow"></span>
                            <ul class="submenu">
                                <li><a href="patient-dashboard.html" class="sub-menu-item">Dashboard</a></li>
                                <li><a href="patient-profile.html" class="sub-menu-item">Profile</a></li>
                                <li><a href="booking-appointment.html" class="sub-menu-item">Book Appointment</a></li>
                                <li><a href="patient-invoice.html" class="sub-menu-item">Invoice</a></li>
                            </ul>
                        </li>

                        <li class="has-submenu parent-menu-item">
                            <a href="javascript:void(0)">Pharmacy</a><span class="menu-arrow"></span>
                            <ul class="submenu">

                                <li><a href="MedicalProductURL?service=listAllProducts" class="sub-menu-item">Shop</a></li>

                                <li><a href="CartURL" class="sub-menu-item">Shop Cart</a></li>
                                <li><a href="CheckoutURL" class="sub-menu-item">Checkout</a></li>
                                <li><a href="pharmacy-account.html" class="sub-menu-item">Account</a></li>
                            </ul>
                        </li>

                        <li class="has-submenu parent-parent-menu-item"><a href="javascript:void(0)">Pages</a><span class="menu-arrow"></span>
                            <ul class="submenu">
                                <li><a href="aboutus.html" class="sub-menu-item"> About Us</a></li>
                                <li><a href="departments.html" class="sub-menu-item">Departments</a></li>
                                <li><a href="faqs.html" class="sub-menu-item">FAQs</a></li>
                                <li class="has-submenu parent-menu-item">
                                    <a href="javascript:void(0)" class="menu-item"> Blogs </a><span class="submenu-arrow"></span>
                                    <ul class="submenu">
                                        <li><a href="blogs.html" class="sub-menu-item">Blogs</a></li>
                                        <li><a href="blog-detail.html" class="sub-menu-item">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="terms.html" class="sub-menu-item">Terms & Policy</a></li>
                                <li><a href="privacy.html" class="sub-menu-item">Privacy Policy</a></li>
                                <li><a href="error.html" class="sub-menu-item">404 !</a></li>
                                <li><a href="contact.html" class="sub-menu-item">Contact</a></li>
                            </ul>
                        </li>
                        <li><a href="../admin/index.html" class="sub-menu-item" target="_blank">Admin</a></li>
                    </ul><!--end navigation menu-->
                </div><!--end navigation-->
            </div><!--end container-->
        </header><!--end header-->
        <!-- Navbar End -->

        <!-- Start Hero -->
        <section class="home-slider position-relative">
            <div id="carouselExampleInterval" class="carousel slide carousel-fade" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="bg-half-170 d-table align-items-center w-100" style="background:url('images/bg/pharm01.jpg') center center;">
                            <div class="bg-overlay bg-overlay-dark"></div>
                            <div class="container">
                                <div class="row mt-5">
                                    <div class="col-lg-12">
                                        <div class="heading-title">
                                            <h1 class="fw-bold mb-4">Doctors Prescribe <br> Meko Products</h1>
                                            <p class="para-desc mb-0">Great doctor if you need your family member to get effective immediate assistance, emergency treatment or a simple consultation.</p>

                                            <div class="mt-4 pt-2">
                                                <a href="#" class="btn btn-primary">Shop now</a>
                                            </div>
                                        </div>
                                    </div><!--end col-->
                                </div><!--end row-->
                            </div><!--end container-->
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="bg-half-170 d-table align-items-center w-100" style="background:url('images/bg/pharm02.jpg') center center;">
                            <div class="bg-overlay bg-overlay-dark"></div>
                            <div class="container">
                                <div class="row mt-5">
                                    <div class="col-lg-12">
                                        <div class="heading-title">
                                            <h1 class="fw-bold mb-4">Virus Protection <br> Gears @15% Off</h1>
                                            <p class="para-desc mb-0">Great doctor if you need your family member to get effective immediate assistance, emergency treatment or a simple consultation.</p>

                                            <div class="mt-4 pt-2">
                                                <a href="#" class="btn btn-primary">Shop now</a>
                                            </div>
                                        </div>
                                    </div><!--end col-->
                                </div><!--end row-->
                            </div><!--end container-->
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="bg-half-170 d-table align-items-center w-100" style="background:url('images/bg/pharm03.jpg') center center;">
                            <div class="bg-overlay bg-overlay-dark"></div>
                            <div class="container">
                                <div class="row mt-5">
                                    <div class="col-lg-12">
                                        <div class="heading-title">
                                            <h1 class="fw-bold mb-4">Cosmetics Body <br> Lotion</h1>
                                            <p class="para-desc mb-0">Great doctor if you need your family member to get effective immediate assistance, emergency treatment or a simple consultation.</p>

                                            <div class="mt-4 pt-2">
                                                <a href="#" class="btn btn-primary">Shop now</a>
                                            </div>
                                        </div>
                                    </div><!--end col-->
                                </div><!--end row-->
                            </div><!--end container--> 
                        </div>
                    </div>
                </div>
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleInterval" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleInterval" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleInterval" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
            </div>
        </section><!--end section-->
        <!-- End Hero -->

        <!-- Start -->
        <section class="section">
            <!-- Start Most Viewed Products -->
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h5 class="mb-0">Most Viewed Products</h5>
                    </div><!--end col-->
                </div><!--end row-->

                <div class="row">
                    <% for (MedicalProducts medical : data){ %>
                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <ul class="label list-unstyled mb-0">
                                <li><a href="javascript:void(0)" class="badge badge-pill badge-success">Featured</a></li>
                            </ul>

                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="ProductDetailURL?service=detailProduct&pid=<%=medical.getMedicationID()%>"><img src="images/pharmacy/shop/<%=medical.getImage()%>" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="ProductDetailURL?service=detailProduct&pid=<%=medical.getMedicationID()%>" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>


                            <div class="card-body content pt-4 p-2">
                                <a href="ProductDetailURL?service=detailProduct&pid=<%=medical.getMedicationID()%>" class="text-dark product-name h6"><%= medical.getName() %></a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$<%= medical.getPrice()%> </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div><!--end col-->
                    <%}%>

                    <!--                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                                            <div class="card shop-list border-0">
                                                <div class="shop-image position-relative overflow-hidden rounded shadow">
                                                    <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/" class="img-fluid" alt=""></a>
                                                    <ul class="list-unstyled shop-icons">
                                                        <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                                    </ul>                                
                    
                                                    <div class="qty-icons">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                                        <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                                    </div>
                                                </div>-->

                    <!--                            <div class="card-body content pt-4 p-2">
                                                    <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Stethoscope</a>
                                                    <div class="d-flex justify-content-between mt-1">
                                                        <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                                        <ul class="list-unstyled text-warning mb-0">
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>end col
                                        
                                        <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                                            <div class="card shop-list border-0">
                                                <div class="shop-image position-relative overflow-hidden rounded shadow">
                                                    <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/pulse-oximeter.jpg" class="img-fluid" alt=""></a>
                                                    <ul class="list-unstyled shop-icons">
                                                        <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                                    </ul>                                
                    
                                                    <div class="qty-icons">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                                        <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                                    </div>
                                                </div>
                                                <div class="card-body content pt-4 p-2">
                                                    <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Pulse oximeter</a>
                                                    <div class="d-flex justify-content-between mt-1">
                                                        <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                                        <ul class="list-unstyled text-warning mb-0">
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>end col
                                        
                                        <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                                            <div class="card shop-list border-0">
                                                <div class="shop-image position-relative overflow-hidden rounded shadow">
                                                    <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/medicine.jpg" class="img-fluid" alt=""></a>
                                                    <ul class="list-unstyled shop-icons">
                                                        <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                                    </ul>                                
                    
                                                    <div class="qty-icons">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                                        <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                                    </div>
                                                </div>
                                                <div class="card-body content pt-4 p-2">
                                                    <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Medicine pills</a>
                                                    <div class="d-flex justify-content-between mt-1">
                                                        <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                                        <ul class="list-unstyled text-warning mb-0">
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>end col
                                        
                                        <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                                            <div class="card shop-list border-0">
                                                <div class="shop-image position-relative overflow-hidden rounded shadow">
                                                    <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/smoking-habit.jpg" class="img-fluid" alt=""></a>
                                                    <ul class="list-unstyled shop-icons">
                                                        <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                                    </ul>                                
                    
                                                    <div class="qty-icons">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                                        <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                                    </div>
                                                </div>
                                                <div class="card-body content pt-4 p-2">
                                                    <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Smokill smoking habit</a>
                                                    <div class="d-flex justify-content-between mt-1">
                                                        <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                                        <ul class="list-unstyled text-warning mb-0">
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>end col
                                        
                                        <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                                            <div class="card shop-list border-0">
                                                <div class="shop-image position-relative overflow-hidden rounded shadow">
                                                    <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/sanitizer.jpg" class="img-fluid" alt=""></a>
                                                    <ul class="list-unstyled shop-icons">
                                                        <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                                    </ul>                                
                    
                                                    <div class="qty-icons">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                                        <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                                    </div>
                                                </div>
                                                <div class="card-body content pt-4 p-2">
                                                    <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Sanitizer</a>
                                                    <div class="d-flex justify-content-between mt-1">
                                                        <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                                        <ul class="list-unstyled text-warning mb-0">
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>end col-->

                    <!--                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                                            <div class="card shop-list border-0">
                                                <div class="shop-image position-relative overflow-hidden rounded shadow">
                                                    <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/nicotex.jpg" class="img-fluid" alt=""></a>
                                                    <ul class="list-unstyled shop-icons">
                                                        <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                                    </ul>                                
                    
                                                    <div class="qty-icons">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                                        <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                                    </div>
                                                </div>
                                                <div class="card-body content pt-4 p-2">
                                                    <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Nicotex</a>
                                                    <div class="d-flex justify-content-between mt-1">
                                                        <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                                        <ul class="list-unstyled text-warning mb-0">
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>end col
                                        
                                        <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                                            <div class="card shop-list border-0">
                                                <div class="shop-image position-relative overflow-hidden rounded shadow">
                                                    <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/medigrip.jpg" class="img-fluid" alt=""></a>
                                                    <ul class="list-unstyled shop-icons">
                                                        <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                                        <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                                    </ul>                                
                    
                                                    <div class="qty-icons">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                                        <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                                        <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                                    </div>
                                                </div>
                                                <div class="card-body content pt-4 p-2">
                                                    <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Medigrip</a>
                                                    <div class="d-flex justify-content-between mt-1">
                                                        <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                                        <ul class="list-unstyled text-warning mb-0">
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                            <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>end col-->
                </div><!--end row-->
            </div><!--end container-->

            <div class="container mt-100 mt-60">
                <div class="row">
                    <div class="col-12">
                        <h5 class="mb-0">Categories</h5>
                    </div><!--end col-->
                </div><!--end row-->

                <div class="row">
                    <div class="col-lg-12 mt-4 pt-2">
                        <div class="slider-range-four">
                            <% for (Categories cat : dataCat){ %>
                            <div class="tiny-slide">
                                <a href="MedicalProductURL?service=categories&cid=<%=cat.getCategoriesID()%>" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                    <div class="img-container">
                                        <img src="images/pharmacy/shop/<%=cat.getImage()%>" class="img-fluid" alt="">
                                    </div>
                                    <div class="category-title">
                                        <span class="text-dark title-white"><span class="h5"><%=cat.getName()%></span><br></span>
                                    </div>
                                </a>
                            </div>
                            <% } %>  
                            <!--                            <div class="tiny-slide">
                                                            <a href="#" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                                                <img src="images/pharmacy/sexual.jpg" class="img-fluid" alt="">
                                                                <div class="category-title">
                                                                    <span class="text-dark title-white"><span class="h5">Sexual</span><br>Wallness</span>
                                                                </div>
                                                            </a>
                                                        </div>
                            
                                                        <div class="tiny-slide">
                                                            <a href="#" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                                                <img src="images/pharmacy/weight.jpg" class="img-fluid" alt="">
                                                                <div class="category-title">
                                                                    <span class="text-dark title-white"><span class="h5">Weight</span><br>Management</span>
                                                                </div>
                                                            </a>
                                                        </div>
                            
                                                        <div class="tiny-slide">
                                                            <a href="#" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                                                <img src="images/pharmacy/pain.jpg" class="img-fluid" alt="">
                                                                <div class="category-title">
                                                                    <span class="text-dark title-white"><span class="h5">Pain</span><br>Relief</span>
                                                                </div>
                                                            </a>
                                                        </div>
                            
                                                        <div class="tiny-slide">
                                                            <a href="#" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                                                <img src="images/pharmacy/heart.jpg" class="img-fluid" alt="">
                                                                <div class="category-title">
                                                                    <span class="text-dark title-white"><span class="h5">Heart</span><br>Health</span>
                                                                </div>
                                                            </a>
                                                        </div>
                                                        
                                                        <div class="tiny-slide">
                                                            <a href="#" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                                                <img src="images/pharmacy/cough.jpg" class="img-fluid" alt="">
                                                                <div class="category-title">
                                                                    <span class="text-dark title-white"><span class="h5">Cough</span><br> & Cold</span>
                                                                </div>
                                                            </a>
                                                        </div>
                                                        
                                                        <div class="tiny-slide">
                                                            <a href="#" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                                                <img src="images/pharmacy/diabetes.jpg" class="img-fluid" alt="">
                                                                <div class="category-title">
                                                                    <span class="text-dark title-white"><span class="h5">Diabetes</span><br>Care</span>
                                                                </div>
                                                            </a>
                                                        </div>
                                                        
                                                        <div class="tiny-slide">
                                                            <a href="#" class="card pharpachy-categories border-0 rounded overflow-hidden">
                                                                <img src="images/pharmacy/cancer.jpg" class="img-fluid" alt="">
                                                                <div class="category-title">
                                                                    <span class="text-dark title-white"><span class="h5">Cancer</span><br>Care</span>
                                                                </div>
                                                            </a>
                                                        </div>-->
                        </div>
                    </div><!--end col-->
                </div><!--end row-->
            </div><!--end container-->

            <!--            <div class="container mt-100 mt-60">
                            <div class="py-5 px-4 rounded shadow" style="background: url('images/pharmacy/cta.jpg') center;">
                                <div class="row my-lg-5">
                                    <div class="col-lg-12">
                                        <div class="section-title">
                                            <h1 class="title mb-4">Clinical Equipments <br> Stellar Price</h1>
                                            <p class="para-desc mb-0">Great doctor if you need your family member to get effective immediate assistance, emergency treatment or a simple consultation.</p>
            
                                            <div class="mt-4 pt-2">
                                                <a href="#" class="btn btn-primary">Shop now</a>
                                            </div>
                                        </div>
                                    </div>end col
                                </div>end row
                            </div>
                        </div>end container-->

            <div class="container mt-100 mt-60">
                <div class="row">
                    <div class="col-12">
                        <h5 class="mb-0">Popular Products</h5>
                    </div><!--end col-->
                </div><!--end row-->

                <div class="row">
                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <ul class="label list-unstyled mb-0">
                                <li><a href="javascript:void(0)" class="badge badge-pill badge-success">Featured</a></li>
                            </ul>
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/masks.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Face masks</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->

                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/handwash.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Dettol handwash</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->

                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/herbal-care.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Herbal care product</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->

                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/medical-equptment.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Medical equptment</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->
                </div><!--end row-->
            </div><!--end container-->

            <div class="container mt-100 mt-60">
                <div class="row">
                    <div class="col-12">
                        <h5 class="mb-0">Recent Products</h5>
                    </div><!--end col-->
                </div><!--end row-->

                <div class="row">           
                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/praganews.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Praganews</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->

                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/ashwagandha.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Ashwagandha churna</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->

                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/beby-products.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Beby products</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->

                    <div class="col-lg-3 col-md-6 col-12 mt-4 pt-2">
                        <div class="card shop-list border-0">
                            <div class="shop-image position-relative overflow-hidden rounded shadow">
                                <a href="pharmacy-product-detail.html"><img src="images/pharmacy/shop/kidney-tray.jpg" class="img-fluid" alt=""></a>
                                <ul class="list-unstyled shop-icons">
                                    <li><a href="#" class="btn btn-icon btn-pills btn-soft-danger"><i data-feather="heart" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-primary"><i data-feather="eye" class="icons"></i></a></li>
                                    <li class="mt-2"><a href="#" class="btn btn-icon btn-pills btn-soft-warning"><i data-feather="shopping-cart" class="icons"></i></a></li>
                                </ul>                                

                                <div class="qty-icons">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="btn btn-pills btn-icon btn-primary minus">-</button>
                                    <input min="0" name="quantity" value="0" type="number" class="btn btn-pills btn-icon btn-primary qty-btn quantity">
                                    <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="btn btn-pills btn-icon btn-primary plus">+</button>
                                </div>
                            </div>
                            <div class="card-body content pt-4 p-2">
                                <a href="pharmacy-product-detail.html" class="text-dark product-name h6">Kidney tray</a>
                                <div class="d-flex justify-content-between mt-1">
                                    <h6 class="text-muted small font-italic mb-0 mt-1">$16.00 </h6>
                                    <ul class="list-unstyled text-warning mb-0">
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                        <li class="list-inline-item"><i class="mdi mdi-star"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div><!--end col-->
                </div><!--end row-->
            </div><!--end container-->
        </section><!--end section-->

        <!-- Start -->
        <footer class="bg-footer">
            <div class="container">
                <div class="row">
                    <div class="col-xl-5 col-lg-4 mb-0 mb-md-4 pb-0 pb-md-2">
                        <a href="#" class="logo-footer">
                            <img src="images/logo-light.png" height="22" alt="">
                        </a>
                        <p class="mt-4 me-xl-5">Great doctor if you need your family member to get effective immediate assistance, emergency treatment or a simple consultation.</p>
                    </div><!--end col-->

                    <div class="col-xl-7 col-lg-8 col-md-12">
                        <div class="row">
                            <div class="col-md-4 col-12 mt-4 mt-sm-0 pt-2 pt-sm-0">
                                <h5 class="text-light title-dark footer-head">Company</h5>
                                <ul class="list-unstyled footer-list mt-4">
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> About us</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Services</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Team</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Project</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Blog</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Login</a></li>
                                </ul>
                            </div><!--end col-->

                            <div class="col-md-4 col-12 mt-4 mt-sm-0 pt-2 pt-sm-0">
                                <h5 class="text-light title-dark footer-head">Departments</h5>
                                <ul class="list-unstyled footer-list mt-4">
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Eye Care</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Psychotherapy</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Dental Care</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Orthopedic</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Cardiology</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Gynecology</a></li>
                                    <li><a href="#" class="text-foot"><i class="mdi mdi-chevron-right me-1"></i> Neurology</a></li>
                                </ul>
                            </div><!--end col-->

                            <div class="col-md-4 col-12 mt-4 mt-sm-0 pt-2 pt-sm-0">
                                <h5 class="text-light title-dark footer-head">Contact us</h5>
                                <ul class="list-unstyled footer-list mt-4">
                                    <li class="d-flex align-items-center">
                                        <i data-feather="mail" class="fea icon-sm text-foot align-middle"></i>
                                        <a href="mailto:contact@example.com" class="text-foot ms-2">contact@example.com</a>
                                    </li>

                                    <li class="d-flex align-items-center">
                                        <i data-feather="phone" class="fea icon-sm text-foot align-middle"></i>
                                        <a href="tel:+152534-468-854" class="text-foot ms-2">+152 534-468-854</a>
                                    </li>

                                    <li class="d-flex align-items-center">
                                        <i data-feather="map-pin" class="fea icon-sm text-foot align-middle"></i>
                                        <a href="javascript:void(0)" class="video-play-icon text-foot ms-2">View on Google map</a>
                                    </li>
                                </ul>

                                <ul class="list-unstyled social-icon footer-social mb-0 mt-4">
                                    <li class="list-inline-item"><a href="#" class="rounded-pill"><i data-feather="facebook" class="fea icon-sm fea-social"></i></a></li>
                                    <li class="list-inline-item"><a href="#" class="rounded-pill"><i data-feather="instagram" class="fea icon-sm fea-social"></i></a></li>
                                    <li class="list-inline-item"><a href="#" class="rounded-pill"><i data-feather="twitter" class="fea icon-sm fea-social"></i></a></li>
                                    <li class="list-inline-item"><a href="#" class="rounded-pill"><i data-feather="linkedin" class="fea icon-sm fea-social"></i></a></li>
                                </ul><!--end icon-->
                            </div><!--end col-->
                        </div><!--end row-->
                    </div><!--end col-->
                </div><!--end row-->
            </div><!--end container-->

            <div class="container mt-5">
                <div class="pt-4 footer-bar">
                    <div class="row align-items-center">
                        <div class="col-sm-6">
                            <div class="text-sm-start text-center">
                                <p class="mb-0"><script>document.write(new Date().getFullYear())</script> © Doctris. Design with <i class="mdi mdi-heart text-danger"></i> by <a href="../../../index.html" target="_blank" class="text-reset">Shreethemes</a>.</p>
                            </div>
                        </div><!--end col-->

                        <div class="col-sm-6 mt-4 mt-sm-0">
                            <ul class="list-unstyled footer-list text-sm-end text-center mb-0">
                                <li class="list-inline-item"><a href="terms.html" class="text-foot me-2">Terms</a></li>
                                <li class="list-inline-item"><a href="privacy.html" class="text-foot me-2">Privacy</a></li>
                                <li class="list-inline-item"><a href="aboutus.html" class="text-foot me-2">About</a></li>
                                <li class="list-inline-item"><a href="contact.html" class="text-foot me-2">Contact</a></li>
                            </ul>
                        </div><!--end col-->
                    </div><!--end row-->
                </div>
            </div><!--end container-->
        </footer><!--end footer-->
        <!-- End -->

        <!-- Back to top -->
        <a href="#" onclick="topFunction()" id="back-to-top" class="btn btn-icon btn-pills btn-primary back-to-top"><i data-feather="arrow-up" class="icons"></i></a>
        <!-- Back to top -->

        <!-- Offcanvas Start -->
        <div class="offcanvas bg-white offcanvas-top" tabindex="-1" id="offcanvasTop">
            <div class="offcanvas-body d-flex align-items-center align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="text-center">
                                <h4>Search now.....</h4>
                                <div class="subcribe-form mt-4">
                                    <form>
                                        <div class="mb-0">
                                            <input type="text" id="help" name="name" class="border bg-white rounded-pill" required="" placeholder="Search">
                                            <button type="submit" class="btn btn-pills btn-primary">Search</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div><!--end col-->
                    </div><!--end row-->
                </div><!--end container-->
            </div>
        </div>
        <!-- Offcanvas End -->

        <!-- Offcanvas Start -->
        <div class="offcanvas offcanvas-end bg-white shadow" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
            <div class="offcanvas-header p-4 border-bottom">
                <h5 id="offcanvasRightLabel" class="mb-0">
                    <img src="images/logo-dark.png" height="24" class="light-version" alt="">
                    <img src="images/logo-light.png" height="24" class="dark-version" alt="">
                </h5>
                <button type="button" class="btn-close d-flex align-items-center text-dark" data-bs-dismiss="offcanvas" aria-label="Close"><i class="uil uil-times fs-4"></i></button>
            </div>
            <div class="offcanvas-body p-4 px-md-5">
                <div class="row">
                    <div class="col-12">
                        <!-- Style switcher -->
                        <div id="style-switcher">
                            <div>
                                <ul class="text-center list-unstyled mb-0">
                                    <li class="d-grid"><a href="javascript:void(0)" class="rtl-version t-rtl-light" onclick="setTheme('style-rtl')"><img src="images/layouts/landing-light-rtl.png" class="img-fluid rounded-md shadow-md d-block" alt=""><span class="text-muted mt-2 d-block">RTL Version</span></a></li>
                                    <li class="d-grid"><a href="javascript:void(0)" class="ltr-version t-ltr-light" onclick="setTheme('style')"><img src="images/layouts/landing-light.png" class="img-fluid rounded-md shadow-md d-block" alt=""><span class="text-muted mt-2 d-block">LTR Version</span></a></li>
                                    <li class="d-grid"><a href="javascript:void(0)" class="dark-rtl-version t-rtl-dark" onclick="setTheme('style-dark-rtl')"><img src="images/layouts/landing-dark-rtl.png" class="img-fluid rounded-md shadow-md d-block" alt=""><span class="text-muted mt-2 d-block">RTL Version</span></a></li>
                                    <li class="d-grid"><a href="javascript:void(0)" class="dark-ltr-version t-ltr-dark" onclick="setTheme('style-dark')"><img src="images/layouts/landing-dark.png" class="img-fluid rounded-md shadow-md d-block" alt=""><span class="text-muted mt-2 d-block">LTR Version</span></a></li>
                                    <li class="d-grid"><a href="javascript:void(0)" class="dark-version t-dark mt-4" onclick="setTheme('style-dark')"><img src="images/layouts/landing-dark.png" class="img-fluid rounded-md shadow-md d-block" alt=""><span class="text-muted mt-2 d-block">Dark Version</span></a></li>
                                    <li class="d-grid"><a href="javascript:void(0)" class="light-version t-light mt-4" onclick="setTheme('style')"><img src="images/layouts/landing-light.png" class="img-fluid rounded-md shadow-md d-block" alt=""><span class="text-muted mt-2 d-block">Light Version</span></a></li>
                                    <li class="d-grid"><a href="../admin/index.html" target="_blank" class="mt-4"><img src="images/layouts/light-dash.png" class="img-fluid rounded-md shadow-md d-block" alt=""><span class="text-muted mt-2 d-block">Admin Dashboard</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- end Style switcher -->
                    </div><!--end col-->
                </div><!--end row-->
            </div>

            <div class="offcanvas-footer p-4 border-top text-center">
                <ul class="list-unstyled social-icon mb-0">
                    <li class="list-inline-item mb-0"><a href="https://1.envato.market/doctris-template" target="_blank" class="rounded"><i class="uil uil-shopping-cart align-middle" title="Buy Now"></i></a></li>
                    <li class="list-inline-item mb-0"><a href="https://dribbble.com/shreethemes" target="_blank" class="rounded"><i class="uil uil-dribbble align-middle" title="dribbble"></i></a></li>
                    <li class="list-inline-item mb-0"><a href="https://www.facebook.com/shreethemes" target="_blank" class="rounded"><i class="uil uil-facebook-f align-middle" title="facebook"></i></a></li>
                    <li class="list-inline-item mb-0"><a href="https://www.instagram.com/shreethemes/" target="_blank" class="rounded"><i class="uil uil-instagram align-middle" title="instagram"></i></a></li>
                    <li class="list-inline-item mb-0"><a href="https://twitter.com/shreethemes" target="_blank" class="rounded"><i class="uil uil-twitter align-middle" title="twitter"></i></a></li>
                    <li class="list-inline-item mb-0"><a href="mailto:support@shreethemes.in" class="rounded"><i class="uil uil-envelope align-middle" title="email"></i></a></li>
                    <li class="list-inline-item mb-0"><a href="../../../index.html" target="_blank" class="rounded"><i class="uil uil-globe align-middle" title="website"></i></a></li>
                </ul><!--end icon-->
            </div>
        </div>
        <!-- Offcanvas End -->

        <!-- javascript -->
        <script src="js/bootstrap.bundle.min.js"></script>
        <!-- SLIDER -->
        <script src="js/tiny-slider.js"></script>
        <script src="js/tiny-slider-init.js"></script>
        <!-- Icons -->
        <script src="js/feather.min.js"></script>
        <!-- Main Js -->
        <script src="js/app.js"></script>
    </body>
</html>

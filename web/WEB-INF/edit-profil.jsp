<%--
  Created by IntelliJ IDEA.
  User: zidan
  Date: 14/06/2020
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="w" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<w:wrapper>

    <div class="page-wrapper">
    <div class="content">
    <div class="row">
    <div class="col-lg-8 offset-lg-2">
    <h4 class="page-title">Edit Patient</h4>
    </div>
    </div>
    <div class="row">
    <div class="col-lg-8 offset-lg-2">
    <form method="POST" action="edit-profil">
    <div class="row">
    <div class="col-sm-6">
    <div class="form-group">
    <label>Nom Complet <span class="text-danger">*</span></label>
    <input class="form-control" type="text" value="" name="nom">
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
    <label>Username <span class="text-danger">*</span></label>
    <input class="form-control" type="text" name="username">
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
    <label>Email <span class="text-danger">*</span></label>
    <input class="form-control" type="email" name="email">
    </div>
    </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label>Date De Naissance</label>
                <div class="cal-icon">
                    <input type="date" class="form-control datetimepicker" name="datenaissance">
                </div>
            </div>
        </div>

        <div class="col-sm-6">
    <div class="form-group">
    <label>Password</label>
    <input class="form-control" type="password" name="password">
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
    <label>Confirm Password</label>
    <input class="form-control" type="password" name="password">
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group gender-select">
    <label class="gen-label">Gender:</label>
    <div class="form-check-inline">
    <label class="form-check-label">
    <input type="radio" name="civilite" class="form-check-input" checked value="1">Homme
    </label>
    </div>
    <div class="form-check-inline">
    <label class="form-check-label">
    <input type="radio" name="civilite" class="form-check-input"  value="0">Femme
    </label>
    </div>
    </div>
    </div>
    <div class="col-sm-12">
    <div class="row">
    <div class="col-sm-12">
    <div class="form-group">
    <label>Address</label>
    <input type="text" class="form-control" nom="adresse">
    </div>
    </div>
    <%--<div class="col-sm-6 col-md-6 col-lg-3">
    <div class="form-group">
    <label>Country</label>
    <select class="form-control select">
    <option selected>USA</option>
    <option>United Kingdom</option>
    </select>
    </div>
    </div>--%>
<%--    <div class="col-sm-6 col-md-6 col-lg-3">
    <div class="form-group">
    <label>City</label>
    <input type="text" class="form-control" name="assurance">
    </div>
    </div>--%>
<%--    <div class="col-sm-6 col-md-6 col-lg-3">
    <div class="form-group">
    <label>State/Province</label>
    <select class="form-control select">
    <option>California</option>
    <option>Alaska</option>
    <option>Alabama</option>
    <option class="selected">New York</option>
    </select>
    </div>
    </div>
    <div class="col-sm-6 col-md-6 col-lg-3">
    <div class="form-group">
    <label>Postal Code</label>
    <input type="text" class="form-control" value="11550">
    </div>
    </div>--%>
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
    <label>Numero Telephone</label>
    <input class="form-control" type="text" value="" name="numtelephone">
    </div>
    </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label>Assurance</label>
                <input class="form-control" type="text" value="" name="assurance">
            </div>
        </div>

        <div class="col-sm-6">
            <div class="form-group">
                <label>Profession </label>
                <input class="form-control" type="text" value="" name="profession">
            </div>
        </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
    <label>Avatar</label>
    <div class="profile-upload">
    <div class="upload-img">
    <img alt="" src="assets/img/user.jpg">
    </div>
    <div class="upload-input">
    <input type="file" class="form-control">
    </div>
    </div>
    </div>
    </div>
   <%-- </div>--%>

    <div class="m-t-20 text-center">
    <button class="btn btn-primary submit-btn">Save</button>
    </div>
    </form>
    </div>
    </div>
    </div>
    <div class="notification-box">
    <div class="msg-sidebar notifications msg-noti">
    <div class="topnav-dropdown-header">
    <span>Messages</span>
    </div>
    <div class="drop-scroll msg-list-scroll" id="msg_list">
    <ul class="list-box">
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">R</span>
    </div>
    <div class="list-body">
    <span class="message-author">Richard Miles </span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item new-message">
    <div class="list-left">
    <span class="avatar">J</span>
    </div>
    <div class="list-body">
    <span class="message-author">John Doe</span>
    <span class="message-time">1 Aug</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">T</span>
    </div>
    <div class="list-body">
    <span class="message-author"> Tarah Shropshire </span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">M</span>
    </div>
    <div class="list-body">
    <span class="message-author">Mike Litorus</span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">C</span>
    </div>
    <div class="list-body">
    <span class="message-author"> Catherine Manseau </span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">D</span>
    </div>
    <div class="list-body">
    <span class="message-author"> Domenic Houston </span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">B</span>
    </div>
    <div class="list-body">
    <span class="message-author"> Buster Wigton </span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">R</span>
    </div>
    <div class="list-body">
    <span class="message-author"> Rolland Webber </span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">C</span>
    </div>
    <div class="list-body">
    <span class="message-author"> Claire Mapes </span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">M</span>
    </div>
    <div class="list-body">
    <span class="message-author">Melita Faucher</span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">J</span>
    </div>
    <div class="list-body">
    <span class="message-author">Jeffery Lalor</span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">L</span>
    </div>
    <div class="list-body">
    <span class="message-author">Loren Gatlin</span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    <li>
    <a href="chat.html">
    <div class="list-item">
    <div class="list-left">
    <span class="avatar">T</span>
    </div>
    <div class="list-body">
    <span class="message-author">Tarah Shropshire</span>
    <span class="message-time">12:28 AM</span>
    <div class="clearfix"></div>
    <span class="message-content">Lorem ipsum dolor sit amet, consectetur adipiscing</span>
    </div>
    </div>
    </a>
    </li>
    </ul>
    </div>
    <div class="topnav-dropdown-footer">
    <a href="chat.html">See all messages</a>
    </div>
    </div>
    </div>
    </div>
</w:wrapper>
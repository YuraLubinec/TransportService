<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap -->
  <link href="<c:url value = "/resources/dist/css/bootstrap/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value = "/resources/dist/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">

  <!-- Bootstrap Data table css-->
  <link href="<c:url value = "/resources/dist/bootstrap-dataTables/css/dataTables.bootstrap.min.css" />" rel="stylesheet">

  <!-- Datepicker CSS -->
  <link href="<c:url value = "/resources/dist/css/dateTimePicker/bootstrap-datepicker.css" />" rel="stylesheet">

  <!-- Main CSS -->
  <link href="<c:url value = "/resources/dist/css/main.css" />" rel="stylesheet">

    <!-- jQuery CSS -->
  <link href="<c:url value = "/resources/dist/css/jquery/jquery-ui.css" />" rel="stylesheet">

  <!-- Bootstrap toggle CSS -->
  <link href="<c:url value = "/resources/dist/css/toggleBootstrap/bootstrap-toggle.min.css" />" rel="stylesheet">

  <!-- jQuery -->
  <script src="<c:url value = "/resources/dist/js/jquery/jquery.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/js/jquery/jquery.js" />"></script>
  <script src="<c:url value = "/resources/dist/js/jquery/jquery-ui.js" />"></script>


  <!-- Main script -->
  <script src="<c:url value = "/resources/js/main.js" />"></script>

  <!-- Bootstrap JS -->
  <script src="<c:url value = "/resources/dist/js/bootstrap/bootstrap.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/js/bootstrap/bootstrap.js" />"></script>

  <!-- Bootstrap Data table js-->
  <script src="<c:url value = "/resources/dist/bootstrap-dataTables/js/jquery.dataTables.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/bootstrap-dataTables/js/dataTables.bootstrap.min.js" />"></script>

  <!-- WebSocket JS -->
  <script src="<c:url value = "/resources/dist/js/web_socket/sockjs.min.js" />"></script>
  <script src="<c:url value = "/resources/dist/js/web_socket/stomp.min.js" />"></script>

  <!-- Bootstrap toggle JS -->
  <script src="<c:url value = "/resources/js/toggleBootstrap/bootstrap-toggle.min.js"/>"></script>
  <script src="<c:url value = "/resources/js/toggleBootstrap/workTypeToggle.js"/>"></script>

  <!-- Datepicker JS -->
<script src=<c:url value="/resources/js/dateTimePicker/bootstrap-datepicker.js" />></script>
<script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>


  <title>
    <tiles:insertAttribute name="title" ignore="true" />
  </title>

</head>

<body>

  <tiles:insertAttribute name="menu" />

  <div id="">
    <tiles:insertAttribute name="body" />
  </div>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
  <div class="row">
    <h1 class="pull-down col-md-6">Редагування замовлення</h1>
  </div>
  <div class="row">
    <div class="col-md-4">

      <form:form action="" method="POST" modelAttribute="orders" class="form-group pull-down">
        <fieldset>
          <label class="col-md-12 no-padding-left">Табельний номер</label>
          <form:input type="text" id="" path="user_tab" readonly="true" class="form-control" cssErrorClass="" />

          <label>Замовник</label>
          <form:input type="text" path="customer" readonly="true" class="form-control" cssErrorClass="" />

          <label>Номер телефону</label>
          <form:input type="text" path="mobile_phone_number" readonly="true" class="form-control" cssErrorClass="" />


          <label>Email</label>
          <form:input type="text" path="second_email" readonly="true" class="form-control" cssErrorClass=""/>

          <label>Вид робіт</label>
          <form:select id='typeOfWork' path="workType" items="${typeWorks}" class="form-control" data-placeholder="work"
            itemLabel="name" itemValue="id" readonly="true" />

          <label>Кількість</label>
          <form:input path="count" id="countOrders" class="form-control" readonly="true" value="${orders.count}" />

          <div id="car_name">
            <label>Марка авто</label>
            <form:select path="car" items="${cars}" class="form-control" data-placeholder="cars" itemLabel="name" itemValue="id"
            />
          </div>
          <label>Модель</label>
          <form:input required="required" path="car_model" class="form-control" cssErrorClass="error form-control" />
          <form:errors path="car_model" class="help-block with-errors" cssErrorClass="" />

          <label>Номер авто</label>
          <form:input required="required" id="" path="car_number" class="form-control" cssErrorClass="error form-control"/>
          <form:errors path="car_number" class="help-block with-errors" cssErrorClass="" />
          <!-- 	 data of orders  -->
          <input id="timeOrder" type="hidden">
          <input id="orderStatus" value='${orders.status_order}' type="hidden"></input>
          <!-- all data from controller -->
          <c:forEach items='${workTypeFromSap}' var='typeOfWork'>
            <input class='idWork' type="hidden" value='${typeOfWork.id}'>
            <input class='nameWork' type="hidden" value='${typeOfWork.name}'>
            <input class='timeWork' type="hidden" value='${typeOfWork.time}'>

          </c:forEach>

          <c:if test="${orders.status_order == 'NEW'}">
            <div class="col-md-12 no-padding-left">
              <p>
                <font color="red"><strong> Дата яку вказав замовник :</strong></font>
                <c:out value='${orders.date}'></c:out>
              </p>
              <p>
                <font color="red"><strong> Термін вказаний замовником :</strong></font>
                <c:out value='${orders.time}'></c:out> -
                <c:out value='${orders.time_end}'></c:out>
              </p>
              <p>
                <font color="green"><strong> Виберіть доступний час для надання послуги :</strong></font>
              </p>
            </div>
          </c:if>

          <label class="col-md-6 no-padding-left">Дата</label>
          <label class="col-md-3">Початок</label>
          <label class="col-md-3">Кінець</label>
          <div id="datePicker">
            <div class="col-md-6 no-padding">
              <form:input id="dpicker" required="required" path="date" class="date start form-control" cssErrorClass="date start error form-control"
              />
              <form:errors path="date" class="help-block with-errors" cssErrorClass="" />
            </div>
            <div class="col-md-3 no-padding-right">
              <form:select id="selectForm" path="time" class="tpicker form-control" required="required" cssErrorClass="error form-control">
                <form:option value="${orders.time}">${orders.time}</form:option>
              </form:select>
              <form:errors path="time" class="help-block with-errors" cssErrorClass="" />

            </div>
            <div class="col-md-3 no-padding-right">
              <form:input id="time_end" required="required" path="time_end" class="form-control" readonly="true" cssErrorClass="error form-control"
              />
              <form:errors path="time_end" class="help-block with-errors" cssErrorClass="" />
            </div>
          </div>
          <label class="col-md-12 no-padding-left">Статус замовлення</label>
          <form:select path="status_order" items="${items}" itemLabel="statusOrder" class="form-control" />
          <button id="sendForm" type="submit" class="btn btn-success pull-down">Зберегти
            	<span class="glyphicon glyphicon-ok"></span>
            </button>
          <a href=<c:url value="/admin/order" /> class="btn btn-default pull-down">Назад</a>
        </fieldset>
      </form:form>
    </div>
  </div>
</div>

<input id="idOrder" type="hidden" value="${orders.id}" />
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- DateTimePicker -->
<script src=<c:url value="/resources/js/dateTimePicker/timeForAdmin.js" />></script>




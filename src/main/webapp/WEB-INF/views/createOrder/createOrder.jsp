<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

 
 <link href="<c:url value = "/resources/dist/css/user/userOrder.css" />"  rel="stylesheet" >
 <!-- CSS Nouislider -->
 <link href="<c:url value = "/resources/dist/css/dateTimePicker/nouislider.min.css" />" rel="stylesheet">


<div class="container-fluid">

  <div class="col-md-12">

    <c:if test="${param.message != true}">
      <div class="row">
        <h2>Для реєстрації замовлення заповніть дану форму</h2>
      </div>
      <div class="col-md-4 col-md-offset-4">

        <form:form action="" method="POST" modelAttribute="orders" class="form-group" id="orderForm">
          <div class = "form-inline col-lg-12 no-padding" >
	          <div class="col-md-9 no-padding form-group">
	          <label class="col-md-9 no-padding-left form-group">Вид робіт</label>
	          <div class = "input-group"><span class="input-group-addon"><span class="glyphicon glyphicon glyphicon-cog"></span></span>
	            <form:select id="typeOfWork" path="workType" items="${workTypeFromSap}" class="form-control orderInput" data-placeholder="work"
	              itemLabel="name" itemValue="id" cssErrorClass="error form-control" />
	            <form:errors path="workType" class="help-block with-errors" cssErrorClass="" />
	            </div>
	          </div>
	          <div class="col-md-3 no-padding form-group">
	          <label class="col-md-12 form-group">Кількість</label>
	             <div class = "input-group"><span class="input-group-addon"><span class = "glyphicon glyphicon-minus"></span></span>
	            <form:select id="countOrder" path="count" class="form-control orderInput">
	              <option>1&emsp;&emsp;</option>
	              <option>2&emsp;&emsp;</option>
	              <option>3&emsp;&emsp;</option>
	              <option>4&emsp;&emsp;</option>
	            </form:select>
	          </div>
	          </div>
          </div>
          <input id="idFromSelect" type="hidden">
          <input id="nameFromSelect" type="hidden">
          <input id="timeFromSelect" type="hidden" value='30'>
          <input id="priceFromSelect" type="hidden">

          <!-- all data from controller -->
          <c:forEach items='${workTypeFromSap}' var='typeOfWork'>
            <input class='idWork' type='hidden' value='${typeOfWork.id}'>
            <input class='nameWork' type="hidden" value='${typeOfWork.name}'>
            <input class='priceWork' type="hidden" value='${typeOfWork.price}'>
            <input class='timeWork' type="hidden" value='${typeOfWork.time}'>

          </c:forEach>

          <label>Табельний номер</label>
          <form:input required="required" id="tableNumber" class="form-control orderInput" path="user_tab" placeholder="Введіть Ваш табельний номер"
            cssErrorClass="error form-control" />
          <form:errors path="user_tab" class="help-block with-errors" cssErrorClass="" />

          <label>Марка автор</label>
          <form:select id="carBrand" path="car" items="${cars}" class="form-control orderInput" data-placeholder="cars" itemLabel="name"
            itemValue="id" cssErrorClass="error form-control" />
          <form:errors path="car" class="help-block with-errors" cssErrorClass="" />

          <label>Модель</label>
          <form:input id="modelCar" required="required" path="car_model" placeholder="Введіть модель авто" class="form-control orderInput"
            cssErrorClass="error form-control" />
          <form:errors path="car_model" class="help-block with-errors" cssErrorClass="" />

          <label>Номер авто</label>
          <form:input id="numberCar" required="required" path="car_number" class="form-control orderInput" placeholder="Введіть номер Вашого авто"
            cssErrorClass="error form-control" />
          <form:errors path="car_number" class="help-block with-errors" cssErrorClass="" />

          <label>Дата</label>
          <div id="datePicker">
            <form:input id="dpicker" required="required" path="date" class="date start dateChange form-control " placeholder="Виберіть дату"
              cssErrorClass="date start dateChange error form-control" />
            <form:errors path="date" class="help-block with-errors" cssErrorClass="" />
          </div>


          <label> Виберіть період надання послуги</label>

          <div class="col-md-12">
            <div class="containSlider">
              <div id="range"></div>
            </div>
          </div>
          <br>
          <br>
          <br>
        <div class = "form-inline no-padding col-md-12">
          <div class="col-md-6 form-group no-padding-left">
            <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon glyphicon-time"></span></span>
            <form:input id="startTime" required="required" path="time" class="form-control" placeholder="початок"
              readonly="true" cssErrorClass="error form-control" />
            <form:errors path="time" class="help-block with-errors" cssErrorClass="" />
            </div>
          </div>

          <div class="col-md-6 form-group no-padding">
            <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon glyphicon-time"></span></span>
            <form:input id="endTime" required="required" path="time_end" class="form-control" placeholder="кінець"
              readonly="true" cssErrorClass="error form-control" />
            <form:errors path="time_end" class="help-block with-errors" cssErrorClass="" />
            </div>
          </div>
        </div>
          <label>Мобільний номер</label>
          <form:input id="mobile_phone_number" required="required" path="mobile_phone_number" class="form-control orderInput"
            placeholder="+38011111111" cssErrorClass="error form-control" />
          <form:errors path="mobile_phone_number" class="help-block with-errors" cssErrorClass="" />

          <label>Якщо у вас немає email адреси, вкажіть будь ласка адресу, на яку має прийти сповіщення про підтвердження замовлення</label>
          <form:input id="second_email" path="second_email" class="form-control orderInput" placeholder="__.__@oe.if.ua"
            cssErrorClass="error form-control" />
          <form:errors path="second_email" class="help-block with-errors" cssErrorClass="" />

          <br>

          <div class="">
            <button id="" type="submit" class="btn btn-success paymentApprove form-control pull-down">Замовити
          <span class="glyphicon glyphicon-ok"></span>
          </button>
          </div>

        </form:form>

      </div>

      <div class="row">

        <div class="col-md-8 col-md-offset-2">
          <h2>Перелік доступних послуг</h2>
          <div class="table-responsive">
            <table class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th class="col-md-4">Назва робіт</th>
                  <th class="col-md-4">Вартість послуги</th>
                  <th class="col-md-4">Час виконання послуги</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${workTypeFromSap}" var="workType">
                  <tr id="${workType.id}">
                    <td>
                      <c:out value="${workType.name}"></c:out>
                    </td>
                    <td>
                      <c:out value="${workType.price}. грн"> </c:out>
                    </td>
                    <td>
                      <c:out value="${workType.time/60} год."> </c:out>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </c:if>

    <c:if test="${param.message == true}">

      <div class="row">
        <div class="alert alert-success col-md-4 col-md-offset-4">
          Ваше замовлення оформлено, очікуйте квитанцію для оплати на Вашу електронну пошту!
        </div>
      </div>

      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <a href=<c:url value="/" /> class="btn btn-success">Повернутися</a>
        </div>
      </div>

    </c:if>
  </div>
</div>

<input id="message" type="hidden" value="${param.message}" />
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main js -->
<script src=<c:url value="/resources/js/user/user.js" />></script>

<!-- Nouislider library -->
<script src=<c:url value="/resources/js/dateTimePicker/nouislider.min.js" />></script> 
<!-- Default timeRange -->
<script src=<c:url value="/resources/js/dateTimePicker/timeRangeDisable.js" />></script>
  
<script src=<c:url value="/resources/js/dateTimePicker/timeRange.js" />></script>
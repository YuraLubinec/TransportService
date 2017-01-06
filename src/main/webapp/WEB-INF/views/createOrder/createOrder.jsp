<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">

  <div class="col-md-12">

    <c:if test="${param.id == null}">
      <div class="row">
        <h2>Для реєстрації замовлення заповніть дану форму</h2>
      </div>
      <div class="col-md-4 col-md-offset-4">

        <form:form action="" method="POST" modelAttribute="orders" class="form-group" id="orderForm">

          <label class="col-md-12 no-padding-left">Вид робіт</label>
          <div class="col-md-9 no-padding">
            <form:select id="typeOfWork" path="workType" items="${workTypeFromSap}" class='form-control orderInput' data-placeholder="work"
              itemLabel="name" itemValue="id" cssErrorClass="error form-control" />
            <form:errors path="workType" class="help-block with-errors" cssErrorClass="" />
          </div>
          <div class="col-md-2 bold-padding">Кількість:</div>
          <div class="col-md-1 no-padding-right">
            <form:select id="countOrder" path="count" class="no-padding option-center form-control">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
            </form:select>
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

          <label>Мобільний номер</label>
          <form:input id="mobile_phone_number" required="required" path="mobile_phone_number" class="form-control orderInput"
            placeholder="+38011111111" cssErrorClass="error form-control" />
          <form:errors path="mobile_phone_number" class="help-block with-errors" cssErrorClass="" />

          <br>

          <label> Виберіть період надання послуги</label>

          <div class = "col-md-12">
	          <div class="containSlider">
	            <div id="range"></div>
	          </div>
          </div>
          <br>

          <label class="col-md-6 no-padding-left">Початок</label>
          <label class="col-md-6">Кінець</label>

          <div class="col-md-6 no-padding">
            <form:input id="startTime" required="required" path="time" class="form-control col-md-6 " placeholder="start" readonly="true"
              cssErrorClass="error form-control" />
            <form:errors path="time" class="help-block with-errors" cssErrorClass="" />
          </div>

          <div class="col-md-6 no-padding-right">
            <form:input id="endTime" required="required" path="time_end" class="col-md-6 form-control" placeholder="end" readonly="true"
              cssErrorClass="error form-control" />
            <form:errors path="time_end" class="help-block with-errors" cssErrorClass="" />
          </div>
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
                      <c:out value="${workType.price},грн"> </c:out>
                    </td>
                    <td>
                      <c:out value="${workType.time/60}год."> </c:out>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </c:if>

    <c:if test="${param.id != null}">

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

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />
 <link rel="stylesheet" href=<c:url value="/resources/dist/css/user/userOrder.css" />>
 <link href="<c:url value = "/resources/dist/css/dateTimePicker/nouislider.css" />" rel="stylesheet">
 <link href="<c:url value = "/resources/dist/css/dateTimePicker/nouislider.min.css" />" rel="stylesheet">
 <link href="<c:url value = "/resources/dist/css/dateTimePicker/nouislider.pips.css" />" rel="stylesheet">
 <link href="<c:url value = "/resources/dist/css/dateTimePicker/nouislider.tooltips.css" />" rel="stylesheet">
 <script src=<c:url value="/resources/js/dateTimePicker/nouislider.js" />></script>
 <script src=<c:url value="/resources/js/dateTimePicker/nouislider.min.js" />></script> 
 <script src=<c:url value="/resources/js/dateTimePicker/timeRange.js" />></script>
 <script src=<c:url value="/resources/js/dateTimePicker/timeRangeDisable.js" />></script>
 <script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>
 <script src=<c:url value="/resources/js/dateTimePicker/dateTimePicker.js" />></script>
 <script src=<c:url value="/resources/js/dateTimePicker/bootstrap-datepicker.js" />></script>
 <script src=<c:url value="/resources/js/dateTimePicker/datepair.js" />></script>
 <script src=<c:url value="/resources/js/dateTimePicker/jquery.timepicker.js" />></script>        

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered" id="orders">
          <thead>
            <tr>
              <th class="col-md-2">Замовник</th>
              <th class="col-md-1">Табельний номер</th>
              <th class="col-md-3">Вид робіт</th>
              <th class="col-md-1">Дата</th>
              <th class="col-md-1">Час</th>
              <th class="col-md-1">Всього до оплати</th>
              <th class="col-md-1">Номер замовлення</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${orders}" var="order">
            <tr id="${order.id}" class="dataRow">
              <td>
                <c:out value="${order.customer}"></c:out>
              </td>
              <td>
                <c:out value="${order.user_tab}"></c:out>
              </td>
              <td>
                <c:out value="${order.workType.name}"></c:out>
              </td>
              <td>
                <c:out value="${order.date}"></c:out>
              </td>
              <td>
                <c:out value="${order.time}"></c:out>
              </td>
              <td>
                <c:out value="${order.all_sum}"></c:out>
              </td>
              <td>
                <c:out value="${order.bill_number}"></c:out>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <a class="btn btn-primary" href=<c:url value="/cashier" />>Головна старінка касира</a>
    </div>
  </div>
</div>


<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main page script -->
<script src=<c:url value="/resources/js/cashier/cashier.js" />></script>

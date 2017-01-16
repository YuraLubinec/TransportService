$(function() {
  var contextPath = $('#contextPath').val();
  var stompClient = null;
  
  connect();

  $(document).ready(function() {
	    $('#orders').DataTable({
	      language: {
	        search: "Введіть ПІП замовника:",
	        searchPlaceholder: "пошук...",
	        zeroRecords: "За даними параметрами збігів не знайдено",
	        paginate: {
	          next: "Наступна",
	          previous: "Попередня"
	        }
	      },
	      order: [1, 'asc'],
	      columnDefs: [{
	        targets: [2, 3, 4, 6, 8, 10, 11],
	        orderable: false,
	      }, {
	        targets: [0, 2, 3, 4, 5, 6, 7, 8, 9, 10],
	        searchable: false,
	      }],
	      bLengthChange: false,
	      info: false,
	    });
	  });
  
  function connect() {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.debug = null;
    stompClient.connect({}, function(frame) {
      stompClient.subscribe('/adminNotification', function(orderNotification) {
        alert(JSON.parse(orderNotification.body).notifictionMessage);
        document.location.href = contextPath + '/admin/order';
      });
    });
  }
  
  $(document).on('click', '.delete', function() {
    if (confirm('Ви справді хочете видалити дане замовлення')) {
      deleteOrder($(this));
    }
    return false;
  });

  function deleteOrder(id) {
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/admin/order/delete',
      contentType: 'application/json',
      data: JSON.stringify(id.prop('id')),
      success: function() {
    	  id.closest('tr').remove();
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  };
  
});
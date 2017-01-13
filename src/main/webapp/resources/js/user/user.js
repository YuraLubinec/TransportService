$(function() {
  var stompClient = null;
  var contextPath = $('#contextPath').val();
  
//Create web socket connection to the server, invoke sendName and disconnect functions
  function connect(customer) {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      if (socket.readyState === 1) {
        sendName(customer);
        disconnect();
      }
    });
  }

  // web socket disconnect
  function disconnect() {
    if (stompClient != null) {
      stompClient.disconnect();
    }
  }

  //Sent message to the server about new order confirmation
  function sendName(customer) {
    stompClient.send("/app/newOrderNotification", {}, JSON.stringify({
      'message': 'Нове замовлення від '+customer
    }));
  }

  $('#orderForm').on('submit', function(){
    connect($('#tableNumber').val());
  });

});
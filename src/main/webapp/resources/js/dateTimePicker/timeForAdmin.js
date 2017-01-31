
$(function() {
  var contextPath = $('#contextPath').val();
  
  // this function execution when downloading page and return fee time for date which shoose
  $(document).ready(function(){
	  if($("#orderStatus").val() == 'NEW'){
		selectTime($("#dpicker").val());
	  }
  });

  // this function appeals to AJAX  
  $(document).on('click', '.day', function() {
    var classVal = $(this).prop('class');
    if (classVal === 'day') {
      selectTime($("#dpicker").val());
    } else {
      if ($("#dpicker").val() == "") {
        $('#selectForm').children('option').remove();  
      }
    }
  });
  
  $(document).on('click', '.tpicker', function() {
	  if ($("#dpicker").val() != "") {
		  var sizeSelect = $('select.tpicker option').length;
		  if ( sizeSelect <= 1 ){
			  selectTime($("#dpicker").val());
			  setEndTimeForOrder();
		  }
	    setEndTimeForOrder();
	  }
	});

  function selectTime(timeInput) {
	  getDataOrder();
    $.ajax({
      type: 'POST',
      url: contextPath + '/admin/selectTimeAdmin',
      contentType: 'application/json',
      data: JSON.stringify({
        "date": timeInput,
        "id": $("#idOrder").val(),
        "timeExecution": $("#timeOrder").val(),

      }),
      success: function(response) {
        $('#selectForm').children('option').remove();
        for (var i = 0; i < response.length; i++) {
          $('#selectForm').append($('<option></option>').val(
            response[i]).html(response[i]))
        }
        setEndTimeForOrder();
      },
      error: function(jqXHR) {
        if (jqXHR.status == 400) {
          console.log(timeInput);
          console.log()
          alert('Невірно введена дата, повторіть спробу!!!');
        } else {
          alert('Smth wrong... code: ' + jqXHR.status);
        }
      },
    });
  };
});

// this function for getting the time execution of order
function getDataOrder() {
  var idWorkFromSelect = $("#typeOfWork").val();
  var idWork = document.getElementsByClassName('idWork');
  var nameWork = document.getElementsByClassName('nameWork');
  var timeWork = document.getElementsByClassName('timeWork');

  for (var i = 0; i < idWork.length; i++) {

    if (idWork[i].value === idWorkFromSelect) {

      $('#timeOrder').val(timeWork[i].value);
    }
  }
}

function setEndTimeForOrder() {
  var startTime = $('#selectForm').val();
  if(startTime !== null){
	  var endTime = getEndTime(startTime);
	  $('#time_end').val(endTime);
  }else{
	  $('#time_end').val(null);
	  $('#selectForm').val(null);
	  
  }
}

// this  function return time of end function
function getEndTime(timeString) {
  var time = timeString.split(":");
  var hours = time[0];
  var minutes = time[1];
  var seconds = time[2];

  var timeWorkExecution = $("#timeOrder").val();
  var countOrder = $("#countOrders").val();
  
  var minuteExecution = (((hours * 60) + (timeWorkExecution * countOrder)));
    
  var execCheck = minuteExecution/60;
  var str = execCheck.toString();
  
  if( str.length >= 3 && str[3] == 5){
	  
	  if(minutes == 30){
		  minuteExecution += 30;
		  minutes = "00";
	  }else{
		  minutes = "30"
		  minuteExecution -= 30;
	  }  
  }
  
  var hourEndExec = minuteExecution / 60;

  var hourString = hourEndExec.toString();
  
  console.log(minutes);
  
  var timeEnd = hourString.concat(':').concat(minutes).concat(':').concat(
    seconds);
  return timeEnd;
}

/**
 * @author user
 */

//@Bind #bftStart.onClick  
!function(startAction){
	startAction.execute(function(rv){
		if(rv!="FFAILURE")
		window.location = "startMeeting.jsp?rv="+rv;
	});
};
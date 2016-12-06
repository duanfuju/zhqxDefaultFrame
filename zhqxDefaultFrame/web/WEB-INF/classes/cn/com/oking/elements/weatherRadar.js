/** @Bind #btnNanjingStation.onClick  */
!function(ifShow,btnNanjingStation,btnHefeiStation,btnAlert,btnFine){
	ifShow.set("path","NanjingStation.jsp");
	ifShow.reload();
	
	btnNanjingStation.set("style", {
			   backgroundColor : "blue"
			});
	btnHefeiStation.set("style", {
		   backgroundColor : ""
		});
	btnAlert.set("style", {
		   backgroundColor : ""
		});
	btnFine.set("style", {
		   backgroundColor : ""
		});
};

/** @Bind #btnHefeiStation.onClick  */
!function(ifShow,btnNanjingStation,btnHefeiStation,btnAlert,btnFine){
	ifShow.set("path","HefeiStation.jsp");
	ifShow.reload();
	btnNanjingStation.set("style", {
		   backgroundColor : ""
		});
	btnHefeiStation.set("style", {
		   backgroundColor : "blue"
		});
	btnAlert.set("style", {
		   backgroundColor : ""
		});
	btnFine.set("style", {
		   backgroundColor : ""
		});
};

/** @Bind #btnAlert.onClick  */
!function(ifShow,btnNanjingStation,btnHefeiStation,btnAlert,btnFine){
	ifShow.set("path","Alert.jsp");
	ifShow.reload();
	btnNanjingStation.set("style", {
		   backgroundColor : ""
			});
	btnHefeiStation.set("style", {
		   backgroundColor : ""
		});
	btnAlert.set("style", {
		   backgroundColor : "blue"
		});
	btnFine.set("style", {
		   backgroundColor : ""
		});

};

/** @Bind #btnFine.onClick  */
!function(ifShow,btnNanjingStation,btnHefeiStation,btnAlert,btnFine){
	ifShow.set("path","Fine.jsp");
	ifShow.reload();
	btnNanjingStation.set("style", {
		   backgroundColor : ""
		});
	btnHefeiStation.set("style", {
		   backgroundColor : ""
		});
	btnAlert.set("style", {
		   backgroundColor : ""
		});
	btnFine.set("style", {
		   backgroundColor : "blue"
		});
};


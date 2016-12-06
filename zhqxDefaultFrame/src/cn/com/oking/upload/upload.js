var _fileName = "";

/** @Bind #autoUploadAction.onReady */
!function(autoUploadAction,labtip){
	var _exec = "${request.getParameter('exec')}";
	var _size = "${request.getParameter('size')}";
	var f = autoUploadAction.get("filters");
	f[0].extensions = _exec;
	autoUploadAction.set("filters",f);  //限制类型
	autoUploadAction.set("maxFileSize",_size);  //限制大小
	labtip.set("text","文件格式:"+_exec+"\t最大:"+_size);
	//alert(fil.extensions);
};

/** @Bind #autoUploadAction.beforeFileUpload */
!function( self, form){
	var _fileid = "${request.getParameter('fileid')}";
	var _pathType = "${request.getParameter('pathType')}";
	var _type = "${request.getParameter('type')}";
	//
	//动态设置参数
	//var entity = form.get("entity");
	self.set("parameter", {
		fileid: _fileid,
		pathType:_pathType,
		type:_type
	});
	//上面代码可以简写为
	//self.set("parameter", entity.toJSON());
};

/** @Bind #autoUploadAction.onFileUploaded */
!function(arg) {
	//获取FileResolver方法返回的信息
	var info = arg.returnValue;
//	var name = java.net.URLDecoder.decode(info.fileName,"UTF-8");
//	dorado.MessageBox.alert(name);
	window.parent.setUploadParam(info.fileid,_fileName);
};


/** @Bind #autoUploadAction.onFilesAdded */
!function(self,arg){
	var file = arg.files[0];
	_fileName = file.name;
};

/** @Bind #autoUploadAction.onUploadProgress */
!function(arg, autoUploadProgressBar) {
	autoUploadProgressBar.set("value", arg.total.percent);
};

var prettySize = function(value) {
	var _format = function(value, unit) {
		return (value.toFixed(1) + ' ' + unit).replace('.0', '');
	};
	var K = 1024;
	var M = K * K;
	var G = M * K;
	var T = G * K;
	var dividers = [ T, G, M, K, 1 ];
	var units = [ 'TB', 'GB', 'MB', 'KB', 'B' ];
	if (value == 0) {
		return '0B';
	} else if (value < 0) {
		return 'Invalid size';
	}

	var result = '';
	var temp = 0;
	for ( var i = 0; i < dividers.length; i++) {
		var divider = dividers[i];
		if (value >= divider) {
			temp = value / divider;
			if (temp < 1.05) {
				result = _format(value,
						units[((i + 1) < units.length) ? (i + 1) : i]);
			} else {
				result = _format(temp, units[i]);
			}
			break;
		}
	}
	return result;
};


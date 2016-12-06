/*
 * Ext JS Library 2.0.2
 * Copyright(c) 2006-2008, Ext JS, LLC.
 * licensing＠extjs.com
 * 
 * extjs.com/license
 */

Ext.onReady(function(){

    Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

    // create some portlet tools using built in Ext tool ids
    var tools = [{
        id:'gear',
        handler: function handleMaximize(e, target, panel) {
		
        // create the window on the first click and reuse on subsequent clicks
            win = new Ext.Window({
            	title :panel.title,
                layout      : 'fit',
                width       : 800,
                height      : 550,
                closeAction :'hide',
                plain       : true,
                modal:true,
                items : new Ext.Panel({
					html : panel.region,
					width: '100%',
					height : '100%'
                }),
                buttons: [{
                    text     : '关闭',
                    handler  : function(){
                        win.hide();
                    }
                }]
            });
        
        win.show();
	}
    },{
        id:'close',
        handler: function(e, target, panel){
            panel.ownerCt.remove(panel, true);
        }
    }];

    var viewport = new Ext.Viewport({
        layout:'border',
        items:[
			   /*左侧菜单开始
			   {
            region:'west',
            id:'west-panel',
            title:'West',
            split:true,
            width: 200,
            minSize: 175,
            maxSize: 400,
            collapsible: true,
            margins:'35 0 5 5',
            cmargins:'35 5 5 5',
            layout:'accordion',
            layoutConfig:{
                animate:true
            },
            items: [{
                html: '111',
                title:'Navigation',
                autoScroll:true,
                border:false,
                iconCls:'nav'
            },{
                title:'Settings',
                html: '22',
                border:false,
                autoScroll:true,
                iconCls:'settings'
            }]
        },
			左侧菜单结束*/
		{
            xtype:'portal',
            region:'center',
            margins:'0 5 5 0',
            items:[{
                columnWidth:.74,
                style:'padding:0 0 0 10px',
                items:[{
                    title: '彩云天气',
					
                    layout:'fit',
					region: '<iframe src="http://218.2.99.66/pkqx/dorado/caiyun/list.jsp"   style="width:100%; height:200px; margin-left:1px; margin-top:2px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>',
                    tools: tools,
					autoScroll:true,
						bodyStyle : 'overflow-x:visible; overflow-y:scroll',
                    html:'<iframe src="http://218.2.99.66/pkqx/dorado/caiyun/list.jsp"  name="hla" style="width:100%; height:170px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>'
                }
				
				,{
                    title: '数据同步',
                    region: '<iframe src="http://218.2.99.66/pkqx/znjk/qxglIndex.jsp"   style="width:100%; height:450px; margin-left:-40px; margin-top:2px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>',
                    tools: tools,
                    html:'<iframe src="http://218.2.99.66/pkqx/znjk/qxglIndex.jsp"  name="hla" style="width:100%; height:390px;margin-left:0px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>'
                }
				
				]
            }
			
			,{
                columnWidth:.25,
                style:'padding:0 0 0 10px;',
                items:[{
                    title: '未来一小时降雨预报',
                    region: '<iframe src="http://218.2.99.66/pkqx/dorado/caiyun/deskqxt/index2.html?a=a=12#118.6281,32.0588"   style="width:100%; height:450px; margin-left:1px; margin-top:2px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>',
                    tools: tools,
                    html:'<iframe src="http://218.2.99.66/pkqx/dorado/caiyun/deskqxt/index2.html?a=1a=12#118.6523,32.1547"  name="hla" style="width:100%; height:170px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>'
                },{
                    title: '雨量排序图',
                     region: '<iframe src="http://218.2.99.66/pkqx/dorado/echarts2.2.3/echarts_pkyl.jsp"   style="width:100%; height:450px; margin-left:1px; margin-top:2px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>',
                    tools: tools,
                    html:'<img src="../3.png" height="170" />'
                }
				]
            }
			
			
				
			]
        }]
    });
});


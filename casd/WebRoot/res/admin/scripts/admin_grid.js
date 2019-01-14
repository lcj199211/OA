(function($) {
	$.fn.admin_grid = function(options) {

		var defaults = {
			url : " ", // 默认调用json路径
			excel_url : "?type=Excel",
			queryBtn : "#btnSearch",
			excelBtn : "#btnExcel",
			pageSize : 20,
			cmdHanlder : function() {
			}
		};
	

		var grid = this;

		var opts = $.extend({}, defaults, options);
		var queryParams = {};

		$("input[name],select[name]", $(grid).parents(".easyui-layout:first").find(".search")).each(function(index, obj) {
			if (queryParams[$(this).attr("name")] == undefined) {
				queryParams[$(this).attr("name")] = $(this).val();
			} else {
				queryParams[$(this).attr("name")] = queryParams[$(this).attr("name")] + "," + $(this).val();
			}
		});

		var cmenu;
		function createColumnMenu() {
			cmenu = $('<div/>').appendTo('body');
			cmenu.menu({
				onClick : function(item) {
					if (item.iconCls == 'icon-ok') {
						$(grid).datagrid('hideColumn', item.name);
						cmenu.menu('setIcon', {
							target : item.target,
							iconCls : 'icon-empty'
						});
					} else {
						$(grid).datagrid('showColumn', item.name);
						cmenu.menu('setIcon', {
							target : item.target,
							iconCls : 'icon-ok'
						});
					}
				}
			});
			var fields = $(grid).datagrid('getColumnFields', false);
			for (var i = 0; i < fields.length; i++) {
				var field = fields[i];
				if (field == "ck" || field == "op")
					continue;
				var col = $(grid).datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text : col.title,
					name : field,
					iconCls : 'icon-ok'
				});
			}
		}

		var load_params = null;
		$(grid).datagrid($.extend({
			pageList : [ 20, 30, 50, 100 ],
			queryParams : queryParams,
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
				if (!cmenu) {
					createColumnMenu();
				}
				cmenu.menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
			onLoadSuccess : function(data) {
				var grid = this;
				$(".opt", $(grid).parent()).linkbutton().click(function() {
					var cmd = $(this).attr("cmd");
					var i = parseInt($(this).attr("i"));
					var flag = opts.cmdHanlder(cmd, data.rows[i], this);
					return (flag == true);
				});
			},
			onBeforeLoad : function(params) {
				load_params = params;
			}
		}, opts));

		$(opts.queryBtn).click(function() {
			var queryParams = {};
			$("input[name],select[name]", $(grid).parents(".easyui-layout:first").find(".search")).each(function(index, obj) {
				if (queryParams[$(this).attr("name")] == undefined) {
					queryParams[$(this).attr("name")] = $(this).val();
				} else {
					queryParams[$(this).attr("name")] = queryParams[$(this).attr("name")] + "," + $(this).val();
				}
			});
			$(grid).datagrid({
				queryParams : queryParams
			});
		});
		
		$(opts.excelBtn)
				.click(
						function() {
							var excel = null;

							$("#exportDiv").remove();
							var pageOptions = $($(grid).datagrid("getPager")).pagination("options");
							var pageCount = Math.ceil(pageOptions.total / pageOptions.pageSize);
							var html = '';

							html = '<form method="POST" target="_top" id="export"><table><tr><td style="line-height: 30px">导出从<input type="text" name="start" class="easyui-numberspinner" style="width: 50px;" required="required" data-options="min:1,max:'
									+ pageCount
									+ ',editable:true" value="1" />页到<input type="text" style="width: 50px;" name="end" class="easyui-numberspinner" required="required" data-options="min:1,max:'
									+ pageCount + ',editable:true" value="1" />页</td></tr></table>';
							for ( var str in load_params) {
								html += '<input type="hidden" name = "' + str + '" value = "' + load_params[str] + '"/>';
							}
							html += '</form>';
							if (excel == undefined) {
								excel = $('<div id="exportDiv" style="width: 300px; height: 150px; padding: 5px;"></div>').appendTo('body');
								$(excel).append(html);
								$.parser.parse(excel);
							}

							$(excel).dialog({
								title : "导出Excel",
								iconCls : 'icon-page_excel',
								modal : true,
								closed : false,
								buttons : [ {
									text : '确定',
									iconCls : 'icon-ok',
									handler : function() {
										var isValid = $("#export").form('validate');
										if (isValid) {
											$("#export").attr("action", opts.excel_url);
											$("#export").submit();
											$(excel).dialog("close");
										} else {
											return isValid;

										}
									}
								}, {
									text : '取消',
									iconCls : 'icon-cancel',
									handler : function() {

										$(excel).dialog("close");
									}
								} ]
							});

						});
	}
})(jQuery);

$(function() {
	document.onkeydown = function(e) {
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {
			var queryParams = {};
			$("input[name],select[name]", $("#data").parents(".easyui-layout:first").find(".search")).each(function(index, obj) {
				if (queryParams[$(this).attr("name")] == undefined) {
					queryParams[$(this).attr("name")] = $(this).val();
				} else {
					queryParams[$(this).attr("name")] = queryParams[$(this).attr("name")] + "," + $(this).val();
				}
			});
			$("#data").datagrid({
				queryParams : queryParams
			});
		}
	}
});
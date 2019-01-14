//初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({
		animate : false
	});

	$.each(_menus, function(i, n) {
		var menulist = '';
		menulist += '<ul>';
		if (!!n.child) {
			$.each(n.child, function(j, o) {
				menulist += "<li>";
				var icon = (o.icon ? o.icon : "icon-folder");
				if (!o.url || o.url == "")
					icon = (o.icon ? o.icon : "icon-folder");
				menulist += '<div><a ref="' + o.pid + '" href="javascript:;" rel="' + (o.url ? o.url : "") + '" ><span class="icon ' + icon
						+ '" >&nbsp;</span><span class="nav">' + o.program_name + '</span></a></div>';
				if (!!o.child) {
					menulist += "<ul>"
					$.each(o.child, function(j, q) {
						var icon = (q.icon ? q.icon : "icon-page");
						if (!q.url || q.url == "")
							icon = (q.icon ? q.icon : "icon-folder");
						menulist += '<li><div><a ref="' + q.pid + '" href="javascript:;" rel="' + (q.url ? q.url : "") + '" ><span class="icon '
								+ icon + '" >&nbsp;</span><span class="nav">' + q.program_name + '</span></a></div></li> ';
					});
					menulist += "</ul>"
				}
				menulist += "</li>"
			})
		}
		menulist += '</ul>';

		$('#nav').accordion('add', {
			title : n.program_name,
			content : menulist,
			iconCls : 'icon ' + (n.icon ? n.icon : "icon-package")
		});

	});

	$('.easyui-accordion li a').click(function() {

		var url = $(this).attr("rel");
		if (url == "") {
			$("ul a:first", $(this).parent().parent()).click();
			return;
		}
		var tabTitle = $(this).children('.nav').text();
		var menuid = $(this).attr("ref");
		var icon = $(this).children('.icon').attr("class");

		addTab(tabTitle, url, icon);
		$('.easyui-accordion li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});

	// 选中第一个
	var panels = $('#nav').accordion('panels');
	if (panels.length > 0) {
		var t = panels[0].panel('options').title;
		$('#nav').accordion('select', t);
	}
}

function InitTab() {
	$('#tabs').tabs({
		onSelect : function(title) {
			// var currTab = $('#tabs').tabs('getTab', title);
			// var iframe = $(currTab.panel('options').content);

			// var src = iframe.attr('src');
			// if (src)
			// $('#tabs').tabs('update', { tab: currTab, options: { content:
			// createFrame(src)} });

		}
	});
}

function addTab(subtitle, url, icon) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title : subtitle,
			content : createFrame(url),
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

function refreshTab() {
	$('#mm-tabupdate').click();
}

function closeTab(subtitle) {
	if (!subtitle) {
		var currPanel = $('#tabs').tabs('getSelected');
		var tab = currPanel.panel('options').tab
		subtitle = tab.eq(0).text();
	}
	$('#tabs').tabs('close', subtitle);
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	})
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}
// 绑定右键菜单事件
function tabCloseEven() {
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		})
	})
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	})
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			$('#tabs').tabs('close', t);
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			// msgShow('系统提示','后边没有啦~~','error');

			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {

			return false;
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});

}

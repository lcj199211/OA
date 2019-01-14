(function ($) {
    ///options 
    ///success function
    ///fail function
    ///complete function
    $.fn.browserbutton = function (options) {
        options = $.extend({ filename: new Date().getTime() + "_filename" }, options || {});
        var file_name = options.filename;
        var container;
        var button = this;
        this.css("cursor", "pointer");
        var file;
        if (!container) {

            $(this).wrap("<span style=\"display:inline-block;position:relative;*position:static;overflow:hidden;padding:0px;vertical-align:top;\" unselectable=\"on\"></span>"); //overflow:hidden;
            container = $(this).parent();
            if (!$.support.leadingWhitespace) {
                container.css("width", container.outerWidth(true));
                container.css("height", container.outerHeight(true));
                $(this).css("display", "block");
            }

            file = $("<input type=\"file\"  size=\"1\" style=\"cursor:pointer;font-size:118pt;position:absolute;*position:static;top:0;right:-10px;filter:alpha(opacity=0);-moz-opacity:0;opacity:0;\" id=\"" + file_name + "\"  name=\"" + file_name + "\" />");   //         

            file.appendTo(container);

            if (!$.support.leadingWhitespace) {
                file.css("margin-top", -1 * container.height() - 20);
                file.css("margin-left", -1 * file.width() + container.width() + 20);
            }
            file.change(function () {
                $(button).attr("disabled", "disabled");
                $.ajaxFileUpload({
                    url: options.url,
                    secureuri: false,
                    fileElementId: file_name,
                    dataType: 'json',
                    success: function (data, status) {
                        $(button).removeAttr("disabled");

                        if (options.callback != null)
                            options.callback(data);
                    },
                    error: function (data, status) {
                        $(button).removeAttr("disabled");
                        alert(data.msg);
                    }
                });
            });
        }
    }
})(jQuery)